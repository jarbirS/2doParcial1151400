package dao;

import dto.Servicio;
import util.Conexion;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio>{
	public ServicioDao() {
		super(Servicio.class);
	}
}
