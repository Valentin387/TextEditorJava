package CONTROLADOR;

import javax.swing.JTextArea;

public class ConvertorTo_UpperCase implements IDraftUser {

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		jta.setText(njta.getText().toUpperCase());
		
	}

}
