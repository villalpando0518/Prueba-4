package mx.uam.ayd.proyecto.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.VentasMenuRepository;
import mx.uam.ayd.proyecto.negocio.modelo.VentasMenu;

@Service
public class ServicioVentasMenu {
	
	@Autowired
	private VentasMenuRepository ventasMenuRepository;
	
	public List<VentasMenu> recuperaVentas(){
		
		List<VentasMenu> ventas = new ArrayList<>();
		for(VentasMenu i: ventasMenuRepository.findAll()) {
			ventas.add(i);
		}
		
		return ventas;
		
		
	}
	
	public void crea(VentasMenu v) {
		
		ventasMenuRepository.save(v);
	
	}
	
	public void actualiza(VentasMenu v) {
		
		ventasMenuRepository.save(v);
	}
	
	public VentasMenu recuperaHoy() {
		VentasMenu v= new VentasMenu(); 
			//v=	ventasMenuRepository.findById(i);
		LocalDate fechaDeHoy = LocalDate.now();
		v = ventasMenuRepository.findByFecha(fechaDeHoy);
		
		return v;	
	}

}
