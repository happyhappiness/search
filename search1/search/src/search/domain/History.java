package search.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user")
public class History implements java.io.Serializable {

	// Fields

	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	/*
	 *ÓÃ»§ËÑË÷´Ê
	 */
	@Column(name = "word", length = 255)
	private String word;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** full constructor */
	public History(String word) {
		this.word = word;
	}
	
	
	// Property accessors
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
