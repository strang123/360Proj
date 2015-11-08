import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import java.awt.BorderLayout;
//tester
public class MainWindow {

	//private JFrame frmIpims;
	//private MainWindow window;
	private JTextField textField;

	

	/**
	 * Create the application.
	 */
	public MainWindow() 
	{
	
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	//private void initialize() {
	//	frmIpims = new UserMenuWindow();
		
	//}
	static JMenuBar PatientMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu AppointmentBtn = new JMenu("Appointment");
		menuBar.add(AppointmentBtn);
		JMenuItem mntmSchedule = new JMenuItem("Schedule Appointment");
		AppointmentBtn.add(mntmSchedule);
		JMenuItem mntmView = new JMenuItem("View Appointment");
		AppointmentBtn.add(mntmView);
		JMenuItem mntmCancel_3 = new JMenuItem("Cancel");
		AppointmentBtn.add(mntmCancel_3);
		JMenu mnHealth = new JMenu("Health");
		menuBar.add(mnHealth);
		JMenuItem mntmUpdateHealthInformation = new JMenuItem("Update Health Information");
		mnHealth.add(mntmUpdateHealthInformation);
		JMenuItem mntmSendMedicalAlert = new JMenuItem("Send Medical Alert");
		mnHealth.add(mntmSendMedicalAlert);
		JMenuItem mntmCancel_2 = new JMenuItem("Cancel");
		mnHealth.add(mntmCancel_2);
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnAccount.add(mntmLogOut);
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnAccount.add(mntmQuit);
		JMenuItem mntmCancel_1 = new JMenuItem("Cancel");
		mnAccount.add(mntmCancel_1);
		return menuBar;
	}
	static JMenuBar DoctorMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnPatient = new JMenu("Patient");
		menuBar.add(mnPatient);
		JMenuItem mntmFindPatient = new JMenuItem("Find Patient");
		mnPatient.add(mntmFindPatient);
		JMenuItem mntmCancel_2 = new JMenuItem("Cancel");
		mnPatient.add(mntmCancel_2);
		JMenu Appointmentsbtn = new JMenu("Appointments");
		menuBar.add(Appointmentsbtn);
		JMenuItem mntmViewAppointments = new JMenuItem("View Appointments");
		Appointmentsbtn.add(mntmViewAppointments);
		JMenuItem mntmCancel_3 = new JMenuItem("Cancel");
		Appointmentsbtn.add(mntmCancel_3);
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnAccount.add(mntmLogOut);
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnAccount.add(mntmQuit);
		JMenuItem mntmCancel_1 = new JMenuItem("Cancel");
		mnAccount.add(mntmCancel_1);
		return menuBar;
	}
	static JMenuBar AdminMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnAdministration = new JMenu("Administration");
		menuBar.add(mnAdministration);
		JMenuItem mntmSearchAccount = new JMenuItem("Search Account");
		mnAdministration.add(mntmSearchAccount);
		JMenuItem mntmViewAccountRequests = new JMenuItem("View Account Requests");
		mnAdministration.add(mntmViewAccountRequests);
		JMenuItem mntmCancel = new JMenuItem("Cancel");
		mnAdministration.add(mntmCancel);
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnAccount.add(mntmLogOut);
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnAccount.add(mntmQuit);
		JMenuItem mntmCancel_1 = new JMenuItem("Cancel");
		mnAccount.add(mntmCancel_1);
		return menuBar;
	}
	static JMenuBar NurseMenu() { //The Nurse, LabStaff, and HSPStaff menus are the same, since everything they need to do requires searching for a patient
		JMenuBar menuBar = new JMenuBar();
		JMenu mnPatient = new JMenu("Patient");
		menuBar.add(mnPatient);
		JMenuItem mntmFindPatient = new JMenuItem("Find Patient");
		mnPatient.add(mntmFindPatient);
		JMenuItem mntmCancel_2 = new JMenuItem("Cancel");
		mnPatient.add(mntmCancel_2);
		JMenu mnAccount = new JMenu("Account");
		menuBar.add(mnAccount);
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mnAccount.add(mntmLogOut);
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnAccount.add(mntmQuit);
		JMenuItem mntmCancel_1 = new JMenuItem("Cancel");
		mnAccount.add(mntmCancel_1);
		return menuBar;
	}
	static JMenuBar LabStaffMenu() {
		return NurseMenu();
	}
	static JMenuBar HSPStaffMenu() {
		return NurseMenu();
	}
	
}
