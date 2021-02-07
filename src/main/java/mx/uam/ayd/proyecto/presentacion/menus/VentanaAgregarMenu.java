package mx.uam.ayd.proyecto.presentacion.menus;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Menu;

import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@Component
public class VentanaAgregarMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private ControlMenu control;
	
	private JTextArea menu = new JTextArea();

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		try {
			VentanaAgregarRecordatorio dialog = new VentanaAgregarRecordatorio();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	*/
	
	
	
	/**
	 * Create the dialog.
	 */
	public VentanaAgregarMenu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		menu.setText("Nada");
		menu.setBounds(10, 40, 369, 151);
		contentPanel.add(menu);

		
		JLabel lblNewLabel = new JLabel("Menú del día:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 10, 149, 13);
		contentPanel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setText("");
			}
		});
		btnNewButton.setBounds(150, 201, 85, 21);
		contentPanel.add(btnNewButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton Guardar = new JButton("Guardar");
				Guardar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//control.actualizarRecordatorios(recordatorio.getText());
						actualizarRec();
						dispose();
						
					}
				});
				Guardar.setActionCommand("OK");
				buttonPane.add(Guardar);
				getRootPane().setDefaultButton(Guardar);
			}
			{
				JButton cancelButton = new JButton("Cancel");
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
	
	public void muestra(ControlMenu control, Menu m) {
		
		//this.control = control;
		try {
			VentanaAgregarMenu dialog = new VentanaAgregarMenu();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.control = control;
			dialog.menu.setText(m.getMen());
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void actualizarRec() {
		this.control.actualizarMenus(this.menu.getText());
	}
}
