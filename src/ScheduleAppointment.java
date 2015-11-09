import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ScheduleAppointment extends JDialog {

	private JPanel contentPane;
	private JCheckBox chckbxMonday, chckbxTuesday,chckbxWednesday,chckbxThurday,chckbxFriday,
						chckbxAm, chckbxAm_1, chckbxAm_2,chckbxAm_3, chckbxPm_1,chckbxPm_2,
						chckbxPm,chckbxPm_3;
	private JComboBox comboBox;
	String day = "";
	String time = "";
	String id = "";
	String doctor = "";
	String ssn = "";

	
	public ScheduleAppointment() 
	{
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 301, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null); 
		
		JLabel lblWhatDaysOf = new JLabel("What Days of the week are you available?*");
		lblWhatDaysOf.setBounds(6, 81, 247, 14);
		contentPane.add(lblWhatDaysOf);
		
		 chckbxMonday = new JCheckBox("Monday");
		chckbxMonday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				day = "";
				day = arg0.getActionCommand();
			}
		});
		chckbxMonday.setBounds(6, 101, 83, 23);
		contentPane.add(chckbxMonday);
		
		 chckbxTuesday = new JCheckBox("Tuesday");
		chckbxTuesday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = "";
				day = e.getActionCommand();
			}
		});
		chckbxTuesday.setBounds(6, 127, 90, 23);
		contentPane.add(chckbxTuesday);
		
		JCheckBox chckbxWednesday = new JCheckBox("Wednesday");
		chckbxWednesday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = "";
				day = e.getActionCommand();
			}
		});
		chckbxWednesday.setBounds(6, 153, 108, 23);
		contentPane.add(chckbxWednesday);
		
		 chckbxThurday = new JCheckBox("Thurday");
		chckbxThurday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = "";
				day = e.getActionCommand();
			}
		});
		chckbxThurday.setBounds(6, 179, 102, 23);
		contentPane.add(chckbxThurday);
		
		 chckbxFriday = new JCheckBox("Friday");
		chckbxFriday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				day = "";
				day = e.getActionCommand();
			}
		});
		chckbxFriday.setBounds(6, 205, 83, 23);
		contentPane.add(chckbxFriday);
		
		JLabel lblWhatTimesOf = new JLabel("What times of the day are you available?*");
		lblWhatTimesOf.setBounds(6, 235, 209, 14);
		contentPane.add(lblWhatTimesOf);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				if(ssn != "" && day != "" && time != "")
				{
					id = Frames.rand();
					Frames.insert("SCHEDULE", Frames.user, id);
					Frames.update("SCHEDULE","DAY", Frames.user, day, id);
					Frames.update("SCHEDULE","TIME", Frames.user, time, id);
					Frames.update("SCHEDULE", "DOCTERSSN", Frames.user, ssn, id);
				
					
					chckbxMonday.setSelected(false);
					chckbxTuesday.setSelected(false);
					chckbxWednesday.setSelected(false);
					chckbxThurday.setSelected(false);
					chckbxFriday.setSelected(false);
					chckbxAm.setSelected(false);
					chckbxAm_1.setSelected(false);
					chckbxAm_2.setSelected(false);
					chckbxAm_3.setSelected(false);
					chckbxPm_1.setSelected(false);
					chckbxPm_2.setSelected(false);
					chckbxPm.setSelected(false);
					chckbxPm_3.setSelected(false);
					comboBox.setSelectedIndex(0);
					Frames.userMenu.setLocationRelativeTo(null);
					Frames.appt.setVisible(false); 
					Frames.userMenu.setVisible(true);
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "You have left an option blank", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		btnSubmit.setBounds(75, 385, 89, 23);
		contentPane.add(btnSubmit);
		
		 chckbxAm = new JCheckBox("8 am");
		chckbxAm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
				
			}
		});
		chckbxAm.setBounds(6, 256, 66, 23);
		contentPane.add(chckbxAm);
		
		 chckbxAm_1 = new JCheckBox("9 am");
		chckbxAm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxAm_1.setBounds(74, 256, 90, 23);
		contentPane.add(chckbxAm_1);
		
		 chckbxAm_2 = new JCheckBox("10 am");
		chckbxAm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxAm_2.setBounds(6, 287, 66, 23);
		contentPane.add(chckbxAm_2);
		
		 chckbxAm_3 = new JCheckBox("11 am");
		chckbxAm_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxAm_3.setBounds(74, 287, 66, 23);
		contentPane.add(chckbxAm_3);
		
		 chckbxPm = new JCheckBox("12 pm");
		chckbxPm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxPm.setBounds(6, 313, 66, 23);
		contentPane.add(chckbxPm);
		
		 chckbxPm_1 = new JCheckBox("1 pm");
		chckbxPm_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxPm_1.setBounds(74, 313, 90, 23);
		contentPane.add(chckbxPm_1);
		
		 chckbxPm_2 = new JCheckBox("2 pm");
		chckbxPm_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxPm_2.setBounds(6, 339, 66, 23);
		contentPane.add(chckbxPm_2);
		
		 chckbxPm_3 = new JCheckBox("3 pm");
		chckbxPm_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				time = "";
				time = e.getActionCommand();
			}
		});
		chckbxPm_3.setBounds(74, 339, 66, 23);
		contentPane.add(chckbxPm_3);
		
		
		
		
		comboBox = new JComboBox();
		comboBox.setBounds(10, 50, 164, 20);
		contentPane.add(comboBox);
		
		try
		{
			ArrayList<String> list = new ArrayList<String>();
			
			list = new ArrayList(Frames.list());
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
				doctor = evt.getItem().toString();
				ssn = Frames.get(doctor, "USERNAME", "DOCTOR", "SSN");			
				
			}
		});
		
		JLabel lblDoctors = new JLabel("Doctors");
		lblDoctors.setBounds(10, 25, 46, 14);
		contentPane.add(lblDoctors);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Frames.appt.setVisible(false);
				Frames.userMenu.setVisible(true);
			}
		});
		btnGoBack.setBounds(75, 410, 89, 23);
		contentPane.add(btnGoBack);
	}
}
