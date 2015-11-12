

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JComboBox;

public class RetrieveInfoWindowHSP extends JDialog {
	private static final long serialVersionUID = 5025721258742123338L;
	public String
		combobox_patient,
		fpatientName,
		lpatientName,
		gender,
		email,
		socialSecurity,
		insuranceName,
		patientCondition,
		medications;
	private Object[][] data = {
			{"First Name:", fpatientName},
			{"Last Name:", lpatientName},
	        {"Gender:", gender},
	        {"E-mail:", email},
	        {"SSN:", socialSecurity},
	        {"Insurance:", insuranceName}
	 
	};
	private static final int patientNameField = 0;
	private static final int genderField = 1;
	private static final int birthdayField = 2;
	private static final int phoneNumberField = 3;
	private static final int emailField = 4;
	private static final int addressField = 5;
	private static final int socialSecurityField = 6;
	private static final int insuranceNameField = 7;
	private String getField(int row) {return (String) table.getModel().getValueAt(row, 1);}
	private void whine(String message) {
		JOptionPane.showMessageDialog(getContentPane(), message, "ERROR", JOptionPane.ERROR_MESSAGE);
	}
	private void check() {
		try {
			if(!validEmail()) {whine("Please enter a valid email address.");}
			else if(!validBirthday(getField(birthdayField), 0, "", new ArrayList<String>())) {whine("Please enter a valid birthday.");}
			else if(!validCellPhone()) {whine("Please enter a valid phone number.");}
		}
		catch(Exception e) {whine("Please fill all entries.");}
	}
	private boolean validEmail() {
		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		Matcher m = p.matcher(getField(emailField));
		if(m.matches()) {return true;}
		else {return false;}
	}
	private boolean validBirthday(String parsing, int index, String nextToken, ArrayList<String> results) {
		try {
			if(index == parsing.length()) {
				results.add(nextToken);
				return validBirthMonth(results.get(0)) && validBirthDay(results.get(1)) && validBirthYear(results.get(2));
			}
			else if(parsing.charAt(index) == '/' || parsing.charAt(index) == '-') {
				results.add(nextToken);
				return validBirthday(parsing, index+1, "", results);
			}
			else if(Character.isDigit(parsing.charAt(index))) {
				return validBirthday(parsing, index+1, nextToken+parsing.charAt(index), results);
			}
		}
		catch (Exception e) {return false;}
		return false;
	}
	private boolean validBirthMonth(String month) {
		try {
			int i = Integer.parseInt(month);
			if(i > 12 || i < 1 || (month.length() != 1 && month.length() != 2)) {return false;}
			else {return true;}
		}
		catch(NumberFormatException e) {return false;}
	}
	private boolean validBirthDay(String day) {
		try {
			int i = Integer.parseInt(day);
			if(i > 31 || i < 1 || (day.length() != 1 && day.length() != 2)) {return false;}
			else {return true;}
		}
		catch(NumberFormatException e) {return false;}
	}
	private boolean validBirthYear(String year) {
		try {
			int i = Integer.parseInt(year);
			if(i < 1800 || i > 2100 || year.length() != 4) {return false;}
			else {return true;}
		}
		catch(NumberFormatException e) {return false;}
	}
	private boolean validCellPhone() {
		try {
			String cellPhone = getField(phoneNumberField);
			if(cellPhone.length() != 10) {return false;}
			else {return true;}
		}
		catch(NumberFormatException e) {return false;}
	}
	
	private JPanel contentPane;
	private JTable table;
	private String[] columnNames = {"", ""}; //having two columns doesn't work without the nonexistent column names
    private DefaultTableModel model = new DefaultTableModel(data, columnNames) {
		private static final long serialVersionUID = -8187053556158357139L; //gets rid of some warning; something to do with serialization
		public boolean isCellEditable(int row, int column) { //prevents user from editing the "Patient Name", but allows editting patientName
		if (column == 1) {return true;}
	    return false;
	   }
	};
	private JToolBar toolBar;
	private JButton btnUpdate;
	private JButton btnEditMedicalHistory;
	private JButton btnSendAlert;
	private JButton btnViewAppointments;
	private JComboBox comboBox;
	private JButton btnGoBack;
	public RetrieveInfoWindowHSP() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(300, 300, 484, 240); //window size
		setMinimumSize(new Dimension(484, 200)); //prevents the user from shrinking the window to silly sizes
		setTitle("IPIMS");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(3, 6, 0, 6)); //distance the plane is from the edges of the window
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 3, 456, 176);
		contentPane.add(scrollPane);
		table = new JTable(model);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.setShowGrid(false);
		table.getTableHeader().setReorderingAllowed(false); //prevent user from swapping columns
		table.getTableHeader().setResizingAllowed(false); //prevent user from resizing columns
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //prevent user from selecting multiple doctors
		table.getColumnModel().getColumn(0).setPreferredWidth(2);
		table.setTableHeader(null);
		table.setAutoCreateColumnsFromModel(false); //forgot why I have this here; it's probably important
		scrollPane.setViewportView(table); //lets table be scrollable
		
		toolBar = new JToolBar();
		toolBar.setBounds(6, 179, 456, 23);
		toolBar.setFloatable(false);
		contentPane.add(toolBar);
	/*	btnViewAppointments = new JButton("View Appointments");
		btnViewAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Frames.patient_info.setVisible(false); 
				Frames.docViewPatient.dispose();
				Frames.docViewPatient = new DocViewPatient();
				Frames.docViewPatient.setLocationRelativeTo(null);
				Frames.docViewPatient.setVisible(true);
			}
		});
		toolBar.add(btnViewAppointments);*/
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e)
		{
			//check();
				if(table.getValueAt(0, 1) != null &&
						table.getValueAt(1, 1) != null &&
						table.getValueAt(2, 1) != null &&
						table.getValueAt(3, 1) != null &&
						table.getValueAt(4, 1) != null &&
						table.getValueAt(5, 1) != null)
				{
					fpatientName = table.getValueAt(0, 1).toString();
					lpatientName = table.getValueAt(1, 1).toString();
					gender = table.getValueAt(2, 1).toString();
					email = table.getValueAt(3, 1).toString();
					socialSecurity = table.getValueAt(4, 1).toString();
					insuranceName = table.getValueAt(5, 1).toString();
				}
				if(fpatientName != "" &&
						lpatientName != "" &&
						gender != "" &&
						email != "" &&
						socialSecurity != "" &&
						insuranceName != "" && table.getCellEditor() != null)
				{
					table.getCellEditor().stopCellEditing();
					Frames.updateinfo("PATIENT", "FIRSTNAME", fpatientName, combobox_patient);
					Frames.updateinfo("PATIENT", "LASTNAME", lpatientName, combobox_patient);
					Frames.updateinfo("PATIENT", "GENDER", gender, combobox_patient);
					Frames.updateinfo("PATIENT", "EMAIL", email, combobox_patient);
					Frames.updateinfo("PATIENT", "SSN", socialSecurity, combobox_patient);
					Frames.updateinfo("PATIENT", "INSURANCENAME", insuranceName, combobox_patient);
					Frames.patient_info_hsp.setVisible(false); 
					Frames.nspMenu.setLocationRelativeTo(null);
					Frames.nspMenu.setVisible(true);
					JOptionPane.showMessageDialog(getContentPane(), "Patient information has been updated", "Update Successful",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(getContentPane(), "Ensure that you have filled all forms", "Error",JOptionPane.ERROR_MESSAGE);

				}
					
			
		}
		});
		toolBar.add(btnUpdate);	
		
		comboBox = new JComboBox();
		try
		{
			ArrayList<String> list = new ArrayList<String>();
			list = new ArrayList(Frames.listPatients());
			comboBox.addItem("");
			for(int i = 0; i < list.size(); i++)
			{
				comboBox.addItem(list.get(i));
			}
		}
		catch(NullPointerException e)
		{
			e.printStackTrace();
		}
		comboBox.addItemListener(new ItemListener()
		{
	
			public void itemStateChanged(ItemEvent evt) 
			{
				combobox_patient = evt.getItem().toString();
				Frames.doc_patient = combobox_patient;
				table.setValueAt(Frames.get(combobox_patient, "USERNAME", "PATIENT", "FIRSTNAME"), 0, 1);
				table.setValueAt(Frames.get(combobox_patient, "USERNAME", "PATIENT", "LASTNAME"), 1, 1);
				table.setValueAt(Frames.get(combobox_patient, "USERNAME", "PATIENT", "GENDER"), 2, 1);
				table.setValueAt(Frames.get(combobox_patient, "USERNAME", "PATIENT", "EMAIL"), 3, 1);
				table.setValueAt(Frames.get(combobox_patient, "USERNAME", "PATIENT", "SSN"), 4, 1);
				table.setValueAt(Frames.get(combobox_patient, "USERNAME", "PATIENT", "INSURANCENAME"), 5, 1);
			}
		});
		
		btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				Frames.patient_info_hsp.setVisible(false); 
				if(Frames.nspMenu != null)
				{
					Frames.nspMenu.dispose();
				}				
				Frames.nspMenu = new NSPStaffMenuWindow();
				Frames.nspMenu.setLocationRelativeTo(null);
				Frames.nspMenu.setVisible(true);
			}
		});
		toolBar.add(btnGoBack);
		toolBar.add(comboBox);
		
	}
}








