import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.io.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
//import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UploadLab extends JDialog {

	private final JPanel contentPanel = new JPanel();
	//private JTextField textFieldContent;
	private JTextArea textFieldContent;

	
	

	public UploadLab() {
	
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			//textFieldContent = new JTextField();
			textFieldContent = new JTextArea();
			textFieldContent.setBounds(10, 11, 414, 206);
			contentPanel.add(textFieldContent);
			textFieldContent.setColumns(10);
			textFieldContent.setLineWrap(true);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Open");
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
			{
				JButton cancelButton = new JButton("Save");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fs = new JFileChooser(new File("c:\\"));
						fs.setDialogTitle("Save a File");
			//			fs.setFileFilter(new FileTypeFilter(".txt","Text File"));
						int result = fs.showSaveDialog(null);
						if (result == JFileChooser.APPROVE_OPTION){
							String content = textFieldContent.getText();
							File fi = fs.getSelectedFile();
							try{
								FileWriter fw = new FileWriter(fi.getPath());
								fw.write(content);
								fw.flush();
								fw.close();
								JOptionPane.showMessageDialog(null, "Upload Successful");
							}catch(Exception e2){
								JOptionPane.showMessageDialog(null, e2.getMessage());
							}
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
