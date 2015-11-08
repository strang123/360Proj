import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class DoctorMenuWindow extends JFrame{
	
	private JPanel contentPane;
	public static JLabel lblNewLabel;

		
	public DoctorMenuWindow(){
		
		setTitle("Doctor Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 248, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 64, 200, 157);
		contentPane.add(panel_1);
		
		JButton btnAccessPatientRecords = new JButton("Access Patient Records");
		btnAccessPatientRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.docMenu.setVisible(false); 
				Frames.patient_info.dispose();
				Frames.patient_info = new RetrieveInfoWindowDoctor();
				Frames.patient_info.setLocationRelativeTo(null);
				Frames.patient_info.setVisible(true);
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_1.add(btnAccessPatientRecords);
		//		btnAccessPatientRecords.setEnabled(false);
				
				JButton btnAccessLabRecords = new JButton("Access Lab Records");
				btnAccessLabRecords.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) 
					{
						AccessLabReport lab = new AccessLabReport();
						lab.setVisible(true);
					}
				});
				panel_1.add(btnAccessLabRecords);
				//		btnAccessLabRecords.setEnabled(false);
						
						JButton btnUpdateHealthCondition = new JButton("Update Health Condition");
						btnUpdateHealthCondition.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) 
							{
								Frames.docMenu.setVisible(false); 
								Frames.update_doc.dispose();
								Frames.update_doc = new UpdateHealthDoctors();
								Frames.update_doc.setLocationRelativeTo(null);
								Frames.update_doc.setVisible(true);
							}
						});
						panel_1.add(btnUpdateHealthCondition);
						//	btnUpdateHealthCondition.setEnabled(false);
							
							JButton btnEPrescribe = new JButton("E-Prescribe Medication");
							btnEPrescribe.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) 
								{
									Frames.docMenu.setVisible(false); 
									Frames.prescribe.dispose();
									Frames.prescribe = new EPrescribeWindow();
									Frames.prescribe.setLocationRelativeTo(null);
									Frames.prescribe.setVisible(true);
								}
							});
							panel_1.add(btnEPrescribe);
							
							JButton btnExitProgram = new JButton("Exit Program");
							btnExitProgram.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									System.exit(0);
								}
							});
							panel_1.add(btnExitProgram);
		
		JLabel lblpleaseSelectAn = new JLabel("<html><b>Please Select an Option</b></html>");
		lblpleaseSelectAn.setBounds(44, 11, 160, 14);
		contentPane.add(lblpleaseSelectAn);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 39, 97, 14);
		contentPane.add(lblNewLabel);
	}
}
