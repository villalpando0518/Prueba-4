package mx.uam.ayd.proyecto.presentacion.empleados;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class VentanaEmpleados extends JFrame {

	private final JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel modelo = new DefaultTableModel(){ 
	    @Override 
	    public boolean isCellEditable(int row, int column) { 
	     return false; 
	    } 
	};
	
	private JTextField textnombre;
	private JTextField textapellidos;
	private JTextField textedad;
	private JTextField textsueldo;
	private JTextField textocupacion;

	private ControlEmpleados controlEmpleados;
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
	
	
	public VentanaEmpleados() {
		this.contentPane = new JPanel();
		initialize();
	}
	
	private void initialize() {
		setTitle("Empleados");
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(48, 197, 89, 23);
		contentPane.add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEmpleados.registrarEmpleado();
			}
		});
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEmpleados.editarEmpleado();
			}
		});
		btnEditar.setBounds(289, 197, 89, 23);
		contentPane.add(btnEditar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 33, 379, 153);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		modelo.addColumn("Id_Empleado");
		modelo.addColumn("Nombre");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Edad");
		modelo.addColumn("Sueldo");
		modelo.addColumn("Ocupación");
		
		scrollPane.setViewportView(table);
	}
	
	
				public void muestra(ControlEmpleados control, List <Empleado> empleados) {
					this.controlEmpleados = control;
					modelo.setRowCount(0);
					for(Empleado empleado:empleados) {
						modelo.addRow(new Object[] {empleado.getIdEmp(), empleado.getNombre(), empleado.getApellidos(),
						empleado.getEdad(), empleado.getSueldo(), empleado.getOcupacion()});
						table.setModel(modelo);
						}
					setVisible(true);
					}
				
				public void registrarEmpleado() {
					controlEmpleados.registrar();
				}
				
				public void muestraDialogoConMensaje(String mensaje ) {
					JOptionPane.showMessageDialog(this , mensaje);
				}
				
				public void actualizaEmpleados(ControlEmpleados control, List <Empleado> empleados) {
					this.controlEmpleados = control;
					modelo.setRowCount(0);
					for(Empleado empleado:empleados) {
						modelo.addRow(new Object[] {empleado.getIdEmp(), empleado.getNombre(), empleado.getApellidos(), empleado.getEdad(),
						empleado.getSueldo(), empleado.getOcupacion()});
						table.setModel(modelo);
					}
					
				setVisible(true);
				}
}



