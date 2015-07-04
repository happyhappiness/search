package search.domain;

/**
 * AbstractKeywordId entity provides the base persistence definition of the
 * KeywordId entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractKeywordId implements java.io.Serializable {

	// Fields

	private Integer kid;
	private Url url;

	// Constructors

	/** default constructor */
	public AbstractKeywordId() {
	}

	/** full constructor */
	public AbstractKeywordId(Integer kid, Url url) {
		this.kid = kid;
		this.url = url;
	}

	// Property accessors

	public Integer getKid() {
		return this.kid;
	}

	public void setKid(Integer kid) {
		this.kid = kid;
	}

	public Url getUrl() {
		return this.url;
	}

	public void setUrl(Url url) {
		this.url = url;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AbstractKeywordId))
			return false;
		AbstractKeywordId castOther = (AbstractKeywordId) other;

		return ((this.getKid() == castOther.getKid()) || (this.getKid() != null
				&& castOther.getKid() != null && this.getKid().equals(
				castOther.getKid())))
				&& ((this.getUrl() == castOther.getUrl()) || (this.getUrl() != null
						&& castOther.getUrl() != null && this.getUrl().equals(
						castOther.getUrl())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getKid() == null ? 0 : this.getKid().hashCode());
		result = 37 * result
				+ (getUrl() == null ? 0 : this.getUrl().hashCode());
		return result;
	}

}