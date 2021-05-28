package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionListenerCreateContext  extends JFrame implements ActionListener{

	
	private JTextArea textArea1;
	private ICreateUser strategy; 
	private JTextField JTf1;
	
	public ActionListenerCreateContext(JTextArea TA1, JTextField JTf1){
		this.textArea1=TA1;
		this.JTf1=JTf1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String textSelectedInComboBox;
		
		textSelectedInComboBox = (String) ((JComboBox)event.getSource()).getSelectedItem();
	
		
		JTf1.setText("= " + textSelectedInComboBox);
		
		if("Texto.txt".equals(textSelectedInComboBox)) {
			this.strategy = new DBTexto();
		}
		
		if("Oracle.txt".equals(textSelectedInComboBox)) {
			this.strategy = new DBOracle();
		}
		
		if("SQL.txt".equals(textSelectedInComboBox)) {
			this.strategy = new DBsql();
		}
		
		strategy.CreateDBFile(textArea1);
		
	}

}
