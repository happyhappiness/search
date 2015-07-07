package search.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "history")
public class History implements java.io.Serializable {

	// Fields

	@Id
	@GeneratedValue
	@Column(name = "hid")
	private Integer hid;
	
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
	public History(int id, String word) {
		this.id = id;
		this.word = word;
	}
	
	
	// Property accessors
	public Integer getHid() {
		return hid;
	}

	public void setHid(Integer hid) {
		this.hid = hid;
	}

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
