package mx.uam.ayd.proyecto.presentacion.registrarCliente;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;

@Component
public class VentanaRegistrarCliente extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textcorreo;
	private JTextField textpromocion;
	private List <Cliente> clientes;

	private ControlRegistrarCliente control;
	private JTextField textField;
	
	/**
	 * VentanaRegistrarCliente: Permite inicializar los componentes de la ventana
	 */
	public VentanaRegistrarCliente() {
		setTitle("Agregar Cliente");
		setTitle("Registrar Cliente");

		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(114, 89, 82, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Correo:");
		lblNewLabel_1.setBounds(114, 120, 61, 14);
		contentPanel.add(lblNewLabel_1);	
		
		textnombre = new JTextField();
		textnombre.setBounds(200, 86, 136, 20);
		contentPanel.add(textnombre);
		textnombre.setColumns(10);
		
		textcorreo = new JTextField();
		textcorreo.setBounds(200, 117, 136, 20);
		contentPanel.add(textcorreo);
		textcorreo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Agregar Cliente");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(136, 24, 216, 25);
		contentPanel.add(lblNewLabel_5);
		
		textpromocion = new JTextField();
		textpromocion.setBounds(200, 148, 136, 20);
		contentPanel.add(textpromocion);
		textpromocion.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Promoción:");
		lblNewLabel_1_1.setBounds(114, 151, 88, 14);
		contentPanel.add(lblNewLabel_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.registrarCliente(textnombre.getText(), textcorreo.getText(), textpromocion.getText());
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
		/**
		 * muestra: Muestra la lista de los clientes registrados
		 * @param control
		 * @param cliente
		 */
		public void muestra(ControlRegistrarCliente control, List <Cliente> cliente) {
				try {
					VentanaRegistrarCliente dialog = new VentanaRegistrarCliente();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.control = control;
					dialog.setVisible(true);
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
				
		/**
		 * muestraDialogoConMensaje: Muestra un mensaje cuando el cliente se agrego con éxito a la BD
		 * @param mensaje Mensaje de éxito o erroe al agregar cliente
		 */
		public void muestraDialogoConMensaje(String mensaje ) {
			JOptionPane.showMessageDialog(this , mensaje);
		}
}
