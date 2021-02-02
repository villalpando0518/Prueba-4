package mx.uam.ayd.proyecto.negocio;

import mx.uam.ayd.proyecto.negocio.modelo.Recordatorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import mx.uam.ayd.proyecto.datos.RecordatorioRepository;


@Service
public class ServicioRecordatorio {
	
	@Autowired
	private RecordatorioRepository recordatorioRepository; 
	
	
	public Recordatorio recupera() {
		
		Recordatorio recordatorio = this.recordatorioRepository.findById(1);
		
		return recordatorio;
	}
	
	public Recordatorio crea(String info){
		
		Recordatorio recordatorio = new Recordatorio();
		recordatorio.setId(1);
		recordatorio.setInfo(info);
		this.recordatorioRepository.save(recordatorio);
		
		return recordatorio;	
		
	}
	
	public void borrar() {
		
		this.recordatorioRepository.deleteAll();
	}
	
	

}
