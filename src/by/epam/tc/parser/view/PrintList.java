package by.epam.tc.parser.view;

import java.util.List;

import by.epam.tc.parser.entity.KindDish;

public class PrintList {
	private List<KindDish> menuList;

	public PrintList() {
	}

	public void printList(List<KindDish> menuList) {
		this.menuList = menuList;
		for (KindDish iterableKindDish : menuList) {
			System.out.println(iterableKindDish.getNameKindDish() + " id = "
					+ iterableKindDish.getId());
			printElement(iterableKindDish.getName());
			printElement(iterableKindDish.getDescription());
			printElement(iterableKindDish.getPortion());
			printElement(iterableKindDish.getPrice());
		}
	}

	private void printElement(String element) {
		if (element != null) {
			System.out.println(element);
		}
	}
}
