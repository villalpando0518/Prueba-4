package mx.uam.ayd.proyecto.presentacion.proveedores;

import java.awt.BorderLayout;
import java.util.List;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.ControlRegistrarEmpleado;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.VentanaRegistrarEmpleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@Component
public class VentanaProveedores extends JFrame {

	private final JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel modelo = new DefaultTableModel(){ 
	    @Override 
	    public boolean isCellEditable(int row, int column) { 
	     return false; 
	    } 
	};
	
	private JTextField textnomProveedor;
	private JTextField textmarca;
	private JTextField texttipo;
	private JTextField textcosto;
	
	private ControlProveedores controlProveedores;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VentanaRegistrarEmpleado dialog = new VentanaRegistrarEmpleado();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}/*

	/**
	 * Create the dialog.
	 */
	
	
	public VentanaProveedores() {
		this.contentPane = new JPanel();
		initialize();
	}
	
	private void initialize() {
		setTitle("Proveedores");
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(48, 197, 89, 23);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlProveedores.registrarProveedor();
			}
		});
		
		JButton btnEditar = new JButton("Modificar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlProveedores.editarProveedor();
			}
		});
		btnEditar.setBounds(289, 197, 89, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 33, 379, 153);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		modelo.addColumn("Id_Proveedor");
		modelo.addColumn("Nombre del Proveedor");
		modelo.addColumn("Marca");
		modelo.addColumn("Tipo");
		modelo.addColumn("Costo");
		
		
		scrollPane.setViewportView(table);
	}
	
	
				public void muestra(ControlProveedores control, List <Proveedor> proveedores) {
					this.controlProveedores = control;
					modelo.setRowCount(0);
					for(Proveedor proveedor:proveedores) {
						modelo.addRow(new Object[] {proveedor.getIdProv(), proveedor.getNomProveedor(), proveedor.getMarca(),
								proveedor.getTipo(), proveedor.getCosto()});
						table.setModel(modelo);
						}
					setVisible(true);
					}
				
				public void registrarProveedor() {
					controlProveedores.registrar();
				}
				
				public void muestraDialogoConMensaje(String mensaje ) {
					JOptionPane.showMessageDialog(this , mensaje);
				}
				
				public void actualizaProveedores(ControlProveedores control, List <Proveedor> proveedores) {
					this.controlProveedores = control;
					modelo.setRowCount(0);
					for(Proveedor proveedor:proveedores) {
						modelo.addRow(new Object[] {proveedor.getIdProv(), proveedor.getNomProveedor(), proveedor.getMarca(),
								proveedor.getTipo(), proveedor.getCosto()});
						table.setModel(modelo);
					}
					
				setVisible(true);
				}
}

