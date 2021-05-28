package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ActionListenerCancel extends JFrame implements ActionListener{

	
	private JTextArea Jta2;
	
	public ActionListenerCancel(JTextArea TA) {
		this.Jta2=TA;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.Jta2.setText("");
	}
	

}
