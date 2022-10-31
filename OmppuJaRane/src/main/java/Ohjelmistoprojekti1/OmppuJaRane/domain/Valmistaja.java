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

public class Valmistaja {
	
	//jpa id
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	//atribuutit
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Vaatteet> vaatteet;
	
	//parametritön konstruktori
	public Valmistaja() {}

	//konstruktori
	public Valmistaja(String name, List<Vaatteet> vaatteet) {
		super();
		this.name = name;
		this.vaatteet = vaatteet;
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

	public List<Vaatteet> getVaatteet() {
		return vaatteet;
	}

	public void setVaatteet(List<Vaatteet> vaatteet) {
		this.vaatteet = vaatteet;
	}

	@Override
	public String toString() {
		return "Valmistaja [id=" + id + ", name=" + name + ", vaatteet=" + vaatteet + "]";
	}
	
	
	

}
