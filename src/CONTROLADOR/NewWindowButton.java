package CONTROLADOR;
import VISTA.SegundaVentana;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class NewWindowButton extends JFrame implements ActionListener{

	private boolean open = false;
	
	public void setOpen(boolean state) {
		this.open=state;
	}
	
	
	@Override //I try to invoke the singleton object
	public void actionPerformed(ActionEvent e) {
		
		try {
			SegundaVentana sv = SegundaVentana.getInstance();
			if(sv != null) {
				sv.action(this.open);
			}	
		}catch(Exception e1) {
			JOptionPane.showMessageDialog(null, "Error");
		}
		
	}
	
}
