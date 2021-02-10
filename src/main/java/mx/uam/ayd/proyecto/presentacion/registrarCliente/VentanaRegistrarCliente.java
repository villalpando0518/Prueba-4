package mx.uam.ayd.proyecto.presentacion.registrarCliente;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class VentanaRegistrarCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnombre;
	private JTextField textcorreo;

	private ControlRegistrarCliente control;
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
	public VentanaRegistrarCliente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Correo");
		lblNewLabel.setBounds(119, 65, 46, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(119, 35, 61, 14);
		contentPanel.add(lblNewLabel_1);
		
		textnombre = new JTextField();
		textnombre.setBounds(190, 35, 136, 20);
		contentPanel.add(textnombre);
		textnombre.setColumns(10);
		
		textcorreo = new JTextField();
		textcorreo.setBounds(190, 65, 136, 20);
		contentPanel.add(textcorreo);
		textcorreo.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						control.guardar(textnombre.getText(), textcorreo.getText());
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
	
				public void muestra(ControlRegistrarCliente control) {
					try {
						VentanaRegistrarCliente dialog = new VentanaRegistrarCliente();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.control = control;
						dialog.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}


}
