import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class NSPStaffMenuWindow extends JFrame {
	
	private JPanel contentPane;

	
	public NSPStaffMenuWindow(){
		
		setTitle("NSP Staff Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblpleaseSelectAn = new JLabel("<html><b>Please Select an Option</b></html>");
		panel.add(lblpleaseSelectAn);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		
		
		JButton btnUpdateMedicalHistory = new JButton("Retrieve Patient Information");
		btnUpdateMedicalHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				/*Frames.nspMenu.setVisible(false); 
				Frames.patient_info_hsp.dispose();
				Frames.patient_info_hsp = new RetrieveInfoWindowHSP();
				Frames.patient_info_hsp.setLocationRelativeTo(null);
				Frames.patient_info_hsp.setVisible(true);*/
				
				Frames.nspMenu.setVisible(false); 
				if(Frames.patient_info_hsp != null)
				{
					Frames.patient_info_hsp.dispose();
				}				
				Frames.patient_info_hsp = new RetrieveInfoWindowHSP();
				Frames.patient_info_hsp.setLocationRelativeTo(null);
				Frames.patient_info_hsp.setVisible(true);
			}
		});
		panel_1.add(btnUpdateMedicalHistory);
	//	btnUpdateMedicalHistory.setEnabled(false);
		
		
	
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JButton btnGenerateStatisticalReport = new JButton("Generate Statistical Report");
		btnGenerateStatisticalReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.nspMenu.setVisible(false);
				Frames.stats.setLocationRelativeTo(null);
				Frames.stats.setVisible(true);
			}
		});
		panel_1.add(btnGenerateStatisticalReport);
		panel_1.add(btnExitProgram);
		
		JButton btnUploadupdateMedicalHistory = new JButton("Upload / Update Medical History");
		btnUploadupdateMedicalHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UploadLab med = new UploadLab();
				med.setVisible(true);
			}
		});
		panel_1.add(btnUploadupdateMedicalHistory);
	}
}
