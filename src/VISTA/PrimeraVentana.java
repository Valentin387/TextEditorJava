package VISTA;
import javax.swing.JButton;
import javax.swing.JFrame;

import CONTROLADOR.NewWindowButton;

public class PrimeraVentana {


	public void action() {
		
		//I create the frame
		JFrame first_app = new JFrame("Primera Ventana");
		first_app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		first_app.setSize(400, 300);
		first_app.setLayout(null);
		first_app.setResizable(false);

		//button for creating a NewWindow only once
		JButton  nuevaVentanaButton = new JButton("Open Text-Editor");
		NewWindowButton ntb = new NewWindowButton();
		ntb.setOpen(false);
		
		nuevaVentanaButton.addActionListener(ntb);	
		nuevaVentanaButton.setBounds(120,40,150,40);
		first_app.add(nuevaVentanaButton);
		
		//button for opening the "texto.txt" in disc the first time
		JButton OpenTextoButton = new JButton("Open File");
		NewWindowButton opn = new NewWindowButton();
		opn.setOpen(true);
		
		OpenTextoButton.addActionListener(opn);		
		OpenTextoButton.setBounds(120,120,150,40);
		first_app.add(OpenTextoButton);
		
	
		first_app.setVisible(true);
		
	}
	
}


