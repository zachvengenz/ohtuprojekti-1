package Ohjelmistoprojekti1.OmppuJaRane.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity

public class Apparel {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long apparelId;
	
	//atribuutit
	private String name;
	private String type;
	private Double price;
	
	@ManyToOne
	@JoinColumn(name = "valmistajaId")
	private Maker maker;
	
	//parametritön konstruktori
	public Apparel() {}

	
	
	//konstruktori
	
	public Apparel(String name, String type, Double price, Maker maker) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.maker = maker;
	}
	
	//getterit setterit


	public Long getId() {
		return apparelId;
	}



	public void setId(Long id) {
		this.apparelId = id;
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



	public Maker getMaker() {
		return maker;
	}



	public void setMaker(Maker maker) {
		this.maker = maker;
	}


	//toString
	
	@Override
	public String toString() {
		return "Vaatteet [id=" + apparelId + ", name=" + name + ", type=" + type + ", price=" + price + ", maker="
				+ maker + "]";
	}
	
	
	

}