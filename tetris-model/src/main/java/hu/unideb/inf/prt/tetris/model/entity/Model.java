package hu.unideb.inf.prt.tetris.model.entity;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

@XmlRootElement(name = "highscores")
@XmlAccessorType(XmlAccessType.FIELD)
public class Model {

	private static Logger logger = LoggerFactory.getLogger(Model.class);

	@XmlElement(name = "highscore")
	private List<Highscore> highscoreList;

	public Model() {
		super();
	}

	public void saveHighscoreTable() {
		try {
			File savedFile = new File("/highscoretable.xml");
			File file;
			String[] splitter = savedFile.toString().split("\\.");
			if (splitter[splitter.length - 1].equals("xml")) {
				file = savedFile;
			} else {
				file = new File(savedFile.toString() + ".xml");
			}
			JAXBContext context = JAXBContext.newInstance(Model.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.marshal(this, file);
			logger.info("XML file successfully saved");
		} catch (JAXBException e) {
			logger.error("JAXBException thrown while processing XML file");
		}
	}

	public Model openHighscoreTable() {
		try {
			File openedFile = new File("/highscoretable.xml");
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			URL url = getClass().getResource("/highscoretable.xsd");
			Source xmlFile = new StreamSource(openedFile);
			Schema schema = schemaFactory.newSchema(url);
			Validator validator = schema.newValidator();
			validator.validate(xmlFile);
			JAXBContext context = JAXBContext.newInstance(Model.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (Model) unmarshaller.unmarshal(openedFile);
		} catch (JAXBException | IOException | SAXException e) {
			logger.error("Exception thrown while opening XML file");
		}
		return null;
	}

	public List<Highscore> getHighscoreList() {
		return highscoreList;
	}

	public void setHighscoreList(List<Highscore> highscoreList) {
		this.highscoreList = highscoreList;
	}
}
