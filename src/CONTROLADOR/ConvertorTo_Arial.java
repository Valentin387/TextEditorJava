package CONTROLADOR;

//import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;

public class ConvertorTo_Arial implements IDraftUser{

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		jta.setText(njta.getText());
		
		Font font = new Font("Arial", Font.PLAIN, 14);
        jta.setFont(font);
	}

}
