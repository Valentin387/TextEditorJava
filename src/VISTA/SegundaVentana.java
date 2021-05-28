package VISTA;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import CONTROLADOR.ActionListenerApply;
import CONTROLADOR.ActionListenerCancel;
import CONTROLADOR.ActionListenerContext;
import CONTROLADOR.ActionListenerCount;
import CONTROLADOR.ActionListenerCreateContext;
import CONTROLADOR.ActionListenerOpen;
import CONTROLADOR.ActionListenerSave;
import CONTROLADOR.ActionListenerWordReplacer;
import CONTROLADOR.NewJTextArea;
import CONTROLADOR.WordCounter;
import MODELO.FileDirection;

public class SegundaVentana {

	//I apply Singleton
	private static SegundaVentana instance=null;
	private SegundaVentana() {}
	
	public static SegundaVentana getInstance() {
		if(instance == null) {
			instance = new SegundaVentana();
			return instance;
		}else {
			
			JFrame alert = new JFrame("Alert");
			JOptionPane.showMessageDialog(alert,
					"You can't open this form twice\n"
					+ "close me and re-compile the code instead",
					"Alert: Exception: Singleton",
					JOptionPane.INFORMATION_MESSAGE);
	
			return null;
		}
	}
	
	//I couldn't apply the JScrollPane because that requires a Layout!=null
	//and I don't now how to handle that
	public void action(boolean open) {
	
		//I create the frame
		JFrame app = new JFrame("Segunda Ventana");
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(800, 550);
		app.setLayout(null);
		app.setResizable(false);
		app.setLocationRelativeTo(null);
		
		//First testArea
		NewJTextArea testArea1 = new NewJTextArea();					//the observed
		testArea1.setBounds(140, 60, 300, 400);
	
		//Second textArea
		JTextArea testArea2 = new JTextArea(); 			
		testArea2.setBounds(470, 60, 300, 400);
		
		//Add JTestAreas to the JFrame
		app.add(testArea1);
		app.add(testArea2);
		
		//ComboBox for DATABASES
		//it creates the .txt's in the same folder of the computer where this project is. 
		JTextField DBHeading = new JTextField("Create new DATABASE:"); 
		DBHeading.setEditable(false);
		DBHeading.setBounds(20, 10, 135, 20);
				
		JComboBox<String> boxDB = new JComboBox<String>();
		boxDB.setBounds(160, 10, 120, 20);
		String[] arrayDB = {"Texto.txt", "Oracle.txt", "SQL.txt"};
			
		for(String st: arrayDB) {
			boxDB.addItem(st);
		}
				
		JTextField selectedDB = new JTextField(17);
		selectedDB.setBounds(285, 10, 120, 25);
				
		ActionListenerCreateContext cre = new ActionListenerCreateContext(testArea1, selectedDB);
		boxDB.addActionListener(cre);
				
		app.add(DBHeading);
		app.add(boxDB);
		app.add(selectedDB);
		
		//Button for choosing a file from disc
		JButton chooseFileButton = new JButton("Open File");
		ActionListenerOpen o1 = new ActionListenerOpen();
		o1.theSet(testArea1);
		chooseFileButton.addActionListener(o1);
		chooseFileButton.setBounds(410,10,120,20);
		app.add(chooseFileButton);
		
		//It displays the chosen file into the JTestArea1 in the first instance
		if (open) {
			o1.actionPerformed(null); //if I opened something in "Primera Ventana"
		} 
		
		//Button for saving changes in the open file displayed in the JTextArea 
		JButton saveButton = new JButton("Save");
		ActionListenerSave sv = new ActionListenerSave();
		sv.theSet(testArea1);
			sv.fileSet(FileDirection.file);
		saveButton.addActionListener(sv);
		saveButton.setBounds(530,10,120,20);
		app.add(saveButton);				
			
		//Label for word counter 							[Observer Pattern]
		JLabel counterlabel = new JLabel();
		counterlabel.setBounds(300, 480, 120, 20);
		app.add(counterlabel);
		counterlabel.setText("Words: ");
		
		//Button for re-counting words manually 
			//	because I really couldn't make it automatic
		//I would have to mess with overriding basic input methods
		//in NewJTextArea and that's too much for now.
		//However, Observer pattern was applied successfully
		JButton counterButton = new JButton("Re-count");
		ActionListenerCount alc = new ActionListenerCount();
		alc.setObserved(testArea1);
		
		WordCounter woco = new WordCounter();
		alc.setObserver(woco);
		alc.giveMeLabel(counterlabel); 
		
		counterButton.addActionListener(alc);
		counterButton.setBounds(180, 480, 100, 20);
		app.add(counterButton);
		
		//Label for Draft View
		
		JLabel draftViewLabel = new JLabel();
		draftViewLabel.setBounds(490, 30, 248, 20);
		app.add(draftViewLabel);
		draftViewLabel.setText("Draft View (check/write the changes here):");
		
		//some important globals for the following design:
			int textFieldVerticalcor=50;
			int comboBoxVerticalcor=80;
			int selectedFromBoxVerticalcor=110;
		
		//ComboBox for fonts and its JTestField
		JTextField fontHeading = new JTextField("Fonts Available");
		fontHeading.setEditable(false);
		fontHeading.setBounds(15, 50, 100, 20);
		
		JComboBox<String> boxFonts = new JComboBox<String>();
		boxFonts.setBounds(15, 80, 120, 30);
		String[] arrayFonts = {"Times New Roman", "Arial", "Segoe Script"};
	
		for(String st: arrayFonts) {
			boxFonts.addItem(st);
		}
		
		JTextField selectedFont = new JTextField(17);
		selectedFont.setBounds(15, 110, 120, 25);
		
		ActionListenerContext alCOfont = new ActionListenerContext(testArea1,testArea2,selectedFont);
		boxFonts.addActionListener(alCOfont);
		
		app.add(fontHeading);
		app.add(boxFonts);
		app.add(selectedFont);
		
		//ComboBox for CASE and its JTestField
		textFieldVerticalcor+=100;
		comboBoxVerticalcor+=100;
		selectedFromBoxVerticalcor+=100;
		
		JTextField CASEHeading = new JTextField("Cases Available");
		CASEHeading.setEditable(false);
		CASEHeading.setBounds(15, textFieldVerticalcor, 100, 20);
		
		JComboBox<String> boxCASES = new JComboBox<String>();
		boxCASES.setBounds(15, comboBoxVerticalcor, 120, 30);
		String[] arrayCASES = {"All to lower case", "All to upper case", "Random Case in all"};
	
		for(String st: arrayCASES) {
			boxCASES.addItem(st);
		}
		
		JTextField selectedCASE = new JTextField(19);
			selectedCASE.setBounds(15, selectedFromBoxVerticalcor, 120, 25);
		
		ActionListenerContext alCOcase = new ActionListenerContext(testArea1,testArea2,selectedCASE);
		boxCASES.addActionListener(alCOcase);
		
		app.add(CASEHeading);
		app.add(boxCASES);
		app.add(selectedCASE);
		
		//ComboBox for LANGAUGE and its JTestField
		textFieldVerticalcor+=100;
		comboBoxVerticalcor+=100;
		selectedFromBoxVerticalcor+=100;
		
		JTextField LANGUAGEHeading = new JTextField("Languages Available");
		LANGUAGEHeading.setEditable(false);
		LANGUAGEHeading.setBounds(15, textFieldVerticalcor, 120, 20);
		
		JComboBox<String> boxLANGUAGES = new JComboBox<String>();
		boxLANGUAGES.setBounds(15, comboBoxVerticalcor, 120, 30);
		String[] arrayLANGUAGES = {"SPANISH", "CHINESE", "RUSSIAN"};
	
		for(String st: arrayLANGUAGES) {
			boxLANGUAGES.addItem(st);
		}
		
		JTextField selectedLANGUAGE = new JTextField(19);
			selectedLANGUAGE.setBounds(15,selectedFromBoxVerticalcor, 120, 25);
		
		ActionListenerContext alCOLanguage = new ActionListenerContext(testArea1,testArea2,selectedLANGUAGE);
		boxLANGUAGES.addActionListener(alCOLanguage);
		
		app.add(LANGUAGEHeading);
		app.add(boxLANGUAGES);
		app.add(selectedLANGUAGE);
		
		//Space for searching a word and replace it with another in JTextArea1
		int SearchTitleCOR = 340;
		int SearchInputCOR = 360;
		int ReplacetIitleCOR = 380;
		int ReplaceInputCOR = 400;
		
		
		JTextField SearchTitle = new JTextField("Search this:");
		SearchTitle.setEditable(false);
		SearchTitle.setBounds(15,SearchTitleCOR, 80, 20);
		
		JTextField SearchInput = new JTextField(19);
		SearchInput.setBounds(15, SearchInputCOR, 120, 20);
		
		JTextField ReplaceTitle = new JTextField("And replace with:");
		ReplaceTitle.setEditable(false);
		ReplaceTitle.setBounds(15, ReplacetIitleCOR, 100, 20);
		
		JTextField ReplaceInput = new JTextField(19);
		ReplaceInput.setBounds(15, ReplaceInputCOR, 120, 20);
		
		JButton ReplacingWordButton = new JButton("Replace");
		ReplacingWordButton.setBounds(30, 420, 90, 20);
		ActionListenerWordReplacer alWR = new ActionListenerWordReplacer(testArea1,SearchInput,ReplaceInput);
		ReplacingWordButton.addActionListener(alWR);
	
		
		app.add(SearchTitle); 
		app.add(SearchInput);
		app.add(ReplaceTitle);
		app.add(ReplaceInput);
		app.add(ReplacingWordButton);
		
		
		//Button for applying changes in the first JTextArea
		JButton ToApplyButton = new JButton("Apply changes");
		ToApplyButton.setBounds(15,450,120,20);
		ActionListenerApply alApply = new ActionListenerApply(testArea1, testArea2);
		ToApplyButton.addActionListener(alApply);
		app.add(ToApplyButton);
				
		//Button for canceling any changes suggested in the second JTextArea
		JButton ToCancelButton = new JButton("Cancel changes");
		ToCancelButton.setBounds(15,475,125,20);
		ActionListenerCancel alCAN = new ActionListenerCancel(testArea2);
		ToCancelButton.addActionListener(alCAN);
		app.add(ToCancelButton);
		
		//
		
		app.setVisible(true); //very important for this to be at the end.
		
	}
	
}
