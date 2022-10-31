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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//atribuutit
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "valmistaja")
	private List<Vaate> vaatteet;
	
	//parametritön konstruktori
	public Valmistaja() {}

	//konstruktori
	public Valmistaja(String name) {
		super();
		this.name = name;
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

	@Override
	public String toString() {
		return "Valmistaja [id=" + id + ", name=" + name + "]";
	}

	
	
	
	

}
