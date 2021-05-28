package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ActionListenerWordReplacer extends JFrame implements ActionListener {

	private NewJTextArea newJTa1;
	private JTextField SearchWord;
	private JTextField ReplaceWord;
	
	public ActionListenerWordReplacer(NewJTextArea nJTA, JTextField sw, JTextField rw){
		this.newJTa1=nJTA;
		this.SearchWord=sw;
		this.ReplaceWord=rw;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try {
			
			if(newJTa1.getText().contains(SearchWord.getText())) {
				
				String temp = newJTa1.getText().replaceAll(SearchWord.getText(), ReplaceWord.getText());
				newJTa1.setText(temp);
			}else {
				JOptionPane.showMessageDialog(null, "That word is not contained in JTextArea1");
			}
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Error while replacing word");
		}
		
	}

}
