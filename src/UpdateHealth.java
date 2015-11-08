import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class UpdateHealth extends JDialog {

	private JPanel contentPane;
	private JCheckBox chckbxChestPain;
	private JCheckBox chckbxHeadache;
	private JCheckBox chckbxFever;
	private JCheckBox chckbxSoreThroat;
	private JCheckBox chckbxBodyAches;
	private JList<String> list;
	public String condition = "";
	private DefaultListModel<String> model;

	
	public UpdateHealth() {
		setBounds(100, 100, 523, 490);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientHealthInformation = new JLabel("Patient Health Information");
		lblPatientHealthInformation.setBounds(10, 11, 209, 14);
		contentPane.add(lblPatientHealthInformation);
		
		JLabel lblAddNewHealth = new JLabel("Add new Health Info");
		lblAddNewHealth.setBounds(10, 320, 166, 14);
		contentPane.add(lblAddNewHealth);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(279, 390, 89, 23);
		btnSubmit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				
				addNewHealthInfo();
				chckbxChestPain.setSelected(false);
				chckbxFever.setSelected(false);
				chckbxSoreThroat.setSelected(false);
				chckbxBodyAches.setSelected(false);
				Frames.cond.setVisible(false); 
				Frames.userMenu.setLocationRelativeTo(null);
				Frames.userMenu.setVisible(true);
			}
			
		});
		contentPane.add(btnSubmit);
		
		chckbxChestPain = new JCheckBox("Chest Pain");
		chckbxChestPain.setBounds(10, 341, 97, 23);
		contentPane.add(chckbxChestPain);
		
		chckbxHeadache = new JCheckBox("Headache");
		chckbxHeadache.setBounds(208, 341, 97, 23);
		contentPane.add(chckbxHeadache);
		
		chckbxFever = new JCheckBox("Fever");
		chckbxFever.setBounds(404, 341, 97, 23);
		contentPane.add(chckbxFever);
		
		chckbxSoreThroat = new JCheckBox("Sore Throat");
		chckbxSoreThroat.setBounds(109, 341, 97, 23);
		contentPane.add(chckbxSoreThroat);
		
		chckbxBodyAches = new JCheckBox("Body Aches");
		chckbxBodyAches.setBounds(307, 341, 97, 23);
		contentPane.add(chckbxBodyAches);
		
		list = new JList<String>();
		model = new DefaultListModel<String>();
		list.setModel(model);
		list.setBounds(10, 36, 468, 273);
		contentPane.add(list);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Frames.cond.setVisible(false); 
				Frames.userMenu.setLocationRelativeTo(null);
				Frames.userMenu.setVisible(true);
			}
		});
		btnGoBack.setBounds(109, 390, 89, 23);
		contentPane.add(btnGoBack);
	}
	
	public void addNewHealthInfo()
	{
		//TODO: Redo this with database
		String health = "";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		Date date = new Date();
		health += dateFormat.format(date) + ": ";
		boolean alert = false;
		
		if(chckbxChestPain.isSelected())
		{
			
			condition = "Chest Pain";
			String id = Frames.rand();
			Frames.insert("CONDITION", Frames.user, id);
			Frames.update("CONDITION", "COND", Frames.user, health+condition, id);
			Frames.update("CONDITION", "LEVEL", Frames.user, "4", id);
			alert = true;
			if(alert == true)
			{
				JOptionPane.showConfirmDialog(null, "Alert will be sent to your Doctor", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
			alert = false;
		}
		
		if(chckbxHeadache.isSelected())
		{
			condition = "Headache";
			String id = Frames.rand();
			Frames.insert("CONDITION", Frames.user, id);
			Frames.update("CONDITION", "COND", Frames.user, health+condition, id);
			Frames.update("CONDITION", "LEVEL", Frames.user, "2", id);
		}
		if(chckbxFever.isSelected())
		{
			condition = "Fever";
			String id = Frames.rand();
			Frames.insert("CONDITION", Frames.user, id);
			Frames.update("CONDITION", "COND", Frames.user, health+condition, id);
			Frames.update("CONDITION", "LEVEL", Frames.user, "4", id);
			alert = true;
			if(alert == true)
			{
				JOptionPane.showConfirmDialog(null, "Alert will be sent to your Doctor", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
			}
			alert = false;  //test
		}
		
		if(chckbxSoreThroat.isSelected())
		{
			condition = "Sore Throat";
			String id = Frames.rand();
			Frames.insert("CONDITION", Frames.user, id);
			Frames.update("CONDITION", "COND", Frames.user, health+condition, id);
			Frames.update("CONDITION", "LEVEL", Frames.user, "1", id);
		}
		
		if(chckbxBodyAches.isSelected())
		{
			condition = "Body Aches";
			String id = Frames.rand();
			Frames.insert("CONDITION", Frames.user, id);
			Frames.update("CONDITION", "COND", Frames.user, health+condition, id);
			Frames.update("CONDITION", "LEVEL", Frames.user, "3", id);
		}
	
		
		model.addElement(health+condition);
		list.setModel(model);
		this.repaint();
		this.revalidate();
		
		
	}
}
