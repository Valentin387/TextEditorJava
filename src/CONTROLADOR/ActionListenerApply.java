package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionListenerApply extends JFrame implements ActionListener{

	private NewJTextArea newJTa1;
	private JTextArea Jta2;
	
	//constructor
	
	public ActionListenerApply(NewJTextArea nJTA, JTextArea JTA) {
		this.newJTa1=nJTA;
		this.Jta2=JTA;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		this.newJTa1.setFont(this.Jta2.getFont());
		this.newJTa1.setText(this.Jta2.getText());
	}

}
