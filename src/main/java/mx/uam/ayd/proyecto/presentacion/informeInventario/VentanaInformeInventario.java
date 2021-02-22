package mx.uam.ayd.proyecto.presentacion.informeInventario;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.presentacion.realizarPedido.ControlRealizarPedido;
import mx.uam.ayd.proyecto.presentacion.ventasMenu.ControlVentasMenu;

import javax.swing.JTable;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

/**
 * Ventana de la HU-44 Realizar un Pedido
 * 
 * @author Anonymux Corporation
 * 
 */
@SuppressWarnings("serial")
@Component
public class VentanaInformeInventario extends JFrame {
	
	/**
	 * Se declara el contenedor, sirven para agrupar los objetos de esta ventana (buttons, 
	 * checkboxs, jtexts, etc...)
	 */
	private JPanel contentPane;
	/**
	 * Se declara la comunicación con el controlador de Realizar Pedidos{@link ControlRealizarPedido}
	 */
	private ControlInformeInventario control;
	
	@Autowired
	private ControlVentasMenu controlVentasM;
	/**
	 * Se declara la tabla donde se despliegan los datos obtenido
	 */
	private JTable table;
	/**
	 * Se declara el {@link DefaultTableModel} que se usa en la ventana con el nombre model
	 */
	private DefaultTableModel model = new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"Fecha", "ID", "Nombre Producto", "Descripci\u00F3n", "Cantidad", "Cantidad M\u00EDnima"
		}
	) {
		boolean[] columnEditables = new boolean[] {
			false, false, false, false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	};

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgregarUsuario frame = new VentanaAgregarUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public VentanaInformeInventario() {
		setTitle("Informes de Inventario");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel title = new JLabel("Informes de Inventario");
		title.setBounds(122, 58, 392, 73);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Arial", Font.BOLD, 32));
		
		JLabel lblTabla = new JLabel("Productos que necesitan atención (hay escasez) ");
		lblTabla.setBounds(52, 150, 380, 13);
		lblTabla.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnRealizarPedido = new JButton("Realizar un pedido");
		btnRealizarPedido.setBounds(123, 394, 179, 33);
		btnRealizarPedido.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 181, 519, 195);
		scrollPane.setEnabled(false);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.setBounds(454, 470, 111, 25);
		btnCerrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		table = new JTable();
		table.setEnabled(false);
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.setModel(model);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.getColumnModel().getColumn(3).setPreferredWidth(203);
		table.getColumnModel().getColumn(5).setPreferredWidth(99);
		scrollPane.setViewportView(table);
		contentPane.setLayout(null);
		contentPane.add(title);
		contentPane.add(lblTabla);
		contentPane.add(btnCerrar);
		contentPane.add(scrollPane);
		contentPane.add(btnRealizarPedido);
		
		JButton btnNewButton = new JButton("Ventas de Menú");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlVentasM.inicia();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBounds(336, 394, 166, 33);
		contentPane.add(btnNewButton);
		
		// Listeners de los botones de la ventana
		
		btnCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.cerrar();
			}
		});
		
		btnRealizarPedido.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.iniciaRealizarPedido();
			}
		});
		
	}
	
	/**
	 * Recibe al controlador y una lista de Productos para mostrarlo en la ventana
	 * Se comunica con el controlador 
	 * 
	 * @param control
	 * @param productos
	 */
	public void muestra(ControlInformeInventario control, List <Producto> productos) {
		this.control = control;
		model.setRowCount(0);
		for(Producto producto:productos) {
			model.addRow(new Object[] {producto.getFecha(), producto.getIdProducto(),producto.getNombreProducto() , producto.getDescripcion(), producto.getCantidad(), producto.getMinimo()});
		}
		setVisible(true);
	}
}
