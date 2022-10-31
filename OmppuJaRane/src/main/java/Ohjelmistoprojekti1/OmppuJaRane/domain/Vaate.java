package Ohjelmistoprojekti1.OmppuJaRane.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Vaate {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//atribuutit
	private String name;
	private String type;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Valmistaja valmistaja;
	
	//parametritön konstruktori
	public Vaate() {}

	
	
	//konstruktori
	
	public Vaate(String name, String type, Double price, Valmistaja valmistaja) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.valmistaja = valmistaja;
	}
	
	//getterit setterit


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
	}



	public Valmistaja getValmistaja() {
		return valmistaja;
	}



	public void setValmistaja(Valmistaja valmistaja) {
		this.valmistaja = valmistaja;
	}


	//toString
	
	@Override
	public String toString() {
		return "Vaatteet [id=" + id + ", name=" + name + ", type=" + type + ", price=" + price + ", valmistaja="
				+ valmistaja + "]";
	}
	
	
	

}
