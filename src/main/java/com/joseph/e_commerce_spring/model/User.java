package com.joseph.e_commerce_spring.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * The persistent class for the user database table.
 *
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements UserDetails  {
	private static final long serialVersionUID = 1L;
	private static final String AUTHORITIES_DELIMITER = "::";

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

	@Column(name = "enabled", nullable = false, columnDefinition = "TINYINT")
	private boolean enabled;

//	//bi-directional many-to-one association to Userrole
//	@ManyToOne
//	@JoinColumn(name="roleid")
//	private Userrole userrole;
//
//	//bi-directional one-to-one association to Userinfo
//	@OneToOne(mappedBy="user")
//	private Userinfo userinfo;

	//Join column is the main table
	//inverse join column is the other table
	@ManyToMany 
	@JoinTable(
			name = "userrole",
			joinColumns = @JoinColumn(
					name="user_iduser",
					referencedColumnName = "iduser"
					),
			inverseJoinColumns = @JoinColumn(
					name="role_id",
					referencedColumnName = "id"
					)
			)
	private Set<Role> roles = new HashSet<>();

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<SimpleGrantedAuthority> auths = roles.stream().map(
				role ->new SimpleGrantedAuthority(role.getRole())).toList();
		
		
		return auths;
		
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, enabled, iduser, lastogin, modifiedAt, password, roles, username);
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
		return Objects.equals(createdAt, other.createdAt) && enabled == other.enabled
				&& Objects.equals(iduser, other.iduser) && Objects.equals(lastogin, other.lastogin)
				&& Objects.equals(modifiedAt, other.modifiedAt) && Objects.equals(password, other.password)
				&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
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