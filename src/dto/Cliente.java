package dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQueries({@NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
	@NamedQuery(name="Cliente.findByEmail", query="SELECT c FROM Cliente c where c.email = :email")})
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String clave;

	private String email;

	private String nombre;

	//bi-directional many-to-many association to Cliente
	@ManyToMany
	@JoinTable(
		name="seguir"
		, joinColumns={
			@JoinColumn(name="cliente")
			}
		, inverseJoinColumns={
			@JoinColumn(name="tienda")
			}
		)
	private List<Tienda> tiendas;

	public Cliente() {
	}

	public Cliente(String clave, String email, String nombre) {
		this.clave = clave;
		this.email = email;
		this.nombre = nombre;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tienda> getTiendas() {
		return tiendas;
	}

	public void setTiendas(List<Tienda> tiendas) {
		this.tiendas = tiendas;
	}
	

}