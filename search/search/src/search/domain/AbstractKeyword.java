package search.domain;

/**
 * AbstractKeyword entity provides the base persistence definition of the
 * Keyword entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKeyword implements java.io.Serializable {

	// Fields

	private KeywordId id;
	private String word;

	// Constructors

	/** default constructor */
	public AbstractKeyword() {
	}

	/** full constructor */
	public AbstractKeyword(KeywordId id, String word) {
		this.id = id;
		this.word = word;
	}

	// Property accessors

	public KeywordId getId() {
		return this.id;
	}

	public void setId(KeywordId id) {
		this.id = id;
	}

	public String getWord() {
		return this.word;
	}

	public void setWord(String word) {
		this.word = word;
	}

}