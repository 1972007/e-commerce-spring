package com.joseph.e_commerce_spring.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User  {
	private static final long serialVersionUID = 1L;

	@Id
	private String iduser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastogin;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modified_at")
	private Date modifiedAt;

	private String password;

	private String username;

	//bi-directional many-to-one association to Userrole
	@ManyToOne
	@JoinColumn(name="roleid")
	private Userrole userrole;
//
//	//bi-directional one-to-one association to Userinfo
//	@OneToOne(mappedBy="user")
//	private Userinfo userinfo;

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, iduser, lastogin, modifiedAt, password, username, userrole);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(iduser, other.iduser)
				&& Objects.equals(lastogin, other.lastogin) && Objects.equals(modifiedAt, other.modifiedAt)
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username)
				&& Objects.equals(userrole, other.userrole);
	}

//	public User() {
//	}
//
//	public String getIduser() {
//		return this.iduser;
//	}
//
//	public void setIduser(String iduser) {
//		this.iduser = iduser;
//	}
//
//	public Date getCreatedAt() {
//		return this.createdAt;
//	}
//
//	public void setCreatedAt(Date createdAt) {
//		this.createdAt = createdAt;
//	}
//
//	public Date getLastogin() {
//		return this.lastogin;
//	}
//
//	public void setLastogin(Date lastogin) {
//		this.lastogin = lastogin;
//	}
//
//	public Date getModifiedAt() {
//		return this.modifiedAt;
//	}
//
//	public void setModifiedAt(Date modifiedAt) {
//		this.modifiedAt = modifiedAt;
//	}
//
//	public String getPassword() {
//		return this.password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getUsername() {
//		return this.username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public Userrole getUserrole() {
//		return this.userrole;
//	}
//
//	public void setUserrole(Userrole userrole) {
//		this.userrole = userrole;
//	}
//
//	public Userinfo getUserinfo() {
//		return this.userinfo;
//	}
//
//	public void setUserinfo(Userinfo userinfo) {
//		this.userinfo = userinfo;
//	}

}