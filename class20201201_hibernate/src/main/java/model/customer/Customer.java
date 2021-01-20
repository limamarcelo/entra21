package model.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//substituir do código do CustomerDAO do professor
//criarConexão
//por
//buildSessionFactory

import execptions.CustomerAgeException;
import execptions.CustomerCpfException;
import execptions.CustomerDebtException;
import execptions.CustomerNameException;

@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_customer")
	private int id;
	@Column(name = "name", length = 40, nullable = false, unique = false)
	private String name;
	@Column(name = "cpf", length = 14, nullable = false, unique = true)
	private String cpf;
	@Column(name = "age", length = 3, nullable = false, unique = false)
	private int age;
	@Column(name = "debt", length = 6, nullable = false, unique = false)
	private double debt;

	public Customer() {
	}

	public Customer(int id, String name, String cpf, int age, double debt) throws CustomerNameException, CustomerCpfException, CustomerAgeException, CustomerDebtException {
		setId(id);
		setName(name);
		setCpf(cpf);
		setAge(age);
		setDebt(debt);
	}
	
	public Customer(String name, String cpf, int age, double debt) throws CustomerNameException, CustomerCpfException, CustomerAgeException, CustomerDebtException {
		setName(name);
		setCpf(cpf);
		setAge(age);
		setDebt(debt);
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

	public void setName(String name) throws CustomerNameException {
		if (name.isEmpty()) {
			throw new CustomerNameException("Nome do cliente não deve estar em branco");
		}
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws CustomerCpfException {
		if (cpf.isEmpty()) {
			throw new CustomerCpfException("CPF do cliente não deve estar em branco");
		}
		if (cpf.length() != 14) {
			throw new CustomerCpfException("Tamanho CPF do cliente é inválido");
		}
		this.cpf = cpf;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) throws CustomerAgeException {
		if (age <0 || age > 120) {
			throw new CustomerAgeException("Idade do cliente não deve ser menor do que 0 e maior do que 120");
		}
		this.age = age;
	}

	public double getDebt() {
		return debt;
	}

	public void setDebt(double debt) throws CustomerDebtException {
		if(debt <= 0) {
			throw new CustomerDebtException("O débito deve ser maior que zero");
		}
		this.debt = debt;
	}
}