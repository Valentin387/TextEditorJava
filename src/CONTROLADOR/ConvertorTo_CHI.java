package CONTROLADOR;

import javax.swing.JTextArea;

public class ConvertorTo_CHI implements IDraftUser{

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		njta.replaceRange("CHI", 0, 3);
		
	}

}
