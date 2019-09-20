package com.tommy.manik.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="UserInfo")
@NamedQueries({
//	@NamedQuery(
//			name="getAlluser", 
//			//query="SELECT * FROM PROMISE_T1_U_MENU WHERE PROMISE_T1_U_MENU.MENU_PK NOT IN ( SELECT ROLE_MENU_MENU_FK FROM PROMISE_T2_U_ROLE_MENU WHERE ROLE_MENU_ROLE_FK = :roleMenuRoleFk)",
//			query="select a from User a"
//			),
//	@NamedQuery(
//			name="GetUserById", 
//			//query="SELECT m.* FROM PROMISE_T1_U_MENU INNER JOIN PROMISE_T2_U_ROLE_MENU rm ON m.MENU_PK = rm.ROLE_MENU_MENU_FK WHERE rm.ROLE_MENU_ROLE_FK = :roleMenuRoleFk",
//			query="select a from User a where a.id = :userId"
//			)/*,
//	@NamedQuery(
//			name="getMenuListByRole",
//			//query="SELECT m.* FROM PROMISE_T1_U_MENU INNER JOIN PROMISE_T2_U_ROLE_MENU rm ON m.MENU_PK = rm.ROLE_MENU_MENU_FK WHERE rm.ROLE_MENU_ROLE_FK = :roleMenuRoleFk",
//			query="SELECT m FROM Menu m, RoleMenu rm WHERE m.menuPk = rm.roleMenuMenuFk AND rm.roleMenuRoleFk = :roleMenuRoleFk and rm.roleMenuDihapus = :roleMenuDihapus ORDER BY m.menuPk ASC"
//			)*/
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class UserActionEntity{

	
	private int id;
	private String country;
	private String name;
	private UserRole userRole;
	
	@Id
	@GenericGenerator(name="gen",strategy="increment")
    @GeneratedValue(generator="gen")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@ManyToOne
	@JoinColumn(name="role_id")
	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	

}
