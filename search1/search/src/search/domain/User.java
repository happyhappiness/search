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
@Table(name = "user")
public class User implements java.io.Serializable {

	// Fields

	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	/*
	 *�û�����
	 */
	@Column(name = "name", length = 255)
	private String name;

	/*
	 * �û�����
	 */
	@Column(name = "password", length = 255)
	private String password;

	/*
	 * �û�Ȩ�� 0����ͨ 1������Ա
	 */
	@Column(name = "right", length = 1)
	private boolean right;

	
	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	/** full constructor */
	public User(String name, String password, boolean right){
		this.name = name;
		this.password = password;
		this.right = right;
	}

	// Property accessors

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean getRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	
}
