package model.entity.product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.entity.customer.order.item.OrderItem;
import model.execptions.ProductCodeException;
import model.execptions.ProductNameException;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private int id;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	@Column(name = "name_product", length = 45, nullable = false, unique = false)
	private String name;
	
	@Column(name = "code_product", length = 45, nullable = false, unique = false)
	private String code;
	
	@Column(name = "description_product", length = 45, nullable = true, unique = false)
	private String description;

	public Product() {
	}

	public Product(String name, String code, String description) throws ProductNameException, ProductCodeException {
		setName(name);
		setCode(code);
		setDescription(description);
	}

	public Product(int id, String name, String code, String description) throws ProductNameException, ProductCodeException {
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

	public void setName(String name) throws ProductNameException {
		if (name.isEmpty()) {
			throw new ProductNameException("Nome do produto não deve estar em branco");
		}
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) throws ProductCodeException {
		if (code.isEmpty()) {
			throw new ProductCodeException("Código do produto não deve estar em branco");
		}
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<OrderItem> getPedidos() {
		return items;
	}

	public void addOrderItem(OrderItem items) {
		this.items.add(items);
	}
}