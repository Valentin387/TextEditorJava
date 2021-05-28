package CONTROLADOR;

import javax.swing.JTextArea;

public class ConvertorTo_RandomCase implements IDraftUser{

	@Override
	public void tryTheseChanges(NewJTextArea njta, JTextArea jta) {
		
		String words[] = njta.getText().split("\\s");
		int number;
		String temp;
		String newText ="";
		
		for(String str : words) {
			number = (int) (Math.random()*2);
			if(number==0) {
				temp = str.toLowerCase();
			}else {
				temp = str.toUpperCase();
			}
			newText=newText.concat(temp + "\n");
		}
		
		jta.setText(newText); 
	}

}
