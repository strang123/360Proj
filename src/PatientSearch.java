import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

public class PatientSearch extends JFrame {

	private JPanel contentPane;
	private JTextField idText;
	private JTextField firstText;
	private JTextField lastText;

	
	public PatientSearch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel patientSearch = new JLabel("Patient Search");
		patientSearch.setBounds(195, 11, 89, 14);
		contentPane.add(patientSearch);
		
		JLabel userIDlab = new JLabel("UserID");
		userIDlab.setBounds(27, 61, 46, 14);
		contentPane.add(userIDlab);
		
		JLabel firstLab = new JLabel("First Name");
		firstLab.setBounds(27, 89, 65, 14);
		contentPane.add(firstLab);
		
		JLabel lastLab = new JLabel("Last Name");
		lastLab.setBounds(27, 117, 65, 14);
		contentPane.add(lastLab);
		
		JButton submitBut = new JButton("Submit");
		submitBut.setBounds(184, 227, 89, 23);
		contentPane.add(submitBut);
		
		idText = new JTextField();
		idText.setBounds(102, 58, 140, 20);
		contentPane.add(idText);
		idText.setColumns(10);
		
		firstText = new JTextField();
		firstText.setBounds(102, 86, 140, 20);
		contentPane.add(firstText);
		firstText.setColumns(10);
		
		lastText = new JTextField();
		lastText.setBounds(102, 114, 140, 20);
		contentPane.add(lastText);
		lastText.setColumns(10);
		
		submitBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				JOptionPane.showMessageDialog(getContentPane(), "Error, First Name or Last Name field contains numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		});
		
	}
}
