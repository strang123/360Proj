import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;

public class UserMenuWindow extends JFrame {

	public JLabel lblNewLabel;
	private JPanel contentPane;
	public UserMenuWindow() {
		setResizable(false);
		setTitle("IPIMS Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 219, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 83, 185, 143);
		contentPane.add(panel_1);
		
		JButton btnViewAppointments = new JButton("Appointments");
		btnViewAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Frames.userMenu.setVisible(false); 
				if(Frames.sch != null)
				{
					Frames.sch.dispose();
				}				
				Frames.sch = new AppointmentGUI();
				Frames.sch.setLocationRelativeTo(null);
				Frames.sch.setVisible(true);
			}
		});
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnScheduleAppointment = new JButton("Create Appointment");
		panel_1.add(btnScheduleAppointment);
		btnScheduleAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.userMenu.setVisible(false); 
				if(Frames.appt != null)
				{
					Frames.appt.dispose();
				}
				Frames.appt = new ScheduleAppointment();
				Frames.appt.setLocationRelativeTo(null);
				Frames.appt.setSize(280,480);
				Frames.appt.setVisible(true);
				
			
			}
		});
		panel_1.add(btnViewAppointments);
		

		
		
		JButton btnUpdateHealthInformation = new JButton("Update Health Information");
		btnUpdateHealthInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Frames.cond.setSize(580,580);
				Frames.cond.setLocationRelativeTo(null);
				Frames.userMenu.setVisible(false); 
				Frames.cond.setVisible(true);
			}
		});
		panel_1.add(btnUpdateHealthInformation);
		
	
		
		JButton btnExitProgram = new JButton("Exit Program");
		btnExitProgram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		panel_1.add(btnExitProgram);
		
		JLabel lblpleaseSelectAn = new JLabel("<html><b>Please Select an Option</b></html>");
		lblpleaseSelectAn.setBounds(31, 28, 185, 14);
		contentPane.add(lblpleaseSelectAn);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(41, 53, 114, 14);
		contentPane.add(lblNewLabel);
		
	}
}
