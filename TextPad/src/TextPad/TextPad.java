package TextPad;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


class CreateTextPad extends JFrame implements ActionListener,CaretListener
{
	JMenuBar menuBar;
	JMenu file,edit,format,view,help;
	JMenuItem newFile,openFile,saveFile,printFile,exitFile;
	JMenuItem cutEdit,copyEdit,pasteEdit,selectAllEdit;
	JCheckBoxMenuItem wordWrap;
	JMenuItem font;
	JCheckBoxMenuItem statusBar;
	JMenuItem about;
	JTextArea textArea;
	JScrollPane scrollPane;
	
	CreateTextPad() {
		Intialization();
		Intialization_fileItems();
		Intialization_editItems();
		Intialization_formatItems();
		Intialization_viewItems();
		Intialization_helpItems();
		ShowMenuBar();
		AddActionListener();
		ShowFrame();
	}

	private void AddActionListener() {
		newFile.addActionListener(this);
		openFile.addActionListener(this);
		saveFile.addActionListener(this);
		printFile.addActionListener(this);
		exitFile.addActionListener(this);
		
		cutEdit.addActionListener(this);
		copyEdit.addActionListener(this);
		pasteEdit.addActionListener(this);
		selectAllEdit.addActionListener(this);
		
		wordWrap.addActionListener(this);
		font.addActionListener(this);
		
		statusBar.addActionListener(this);
		about.addActionListener(this);
		
		textArea.addCaretListener(this);
	}

	public void ShowMenuBar() {
		file.add(newFile);
		file.add(openFile);
		file.add(saveFile);
		file.add(printFile);
		file.add(exitFile);
		
		edit.add(cutEdit);
		edit.add(copyEdit);
		edit.add(pasteEdit);
		edit.add(selectAllEdit);
		
		format.add(wordWrap);
		format.add(font);
		
		view.add(statusBar);
		
		help.add(about);
		
		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(format);
		menuBar.add(view);
		menuBar.add(help);
		
		setJMenuBar(menuBar);
	}

	private void Intialization_helpItems() {
		about = new JMenuItem("About");
		
	}
	
	private void Intialization_viewItems() {
		statusBar = new JCheckBoxMenuItem("StatusBar");
		
	}

	private void Intialization_formatItems() {
		wordWrap = new JCheckBoxMenuItem("Wrap Word");
		font = new JMenuItem("Font");
	}

	private void Intialization_editItems() {
		cutEdit = new JMenuItem("Cut");
		copyEdit = new JMenuItem("Copy");
		pasteEdit = new JMenuItem("Paste");
		selectAllEdit = new JMenuItem("Select All");
		
	}

	private void Intialization_fileItems() {
		newFile = new JMenuItem("New");
		openFile = new JMenuItem("Open");
		saveFile = new JMenuItem("Save");
		printFile = new JMenuItem("Print");
		exitFile = new JMenuItem("Exit");
		
	}

	private void Intialization() {
		menuBar = new JMenuBar();
		
		file = new JMenu("File");
		edit = new JMenu("Edit");
		format = new JMenu("Format");
		view = new JMenu("View");
		help = new JMenu("Help");
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Arial",Font.PLAIN,15));
		scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		add(scrollPane);
		
	}

	private void ShowFrame() {
		setTitle("TextPad");
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\Ahsan\\eclipse-workspace\\TextPad\\img\\notepad-icon-17545.png");
		setIconImage(icon.getImage());
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newFile){
			new FileMenu().New(textArea, e);
		}
		if(e.getSource() == openFile){
			new FileMenu().Open(textArea, e);
		}
		if(e.getSource() == saveFile){
			new FileMenu().Save(textArea, e);
		}
		if(e.getSource() == printFile){
			new FileMenu().Print(textArea, e);
		}
		if(e.getSource() == exitFile){
			new FileMenu().Exit();
		}
		if(e.getSource() == cutEdit){
			new EditMenu().Cut(textArea, e);
		}
		if(e.getSource() == copyEdit){
			new EditMenu().Copy(textArea, e);
		}
		if(e.getSource() == pasteEdit){
			new EditMenu().Paste(textArea, e);
		}
		if(e.getSource() == selectAllEdit){
			new EditMenu().SelectAll(textArea, e);
		}
		if(wordWrap.isSelected()){
			new Format().wordWrap(textArea, wordWrap.isSelected());
		}
		if(!wordWrap.isSelected()){
			new Format().wordWrap(textArea, wordWrap.isSelected());
		}
		if(e.getSource() == font) {
			new Format().Font(textArea);
		}
		if (e.getSource() == statusBar && statusBar.isSelected()) {
			if (wordWrap.isSelected()) {
				new ViewMenu().statusBar(textArea,this,!statusBar.isSelected());
			}
			else {
				new ViewMenu().statusBar(textArea,this,statusBar.isSelected());
			}
			
		}
		if (e.getSource() == statusBar && !statusBar.isSelected()) {
			new ViewMenu().statusBar(textArea,this,statusBar.isSelected());
		}
		if(e.getSource() == about) {
			new About();
		}
		
	}


	@Override
	public void caretUpdate(CaretEvent e) {
		if (statusBar.isSelected()) {
			if (wordWrap.isSelected()) {
				new ViewMenu().statusBar(textArea,this,!statusBar.isSelected());
			}
			else {
				new ViewMenu().statusBar(textArea,this,statusBar.isSelected());
			}
			
		}
		if (!statusBar.isSelected()) {
			new ViewMenu().statusBar(textArea,this,statusBar.isSelected());
		}
	}
		
}


public class TextPad {

	public static void main(String[] args) {
		new CreateTextPad();

	}

}
