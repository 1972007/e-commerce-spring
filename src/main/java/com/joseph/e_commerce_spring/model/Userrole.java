package com.joseph.e_commerce_spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the userrole database table.
 * 
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name="Userrole.findAll", query="SELECT u FROM Userrole u")
public class Userrole  {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String role;

	@Override
	public int hashCode() {
		return Objects.hash(id, role);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Userrole)) {
			return false;
		}
		Userrole other = (Userrole) obj;
		return id == other.id && Objects.equals(role, other.role);
	}

//	//bi-directional many-to-one association to User
//	@OneToMany(mappedBy="userrole")
//	private List<User> users;

//	public Userrole() {
//	}
//
//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getRole() {
//		return this.role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
//	}

//	public List<User> getUsers() {
//		return this.users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}

//	public User addUser(User user) {
//		getUsers().add(user);
//		user.setUserrole(this);
//
//		return user;
//	}
//
//	public User removeUser(User user) {
//		getUsers().remove(user);
//		user.setUserrole(null);
//
//		return user;
//	}

}