package by.epam.tc.parser.entity;

public class KindDish {
	private int id;
	private String nameKindDish;
	private String name;
	private String description;
	private String portion;
	private String price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPortion() {
		return portion;
	}

	public void setPortion(String portion) {
		this.portion = portion;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public KindDish() {

	}

	public String getNameKindDish() {
		return nameKindDish;
	}

	public void setNameKindDish(String nameKindDish) {
		this.nameKindDish = nameKindDish;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nameKindDish == null) ? 0 : nameKindDish.hashCode());
		result = prime * result + ((portion == null) ? 0 : portion.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KindDish other = (KindDish) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nameKindDish == null) {
			if (other.nameKindDish != null)
				return false;
		} else if (!nameKindDish.equals(other.nameKindDish))
			return false;
		if (portion == null) {
			if (other.portion != null)
				return false;
		} else if (!portion.equals(other.portion))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		return true;
	}
	
	

}
