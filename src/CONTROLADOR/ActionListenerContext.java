package CONTROLADOR;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ActionListenerContext extends JFrame implements ActionListener{

	private NewJTextArea newJTa1;
	private JTextArea Jta2;
	private JTextField JTf1;
	private IDraftUser strategy; 
	
	//constructor
	
	public ActionListenerContext(NewJTextArea nJTA, JTextArea JTA, JTextField JTF) {
		this.newJTa1=nJTA;
		this.Jta2=JTA;
		this.JTf1=JTF;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String textSelectedInComboBox;
		
		textSelectedInComboBox = (String) ((JComboBox)event.getSource()).getSelectedItem();
		String LanguageModule;
		
		try {
			LanguageModule = newJTa1.getText().substring(0, 3);
		}catch(Exception er) {
			LanguageModule = "000";
			JOptionPane.showMessageDialog(null, "Text too short to read languageModule ***");
		}

		
		
		try {
			
			JTf1.setText("= " + textSelectedInComboBox);
			
			if("Arial".equals(textSelectedInComboBox)) {
				this.strategy = new ConvertorTo_Arial();
			}
			
			if("Times New Roman".equals(textSelectedInComboBox)) {
				this.strategy = new ConvertorTo_TimesNewRoman();
			}
			
			if("Segoe Script".equals(textSelectedInComboBox)) {
				this.strategy = new ConvertorTo_SegoeScript();
			}
			
			//not if Chinese
			if(!LanguageModule.equals("CHI")) {
				if("All to lower case".equals(textSelectedInComboBox)) {
					this.strategy = new ConvertorTo_LowerCase();
				}
				
				if("All to upper case".equals(textSelectedInComboBox)) {
					this.strategy = new ConvertorTo_UpperCase();
				}
				
				if("Random Case in all".equals(textSelectedInComboBox)) {
					this.strategy = new ConvertorTo_RandomCase();
				}
			}
			
			//
			
			if("SPANISH".equals(textSelectedInComboBox)) {
				this.strategy = new ConvertorTo_ESP();
			}
			
			if("CHINESE".equals(textSelectedInComboBox)) {
				this.strategy = new ConvertorTo_CHI();
			}
			
			if("RUSSIAN".equals(textSelectedInComboBox)) {
				this.strategy = new ConvertorTo_RUS();
			}
			
			strategy.tryTheseChanges(newJTa1, Jta2);
			
			
		}catch(Exception exception1) {
			JOptionPane.showMessageDialog(null, "Error in Strategy Context of ComboBox'es");
		}
		
	}

}
