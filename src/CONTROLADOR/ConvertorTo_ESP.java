package CONTROLADOR;

import javax.swing.JTextArea;

public class ConvertorTo_ESP implements IDraftUser{

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		njta.replaceRange("ESP", 0, 3);
		
	}

}
