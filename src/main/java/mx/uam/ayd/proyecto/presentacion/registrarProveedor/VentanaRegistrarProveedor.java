package mx.uam.ayd.proyecto.presentacion.registrarProveedor;

import java.util.List;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.presentacion.editarProveedores.ControlEditarProveedor;
import mx.uam.ayd.proyecto.presentacion.proveedores.ControlProveedores;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

@Component
public class VentanaRegistrarProveedor extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private JTextField textnomProveedor;
	private JTextField textmarca;
	private JTextField texttipo;
	private JTextField textcosto;
	private List <Proveedor> proveedores;

	private ControlRegistrarProveedor controlRegistrarProveedor;
	
	public VentanaRegistrarProveedor() {
		setTitle("Registrar Proveedor");
		
		setBounds(100, 100, 435, 328);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		/*
		 * Se agregan todos los JLabel y JButton que se utilizan en la ventana para la interacción con el usuario.
		 */
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(84, 110, 63, 14);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre del Proveedor(s):");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(36, 84, 142, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tipo:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(84, 135, 46, 14);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Costo:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(84, 160, 46, 14);
		contentPanel.add(lblNewLabel_3);
		
		
		textnomProveedor = new JTextField();
		textnomProveedor.setBounds(190, 82, 136, 20);
		contentPanel.add(textnomProveedor);
		textnomProveedor.setColumns(10);
		
		textmarca = new JTextField();
		textmarca.setBounds(190, 107, 136, 20);
		contentPanel.add(textmarca);
		textmarca.setColumns(10);
		
		texttipo = new JTextField();
		texttipo.setBounds(190, 132, 136, 20);
		contentPanel.add(texttipo);
		texttipo.setColumns(10);
		
		textcosto = new JTextField();
		textcosto.setBounds(190, 157, 136, 20);
		contentPanel.add(textcosto);
		textcosto.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Registrar un Proveedor");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(126, 22, 216, 25);
		contentPanel.add(lblNewLabel_5);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				/**
				 * Se agrega el botón "Guardar".
				 */
				JButton okButton = new JButton("Guardar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textnomProveedor.getText().equals("") || textmarca.getText().equals("") || texttipo.getText().equals("") ||textcosto.getText().equals("")) {
							muestraDialogoConMensaje("No deben de haber campos vacios");
						}else {
							    controlRegistrarProveedor.registrarProveedor(textnomProveedor.getText(), textmarca.getText(), 
										 texttipo.getText(), Double.parseDouble(textcosto.getText()));
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				/**
				 * Se agrega el botón "Cancelar".
				 */
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
	 * Recibe el controlRegistrarProveedor del que proviene esta ventana 
	 * y a la lista de proveedores. Muestra la ventana en pantalla.
	 * @param controlRegistrarOrden Control asociado a esta ventana.
	 * @param List<Proveedor> proveedor Lista que contiene todos los proveedores.
	 */
	public void muestra(ControlRegistrarProveedor control,  List<Proveedor> proveedor) 
    {
		try {
			   VentanaRegistrarProveedor dialog = new VentanaRegistrarProveedor();
			   dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			   dialog.controlRegistrarProveedor = control;
			   dialog.setVisible(true);
			} catch (Exception e) 
		           {
						e.printStackTrace();
				   }				
	}	
				
   public void actualizaVentana() 
   {
	   controlRegistrarProveedor.actualizaVentana();
   }
				
   public void muestraDialogoConMensaje(String mensaje )
   {
	 JOptionPane.showMessageDialog(this , mensaje);
   }
				
   public void actualizado(ControlRegistrarProveedor control2) 
   {
	this.controlRegistrarProveedor = control2;
   }
}

