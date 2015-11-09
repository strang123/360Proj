import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class NurseMenuWindow extends JFrame{
	
	private JPanel contentPane;

	
	
	public NurseMenuWindow(){
		
		setTitle("Nurse Main Menu");
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
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
				
		JButton btnUpdateHealthCondition = new JButton("Update Health Condition");
		btnUpdateHealthCondition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.nurseMenu.setVisible(false); 
				if(Frames.update_nurse != null)
				{
					Frames.update_nurse.dispose();
				}				
				Frames.update_nurse = new UpdateHealthNurse();
				Frames.update_nurse.setLocationRelativeTo(null);
				Frames.update_nurse.setVisible(true);
			}
		});
		panel_1.add(btnUpdateHealthCondition);
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		panel_1.add(btnExitProgram);
	}

}
