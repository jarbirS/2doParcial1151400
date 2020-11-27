package util;

import java.util.List;

import dao.ClienteDao;
import dao.ServicioDao;
import dao.TiendaDao;
import dto.Cliente;
import dto.Servicio;
import dto.Tienda;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClienteDao cdao = new ClienteDao();
		/*Cliente c = new Cliente("1090518591", "jarbir98@gmail.com", "jarbir");
		cdao.insert(c);*/
		TiendaDao tdao = new TiendaDao();
		/*Tienda t = new Tienda();
		t.setNombre("Stiwi");
		t.setDescripcion("Tienda de stiwi");
		t.setEmail("stiwi@gmail.com");
		t.setClave("prueba123");
		t.setPropietario("Stewart mejia");
		t.setWeb("http://localhost:8080/tiendita/");
		t.setLema("pritiboi dirtiboi");
		t.setFacebook("https://www.facebook.com/jarbirstewart.mejiarojas");
		t.setImagen("https://cnnespanol.cnn.com/wp-content/uploads/2019/12/dic-18.jpg?resize=940,530");
		tdao.insert(t);*/
		/*ServicioDao sDao = new ServicioDao();
		Servicio s = new Servicio();
		Tienda t = tdao.find(3);
		System.out.println(t.toString());
		s.setNombre("Servicio 2020");
		s.setDescripcion("Descripcion del servicio 2020");
		s.setTiendaBean(t);
		sDao.insert(s);*/
		/*Cliente c = cdao.find(8);
		Tienda t = tdao.find(27);
		List<Tienda> tiendas = c.getTiendas();
		tiendas.add(t);
		c.setTiendas(tiendas);
		cdao.update(c);*/
		/*Tienda t = tdao.find(3);
		t.setNombre("Los recuerdos de ella");
		tdao.update(t);*/
		Tienda t = tdao.findByEmail("info@reparamos.co");
		System.out.println(t.getDescripcion() + "\n "+ t.getClave() + "\n " + t.getPropietario() + "\n " + t.getEmail());
	}

}
