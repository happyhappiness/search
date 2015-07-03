package search.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * Keyword entity. @author MyEclipse Persistence Tools
 */

@Component
@Entity
@Table(name = "KeyWord")
public class Keyword implements java.io.Serializable {

	// Fields

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	/*
	 * keywordƒ⁄»›
	 * 
	 * */
	@Column(name = "word", length = 50)
	private String word;

	/*
	 * keyword”≥…‰url
	 * 
	 * */
	private Set urls = new HashSet(0);
	// Constructors

	/** default constructor */
	public Keyword() {
	}

	/** full constructor */
	public Keyword(int id, String word) {
		this.id = id;
		this.word = word;
	}

	// Property accessors

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	

	public Set getUrls() {
		return this.urls;
	}

	public void setUrls(Set urls) {
		this.urls = urls;
	}

}