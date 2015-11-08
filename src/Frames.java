import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Frames
{
	public static String user = "";
	public static String doc_patient = "";
	public static LogInWindow login = new LogInWindow();
	public static UserAccountRegistration userReg = new UserAccountRegistration();
	public static MainWindow mainMenu = new MainWindow();
	public static UserMenuWindow userMenu = new UserMenuWindow();
	public static DoctorMenuWindow docMenu = new DoctorMenuWindow();
	public static LabStaffMenuWindow labMenu = new LabStaffMenuWindow();
	public static NurseMenuWindow nurseMenu = new NurseMenuWindow();
	public static NSPStaffMenuWindow nspMenu = new NSPStaffMenuWindow();
	
	public static ScheduleAppointment appt = new ScheduleAppointment();
	public static UpdateHealth cond = new UpdateHealth();
	public static EPrescribeWindow prescribe = new EPrescribeWindow();
	public static AppointmentGUI sch = new AppointmentGUI();
	public static UpdateHealthDoctors update_doc = new UpdateHealthDoctors();
	public static RetrieveInfoWindowDoctor patient_info = new RetrieveInfoWindowDoctor();
	public static DocViewPatient docViewPatient = new DocViewPatient();
	public static UpdateHealthNurse update_nurse = new UpdateHealthNurse();
	public static RetrieveInfoWindowHSP patient_info_hsp = new RetrieveInfoWindowHSP();
	public static StatReport stats = new StatReport();
	
	//======================================
	//Frames.java -> sqliteConnection.java
	//======================================
	public static Connection con = sqliteConnection.dbConnector();
	
	public static void find(String find, String attr, String table)
	{
		try
		{
			String test  = "";
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String query = "SELECT " + "'" + attr + "'" +
						" FROM " + "'"+ table + "'"
						+ " WHERE "  + attr  + " = " + "'" + find +"'"+";";
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				test = rs.getString("'"+attr+"'");
			}
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	
	public static String get(String find, String attr, String table, String whatyouwant)
	{
		String returnString = "";

		try
		{
			String test  = "";
			Frames.con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			
			String query = "SELECT "  + whatyouwant  +
						" FROM " + "'"+ table + "'"
						+ " WHERE "  + attr  + " = " + "\"" + find +"\""+";";
			

			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				test = rs.getString(whatyouwant);
			}
			if(test != null)
			{
				returnString = test;
			}
			return returnString;
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		    System.exit(0);
			return returnString;
		}
	}
	
	public static void insert(String table, String username, String id)
	{
		try
		{
			String sql = "";
			Frames.con.setAutoCommit(false);
			Statement stmt = Frames.con.createStatement();
		
			
			sql = 	"INSERT INTO" + "'" + table + "'" + "(USERNAME, ID)" 
					+ "VALUES (" + "'"+ username + "'" + ",'" + id + "')";
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
	public static void update(String table, String attr, String user, String value, String id)
	{
		try
		{
			String sql = "";
			String test = "";
			String num = "";
			int counter = 0;
			Frames.con.setAutoCommit(false);
			Statement stmt = Frames.con.createStatement();

			
			sql = 	"UPDATE " + "'" + table + "'" + " set " + "'" + attr + "'"+
					" = " + "\""+ value + "\"" + " where USERNAME =" + " \""+ user +"\""
							+ "AND ID = " + "'" + id + "';";
			stmt.executeUpdate(sql);
			stmt.close();
			Frames.con.commit();
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName( ) + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	public static String rand()
	{
		Random rn = new Random();
		String randreturn;
		char c = (char)(rn.nextInt(26)+'a');

		int num = rn.nextInt(10);
		
		randreturn = new StringBuilder().append("").append(Character.toUpperCase(c)).append(num).toString();
		return randreturn;
	}
	public static ArrayList<String> list()
	{
		try 
		{
			int counter = 0;
			ArrayList<String> retstr = new ArrayList<String>();
			Connection con = sqliteConnection.dbConnector();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String list = "SELECT USERNAME FROM DOCTOR;";
			PreparedStatement pre = con.prepareStatement(list);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				retstr.add(rs.getString("USERNAME"));
				counter++;
			}
			
			stmt.executeUpdate(list);
			stmt.close();
			con.commit();
			return retstr;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	

	}
	public static DefaultTableModel scheduleTable()
	{
		try
		{
			Connection con = sqliteConnection.dbConnector();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String list = "SELECT * FROM SCHEDULE WHERE USERNAME = \""+Frames.user+"\";";
			
			PreparedStatement pre = con.prepareStatement(list);
			ResultSet rs = pre.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int colCount = metaData.getColumnCount();
			for(int col = 1; col <= colCount; col++)
			{
				columnNames.add(metaData.getColumnName(col));
			}
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while(rs.next())
			{
				Vector<Object> vector = new Vector<Object>();
				for(int columnIndex = 1; columnIndex <= colCount; columnIndex++)
				{
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
			stmt.close();
			con.commit();
			return new DefaultTableModel(data, columnNames)
			{
				boolean[] canEdit = new boolean[]
				{
						false, false, true, true, false
				};
				public boolean isCellEditable(int rowIndex, int columnIndex)
				{
					return canEdit[columnIndex];
				}
			};
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	public static void delete(String table, String attr, String id)
	{
		try
		{
		
			String sql = "";
			Frames.con.setAutoCommit(false);
			Statement stmt = Frames.con.createStatement();
		
			
			sql = 	"DELETE FROM " + "'" + table + "' " + "WHERE "  +attr+ " = " + "\""+id +"\""+ ";";
			stmt.executeUpdate(sql);
			stmt.close();
			Frames.con.commit();
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName( ) + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	public static ArrayList<String> listPatients()
	{
		try 
		{
			int counter = 0;
			ArrayList<String> retstr = new ArrayList<String>();
			Connection con = sqliteConnection.dbConnector();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String list = "SELECT USERNAME FROM PATIENT;";
			PreparedStatement pre = con.prepareStatement(list);
			ResultSet rs = pre.executeQuery();
			while(rs.next())
			{
				retstr.add(rs.getString("USERNAME"));
				counter++;
			}
			
			stmt.executeUpdate(list);
			stmt.close();
			con.commit();
			return retstr;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	

	}
	public static void updateinfo(String table, String attr, String value,String user)
	{
		try
		{
			String sql = "";
			String test = "";
			String num = "";
			int counter = 0;
			Frames.con.setAutoCommit(false);
			Statement stmt = Frames.con.createStatement();

			
			sql = 	"UPDATE " + "'" + table + "'" + " set " + "'" + attr + "'"+
					" = " + "\""+ value + "\"" + " where USERNAME =" + " \""+ user +"\""+";";
			stmt.executeUpdate(sql);
			stmt.close();
			Frames.con.commit();
		}
		catch(Exception e)
		{
			System.err.println( e.getClass().getName( ) + ": " + e.getMessage() );
		    System.exit(0);
		}
	}
	public static DefaultTableModel scheduleTableDocs()
	{
		try
		{
			Connection con = sqliteConnection.dbConnector();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String list = "SELECT * FROM SCHEDULE WHERE USERNAME = \""+Frames.doc_patient+"\";";
			
			PreparedStatement pre = con.prepareStatement(list);
			ResultSet rs = pre.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			Vector<String> columnNames = new Vector<String>();
			int colCount = metaData.getColumnCount();
			for(int col = 1; col <= colCount; col++)
			{
				columnNames.add(metaData.getColumnName(col));
			}
			Vector<Vector<Object>> data = new Vector<Vector<Object>>();
			while(rs.next())
			{
				Vector<Object> vector = new Vector<Object>();
				for(int columnIndex = 1; columnIndex <= colCount; columnIndex++)
				{
					vector.add(rs.getObject(columnIndex));
				}
				data.add(vector);
			}
			stmt.close();
			con.commit();
			return new DefaultTableModel(data, columnNames)
			{
				boolean[] canEdit = new boolean[]
				{
						false, false, true, true, false
				};
				public boolean isCellEditable(int rowIndex, int columnIndex)
				{
					return canEdit[columnIndex];
				}
			};
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	public static ResultSet stats()
	{
		try 
		{
			Connection con = sqliteConnection.dbConnector();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String list = "SELECT * FROM PATIENT;";
			PreparedStatement pre = con.prepareStatement(list);
			ResultSet rs = pre.executeQuery();
			
			stmt.executeUpdate(list);
			stmt.close();
			con.commit();
			return rs;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
	public static ResultSet stats2()
	{
		try 
		{
			Connection con = sqliteConnection.dbConnector();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			String list = "SELECT * FROM CONDITION;";
			PreparedStatement pre = con.prepareStatement(list);
			ResultSet rs = pre.executeQuery();
			
			stmt.executeUpdate(list);
			stmt.close();
			con.commit();
			return rs;
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
}
