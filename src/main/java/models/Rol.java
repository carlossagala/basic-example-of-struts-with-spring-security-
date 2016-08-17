package models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;;

@Entity(name = "ROLES")
public class Rol {

	@Id
	@Column(name = "ID_ROLE")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "ROL")
	private String rol;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROL", joinColumns = {
			@JoinColumn(name = "ID_ROLE", referencedColumnName = "ID_ROLE") }, inverseJoinColumns = {
					@JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO") })
	private List<Usuario> usuarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
