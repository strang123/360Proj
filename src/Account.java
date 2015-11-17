import java.util.Date;

import javax.swing.JOptionPane;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.*;

public class Account
{
	
	//Account Login information
	private String userName;
	private String password;
	
	private String firstName;
	private String lastName;
	
	//Personal Information
	private String email;
	private String cellNumber;
	private String workNumber;
	private Date birthDate;
	private Gender gender;
	private String maritalStatus;
	private String streetAddress;
	private String city;
	private String state;
	private String ssn;
	private boolean allowSms;
	
	//Emergency Contact Variables
	private String emergencyContactName;
	private String emergencyContactRelationship;
	private int emergencyContactPhone;
	
	//Primary Insurance Info
	private String primaryInsuranceName;
	private String primaryInsuranceAddress;
	private String policyNumber;
	private String groupNumber;
	private Date effectiveDate;
	private String policyHolder;
	private Statement stmt;
	private AccountType accountType;
	private String sql;
	
	public Account(String u, String p)
	{
		userName = u;
		password = p;
	}
	public Account()
	{
		
	}
	public int setUserName(String s, String t)
	{
		int ret = 0;
		ret = insert(t, "USERNAME", s);
		return ret;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setPassword(String s, String t, String key)
	{
		update(t, "PASSWORD", s, key);
	}
	public String getPassword()
	{
		return password;
	}
	public void setFirstName(String s, String t, String key)
	{
		update(t, "FIRSTNAME", s, key);
	}
	public String getFirstName()
	{
		return firstName;	
	}
	public void setLastName(String s, String t, String key)
	{
		update(t, "LASTNAME", s, key);
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setEmail(String s, String t, String key)
	{
		update(t, "EMAIL", s, key);
	}
	public String getEmail()
	{
		return email;
	}
	public void setCellNumber(String i, String t)
	{
		cellNumber = i;
	}
	public String getCellNumber()
	{
		return cellNumber;
	}
	public void setWorkNumber(String i)
	{
		workNumber = i;
	}
	public String getWorkNumber()
	{
		return workNumber;
	}
	public void setBirthDate(Date d, String t)
	{
		birthDate = d;
	}
	public void setBirthDate(String s)
	{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			birthDate = format.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getBirthDate()
	{
		return birthDate;
	}
	public String getBirthString()
	{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		return format.format(birthDate);
		
	}
	public void setGender(String g, String t, String key)
	{
		update(t, "GENDER", g, key);
	}
	public Gender getGender()
	{
		return gender;
	}
	public void setMaritalStatus(String s)
	{
		maritalStatus =s;
	}
	public String getMaritalStatus()
	{
		return maritalStatus;
	}
	public void setStreetAddress(String s)
	{
		streetAddress = s;
	}
	public String getStreetAddress()
	{
		return streetAddress;
	}
	public void setCity(String s)
	{
		city = s;
	}
	public String getCity(String s)
	{
		return city;
	}
	public void setState(String s)
	{
		state = s;
	}
	public String getState()
	{
		return state;
	}
	public void setSSN(String i, String t, String key)
	{
		update(t, "SSN", i, key);
	}
	public String getSSN()
	{
		return ssn;
	}
	public void setAllowSms(boolean b, String t)
	{
		allowSms = b;
	}
	public boolean getAllowSms()
	{
		return allowSms;
	}
	public void setEmergencyContactName(String s)
	{
		emergencyContactName = s;
	}
	public String getEmergencyContactName()
	{
		return emergencyContactName;
	}
	public void setEmergencyContactRelationship(String s)
	{
		emergencyContactRelationship = s;
	}
	public String getEmergencyContactRelationship()
	{
		return emergencyContactRelationship;
	}
	public void setEmergencyContactPhone(int i)
	{
		emergencyContactPhone = i;
	}
	public int getEmergencyContactPhone()
	{
		return emergencyContactPhone;
	}
	public void setInsuranceName(String s, String t, String key)
	{
		update(t, "INSURANCENAME", s, key);
	}
	public String getInsuranceName()
	{
		return primaryInsuranceName;
	}
	public void setInsuranceAddress(String s)
	{
		primaryInsuranceAddress = s;
	}
	public String getInsuranceAddress()
	{
		return primaryInsuranceAddress;
	}
	public void setPolicyNumber(String s)
	{
		policyNumber = s;
	}
	public String getPolicyNumber()
	{
		return policyNumber;
	}
	public void setGroupNumber(String s)
	{
		groupNumber = s;
	}
	public String getGroupNumber()
	{
		return groupNumber;
	}
	public void setEffectiveDate(Date d)
	{
		effectiveDate = d;
	}
	public void setEffectiveDate(String s)
	{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		try {
			effectiveDate = format.parse(s);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Date getEffectiveDate()
	{
		return effectiveDate;
	}
	public String getEffectiveString()
	{
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
		
		return format.format(birthDate);
	}
	public void setPolicyHolder(String s)
	{
		policyHolder = s;
	}
	public String getPolicyHolder()
	{
		return policyHolder;
	}
	public void setAccountType(AccountType a)
	{
		accountType = a;
	}
	public AccountType getAccountType()
	{
		return accountType;
	}
	public int insert(String table, String attribute, String text)
	{
		//queries and then inserts
		try
		{
			int okay = 0;
			String test  = "";
			Frames.con.setAutoCommit(false);
			String acctype = "";
			stmt = Frames.con.createStatement();
			
			//checks for duplicate username
			 for(int i = 0; i < 5; i++)
		     {
		    	  switch(i)
		    	  {
		    	  	case 0:
		    	  	{
		    	  		acctype = "PATIENT";
		   
		    	  		break;
		    	  	}
		    	  	case 1:
		    	  	{
		    	  		acctype = "DOCTOR";
		    	  		break;
		    	  	}
		    	  	case 2:
		    	  	{
		    	  		acctype = "NURSE";
		    	  		break;
		    	  	}
		    	  	case 3:
		    	  	{
		    	  		acctype = "LAB";
		    	  		break;
		    	  	}
		    	  	case 4:
		    	  	{
		    	  		acctype = "NSP";
		    	  		break;
		    	  	}
		    	  }
			
			
				String query = "SELECT USERNAME " +
						" FROM " + "'"+ acctype + "'"
						+ " WHERE USERNAME = " + "\"" + text +"\""+";";
				
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next())
				{
					test = rs.getString("USERNAME");
					//System.out.println(query);
				}
			
			
			
			
				if(test == "")
				{
					okay = 1;
				}
				if(okay == 1)
				{
					Frames.con.setAutoCommit(false);
					stmt = Frames.con.createStatement();
					sql = 	"INSERT INTO" + "'" + table + "'" + "(" + "'" + attribute + "'"+")" 
							+ "VALUES (" + "'"+ text + "'"+")";
					stmt.executeUpdate(sql);
					stmt.close();
					Frames.con.commit();
					return okay;
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Username already exists", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
				}
				return okay;
		     }
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		    return 0;
		}
		return 0;
	}
	
	
	public void update(String table, String attribute, String text, String key)
	{
		//queries and then inserts
		try
		{
			
			Frames.con.setAutoCommit(false);
			stmt = Frames.con.createStatement();
			
				Frames.con.setAutoCommit(false);
				stmt = Frames.con.createStatement();
				sql = 	"UPDATE " + "'" + table + "'" + " set " + "'" + attribute + "'"+
						" = " + "\""+ text + "\"" + " where USERNAME =" + " \""+ key +"\";";
				
				stmt.executeUpdate(sql);
				stmt.close();
				Frames.con.commit();
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	
	
	
	
	
	
	
	public String find(String username, String pass)
	{
		//queries and then inserts
		try
		{
			
			String test  = "";
			String acctype = "";
			Frames.con.setAutoCommit(false);
			stmt = Frames.con.createStatement();
			
			 for(int i = 0; i < 5; i++)
		     {
		    	  switch(i)
		    	  {
		    	  	case 0:
		    	  	{
		    	  		acctype = "PATIENT";
		   
		    	  		break;
		    	  	}
		    	  	case 1:
		    	  	{
		    	  		acctype = "DOCTOR";
		    	  		break;
		    	  	}
		    	  	case 2:
		    	  	{
		    	  		acctype = "NURSE";
		    	  		break;
		    	  	}
		    	  	case 3:
		    	  	{
		    	  		acctype = "LAB";
		    	  		break;
		    	  	}
		    	  	case 4:
		    	  	{
		    	  		acctype = "NSP";
		    	  		break;
		    	  	}
		    	  }
			
			
				String query = "SELECT *" +
						" FROM " + "'"+ acctype + "'"+
						" WHERE USERNAME =  "+ "\"" + username + "\"" 
						+ " AND PASSWORD = " + "\"" + pass +"\""+";";
				
				ResultSet rs = stmt.executeQuery(query);
				while(rs.next())
				{
					test = rs.getString("USERNAME");
				}
				if(test != "")
				{
					return acctype;
				}
		     }
			if(test == "")
			{
				JOptionPane.showConfirmDialog(null, "Couldn't find User Name or Password!", "Alert Message", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
				return "";
			}
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		    return "";
		}
		return "";
	}
	
}


