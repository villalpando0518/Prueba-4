package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import java.awt.Font;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class VentanaEditarEmpleado extends JFrame {
	
	private JPanel contentPane;
	private ControlEditarEmpleado controlEditarEmpleado;
	private JComboBox<Integer> comboBox;
	private JTextField nombre;
	private JTextField apellidos;
	private JTextField edad;
	private JTextField sueldo;
	private JTextField ocupacion;

	public VentanaEditarEmpleado() {
		initialize();
	}
	
	public void initialize() {
		setTitle("Editar Empleado");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Empleado");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(137, 11, 136, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre(s):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(77, 70, 86, 17);
		contentPane.add(lblNewLabel_1);
		
		comboBox = new JComboBox<Integer>();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setBounds(189, 41, 70, 22);
		contentPane.add(comboBox);
		
		nombre = new JTextField();
		nombre.setBounds(173, 69, 148, 20);
		contentPane.add(nombre);
		nombre.setColumns(10);
		
		apellidos = new JTextField();
		apellidos.setBounds(173, 100, 148, 20);
		contentPane.add(apellidos);
		apellidos.setColumns(10);
		
		edad = new JTextField();
		edad.setBounds(173, 131, 148, 20);
		contentPane.add(edad);
		edad.setColumns(10);
		
		sueldo = new JTextField();
		sueldo.setBounds(173, 162, 148, 20);
		contentPane.add(sueldo);
		sueldo.setColumns(10);
		
		ocupacion = new JTextField();
		ocupacion.setBounds(173, 192, 148, 20);
		contentPane.add(ocupacion);
		ocupacion.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Id empleado");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(93, 41, 86, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Apellidos:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(77, 103, 86, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Sueldo:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(77, 163, 86, 17);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Ocupación:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(77, 193, 86, 17);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Edad:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(77, 134, 86, 17);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nombre.getText().equals("")|| apellidos.getText().equals("")||edad.getText().equals("")||sueldo.getText().equals("")||
					ocupacion.getText().equals("")) {
						muestraDialogoConMensaje("Hay campos vacios o este empleado no existe");
			}else {
				controlEditarEmpleado.editarEmpleado(nombre.getText(), (Integer)comboBox.getSelectedItem(), apellidos.getText(), 
				Integer.parseInt(edad.getText()), Double.parseDouble(sueldo.getText()), ocupacion.getText());
			}
		}
		
		}); 
		
		btnNewButton.setBounds(205, 223, 101, 27);
		contentPane.add(btnNewButton); 
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEditarEmpleado.termina();
			}
		});
		btnNewButton_1.setBounds(329, 223, 95, 27);
		contentPane.add(btnNewButton_1);
		
	}
	
	public void muestra(ControlEditarEmpleado controlEditarEmpleado, List<Empleado> empleados) {
		this.controlEditarEmpleado = controlEditarEmpleado; 
		DefaultComboBoxModel<Integer> comboBoxModel = new DefaultComboBoxModel<>();
		for(Empleado empleado:empleados) {
			comboBoxModel.addElement(empleado.getIdEmp());
		}
		comboBox.setModel(comboBoxModel);
		setVisible(true);
	}
	
	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
