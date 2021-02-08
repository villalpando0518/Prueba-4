package mx.uam.ayd.proyecto.presentacion.empleados;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

@Component
public class VentanaRegistrarEmpleado extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textapellidos;
	private JTextField textedad;
	private JTextField textsueldo;
	private JTextField textocupacion;

	private ControlRegistrarEmpleado control;
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
	public VentanaRegistrarEmpleado() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		lblNewLabel.setBounds(119, 65, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre(s):");
		lblNewLabel_1.setBounds(119, 35, 61, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setBounds(119, 95, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo:");
		lblNewLabel_3.setBounds(119, 125, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ocupación:");
		lblNewLabel_4.setBounds(119, 155, 61, 14);
		contentPanel.add(lblNewLabel_4);
		
		textnombre = new JTextField();
		textnombre.setBounds(190, 93, 136, 20);
		contentPanel.add(textnombre);
		textnombre.setColumns(10);
		
		textapellidos = new JTextField();
		textapellidos.setBounds(190, 123, 136, 20);
		contentPanel.add(textapellidos);
		textapellidos.setColumns(10);
		
		textedad = new JTextField();
		textedad.setBounds(190, 93, 136, 20);
		contentPanel.add(textedad);
		textedad.setColumns(10);
		
		textsueldo = new JTextField();
		textsueldo.setBounds(190, 123, 136, 20);
		contentPanel.add(textsueldo);
		textsueldo.setColumns(10);
		
		textocupacion = new JTextField();
		textocupacion.setBounds(190, 153, 136, 20);
		contentPanel.add(textocupacion);
		textocupacion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Registrar Empleado");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(10, 10, 187, 13);
		contentPanel.add(lblNewLabel_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.guardar(textnombre.getText(), textapellidos.getText(), 
								Integer.parseInt(textedad.getText()) , Double.parseDouble(textsueldo.getText()) 
								, textocupacion.getText());
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
				public void muestra(ControlRegistrarEmpleado control) {
					try {
						VentanaRegistrarEmpleado dialog = new VentanaRegistrarEmpleado();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.control = control;
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
}


