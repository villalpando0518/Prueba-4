package mx.uam.ayd.proyecto.presentacion.ventasMenu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.VentasMenu;

import javax.swing.JScrollPane;

@Component
public class VentanaVentasMenu extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private ControlVentasMenu control;
	
	private DefaultTableModel model = new DefaultTableModel(new Object[][] {
	},
	new String[] {
		"Fecha", "Contenido", "Nun de ventas"
	}
			);

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			VentanaVentasMenu dialog = new VentanaVentasMenu();
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
	public VentanaVentasMenu() {
		setBounds(100, 100, 471, 345);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(30, 63, 395, 162);
			contentPanel.add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			table.setModel(model);
			/*table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Fecha", "Contenido", "Nun de ventas"
				}
			));*/
			
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setMinWidth(75);
			table.getColumnModel().getColumn(2).setPreferredWidth(20);
		}
		
		JLabel lblNewLabel = new JLabel("Ventas de los menú");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 23, 138, 26);
		contentPanel.add(lblNewLabel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void muestra(ControlVentasMenu i) {
		this.control=i;
		List<VentasMenu> ventas = control.recuperarVentas();
		model.setRowCount(0);
		for(VentasMenu j: ventas) {
			model.addRow(new Object[] {j.getFecha(),j.getMenu(),j.getVentas()});
		}
		
		this.setVisible(true);
	}
}
