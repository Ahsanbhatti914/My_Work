package TextPad;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class About extends JFrame {
	public About() {
		ShowFrame();
	}
	
	private void ShowFrame() {
		setTitle("About TextPad");
		setSize(800,600);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		ImageIcon icon = new ImageIcon("C:\\Users\\Ahsan\\eclipse-workspace\\TextPad\\img\\notepad-icon-17545.png");
		setIconImage(icon.getImage());
		
		JLabel label = new JLabel(new ImageIcon("C:\\Users\\Ahsan\\eclipse-workspace\\TextPad\\img\\icon.png"));
		label.setBounds(150, 100, 100, 100);
		add(label);
		
		JLabel text = new JLabel("<html>"
				+"Lorem Ipsum is simply dummy text of the printing and typesetting industry.<br>"
				+"Lorem Ipsum has been the industry's standard dummy text ever since the 1500s<br>"
				+"when an unknown printer took a galley of type and scrambled it to make a type specimen book.<br>"
				+"Lorem Ipsum is simply dummy text of the printing and typesetting industry.<br>"
				+"Lorem Ipsum has been the industry's standard dummy text ever since the 1500s<br>"
				+"when an unknown printer took a galley of type and scrambled it to make a type specimen book.<br>"
				+"It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
				+ "</html>");
		text.setBounds(150, 180, 500, 300);
		text.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,13));
		add(text);
		
		setVisible(true);
	}
}
