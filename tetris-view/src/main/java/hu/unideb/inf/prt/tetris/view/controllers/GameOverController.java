package hu.unideb.inf.prt.tetris.view.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.unideb.inf.prt.tetris.model.entity.Highscore;
import hu.unideb.inf.prt.tetris.model.service.HighscoreService;
import hu.unideb.inf.prt.tetris.model.serviceImpl.HighscoreServiceImpl;
import hu.unideb.inf.prt.tetris.view.main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GameOverController implements Initializable {

	@FXML
	Button buttonSave;
	@FXML
	Button buttonSkip;
	@FXML
	Label labelScore;
	@FXML
	TextField textFieldPlayer;

	@FXML
	private void handleButtonSave(ActionEvent event) {
		Main.player = textFieldPlayer.getText();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HighscoreDb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			HighscoreService highscoreService = new HighscoreServiceImpl(entityManager);
			entityManager.getTransaction().begin();
			highscoreService.add(new Highscore(Main.player, Main.score));
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		Stage stage;
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LeaderboardFXML.fxml"));
			root = loader.load();
			loader.<LeaderboardController> getController();
			stage = (Stage) buttonSkip.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleButtonSkip(ActionEvent event) {
		Stage stage;
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuFXML.fxml"));
			root = loader.load();
			loader.<MenuController> getController();
			stage = (Stage) buttonSkip.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		textFieldPlayer.setText(Main.player);
		labelScore.setText(Integer.toString(Main.score));
	}
}
