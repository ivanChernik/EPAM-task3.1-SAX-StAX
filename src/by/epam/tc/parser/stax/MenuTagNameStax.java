package by.epam.tc.parser.stax;

public enum MenuTagNameStax {
	COLD_APPETIZER, HOT_APPETIZER, BREAKFAST, NAME, DESCRIPTION, PRICE, PORTION, COLD_APPETIZERS, HOT_APPETIZERS, BREAKFASTS, MENU_LIST;

	public static MenuTagNameStax getElementTagName(String element) {
		switch (element) {
		case "name":
			return NAME;
		case "description":
			return DESCRIPTION;
		case "portion":
			return PORTION;
		case "price":
			return PRICE;
		case "menu-list":
			return MENU_LIST;
		case "cold-appetizers":
			return COLD_APPETIZERS;
		case "cold-appetizer":
			return COLD_APPETIZER;
		case "hot-appetizers":
			return HOT_APPETIZERS;
		case "hot-appetizer":
			return HOT_APPETIZER;
		case "breakfasts":
			return BREAKFASTS;
		case "breakfast":
			return BREAKFAST;
		default:
			throw new EnumConstantNotPresentException(MenuTagNameStax.class,
					element);
		}

	}
}
