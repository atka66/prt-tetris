//CHECKSTYLE:OFF
package hu.unideb.inf.prt.tetris.view.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hu.unideb.inf.prt.tetris.model.entity.Highscore;
import hu.unideb.inf.prt.tetris.model.service.HighscoreService;
import hu.unideb.inf.prt.tetris.model.serviceImpl.HighscoreServiceImpl;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class LeaderboardController implements Initializable {

	@FXML
	ListView<String> listViewHighscores;
	@FXML
	Button buttonBack;

	@FXML
	private void handleButtonBack(ActionEvent event) {
		Stage stage;
		Parent root;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/MenuFXML.fxml"));
			root = loader.load();
			loader.<MenuController> getController();
			stage = (Stage) buttonBack.getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialize(URL location, ResourceBundle resources) {
		List<Highscore> highscoreList = new ArrayList<>();
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HighscoreDb");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			HighscoreService highscoreService = new HighscoreServiceImpl(entityManager);
			highscoreList = highscoreService.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		List<String> sortedStringList = highscoreList.stream()
				.sorted((h1, h2) -> Integer.compare(h2.getScore(), h1.getScore()))
				.map(h -> Integer.toString(h.getScore()) + " - " + h.getPlayer()).collect(Collectors.toList());
		listViewHighscores.setItems(FXCollections.observableArrayList(sortedStringList));
	}
}
