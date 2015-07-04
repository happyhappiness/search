package search.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@Column(name = "kid")
	private int kid;
	
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
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
	@JoinTable(name = "key_url",
		joinColumns = {@JoinColumn(name ="kid",referencedColumnName="kid")},
		inverseJoinColumns = {@JoinColumn( name = "uid", referencedColumnName ="uid")})
	private Set<Url> urls = new HashSet<Url>(0);
	// Constructors

	/** default constructor */
	public Keyword() {
	}

	/** full constructor */
	public Keyword(int kid, String word, Set<Url> urls) {
		this.kid = kid;
		this.word = word;
		this.urls = urls;
	}

	// Property accessors

	public int getKid() {
		return this.kid;
	}

	public void setKid(int kid) {
		this.kid = kid;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	

	public Set<Url> getUrls() {
		return this.urls;
	}

	public void setUrls(Set<Url> urls) {
		this.urls = urls;
	}

}