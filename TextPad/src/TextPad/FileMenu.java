package TextPad;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.layout.element.Text;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.io.font.*;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;





public class FileMenu {

	public void New(JTextArea textArea,ActionEvent e) {
		JOptionPane optionPane = new JOptionPane();
		
		int var = JOptionPane.showConfirmDialog(null, "Do you want to save changes?","CONFIRMATION",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(var == JOptionPane.YES_OPTION)
		{
			Save(textArea, e);
		}
		else if(var == JOptionPane.NO_OPTION)
		{
			textArea.setText(null);
		}
	}
	
	public void Open(JTextArea textArea,ActionEvent e) {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(true);
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Only(.txt)","txt");
		//fileChooser.addChoosableFileFilter(filter);
		
		int action = fileChooser.showOpenDialog(null);
		if(action == fileChooser.APPROVE_OPTION)
		{
			try {
					BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
					textArea.read(reader,null);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}	
		}
		else {
			return;
		}
	}
	
	public void Save(JTextArea textArea,ActionEvent e) {
		
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(true);
		//FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Only(.txt)","txt");
		//fileChooser.addChoosableFileFilter(filter);
		
		int action = fileChooser.showSaveDialog(null);
		if(action == fileChooser.APPROVE_OPTION)
		{
			String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
			if (fileName.contains(".")) {
				
				try {
					String subStr = fileName.substring(fileName.lastIndexOf(".") + 1);
					String exe = "."+subStr;
					String newFileName = fileName.replace(exe,"");
					newFileName = newFileName + exe;
					System.out.println(newFileName);
					BufferedWriter writer = new BufferedWriter(new FileWriter(newFileName));
					textArea.write(writer);
					JOptionPane.showMessageDialog(null, "File saved","Sucessfully Generated",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			else 
			{
				
				fileName = fileName + ".txt";
				
				try {
					BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
					textArea.write(writer);
					JOptionPane.showMessageDialog(null, "File saved","Sucessfully Generated",JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		else 
		{
			return;
		}
	}
	
	public void Print(JTextArea textArea,ActionEvent e) 
	{
		try {
			
			int var = JOptionPane.showConfirmDialog(null, "<html>Do you want to generate PDf? press YES<br> Print text file? press No<html>","CONFIRMATION",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			
			if(var == JOptionPane.YES_OPTION)
			{
				if(generatePDF(textArea))
				{
					JOptionPane.showMessageDialog(null, "PDF generated","Sucessfully Generated",JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "PDF not generated sucessfully","ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
			else if(var == JOptionPane.NO_OPTION)
			{
				try {
					textArea.print();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
				}
			}
		} 
		catch (Exception e2) 
		{
			JOptionPane.showMessageDialog(null, e2.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
		}
	}
		

		
		
	
	public boolean generatePDF(JTextArea textArea) throws IOException, DocumentException {
		
		
		try {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setAcceptAllFileFilterUsed(false);
			FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF only(.pdf)","pdf");
			fileChooser.addChoosableFileFilter(filter);
			
			int action = fileChooser.showSaveDialog(null);
			if(action == fileChooser.APPROVE_OPTION)
			{
				Document document = new Document();
				String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
				if (!fileName.contains(".pdf")) 
				{
					fileName = fileName + ".pdf";
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
					document.open();
					
					if(textArea.getText() == null || textArea.getText().equals(""))
					{
						document.add(new Paragraph(" "));
					}
					else {
						
						document.add(new Paragraph(textArea.getText()));
						
					}
					document.close();
					writer.close();
					
				}
				else {
					PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName));
					document.open();
					
					if(textArea.getText() == null || textArea.getText().equals(""))
					{
						document.add(new Paragraph(" "));
					}
					else {
						
						document.add(new Paragraph(textArea.getText()));
						
					}
					document.close();
					writer.close();
				}
				return true;
			}
			else {
				return false;
			}
			
			
		}
		catch(DocumentException e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);
			return false;
		}
		catch(FileNotFoundException e)
		{
			JOptionPane.showMessageDialog(null, e.toString(),"ERROR",JOptionPane.ERROR_MESSAGE);

			return false;
		}
	}

	public  void Exit() {
		System.exit(0);
	}

}
