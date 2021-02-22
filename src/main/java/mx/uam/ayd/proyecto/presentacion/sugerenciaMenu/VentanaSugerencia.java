package mx.uam.ayd.proyecto.presentacion.sugerenciaMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.negocio.modelo.Sugerencia;
import mx.uam.ayd.proyecto.presentacion.registrarCliente.ControlRegistrarCliente;
import mx.uam.ayd.proyecto.presentacion.registrarCliente.VentanaRegistrarCliente;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.ControlRegistrarEmpleado;

@Component
public class VentanaSugerencia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textsugerencia;

	private ControlSugerencia control;
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
	public VentanaSugerencia() {
		setTitle("Agregar Sugerencia");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sugerencia");
		lblNewLabel.setBounds(67, 68, 78, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre Cliente");
		lblNewLabel_1.setBounds(57, 38, 88, 14);
		contentPanel.add(lblNewLabel_1);
		
		textnombre = new JTextField();
		textnombre.setBounds(155, 35, 171, 20);
		contentPanel.add(textnombre);
		textnombre.setColumns(10);
		
		textsugerencia = new JTextField();
		textsugerencia.setBounds(155, 65, 171, 20);
		contentPanel.add(textsugerencia);
		textsugerencia.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.guardar(textnombre.getText(), textsugerencia.getText());
						dispose();
					}
				});
				
				JButton btnNewButton = new JButton("Ver Sugerencias");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.iniciaSug();
					}
				});
				buttonPane.add(btnNewButton);
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
	
	            
				public void muestra(ControlSugerencia control, List<Sugerencia> sugerencia) {
					try {
						VentanaSugerencia dialog = new VentanaSugerencia();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.control = control;
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				public void muestraDialogoConMensaje(String mensaje ) {
					JOptionPane.showMessageDialog(this , mensaje);
				}
				
				public void actualizado(ControlSugerencia control2) {
					this.control = control2;
				}

}
