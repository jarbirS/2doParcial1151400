package dao;

import dto.Tienda;
import util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda>{

	public TiendaDao() {
		super(Tienda.class);
	}
	
	public Tienda findByEmail(String email){
		Tienda e = new Tienda();
		e = (Tienda) this.getEm().createNamedQuery("Tienda.findByEmail")
			.setParameter("email", email).getSingleResult();
		
		return e;
	}
}
