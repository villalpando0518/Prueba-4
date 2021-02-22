package mx.uam.ayd.proyecto.presentacion.sugerenciaMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.Sugerencia;

@Component
public class VentanaVerSugerencias extends JDialog {

	private final JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel modelo = new DefaultTableModel(){ 
	    @Override 
	    public boolean isCellEditable(int row, int column) { 
	     return false; 
	    } 
	};
	
	private JTextField textnombre;
	private JTextField textsugerencia;

	private ControlSugerencia controlSugerencias;
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
	
	
	public VentanaVerSugerencias() {
		this.contentPane = new JPanel();
		initialize();
	}
	
	private void initialize() {
		setTitle("Sugerencias");
		setBounds(100, 100, 450, 300);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 33, 379, 153);
		contentPane.add(scrollPane);
		
		table = new JTable(modelo);
		modelo.addColumn("Id_Sugerencia");
		modelo.addColumn("NombreCliente");
		modelo.addColumn("Sugerencia");
		
		scrollPane.setViewportView(table);
	}
	
	
	           // muestra la lista de sugerencias 
				public void muestraSug(ControlSugerencia control, List <Sugerencia> sugerencia) {
					this.controlSugerencias = control;
					modelo.setRowCount(0);
					for(Sugerencia sugerencias:sugerencia) {
						modelo.addRow(new Object[] {sugerencias.getIdSugerencia(), sugerencias.getNombre(), sugerencias.getSugerencia()});
						table.setModel(modelo);
						}
					setVisible(true);
					}
				
}
