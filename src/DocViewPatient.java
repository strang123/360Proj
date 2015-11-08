import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
public class DocViewPatient extends JFrame{
	
	private JPanel contentPane, btnPane;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnCancelAppointment, btnUpdateAppointment, btnGoBack;
	public static  int row=0;
	public static int column=0;
	public static String colString = "";
	public static String update="";
	public static String id = "";
	
	public DocViewPatient() 
	{
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600); //window size
		setTitle("Appointment List"); //window title
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(3, 6, 3, 6)); //distance the plane is from the edges of the window
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable(Frames.scheduleTableDocs());
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.setShowGrid(true);
		table.getTableHeader().setReorderingAllowed(false); //prevent user from swapping columns
		table.getTableHeader().setResizingAllowed(false); //prevent user from resizing columns
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); //prevent user from selecting multiple doctors
		table.setAutoCreateColumnsFromModel(false); //forgot why I have this here; it's probably important
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.getModel().addTableModelListener(new TableModelListener(){
			public void tableChanged(TableModelEvent e){
				row = table.getSelectedRow();
				column = table.getSelectedColumn();
				update = table.getModel().getValueAt(row, column).toString();
				colString = table.getModel().getColumnName(column).toString();
				id = table.getModel().getValueAt(row, 1).toString();
			}
    	});
		
		
		scrollPane.setViewportView(table); //lets table be scroll able
		
		btnPane = new JPanel();
		contentPane.add(btnPane, BorderLayout.SOUTH);
		
		btnCancelAppointment = new JButton("Cancel Appointment");
		btnCancelAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(table.getCellEditor() != null)
				{
					table.getCellEditor().stopCellEditing();
					Frames.delete("SCHEDULE", "ID" ,id);
					Frames.docMenu.setVisible(true);
					Frames.docViewPatient.setVisible(false); 
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Please double click on Day or Time of appointment to delete", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);

				}
	    		
			}
		});
		btnPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		btnPane.add(btnCancelAppointment);
		
	    btnUpdateAppointment = new JButton("Update Appointment");
	    btnUpdateAppointment.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		table.getCellEditor().stopCellEditing();
	    		Frames.update("SCHEDULE", colString ,Frames.doc_patient, update, id);
	    		Frames.docMenu.setVisible(true);
				Frames.docViewPatient.setVisible(false); 
	    	}
	    });
		btnPane.add(btnUpdateAppointment);
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.docMenu.setVisible(true);
				Frames.docViewPatient.setVisible(false); 
			}
		});
		btnPane.add(btnGoBack);	
		
		
		
	}
	

}
