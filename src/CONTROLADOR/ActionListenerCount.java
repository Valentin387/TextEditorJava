package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ActionListenerCount extends JFrame implements ActionListener{

	
	private NewJTextArea testArea1;
	private WordCounter wordCounter;
	private JLabel counterlabel;
	
	public void setObserved(NewJTextArea testArea1) {
		this.testArea1=testArea1; //the observed
	}
	
	public void setObserver(WordCounter woco) {
		this.wordCounter=woco; //the observer
	}
	
	public void giveMeLabel(JLabel counterlabel) {
		this.counterlabel = counterlabel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {

			testArea1.addObservers(wordCounter);
			testArea1.NoticeAllObservers();

			counterlabel.setText("Words: "+ wordCounter.getNumberOfWords());
			
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Error in counting");
			//e1.printStackTrace(); //it displays the track or errors into console
		}
		
	}

}
