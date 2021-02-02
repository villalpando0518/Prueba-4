package mx.uam.ayd.proyecto.presentacion.recordatorios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Recordatorio;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@Component
public class VentanaRecordatorios extends JDialog {
	
	
	private ControlRecordatorio control;
	
	

	private final JPanel contentPanel = new JPanel();
	
	JTextArea recordatorios = new JTextArea();

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
	public VentanaRecordatorios() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			
			recordatorios.setText("Sin recordatorios");
			recordatorios.setEditable(false);
			recordatorios.setFont(new Font("Tahoma", Font.PLAIN, 14));
			recordatorios.setBounds(10, 43, 416, 158);
			contentPanel.add(recordatorios);
		}
		
		JLabel lblNewLabel = new JLabel("Recordatorios:");
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
	
	
	public void muestra(ControlRecordatorio control, Recordatorio r) {
		
		this.control = control;
		try {
			
			VentanaRecordatorios dialog = new VentanaRecordatorios();
			//dialog.recordatorios = r.toString();
			dialog.recordatorios.setText(r.getInfo());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
