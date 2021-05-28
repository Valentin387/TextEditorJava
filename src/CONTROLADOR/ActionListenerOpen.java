package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import MODELO.FileDirection;

public class ActionListenerOpen extends JFrame implements ActionListener {

	private JTextArea testArea1;
	
	public void theSet(JTextArea testArea1) {
		this.testArea1=testArea1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		
		int returnVal = chooser.showOpenDialog(this);
	
		File f;
		//this 'if' will prevent that the program throws an exception if I choose [cancel]
		if(returnVal == JFileChooser.APPROVE_OPTION) { 
			f = chooser.getSelectedFile();
			String filename = f.getAbsolutePath();
		
		//it verifies that the chosen file is a .txt
		if(f.getName().toLowerCase().endsWith(".txt")) {
			try {
				
				FileReader reader = new FileReader(filename);
				BufferedReader br = new BufferedReader(reader);
				testArea1.read(br, null);
				br.close();
				testArea1.requestFocus();
				
				// we update the file that we are working with
				FileDirection.file = filename; 
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Error");
			}
			
		}else {
			JFrame alert = new JFrame("Alert");
			JOptionPane.showMessageDialog(alert, "You can only open .TXT/.txt files" ,
					"Data Corruption Danger",JOptionPane.INFORMATION_MESSAGE);
		}
			
		}
	}
}
