package CONTROLADOR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import MODELO.FileDirection;

public class DBOracle implements ICreateUser {

	@Override
	public void CreateDBFile(JTextArea testArea1) {
		
		try {
			File f= new File("Oracle.txt");
			f.delete();
			
			//This file will be saved in the same folder of this Java Project
			FileWriter Writer = new FileWriter("Oracle.txt",true); 
			Writer.write("ESP");
			//this makes a "\n" regardless of the OS 
			Writer.write(System.getProperty("line.separator")); 
			Writer.close();
			
			FileReader reader = new FileReader("Oracle.txt");
			BufferedReader br = new BufferedReader(reader);
			testArea1.read(br, null);
			br.close();
			testArea1.requestFocus();
			
			// we update the file that we are working with
			FileDirection.file = "Oracle.txt"; 
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
	}

}
