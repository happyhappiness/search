package search.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.stereotype.Component;

/**
 * Url entity. @author MyEclipse Persistence Tools
 */

@Component
@Entity
@Table(name = "url")
public class Url implements java.io.Serializable {

	// Fields

	
	@Id
	@GeneratedValue
	@Column(name = "uid")
	private Integer uid;

	/*
	 * url����
	 */
	@Column(name = "url", length = 50)
	private String url;

	/*
	 * url�洢·��
	 */
	@Column(name = "path", length = 100)
	private String path;

	/*
	 * url������Ϣ
	 */
	@Column(name = "title", length = 100)
	private String title;

	/*
	 * url������Ϣ
	 */
	@Column(name = "content", length = 2000)
	private String content;


	/*
	 * url��Ӧ�ؼ���
	 */
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "key_url",
		joinColumns = { @JoinColumn(name = "uid", referencedColumnName = "uid") }, 
		inverseJoinColumns = { @JoinColumn(name = "kid", referencedColumnName = "kid") })
	private Set<Keyword> keywords = new HashSet<Keyword>(0);

	
	// Constructors

	/** default constructor */
	public Url() {
	}

	/** minimal constructor */
	public Url(String url, String path) {
		this.url = url;
		this.path = path;
	}

	/** full constructor */
	public Url(String url, String path, String title, String content,
			Set<Keyword> keywords) {
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

	public Set<Keyword> getKeywords() {
		return this.keywords;
	}

	public void setKeywords(Set<Keyword> keywords) {
		this.keywords = keywords;
	}
}
