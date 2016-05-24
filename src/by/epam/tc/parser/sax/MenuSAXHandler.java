package by.epam.tc.parser.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.tc.parser.entity.KindDish;

public class MenuSAXHandler extends DefaultHandler {
	private static final String COLON = ":";
	private static final String UNDERSCORE = "_";
	private static final String HYPHEN = "-";
	private static final String ID = "id";
	private static final String BREAKFAST = "breakfast";
	private static final String HOT_APPETIZER = "hot-appetizer";
	private static final String COLD_APPETIZER = "cold-appetizer";
	private List<KindDish> menuList = new ArrayList<KindDish>();
	private KindDish kindDish;
	private StringBuilder text;

	public List<KindDish> getMenuList() {
		return menuList;
	}

	@Override
	public void startDocument() throws SAXException {

	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		text = new StringBuilder();
		if (qName.equals(COLD_APPETIZER) || qName.equals(HOT_APPETIZER)
				|| qName.equals(BREAKFAST)) {
			kindDish = new KindDish();
			kindDish.setNameKindDish(qName);
			kindDish.setId(Integer.parseInt(attributes.getValue(ID)));
		}
	}

	@Override
	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		MenuTagNameSAX tagName = MenuTagNameSAX.valueOf(qName.toUpperCase().replace(
				HYPHEN, UNDERSCORE).replace(COLON, ""));
		switch (tagName) {
		case NAME:
			kindDish.setName(text.toString());
			break;
		case DESCRIPTION:
			kindDish.setDescription(text.toString());
			break;
		case PRICE:
			kindDish.setPrice(text.toString());
			break;
		case PORTION:
			kindDish.setPortion(text.toString());
			break;
		case COLD_APPETIZER:
			menuList.add(kindDish);
			kindDish = null;
			break;
		case HOT_APPETIZER:
			menuList.add(kindDish);
			kindDish = null;
			break;
		case BREAKFAST:
			menuList.add(kindDish);
			kindDish = null;
			break;

		}
	}

}
