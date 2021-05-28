package CONTROLADOR;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import MODELO.FileDirection;

public class ActionListenerSave extends JFrame implements ActionListener{

	private JTextArea testArea1;
	private String filename;
	
	public void theSet(JTextArea testArea1) {
		this.testArea1=testArea1;
	}
	
	public void fileSet(String file) {
		this.filename=file;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			String texto = testArea1.getText();
			
			//temporal receptor to erase the old file's content 
			File f= new File(FileDirection.file); 
			f.delete();
			
			File f2= new File(FileDirection.file);
			//to write the new information in the new version of the file
			FileWriter Writer = new FileWriter(f2,true); 
			Writer.write(texto);
			Writer.write(System.getProperty("line.separator"));
			Writer.close();
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}
	}
		

}
