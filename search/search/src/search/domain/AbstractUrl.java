package search.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractUrl entity provides the base persistence definition of the Url
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUrl implements java.io.Serializable {

	// Fields

	private Integer uid;
	private String url;
	private String path;
	private String title;
	private String content;
	private Set keywords = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractUrl() {
	}

	/** minimal constructor */
	public AbstractUrl(String url, String path) {
		this.url = url;
		this.path = path;
	}

	/** full constructor */
	public AbstractUrl(String url, String path, String title, String content,
			Set keywords) {
		this.url = url;
		this.path = path;
		this.title = title;
		this.content = content;
		this.keywords = keywords;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Set keywords) {
		this.keywords = keywords;
	}

}