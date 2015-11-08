import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class DoctorSearchList extends JDialog {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldZipCode;
	private JTextField textFieldCategory;
	private JTextField textFieldInsuranceType;

	
	public DoctorSearchList() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSearchByName = new JLabel("Search By Name:");
		lblSearchByName.setBounds(10, 11, 198, 14);
		contentPane.add(lblSearchByName);
		
		JLabel lblFindADoctor = new JLabel("Find a Doctor:");
		lblFindADoctor.setBounds(10, 67, 198, 14);
		contentPane.add(lblFindADoctor);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(10, 36, 198, 20);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(10, 92, 198, 14);
		contentPane.add(lblZipCode);
		
		textFieldZipCode = new JTextField();
		textFieldZipCode.setBounds(10, 117, 198, 20);
		contentPane.add(textFieldZipCode);
		textFieldZipCode.setColumns(10);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(10, 148, 198, 14);
		contentPane.add(lblCategory);
		
		textFieldCategory = new JTextField();
		textFieldCategory.setBounds(10, 173, 198, 20);
		contentPane.add(textFieldCategory);
		textFieldCategory.setColumns(10);
		
		JLabel lblInsuranceType = new JLabel("Insurance Type");
		lblInsuranceType.setBounds(10, 204, 198, 14);
		contentPane.add(lblInsuranceType);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					boolean validInput = true;
					
					if(!validDoctorName())
					{
						validInput = false;
						JOptionPane.showMessageDialog(getContentPane(), "Doctor must meet the following criteria: Must contain only letters, numbers and '.'", "ERROR", JOptionPane.ERROR_MESSAGE);
						textFieldName.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
					if(!validZipCode())
					{
						validInput = false;
						JOptionPane.showMessageDialog(getContentPane(), "Zip code must meet the following criteria: Must contain only numbers and 5 characters long", "ERROR", JOptionPane.ERROR_MESSAGE);
						textFieldZipCode.setBorder(BorderFactory.createLineBorder(Color.RED));
					}
				
			}
		});
		btnSubmit.setBounds(335, 227, 89, 23);
		contentPane.add(btnSubmit);
		
		textFieldInsuranceType = new JTextField();
		textFieldInsuranceType.setBounds(10, 227, 198, 20);
		contentPane.add(textFieldInsuranceType);
		textFieldInsuranceType.setColumns(10);
		}
	
		
	
		private boolean validZipCode()
		{
			String zipCodeText = textFieldZipCode.getText();
					
			Pattern p = Pattern.compile("[0-9]{4,6}");
					
			Matcher m = p.matcher(zipCodeText);
					
			if(m.matches())
			{
					return true;
			}
			else
			{
					return false;
			}
		}
	
		private boolean validDoctorName()
		{
			String doctorNameText = textFieldName.getText();
			
			if(doctorNameText.contains("!"))
			{
				return false;
			}
			else if(doctorNameText.contains("@"))
			{
				return false;
			}
			else if(doctorNameText.contains("#"))
			{
				return false;
			}
			else if(doctorNameText.contains("$"))
			{
				return false;
			}
			else if(doctorNameText.contains("%"))
			{
				return false;
			}
			else if(doctorNameText.contains("^"))
			{
				return false;
 			}
			else if(doctorNameText.contains("&"))
			{
				return false;
			}
			else if(doctorNameText.contains("*"))
			{
				return false;
			}
			else if(doctorNameText.contains("("))
			{
				return false;
			}
			else if(doctorNameText.contains(")"))
			{
				return false;
			}
			else if(doctorNameText.contains("_"))
			{
				return false;
			}
			else if(doctorNameText.contains("-"))
			{
				return false;
			}
			else if(doctorNameText.contains("="))
			{
				return false;
			}
			else if(doctorNameText.contains("["))
			{
				return false;
			}
			else if(doctorNameText.contains("]"))
			{
				return false;
			}
			else if(doctorNameText.contains("{"))
			{
				return false;
			}
			else if(doctorNameText.contains("}"))
			{
				return false;
			}
			else if(doctorNameText.contains("|"))
			{
				return false;
			}
			else if(doctorNameText.contains("\\"))
			{
				return false;
			}
			else if(doctorNameText.contains(";"))
			{
				return false;
			}
			else if(doctorNameText.contains(":"))
			{
				return false;
			}
			else if(doctorNameText.contains("\'"))
			{
				return false;
			}
			else if(doctorNameText.contains("\""))
			{
				return false;
			}
			else if(doctorNameText.contains("<"))
			{
				return false;
			}
			else if(doctorNameText.contains(">"))
			{
				return false;
			}
			else if(doctorNameText.contains("?"))
			{	 			
				return false;
			}
			else if(doctorNameText.contains("/"))
			{
				return false;
			}
			else if(doctorNameText.contains(","))
			{
				return false;
			}
			else if(doctorNameText.contains("`"))
			{
			return false;
			}
			else if(doctorNameText.contains("~"))
			{
				return false;
			}
			else if(doctorNameText.contains(" "))
			{
				return false;
			}
			else if(doctorNameText.equals(""))
			{
				return false;
			}
			else return true;
	
		
	}
	

}
