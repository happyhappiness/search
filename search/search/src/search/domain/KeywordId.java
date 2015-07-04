package search.domain;

/**
 * KeywordId entity. @author MyEclipse Persistence Tools
 */
public class KeywordId extends AbstractKeywordId implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public KeywordId() {
	}

	/** full constructor */
	public KeywordId(Integer kid, Url url) {
		super(kid, url);
	}

}
