import javax.swing.JApplet;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
//test2
public class UserAccountRegistration extends JDialog{
	private JTextField userName;
	private JTextField password;
	private JTextField confirmPassword;
	private JTextField email;
	private JTextField firstName;
	private JTextField lastName;
	private JLabel lblGender;
	private JTextField currentAddress;
	private JTextField sSN;
	private JTextField emergencyContactName;
	private JTextField emergencyContactRelationship;
	private JTextField emergencyContactPhone;
	private JTextField insuranceName;
	private JTextField insuranceAddress;
	private JTextField policyNumber;
	private JTextField groupNumber;
	private JTextField effectiveMonth;
	private JTextField effectiveDay;
	private JTextField effectiveYear;
	private JTextField policyHolder;
	private JTextField cellPhone;
	private JTextField workPhone;
	private JTextField city;
	private JTextField state;
	private Border border;
	private String genderStr;
	private String maritalStatus;
	private boolean sms;
	String type;
	boolean once = true;
 
  
	public UserAccountRegistration() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("User Account Registration");
		getContentPane().setLayout(null);
		
		ButtonGroup gender = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 336, 501);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Account Info");
		lblNewLabel.setBounds(10, 11, 106, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		userName = new JTextField();
		userName.setBounds(139, 52, 148, 20);
		panel.add(userName);
		userName.setColumns(10);
		
		JLabel label = new JLabel("User Name");
		label.setBounds(10, 55, 70, 14);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(10, 80, 106, 14);
		panel.add(label_1);
		
		password = new JTextField();
		password.setBounds(139, 77, 148, 20);
		panel.add(password);
		password.setColumns(10);
		
		JLabel label_2 = new JLabel("Confirm Password");
		label_2.setBounds(10, 108, 119, 14);
		panel.add(label_2);
		
		confirmPassword = new JTextField();
		confirmPassword.setBounds(139, 105, 148, 20);
		panel.add(confirmPassword);
		confirmPassword.setColumns(10);
		
		JLabel label_3 = new JLabel("Email");
		label_3.setBounds(10, 143, 46, 14);
		panel.add(label_3);
		
		email = new JTextField();
		email.setBounds(139, 140, 148, 20);
		panel.add(email);
		email.setColumns(10);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setBounds(10, 178, 148, 14);
		panel.add(lblPersonalInformation);
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		firstName = new JTextField();
		firstName.setBounds(139, 203, 148, 20);
		panel.add(firstName);
		firstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 206, 70, 14);
		panel.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 231, 70, 14);
		panel.add(lblLastName);
		
		lastName = new JTextField();
		lastName.setBounds(139, 234, 148, 20);
		panel.add(lastName);
		lastName.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(105, 292, 85, 23);
		panel.add(rdbtnMale);
		gender.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(209, 292, 109, 23);
		panel.add(rdbtnFemale);
		gender.add(rdbtnFemale);
		
		lblGender = new JLabel("Gender");
		lblGender.setBounds(10, 293, 70, 14);
		panel.add(lblGender);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 322, 148, 20);
		panel.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "PATIENT", "DOCTOR", "NURSE", "HSP", "LAB"}));
		
		
		
		JLabel lblMaritalStatus = new JLabel("Account Type");
		lblMaritalStatus.setBounds(10, 325, 106, 14);
		panel.add(lblMaritalStatus);
		
	
		
		JLabel label_8 = new JLabel("Primary Insurance Information");
		label_8.setBounds(10, 398, 226, 14);
		panel.add(label_8);
		label_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		insuranceName = new JTextField();
		insuranceName.setBounds(139, 423, 148, 20);
		panel.add(insuranceName);
		insuranceName.setColumns(10);
		
		sSN = new JTextField();
		sSN.setBounds(139, 367, 148, 20);
		panel.add(sSN);
		sSN.setColumns(10);
		
		JLabel label_9 = new JLabel("Name");
		label_9.setBounds(10, 426, 70, 14);
		panel.add(label_9);
		
		
		

		
		JLabel lblSsn = new JLabel("SSN");
		lblSsn.setBounds(10, 373, 46, 14);
		panel.add(lblSsn);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(115, 454, 89, 23);
		panel.add(btnSubmit);
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{userName, password, confirmPassword, email, firstName, lastName, rdbtnMale, rdbtnFemale, comboBox, sSN, insuranceName, btnSubmit}));
		
				btnSubmit.addActionListener(new ActionListener(){
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
						
			
						if(validInput && type != null && once == true)
						{
							
							
							Account acct = new Account();
							
							
							int okay = 0;
							
							
							okay = acct.setUserName(userName.getText(), type);
							if(okay == 1)
							{
										
								acct.setPassword(password.getText(), type, userName.getText());
								acct.setFirstName(firstName.getText(), type, userName.getText());
								acct.setLastName(lastName.getText(), type, userName.getText());
								acct.setEmail(email.getText(), type, userName.getText());
								acct.setGender(genderStr, type, userName.getText());
								acct.setSSN(sSN.getText(), type, userName.getText());
								acct.setInsuranceName(insuranceName.getText(), type, userName.getText());
								once = false; //so submit is only pressed once
								
								//========================================================
								//USERACCOUNTREGISTRATION.JAVA -> PARTICULAR USERMENU.JAVA
								//=========================================================
							
								switch(type)
								{
									case "PATIENT":
									{
										Frames.user = userName.getText();
										Frames.userMenu.setLocationRelativeTo(null);
										Frames.userReg.setVisible(false); 
										Frames.userMenu.setVisible(true);
										break;
									}
									case "DOCTOR":
									{
										Frames.user = userName.getText();
										Frames.docMenu.setLocationRelativeTo(null);
										Frames.userReg.setVisible(false); 
										Frames.docMenu.setVisible(true);
										break;
									}
									case "NURSE": 
									{
										Frames.user = userName.getText();
										Frames.nurseMenu.setLocationRelativeTo(null);
										Frames.userReg.setVisible(false); 
										Frames.nurseMenu.setVisible(true);
										break;
									}
									case "LAB":
									{
										Frames.user = userName.getText();
										Frames.labMenu.setLocationRelativeTo(null);
										Frames.userReg.setVisible(false); 
										Frames.labMenu.setVisible(true);
										break;
									}
									case "NSP":
									{
										Frames.user = userName.getText();
										Frames.nspMenu.setLocationRelativeTo(null);
										Frames.userReg.setVisible(false); 
										Frames.nspMenu.setVisible(true);
										break;
									}
								}
							}
						}
						else
						{
							JOptionPane.showConfirmDialog(null, "Please choose an account type.", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
						}
					}
				});
		comboBox.addItemListener(new ItemListener()
		{
	
			public void itemStateChanged(ItemEvent evt) 
			{
				if(evt.getStateChange() == ItemEvent.SELECTED)
				
					if(evt.getItem() == "PATIENT")
					{
						type = "PATIENT";
					}
					else if(evt.getItem() == "DOCTOR")
					{
						type = "DOCTOR";
					}
					else if(evt.getItem() == "NURSE")
					{
						type = "NURSE";
					}
					else if(evt.getItem() == "HSP")
					{
						type = "NSP";
					}
					else if(evt.getItem() == "LAB")
					{
						type = "LAB";
					}
			}
		});
		rdbtnFemale.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(evt.getActionCommand() == "Female")
				{
					genderStr = "F";
				}		
			}
		});
		rdbtnMale.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent evt)
			{
				if(evt.getActionCommand() == "Male")
				{
					genderStr = "M";
				}				
			}
		});
		border = userName.getBorder();
		 
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


	
	
	private boolean validEffectiveMonth()
	{
		try
		{
			int i = Integer.parseInt(effectiveMonth.getText());
			if(i > 12 || i < 1)
			{
				return false;
			}
			else
			{
				return true;
			}
		}catch(NumberFormatException e)
		{
			return false;
		}
	}

	private boolean validEffectiveDay()
	{
		try{
			
			int i = Integer.parseInt(effectiveDay.getText());
			if(i > 31 || i < 1)
			{
				return false;
			}
			else
			{
				return true;
			}
		}catch(NumberFormatException e)
		{
			return false;
		}
	}
	private boolean validEffectiveYear()
	{
		try{
			int i = Integer.parseInt(effectiveYear.getText());

			if(i < 1800 || i > 2100)
			{
				return false;
			}
			else
			{
				return true;
			}
		}catch(NumberFormatException e)
		{
			return false;
		}
	}

	private boolean validCellPhone()
	{
		try{
			int i = Integer.parseInt(cellPhone.getText());

			if(cellPhone.getText().length() != 10)
			{
				return false;
			}
			else
			{
				return true;
			}
		}catch(NumberFormatException e)
		{
			return false;
		}
	}
	
	private boolean validWorkPhone()
	{
		try{
			int i = Integer.parseInt(workPhone.getText());

			if(workPhone.getText().length() != 10)
			{
				return false;
			}
			else
			{
				return true;
			}
		}catch(NumberFormatException e)
		{
			return false;
		}
	}
}
