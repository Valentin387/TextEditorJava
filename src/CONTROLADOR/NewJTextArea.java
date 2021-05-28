package CONTROLADOR;

import java.util.ArrayList;
import javax.swing.JTextArea;

public class NewJTextArea extends JTextArea{ //The Concrete ObservED 
	
	private ArrayList<WordCounter> wordCounters;
	
	public NewJTextArea() {
		super();
		wordCounters = new ArrayList<WordCounter>();
	}

	public void addObservers(WordCounter wordCounter) {
		this.wordCounters.add(wordCounter);
	}

	public void NoticeAllObservers() {

		for(WordCounter wc: wordCounters) {
			wc.notice(this.getText());
		}
	}
}
