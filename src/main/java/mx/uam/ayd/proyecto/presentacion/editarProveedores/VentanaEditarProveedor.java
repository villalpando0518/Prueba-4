package mx.uam.ayd.proyecto.presentacion.editarProveedores;

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

import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author Panther Zone
 *
 */
@Component
public class VentanaEditarProveedor extends JFrame {
	
	private JPanel contentPane; //JPanel destinado a albergar los botones "Actualizar" y "Cancelar"
	private ControlEditarProveedor controlEditarProveedor; ////Control asociado a esta ventana
	private JComboBox<Integer> comboBox;
	private JTextField nomProveedor;
	private JTextField marca;
	private JTextField tipo;
	private JTextField costo;

	public VentanaEditarProveedor() {
		initialize();
	}
	
	/**
	 * Se agregan todos los JLabel y JButton que se utilizan en la ventana para la interacción con el usuario.
	 */
	
	public void initialize() {
		setTitle("Editar Proveedor");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Editar Proveedor");
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
		
		nomProveedor = new JTextField();
		nomProveedor.setBounds(173, 69, 148, 20);
		contentPane.add(nomProveedor);
		nomProveedor.setColumns(10);
		
		marca = new JTextField();
		marca.setBounds(173, 100, 148, 20);
		contentPane.add(marca);
		marca.setColumns(10);
		
		tipo = new JTextField();
		tipo.setBounds(173, 131, 148, 20);
		contentPane.add(tipo);
		tipo.setColumns(10);
		
		costo = new JTextField();
		costo.setBounds(173, 162, 148, 20);
		contentPane.add(costo);
		costo.setColumns(10);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Id proveedor");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(93, 41, 86, 17);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Marca:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(77, 103, 86, 17);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Costo:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(77, 163, 86, 17);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Tipo:");
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1_1.setBounds(77, 134, 86, 17);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		
		/**
		 * Se agrega el botón "Actualizar".
		 */
		JButton btnNewButton = new JButton("Actualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomProveedor.getText().equals("")|| marca.getText().equals("")||tipo.getText().equals("")||costo.getText().equals("")) {
						muestraDialogoConMensaje("Hay campos vacios o este empleado no existe");
			}else {
				controlEditarProveedor.editarProveedor(nomProveedor.getText(), (Integer)comboBox.getSelectedItem(), marca.getText(), 
						 tipo.getText(), Double.parseDouble(costo.getText()));
			}
		}
		
		}); 
		
		btnNewButton.setBounds(205, 223, 101, 27);
		contentPane.add(btnNewButton); 
		
		/**
		 * Se agrega el botón "Cancelar".
		 */
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlEditarProveedor.termina();
			}
		});
		btnNewButton_1.setBounds(329, 223, 95, 27);
		contentPane.add(btnNewButton_1);
		
	}
	
	public void muestra(ControlEditarProveedor controlEditarProveedor, List<Proveedor> proveedores) {
		this.controlEditarProveedor = controlEditarProveedor; 
		DefaultComboBoxModel<Integer> comboBoxModel = new DefaultComboBoxModel<>();
		for(Proveedor proveedor:proveedores) {
			comboBoxModel.addElement(proveedor.getIdProv());
		}
		comboBox.setModel(comboBoxModel);
		setVisible(true);
	}
	
	public void muestraDialogoConMensaje(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje);
	}
}
