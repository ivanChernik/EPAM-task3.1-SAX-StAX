package by.epam.tc.parser.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.tc.parser.entity.KindDish;

public class MenuStaxParser {
	private static final String ID = "id";
	private List<KindDish> menuList;

	public MenuStaxParser() {
		menuList = new ArrayList<KindDish>();
	}

	public void parseFile(String fileName) {
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		XMLStreamReader reader = null;
		try {
			reader = inputFactory.createXMLStreamReader(new FileInputStream(
					fileName));
			process(reader);
		} catch (FileNotFoundException | XMLStreamException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<KindDish> getMenuList() {
		return menuList;
	}

	private void process(XMLStreamReader reader) throws XMLStreamException {
		KindDish kindDish = null;
		MenuTagNameStax elementName = null;
		while (reader.hasNext()) {
			int typeElement = reader.next();
			switch (typeElement) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = MenuTagNameStax.getElementTagName(reader
						.getLocalName());
				switch (elementName) {
				case COLD_APPETIZER:
					kindDish = initializeKindDish(kindDish, reader);
					break;
				case HOT_APPETIZER:
					kindDish = initializeKindDish(kindDish, reader);
					break;
				case BREAKFAST:
					kindDish = initializeKindDish(kindDish, reader);
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case NAME:
					kindDish.setName(text);
					break;
				case DESCRIPTION:
					kindDish.setDescription(text);
					break;
				case PORTION:
					kindDish.setPortion(text);
					break;
				case PRICE:
					kindDish.setPrice(text);
					break;

				}
				break;

			case XMLStreamConstants.END_ELEMENT:
				elementName = MenuTagNameStax.getElementTagName(reader
						.getLocalName());
				switch (elementName) {
				case COLD_APPETIZER:
					menuList.add(kindDish);
					break;
				case HOT_APPETIZER:
					menuList.add(kindDish);
					break;
				case BREAKFAST:
					menuList.add(kindDish);
					break;

				}
			}
		}
	}

	private KindDish initializeKindDish(KindDish kindDish, XMLStreamReader reader) {
		kindDish = new KindDish();
		kindDish.setNameKindDish(reader.getLocalName());
		kindDish.setId(Integer.parseInt(reader.getAttributeValue(null, ID)));
		return kindDish;
	}


}
