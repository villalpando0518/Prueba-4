package mx.uam.ayd.proyecto.presentacion.empleados;

import java.util.List;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import java.awt.event.ActionListener;

@Component

public class VentanaEmpleados extends JFrame {
	
	private JPanel contentPane;
	private ControlEmpleados controlEmpleados;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel(){ 
	    @Override 
	    public boolean isCellEditable(int row, int column) { 
	     return false; 
	    } 
	};
    
	public VentanaEmpleados() {
		initialize();
	}

	private void initialize() {
		setTitle("Empleados");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 33, 379, 153);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		modelo.addColumn("Id_Empleado");
		modelo.addColumn("Nombre(s)");
		modelo.addColumn("Apellidos");
		modelo.addColumn("Edad");
		modelo.addColumn("Sueldo");
		modelo.addColumn("Ocupación");
		
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEmpleados.editarEmpleado();
			}
		});
		btnNewButton.setBounds(172, 207, 96, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Registrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEmpleados.registrarEmpleado();
			}
		});
		btnNewButton_1.setBounds(27, 207, 96, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cancelar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(310, 207, 96, 29);
		contentPane.add(btnNewButton_2);
	}

	public void muestra(ControlEmpleados control, List <Empleado> empleados) {
		this.controlEmpleados = control;
		modelo.setRowCount(0);
		for(Empleado empleado:empleados) {
			modelo.addRow(new Object[] {empleado.getIdEmp(), empleado.getNombre(),
			empleado.getApellidos(), empleado.getEdad(), empleado.getSueldo(), 
			empleado.getOcupacion()});
			table.setModel(modelo);
			}
			
		setVisible(true);

		}
	
	public void registrarEmpleado() {
		controlEmpleados.registrar();
	}
	
	public void actualizaEmpleados(ControlEmpleados control, List <Empleado> empleados) {
		this.controlEmpleados = control;
		modelo.setRowCount(0);
		for(Empleado empleado:empleados) {
			modelo.addRow(new Object[] {empleado.getIdEmp(), empleado.getNombre(),
			empleado.getApellidos(), empleado.getEdad(), empleado.getSueldo(), 
			empleado.getOcupacion()});
			table.setModel(modelo);
		}
		setVisible(true);
	}
}



