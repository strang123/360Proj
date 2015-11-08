import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;

public class AppointmentList extends JDialog {

	private static final long serialVersionUID = -3168483869283270295L;
	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton;
	public int numberOfDoctors = 55;

	
	public AppointmentList() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600); //window size
		setTitle("Appointment List"); //window title
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); //distance the plane is from the edges of the window
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
	
		
		table = new JTable(new DefaultTableModel(new Object[]{"Doctor's Name", "Location", "Day", "Time"},numberOfDoctors)) {
		//	private static final long serialVersionUID = -8187053556158357139L; //gets rid of some warning; something to do with serialization
			public boolean isCellEditable(int row, int column){ //prevents user from editing cells; there apparently is not a cleaner way of doing this
		        return false;
		   }
		};
		
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.getTableHeader().setReorderingAllowed(false); //prevent user from swapping columns
		table.getTableHeader().setResizingAllowed(false); //prevent user from resizing columns
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //prevent user from selecting multiple doctors
		table.setAutoCreateColumnsFromModel(false); //forgot why I have this here; it's probably important
		table.setBounds(0, 15, 475, 450);
		scrollPane.setViewportView(table); //lets table be scrollable

		contentPane.add(scrollPane);
		
		btnNewButton = new JButton("Request Appointment"); 
		btnNewButton.setBounds(10, 550, 150, 50);
		contentPane.add(btnNewButton);
		getRootPane().setDefaultButton(btnNewButton); //makes button highlight table
		btnNewButton.requestFocus(); //highlights button
	}
}
