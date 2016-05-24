package by.epam.tc.parser.text;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import by.epam.tc.parser.sax.MenuSAXHandler;
import by.epam.tc.parser.stax.MenuStaxParser;
import by.epam.tc.parser.view.PrintList;

public class TestParsers {
	private static final String PATH = "src/by/epam/tc/parser/xml/menu.xml";

	public static void main(String[] args) {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (ParserConfigurationException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MenuSAXHandler saxp = new MenuSAXHandler();
		try {
			parser.parse(new File(PATH), saxp);
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		PrintList printer = new PrintList();
		printer.printList(saxp.getMenuList());
		System.out.println("-----------------------");
		MenuStaxParser stax = new MenuStaxParser();
		stax.parseFile(PATH);
		printer.printList(stax.getMenuList());
	}

}
