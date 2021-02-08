package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.negocio.modelo.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.MenuRepository;


@Service
public class ServicioMenu {
	
	@Autowired
	private MenuRepository menuRepository; 
	
	
	public Menu recupera() {
		
		Menu menu = this.menuRepository.findById(1);
		
		return menu;
	}
	
	public Menu crea(String men){
		
		Menu menu = new Menu();
		menu.setId(1);
		menu.setMen(men);
		this.menuRepository.save(menu);
		
		return menu;	
		
	}
	
	public void borrar() {
		
		this.menuRepository.deleteAll();
	}
	
	

}
