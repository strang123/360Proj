import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class AccessLabReport extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextArea textFieldContent;

	
	public AccessLabReport() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		textFieldContent = new JTextArea();
		textFieldContent.setBounds(10, 11, 414, 206);
		contentPanel.add(textFieldContent);
		textFieldContent.setLineWrap(true);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Access");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fs = new JFileChooser(new File("c:\\"));
						fs.setDialogTitle("Open a File");
						//fs.setFileFilter(new FileTypeFilter(".txt", "Text File"));
						int result = fs.showOpenDialog(null);
						if (result == JFileChooser.APPROVE_OPTION){
							try{
								File fi = fs.getSelectedFile();
								BufferedReader br = new BufferedReader(new FileReader(fs.getSelectedFile().getPath()));
								String line = "";
								String s = "";
								while((line = br.readLine())!= null)
								{
									s += line;
								}
								textFieldContent.setText(s);
								JOptionPane.showMessageDialog(null, "Access Successful");
								if(br != null)
									br.close();
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, e2.getMessage());
							}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
	}	
}

