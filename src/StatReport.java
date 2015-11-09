import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class StatReport extends JFrame {

	private JPanel contentPane;

	
	public StatReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 575, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Health Outcomes");
		lblNewLabel.setBounds(52, 69, 109, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblAdmissionRates = new JLabel("Admission Rates");
		lblAdmissionRates.setBounds(52, 95, 109, 16);
		contentPane.add(lblAdmissionRates);
		
		JLabel lblPatientPopulations = new JLabel("Patient Gender Ratio");
		lblPatientPopulations.setBounds(52, 121, 135, 16);
		contentPane.add(lblPatientPopulations);
		
		JLabel lblStatisticalReports = new JLabel("Statistical Reports");
		lblStatisticalReports.setBounds(199, 25, 121, 16);
		contentPane.add(lblStatisticalReports);
		
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(199, 217, 164, 29);
		contentPane.add(btnGenerateReport);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(199, 69, 344, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(199, 95, 344, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(199, 121, 344, 14);
		contentPane.add(lblNewLabel_4);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Frames.stats.setVisible(false);
				Frames.nspMenu.setLocationRelativeTo(null);
				Frames.nspMenu.setVisible(true);
			}
		});
		btnGoBack.setBounds(52, 220, 89, 23);
		contentPane.add(btnGoBack);
		
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				ResultSet rs = Frames.stats();
				ResultSet rs2 = Frames.stats2();
				int fever = 0;
				int pain = 0;
				int male = 0;
				int female = 0;
				int rate = 0;
				int dead = 0;
				String test = "";
				try {
					while(rs.next())
					{
						test = rs.getString("GENDER");
						if(test.compareTo("M")==0)
						{	
							male++;
						}
						else if(test.compareTo("F")==0)
						{
							female++;
						}
						rate ++;
					}
/*					System.out.println("male: " + male); //show what is stored in male
					System.out.println("female: " + female); //show what is stored in female
					System.out.println("rate: " + rate); //show what is stored in rate*/
					
					while(rs2.next())
					{
						String test2 = rs2.getString("COND");
						boolean tester = false;
						tester = test2.matches("(.*)Pain(.*)");//reg expression
						boolean tester2 = false;
						tester2 = test2.matches("(.*)Fever(.*)");
						if(tester == true)
						{
							pain++;
						}
						if(tester2 == true)
						{
							fever++;
						}
					}
/*					System.out.println("pain: " + pain); //show what is stored in pain
					System.out.println("fever: " + fever); //show what is stored in fever*/
					
					lblNewLabel_1.setText("There are "+ pain +" with chest pain and "+ fever +" with fever.");
					lblNewLabel_4.setText("There are " + male + " males and " + female +" females.");
					lblNewLabel_2.setText("There are a total of " + rate + " patients.");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
