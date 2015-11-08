import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class EPrescribeWindow extends JFrame{
	
	private JPanel contentPane;
	private static String med = "";
	private static String amount = "";
	private static String id = "";
	private static String patient = "";
	
	JTextField tfMedication;
	JTextField tfAmount;
	

	
	public EPrescribeWindow(){
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("E-Prescription");
		
		JLabel lblMedicationName = new JLabel("Medication Name:");
		lblMedicationName.setBounds(10, 166, 200, 50);
		lblMedicationName.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(lblMedicationName);
		
		JLabel lblAmount = new JLabel("Amount Prescribed:");
		lblAmount.setBounds(10, 227, 200, 50);
		lblAmount.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(lblAmount);
		
		tfMedication = new JTextField();
		tfMedication.setBounds(220, 166, 200, 50);
		tfMedication.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(tfMedication);
		
		tfAmount = new JTextField();
		tfAmount.setBounds(220, 227, 200, 50);
		tfAmount.setFont(new Font("Serif", Font.PLAIN, 24));
		contentPane.add(tfAmount);
		
		JButton btnPrescribe = new JButton("Prescribe");
		btnPrescribe.setBounds(60, 288, 150, 50);
		btnPrescribe.setFont(new Font("Serif", Font.PLAIN, 24));
		btnPrescribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				id = Frames.rand();
				med = tfMedication.getText();
				amount = tfAmount.getText();
				Frames.insert("PRESCRIPT", patient, id);
				Frames.update("PRESCRIPT", "PRESCRIPTIONNAME", patient, med, id);
				Frames.update("PRESCRIPT", "AMOUNT", patient, amount, id);
				Frames.update("PRESCRIPT", "DOCTERSSN", patient, Frames.get(Frames.user, "USERNAME", "DOCTOR", "SSN"), id);
				JOptionPane.showMessageDialog(getContentPane(), "Perscription Placed for: "+ tfAmount.getText() + " mgs of " + tfMedication.getText() , "Perscription Placed Sucessfully", JOptionPane.PLAIN_MESSAGE);
				Frames.prescribe.setVisible(false);
				Frames.docMenu.setVisible(true);
			}
		});
		contentPane.add(btnPrescribe);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(254, 288, 150, 50);
		btnCancel.setFont(new Font("Serif", Font.PLAIN, 24));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.prescribe.setVisible(false);
				Frames.docMenu.setVisible(true);
			}
		});
		contentPane.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 23, 371, 119);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JList list = new JList(Frames.listPatients().toArray());
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) 
			{
				patient = list.getSelectedValue().toString();
			}
		});
		list.setBounds(10, 11, 351, 97);
		
		panel.add(list);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(344, 11, 17, 97);
		panel.add(scrollBar);
		
		JLabel lblPatients = new JLabel("Patients");
		lblPatients.setBounds(44, 11, 76, 14);
		contentPane.add(lblPatients);
		
	}
}

