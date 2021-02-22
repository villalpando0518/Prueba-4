package mx.uam.ayd.proyecto.presentacion.clientes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

/**
 *
 * Muestra la ventana de clientes con una tabla que contiene la
 * información completa de cada cliente.
 * @author Panther Zone
 */
@Component
public class VentanaClientes extends JFrame {

	private JPanel contentPane;
	
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel() {
		@Override
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	
	private ControlClientes controlClientes;
	
	/**
	 * VentanaClientes: Permite inicializar la ventana
	 */
	public VentanaClientes() {
		this.contentPane = new JPanel();
		initialize();
	}
	/**
	 * initialize: Permite inicializar los componentes de la ventana
	 */
	private void initialize() {
		
		setTitle("Clientes");
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Agregar");
		btnRegistrar.setBounds(48, 197, 95, 23);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlClientes.registrarCliente();
			}
		});
		
			
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 33, 379, 153);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		modelo.addColumn("Id_Cliente");
		modelo.addColumn("Nombre");
		modelo.addColumn("Correo");
		modelo.addColumn("Promocion");
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(295, 197, 95, 23);
		contentPane.add(btnNewButton);
		
	}
	/**
	 * muestra: Recibe del controlador una lista de clientes para mostrarlos en la ventana 
	 * @param control
	 * @param clientes
	 */
	public void muestra(ControlClientes control, List <Cliente> clientes) {
		this.controlClientes = control;
		modelo.setRowCount(0);
		for(Cliente cliente:clientes) {
			modelo.addRow(new Object[] {cliente.getIdCliente(), cliente.getNombre(), cliente.getCorreo(),
			cliente.getPromocion()});
			table.setModel(modelo);
		}
	setVisible(true);
	}
	/**
	 * registrarCliente: Controla la ventana para agregar a un cliente
	 */
	public void registrarCliente() {
		controlClientes.registrar();
	}
	
}
