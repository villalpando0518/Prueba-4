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
public class VentanaMenus extends JDialog {
	
	
	private ControlMenu control;
	
	

	private final JPanel contentPanel = new JPanel();
	
	JTextArea menus = new JTextArea();

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		try {
			VentanaRecordatorios dialog = new VentanaRecordatorios();
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
	public VentanaMenus() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			menus.setText("Menú del día");
			menus.setEditable(false);
			menus.setFont(new Font("Tahoma", Font.PLAIN, 14));
			menus.setBounds(10, 43, 416, 158);
			contentPanel.add(menus);
		}
		
		JLabel lblNewLabel = new JLabel("Menús");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(159, 10, 146, 22);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}
	
	
	public void muestra(ControlMenu control, Menu m) {
		
		this.control = control;
		try {
			
			VentanaMenus dialog = new VentanaMenus();
			//dialog.recordatorios = r.toString();
			dialog.menus.setText(m.getMen());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}