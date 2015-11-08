import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class StaffAccountCreation extends JDialog {
	private JTextField userName;
	private JTextField password;
	private JTextField confirmPassword;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField workPhone;
	private JTextField cellPhone;
	private Border border;
	private JComboBox accountType;


	public StaffAccountCreation() {
		getContentPane().setLayout(null);
		getContentPane().setSize(450, 550);
		
		JLabel label = new JLabel("User Name");
		label.setBounds(10, 14, 96, 20);
		getContentPane().add(label);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(153, 11, 255, 26);
		getContentPane().add(userName);
		
		border = userName.getBorder();
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(10, 56, 69, 20);
		getContentPane().add(label_1);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(153, 53, 255, 26);
		getContentPane().add(password);
		
		JLabel label_2 = new JLabel("Confirm Password");
		label_2.setBounds(10, 98, 129, 20);
		getContentPane().add(label_2);
		
		confirmPassword = new JTextField();
		confirmPassword.setColumns(10);
		confirmPassword.setBounds(153, 95, 255, 26);
		getContentPane().add(confirmPassword);
		
		JLabel label_3 = new JLabel("First Name");
		label_3.setBounds(10, 180, 96, 20);
		getContentPane().add(label_3);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		firstName.setBounds(153, 177, 255, 26);
		getContentPane().add(firstName);
		
		JLabel label_4 = new JLabel("Last Name");
		label_4.setBounds(10, 222, 96, 20);
		getContentPane().add(label_4);
		
		lastName = new JTextField();
		lastName.setColumns(10);
		lastName.setBounds(153, 219, 255, 26);
		getContentPane().add(lastName);
		
		JLabel label_5 = new JLabel("Email");
		label_5.setBounds(10, 290, 69, 20);
		getContentPane().add(label_5);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(153, 287, 255, 26);
		getContentPane().add(email);
		
		JLabel label_6 = new JLabel("Work Phone");
		label_6.setBounds(10, 332, 96, 20);
		getContentPane().add(label_6);
		
		workPhone = new JTextField();
		workPhone.setColumns(10);
		workPhone.setBounds(153, 329, 255, 26);
		getContentPane().add(workPhone);
		
		cellPhone = new JTextField();
		cellPhone.setColumns(10);
		cellPhone.setBounds(153, 371, 255, 26);
		getContentPane().add(cellPhone);
		
		JLabel label_7 = new JLabel("Cell Phone");
		label_7.setBounds(10, 374, 129, 20);
		getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Account Type");
		label_8.setBounds(10, 416, 129, 20);
		getContentPane().add(label_8);
		
		accountType = new JComboBox();
		accountType.setModel(new DefaultComboBoxModel(AccountType.values()));
		accountType.setBounds(153, 413, 255, 26);
		getContentPane().add(accountType);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(293, 455, 115, 29);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				boolean validInput = true;
				
				if(!validUserName())
				{
					validInput = false;
					JOptionPane.showMessageDialog(getContentPane(), "Username must meet the following criteria:\n1. Must be at least 5 characters long\n2. Must contain only letters and numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
					userName.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				
				if(!validPassword())
				{
					validInput = false;
					JOptionPane.showMessageDialog(getContentPane(), "Password must meet the following criteria:\n1. Must be at least 7 characters long\n2. Must contain only letters and numbers", "ERROR", JOptionPane.ERROR_MESSAGE);
					password.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				else
				{
					password.setBorder(border);
				}
				
				if(!passwordCompare())
				{
					validInput = false;
					JOptionPane.showMessageDialog(getContentPane(), "Passwords do not match.", "ERROR", JOptionPane.ERROR_MESSAGE);
					confirmPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				else
				{
					confirmPassword.setBorder(border);
				}
				
				if(!validEmail())
				{
					validInput = false;
					JOptionPane.showMessageDialog(getContentPane(), "Please enter a valid email address.", "ERROR", JOptionPane.ERROR_MESSAGE);
					email.setBorder(BorderFactory.createLineBorder(Color.RED));
				}
				else
				{
					email.setBorder(border);
				}
				
				//TODO: Phone number Validation
				
				if(validInput)
				{
					
					createUser();
				}
				if( validInput = true)
				{
					Account a = new Account();
				//	a.setUserName(userName.getText());	
				}
			}  
			
		});
		getContentPane().add(btnSubmit);
		

	}
	private boolean passwordCompare()
	{
		if(password.getText().equals(confirmPassword.getText()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	private boolean validPassword()
	{
		String passwordText = password.getText();
		
		if(passwordText.length() >= 7)
		{
			if(passwordText.contains("!"))
			{
				return false;
			}
			else if(passwordText.contains("@"))
			{
				return false;
			}
			else if(passwordText.contains("#"))
			{
				return false;
			}
			else if(passwordText.contains("$"))
			{
				return false;
			}
			else if(passwordText.contains("%"))
			{
				return false;
			}
			else if(passwordText.contains("^"))
			{
				return false;
			}
			else if(passwordText.contains("&"))
			{
				return false;
			}
			else if(passwordText.contains("*"))
			{
				return false;
			}
			else if(passwordText.contains("("))
			{
				return false;
			}
			else if(passwordText.contains(")"))
			{
				return false;
			}
			else if(passwordText.contains("_"))
			{
				return false;
			}
			else if(passwordText.contains("-"))
			{
				return false;
			}
			else if(passwordText.contains("+"))
			{
				return false;
			}
			else if(passwordText.contains("="))
			{
				return false;
			}
			else if(passwordText.contains("["))
			{
				return false;
			}
			else if(passwordText.contains("]"))
			{
				return false;
			}
			else if(passwordText.contains("{"))
			{
				return false;
			}
			else if(passwordText.contains("}"))
			{
				return false;
			}
			else if(passwordText.contains("|"))
			{
				return false;
			}
			else if(passwordText.contains("\\"))
			{
				return false;
			}
			else if(passwordText.contains(";"))
			{
				return false;
			}
			else if(passwordText.contains(":"))
			{
				return false;
			}
			else if(passwordText.contains("\'"))
			{
				return false;
			}
			else if(passwordText.contains("\""))
			{
				return false;
			}
			else if(passwordText.contains("<"))
			{
				return false;
			}
			else if(passwordText.contains(">"))
			{
				return false;
			}
			else if(passwordText.contains("?"))
			{
				return false;
			}
			else if(passwordText.contains("/"))
			{
				return false;
			}
			else if(passwordText.contains(","))
			{
				return false;
			}
			else if(passwordText.contains("."))
			{
				return false;
			}
			else if(passwordText.contains("`"))
			{
				return false;
			}
			else if(passwordText.contains("~"))
			{
				return false;
			}
			else if(passwordText.contains(" "))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}
	private boolean validUserName()
	{
		String userNameText = userName.getText();
		
		if(userNameText.length() >= 5)
		{
			if(userNameText.contains("!"))
			{
				return false;
			}
			else if(userNameText.contains("@"))
			{
				return false;
			}
			else if(userNameText.contains("#"))
			{
				return false;
			}
			else if(userNameText.contains("$"))
			{
				return false;
			}
			else if(userNameText.contains("%"))
			{
				return false;
			}
			else if(userNameText.contains("^"))
			{
				return false;
			}
			else if(userNameText.contains("&"))
			{
				return false;
			}
			else if(userNameText.contains("*"))
			{
				return false;
			}
			else if(userNameText.contains("("))
			{
				return false;
			}
			else if(userNameText.contains(")"))
			{
				return false;
			}
			else if(userNameText.contains("_"))
			{
				return false;
			}
			else if(userNameText.contains("-"))
			{
				return false;
			}
			else if(userNameText.contains("+"))
			{
				return false;
			}
			else if(userNameText.contains("="))
			{
				return false;
			}
			else if(userNameText.contains("["))
			{
				return false;
			}
			else if(userNameText.contains("]"))
			{
				return false;
			}
			else if(userNameText.contains("{"))
			{
				return false;
			}
			else if(userNameText.contains("}"))
			{
				return false;
			}
			else if(userNameText.contains("|"))
			{
				return false;
			}
			else if(userNameText.contains("\\"))
			{
				return false;
			}
			else if(userNameText.contains(";"))
			{
				return false;
			}
			else if(userNameText.contains(":"))
			{
				return false;
			}
			else if(userNameText.contains("\'"))
			{
				return false;
			}
			else if(userNameText.contains("\""))
			{
				return false;
			}
			else if(userNameText.contains("<"))
			{
				return false;
			}
			else if(userNameText.contains(">"))
			{
				return false;
			}
			else if(userNameText.contains("?"))
			{
				return false;
			}
			else if(userNameText.contains("/"))
			{
				return false;
			}
			else if(userNameText.contains(","))
			{
				return false;
			}
			else if(userNameText.contains("."))
			{
				return false;
			}
			else if(userNameText.contains("`"))
			{
				return false;
			}
			else if(userNameText.contains("~"))
			{
				return false;
			}
			else if(userNameText.contains(" "))
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		else
		{
			return false;
		}
	}

	private boolean validEmail()
	{
		String emailString = email.getText();
		
		Pattern p = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
		
		Matcher m = p.matcher(emailString);
		
		if(m.matches())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	private boolean validWorkPhone()
	{
		String phone = workPhone.getText();
		
		phone = phone.replace("-", "");
		phone = phone.replace("(", "");
		phone = phone.replace(")", "");
		
		return true;
	}

	private void createUser()
	{
		//Initialize new account variable with username and password
		Account a = new Account(userName.getText(), password.getText());
		
/*		//Set personal info
		a.setFirstName(firstName.getText());
		a.setLastName(lastName.getText());
		
		//Set contact information
		a.setEmail(email.getText());
		a.setCellNumber(cellPhone.getText());
		a.setWorkNumber(workPhone.getText());
		
		//Set account type
		a.setAccountType((AccountType)accountType.getSelectedItem());
		
		//TODO: Insert New Account into Database 
		*/
	}
}
