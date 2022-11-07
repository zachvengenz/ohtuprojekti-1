package Ohjelmistoprojekti1.OmppuJaRane.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Maker {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long makerId;
	
	//atribuutit
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "maker")
	private List<Apparel> apparel;
	
	//parametritön konstruktori
	public Maker() {}

	//konstruktori
	public Maker(String name) {
		super();
		this.name = name;
	}
	
	
	//getterit setterit
	public Long getId() {
		return makerId;
	}

	public void setId(Long id) {
		this.makerId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Apparel> getApparel() {
		return apparel;
	}

	public void setApparel(List<Apparel> apparel) {
		this.apparel = apparel;
	}

	@Override
	public String toString() {
		return "Valmistaja [id=" + makerId + ", name=" + name + "]";
	}

	
	
	
	

}
