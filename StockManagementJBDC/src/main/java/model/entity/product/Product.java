package model.entity.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int id;
	@Column(name = "name_product")
	private String name;
	@Column(name = "code_product")
	private String code;
	@Column(name = "description_product")
	private String description;

	public Product() {
	}

	public Product(String name, String code, String description) {
		setName(name);
		setCode(code);
		setDescription(description);
	}

	public Product(int id, String name, String code, String description) {
		setId(id);
		setName(name);
		setCode(code);
		setDescription(description);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}