package mx.uam.ayd.proyecto.presentacion.cerrarMesa;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author Anonymux Corporation
 */

@SuppressWarnings("serial")
@Component
public class VentanaCerrarMesa extends JFrame implements ChangeListener {
	
	private JCheckBox checkBox1, checkBox2;
	private JLabel label1;
	private ControlCerrarMesa controlCerrarMesa; //Control asociado a esta ventana
	private int numeroMesa; //Almacena el número de mesa que se tiene que cerrar
	private double montoTotal=0; //Almacena la suma de los costos unitarios de todos los pedidos de la mesa
	private DefaultTableModel modelo = new DefaultTableModel(
		new Object[][] {
	},
	new String[] {
		"Platillo", "Costo"
	}); //Modelo utilizado para llenar la JTable 
	private JTable tablaPedidos = new JTable(modelo); //JTable que muestra los pedidos con su costo unitario en la ventana
	private LinkedList<String> pedidos = new LinkedList<String>(); //Contiene los nombres de los pedidos realizados sobre la mesa
	double[] costos; //Se utiliza para llenar la JTable; la suma de todos los elementos de este arreglo es igual al montoTotal
	private JButton btnCerrarMesa = new JButton("Realizar pago");
	/**
	 * constructor
	 */
	public VentanaCerrarMesa() {
		
		setBounds(300,300,800,300);		
		
		JPanel panel2 = new JPanel();
		getContentPane().add(panel2, BorderLayout.NORTH);
		
		//se llena la tabla con las caracteristicas del pedido, esta centrado.
		getContentPane().add(new JScrollPane(tablaPedidos),BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
				
		
		JLabel title = new JLabel("Detalles de compra");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 30));
		panel2.add(title);
			
		checkBox1 = new JCheckBox("Tarjeta de Credito");
		checkBox1.setBounds(10,10,150,30);
		checkBox1.addChangeListener(this);
		panel.add(checkBox1);
        
		checkBox2 = new JCheckBox("Efectivo");
		checkBox2.setBounds(10,50,150,30);
		checkBox2.addChangeListener(this);        
		panel.add(checkBox2);
        		        
		label1 = new JLabel("Metodo de pago: ninguno");
		label1.setBounds(10,130,250,30);
		panel.add(label1);
		
		/**
		 * Botón que, al ser presionado, deja de mostrar la ventana actual.
		 */
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			setVisible(false);
			}
		});
		panel.add(btnCancelar);
						/**
		 * Botón que, al ser presionado, cierra la mesa en cuestión (this.numeroMesa).
		 */
		
		btnCerrarMesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Timestamp ultimaHoraApertura = controlCerrarMesa.getUltimaHoraApertura(numeroMesa);
				controlCerrarMesa.cambiaEstado3Mesa(numeroMesa, ultimaHoraApertura, 3);
				actualizaStatusMesaVerde(numeroMesa);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Se ha realizado el pago y agrgada la venta en caja \nMesa: "+numeroMesa+"\nHora de apertura: "+horaString(ultimaHoraApertura));
			}

		});
		panel.add(btnCerrarMesa);
		
		
		
	}	

	
	public void stateChanged(ChangeEvent e){
        
		String texto = "Metodo de pago:  ";
        
		if (checkBox1.isSelected() == true) {
			texto += "Tarjeta credito, ";
		}
		if (checkBox2.isSelected() == true) {
			texto += "Efectivo, ";
		}
		
        
		//Quito la última ',' y escribo el texto
		texto = texto.substring(0, texto.length() - 2);
		label1.setText(texto);
	}
		
	/**
	 * Llena la JTable con los valores de los parámetros establecidos.
	 * @param pedidos Contiene todos los pedidos que se van a mostrar en la JTable.
	 * @param costos Contiene todos los costos unitarios que se van a mostrar en la JTable.
	 */
	private void llenaJModel(LinkedList<String> pedidos, double[] costos) {
		this.modelo.setColumnCount(2);
		this.modelo.setRowCount(pedidos.size()+2);
		int i;
		for(i=0; i<pedidos.size(); i++) {
			this.modelo.setValueAt(pedidos.get(i), i, 0);
			this.modelo.setValueAt(costos[i], i, 1);
			this.montoTotal += costos[i];
		}
		
		this.modelo.setValueAt("--------------------", costos.length, 1);
		this.modelo.setValueAt("--------------------", pedidos.size(), 0);
		this.modelo.setValueAt("$ "+montoTotal, costos.length+1, 1);
		this.modelo.setValueAt("TOTAL", pedidos.size()+1, 0);
		this.montoTotal = 0;
	}


	/**
	 * Actualiza los atributos de clase de esta ventana de acuerdo a los parámetros dados y 
	 * muestra ventana en la aplicación.
	 * @param control ControlCerrarMesa del que proviene esta ventana.
	 * @param numMesa Número de la mesa seleccionada por el usuario.
	 * @param horaApertura Hora de apertura de la mesa seleccionada.
	 */
	public void muestra(ControlCerrarMesa control, int numMesa, Timestamp horaApertura) {
		this.numeroMesa = numMesa;
		this.controlCerrarMesa = control;
		this.pedidos = controlCerrarMesa.ultimosPedidos(this.numeroMesa);
		this.costos = controlCerrarMesa.ultimosCostos(this.numeroMesa);

		llenaJModel(pedidos, costos);
		this.tablaPedidos.setModel(this.modelo);
		setTitle("Mesa "+numeroMesa);
		setVisible(true);
	}
	
	/**
	 * Fija el color de fondo de la mesa dada a "VERDE".
	 * @param numeroMesa Número de la mesa cuyo color de fondo se quiere actualizar a "VERDE".
	 */
	private void actualizaStatusMesaVerde(int numeroMesa) {
		controlCerrarMesa.actualizaStatusMesaVerde(numeroMesa);
	}
	
	/**
	 * Extrae la hora, minutos y segundos de la hora dada y los devuelve como String.
	 * @param hr Hora que se quiere visualizar como String.
	 * @return ""+hr.getHours()+":"+hr.getMinutes()+":"+hr.getSeconds() String con el formato de hora para mostrar en pantalla.
	 */
	@SuppressWarnings("deprecation")
	private String horaString(Timestamp hr) {
		return ""+hr.getHours()+":"+hr.getMinutes()+":"+hr.getSeconds();
	}

	public void cerrarEnabled() {
		btnCerrarMesa.setVisible(true);
		
	}

	public void cerrarDisabled() {
		btnCerrarMesa.setVisible(false);
	}
	
}


