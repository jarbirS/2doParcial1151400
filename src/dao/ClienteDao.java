package dao;
import dto.Cliente;
import dto.Tienda;
import util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}
	
	public Cliente findByEmail(String email){
		Cliente e = new Cliente();
		e = (Cliente) this.getEm().createNamedQuery("Cliente.findByEmail")
			.setParameter("email", email).getSingleResult();
		
		return e;
	}
}
