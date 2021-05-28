package CONTROLADOR;

import javax.swing.JTextArea;

public class ConvertorTo_LowerCase implements IDraftUser{

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		jta.setText(njta.getText().toLowerCase());
		
	}

}
