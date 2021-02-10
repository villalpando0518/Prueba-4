package mx.uam.ayd.proyecto.presentacion.registrarEmpleado;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

@Component
public class VentanaRegistrarEmpleado extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textapellidos;
	private JTextField textedad;
	private JTextField textsueldo;
	private JTextField textocupacion;
	private List <Empleado> empleados;

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
		setTitle("Registrar Empleado");
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Apellidos:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(84, 110, 63, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre(s):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(84, 84, 78, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Edad:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(84, 135, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Sueldo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(84, 160, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Ocupación:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(84, 185, 61, 20);
		contentPanel.add(lblNewLabel_4);
		
		textnombre = new JTextField();
		textnombre.setBounds(190, 82, 136, 20);
		contentPanel.add(textnombre);
		textnombre.setColumns(10);
		
		textapellidos = new JTextField();
		textapellidos.setBounds(190, 107, 136, 20);
		contentPanel.add(textapellidos);
		textapellidos.setColumns(10);
		
		textedad = new JTextField();
		textedad.setBounds(190, 132, 136, 20);
		contentPanel.add(textedad);
		textedad.setColumns(10);
		
		textsueldo = new JTextField();
		textsueldo.setBounds(190, 157, 136, 20);
		contentPanel.add(textsueldo);
		textsueldo.setColumns(10);
		
		textocupacion = new JTextField();
		textocupacion.setBounds(190, 186, 136, 20);
		contentPanel.add(textocupacion);
		textocupacion.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Registrar un Empleado");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(126, 22, 216, 25);
		contentPanel.add(lblNewLabel_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.registrarEmpleado(textnombre.getText(), textapellidos.getText(), 
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
	
				public void muestra(ControlRegistrarEmpleado control,  List<Empleado> empleado) {
					try {
						VentanaRegistrarEmpleado dialog = new VentanaRegistrarEmpleado();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.control = control;
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				
					
				}	
				
				public void actualizaVentana() {
					control.actualizaVentana();
				}
				
				public void muestraDialogoConMensaje(String mensaje ) {
					JOptionPane.showMessageDialog(this , mensaje);
				}
				
				public void actualizado(ControlRegistrarEmpleado control2) {
					this.control = control2;
				}
}
