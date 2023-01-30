package TextPad;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;



public class ViewMenu {
	int linenum ;
    int columnnum;
    
	public void statusBar(JTextArea textArea,JFrame frame,boolean var) {
		JLabel label;
		JPanel panel = new JPanel();
		if (var) {
		        // We create a try catch to catch any exceptions. We will simply ignore such an error for our demonstration.
		       try {
		            // First we find the position of the caret. This is the number of where the caret is in relation to the start of the JTextArea
		            // in the upper left corner. We use this position to find offset values (eg what line we are on for the given position as well as
		            // what position that line starts on.
		        int caretpos = textArea.getCaretPosition();
		         linenum = textArea.getLineOfOffset(caretpos);

		            // We subtract the offset of where our line starts from the overall caret position.
		            // So lets say that we are on line 5 and that line starts at caret position 100, if our caret position is currently 106
		            // we know that we must be on column 6 of line 5.
		          columnnum = caretpos - textArea.getLineStartOffset(linenum)+1;

		            // We have to add one here because line numbers start at 0 for getLineOfOffset and we want it to start at 1 for display.
		          linenum += 1;
		          
		       }
		       catch(Exception ex) { 
		    	   JOptionPane.showMessageDialog(null, ex.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
		        }

		        // Once we know the position of the line and the column, pass it to a helper function for updating the status bar.
		        //updateStatus(linenum, columnnum);
		 
			 label = new JLabel("line "+linenum+ ", col " + columnnum);
			 panel.add(label);
		     frame.add(panel,BorderLayout.PAGE_END);
		     frame.setVisible(true);
		     frame.revalidate();
		     
		}
		else 
		{
			
			
			label = new JLabel();
		    frame.add(label,BorderLayout.PAGE_END);
		    frame.setVisible(true);
		    frame.revalidate();
		     
		}

	}

}
