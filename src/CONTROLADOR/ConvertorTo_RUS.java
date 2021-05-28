package CONTROLADOR;

import javax.swing.JTextArea;

public class ConvertorTo_RUS implements IDraftUser{

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		njta.replaceRange("RUS", 0, 3);
		
	}

}
