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

public class LabStaffMenuWindow extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application
	 */

	public LabStaffMenuWindow(){
		
		setTitle("Lab Staff Main Menu");
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
		
		JButton btnUpdateLabRecords = new JButton("Update Lab Records");
		btnUpdateLabRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				AccessLabReport lab = new AccessLabReport();
				lab.setVisible(true);
			}
		});
		panel_1.add(btnUpdateLabRecords);
		//btnUpdateLabRecords.setEnabled(false);
		
		JButton btnEnterLabRecords = new JButton("Enter/Upload Lab Records");
		btnEnterLabRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UploadLab lab = new UploadLab();
				lab.setVisible(true);
			}
		});
		panel_1.add(btnEnterLabRecords);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_1.add(btnExitProgram);
	}

}
