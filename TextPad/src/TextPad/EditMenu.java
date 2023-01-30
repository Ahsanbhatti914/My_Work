package TextPad;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class EditMenu {

	///Toolkit toolkit = Toolkit.getDefaultToolkit();
	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	String myString = null;
	public  void Cut(JTextArea textArea,ActionEvent e)
	{

		if(!(textArea.getText().isEmpty()))
		{
			textArea.cut();	
		}
		else {
			myString="";
			JOptionPane.showMessageDialog(null, "Select text","ERROR",JOptionPane.ERROR_MESSAGE);
		}
			

	}
	public void Copy(JTextArea textArea,ActionEvent e)
	{
		
		if(!(textArea.getText().isEmpty()))
		{
			textArea.copy();
		}
		else 
		{
			myString="";
			JOptionPane.showMessageDialog(null, "Select text","ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
	public void Paste(JTextArea textArea,ActionEvent e)
	{
		try {
			
			
			//StringSelection stringSelection = new StringSelection(myString);
			//clipboard.setContents(stringSelection, null);
			myString = (String) clipboard.getData(DataFlavor.stringFlavor);
			if (!myString.isEmpty()) {
				textArea.paste();
			}
			else {
				JOptionPane.showMessageDialog(null, "No Text selected yet!!!","ERROR",JOptionPane.ERROR_MESSAGE);
			}
			
		} catch (UnsupportedFlavorException e1) {
			JOptionPane.showMessageDialog(null, "Select text is copied yet!!!","ERROR",JOptionPane.ERROR_MESSAGE);
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Select text is copied yet!!!","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
		
	}
	public void SelectAll(JTextArea textArea,ActionEvent e)
	{
		
		if(!(textArea.getText().isEmpty()))
		{
			textArea.selectAll();
		}
		else {
			myString="";
			JOptionPane.showMessageDialog(null, "TextArea is empty","ERROR",JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
