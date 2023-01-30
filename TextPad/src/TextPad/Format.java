package TextPad;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.itextpdf.layout.element.Text;
import com.ozten.font.JFontChooser;



public class Format extends JFrame implements ActionListener{

	static JFontChooser fontChooser = new JFontChooser();;
	JLabel fontLabel,fontStyleLabel,fontSizeLabel,sampleLabel,textLabel;
	JTextField fontTextField,fontStyleField,fontSizeField;
	JComboBox<String> fontBox,fontStyleBox,fontSizeBox;
	JTextArea sampleTextArea,textArea;
	String fontList [] = {"Abadi MT",
			"Minion Web",
			"Agency FB",
			"Aharoni Bold",
			"Aldhabi",
			"Algerian",
			"Almanac MT",
			"American Uncial",
			"Andale Mono",
			"Andalus",
			"Andy",
			"AngsanaUPC",
			"Angsana New",
			"Aparajita",
			"Arabic Transparent",
			"Arabic Typesetting",
			"Arial",
			"Arial Black",
			"Arial Narrow",
			"Arial Narrow Special",
			"Arial Rounded MT",
			"Arial Special",
			"Arial Unicode MS",
			"Augsburger Initials",
			"Avenir Next LT Pro",
			"Bahnschrift",
			"Baskerville Old Face",
			"Batang & BatangChe",
			"Bauhaus 93",
			"Beesknees ITC",
			"Bell MT",
			"Bembo",
			"Berlin Sans FB",
			"Bernard MT Condensed",
			"Bickley Script",
			"Biome",
			"BIZ UDGothic",
			"BIZ UDMincho Medium",
			"Blackadder ITC",
			"Bodoni MT",
			"Bodoni MT Condensed",
			"Bon Apetit MT",
			"Bookman Old Style",
			"Bookshelf Symbol",
			"Book Antiqua",
			"Bradley Hand ITC",
			"Braggadocio",
			"BriemScript",
			"Britannic Bold",
			"Broadway",
			"BrowalliaUPC",
			"Browallia New",
			"Brush Script MT",
			"Calibri",
			"Californian FB",
			"Calisto MT",
			"Cambria",
			"Cambria Math",
			"Candara",
			"Cariadings",
			"Castellar",
			"Cavolini",
			"Centaur",
			"Century",
			"Century Gothic",
			"Century Schoolbook",
			"Chiller",
			"Colonna MT",
			"Comic Sans MS",
			"Consolas",
			"Constantia",
			"Contemporary Brush",
			"Cooper Black",
			"Copperplate Gothic",
			"Corbel",
			"CordiaUPC",
			"Cordia New",
			"Courier New",
			"Curlz MT",
			"Dante",
			"DaunPenh",
			"David",
			"Daytona",
			"Desdemona",
			"DFKai-SB",
			"DilleniaUPC",
			"Directions MT",
			"DokChampa",
			"Dotum & DotumChe",
			"Ebrima",
			"Eckmann",
			"Edda",
			"Edwardian Script ITC",
			"Elephant",
			"Engravers MT",
			"Enviro",
			"Eras ITC",
			"Estrangelo Edessa",
			"EucrosiaUPC",
			"Euphemia",
			"Eurostile",
			"FangSong",
			"Felix Titling",
			"Fine Hand",
			"Fixed Miriam Transparent",
			"Flexure",
			"Footlight MT",
			"Forte",
			"Franklin Gothic",
			"Franklin Gothic Medium",
			"FrankRuehl",
			"FreesiaUPC",
			"Freestyle Script",
			"French Script MT",
			"Futura",
			"Gabriola",
			"Gadugi",
			"Garamond",
			"Garamond MT",
			"Gautami",
			"Georgia",
			"Georgia Ref",
			"Gigi",
			"Gill Sans MT",
			"Gill Sans MT Condensed",
			"Gisha",
			"Gloucester",
			"Goudy Old Style",
			"Goudy Stout",
			"Gradl",
			"Grotesque",
			"Gulim & GulimChe",
			"Gungsuh & GungsuhChe",
			"Hadassah Friedlaender",
			"Haettenschweiler",
			"Harlow Solid Italic",
			"Harrington",
			"HGGothicE",
			"HGMinchoE",
			"HGSoeiKakugothicUB",
			"High Tower Text",
			"Holidays MT",
			"HoloLens MDL2 Assets",
			"Impact",
			"Imprint MT Shadow",
			"Informal Roman",
			"IrisUPC",
			"Iskoola Pota",
			"JasmineUPC",
			"Javanese Text",
			"Jokerman",
			"Juice ITC",
			"KaiTi",
			"Kalinga",
			"Kartika",
			"Keystrokes MT",
			"Khmer UI",
			"Kigelia",
			"Kino MT",
			"KodchiangUPC",
			"Kokila",
			"Kristen ITC",
			"Kunstler Script",
			"Lao UI",
			"Latha",
			"LCD",
			"Leelawadee",
			"Levenim MT",
			"LilyUPC",
			"Lucida Blackletter",
			"Lucida Bright",
			"Lucida Bright Math",
			"Lucida Calligraphy",
			"Lucida Console",
			"Lucida Fax",
			"Lucida Handwriting",
			"Lucida Sans",
			"Lucida Sans Typewriter",
			"Lucida Sans Unicode",
			"Magneto",
			"Maiandra GD",
			"Malgun Gothic",
			"Mangal",
			"Map Symbols",
			"Marlett",
			"Matisse ITC",
			"Matura MT Script Capitals",
			"McZee",
			"Mead Bold",
			"Meiryo",
			"Mercurius Script MT Bold",
			"Microsoft GothicNeo",
			"Microsoft Himalaya",
			"Microsoft JhengHei",
			"Microsoft JhengHei UI",
			"Microsoft New Tai Lue",
			"Microsoft PhagsPa",
			"Microsoft Sans Serif",
			"Microsoft Tai Le",
			"Microsoft Uighur",
			"Microsoft YaHei",
			"Microsoft YaHei UI",
			"Microsoft Yi Baiti",
			"MingLiU",
			"MingLiU-ExtB",
			"MingLiU_HKSCS",
			"MingLiU_HKSCS-ExtB",
			"Minion Web",
			"Miriam",
			"Miriam Fixed",
			"Mistral",
			"Modern Love",
			"Modern No. 20",
			"Mongolian Baiti",
			"Monotype.com",
			"Monotype Corsiva",
			"Monotype Sorts",
			"MoolBoran",
			"MS Gothic",
			"MS LineDraw",
			"MS Mincho",
			"MS Outlook",
			"MS PGothic",
			"MS PMincho",
			"MS Reference",
			"MS UI Gothic",
			"MT Extra",
			"MV Boli",
			"Myanmar Text",
			"Narkisim",
			"News Gothic MT",
			"New Caledonia",
			"Niagara",
			"Nirmala UI",
			"Nyala",
			"OCR-B-Digits",
			"OCRB",
			"OCR A Extended",
			"Old English Text MT",
			"Onyx",
			"Palace Script MT",
			"Palatino Linotype",
			"Papyrus",
			"Parade",
			"Parchment",
			"Parties MT",
			"Peignot Medium",
			"Pepita MT",
			"Perpetua",
			"Perpetua Titling MT",
			"Placard Condensed",
			"Plantagenet Cherokee",
			"Playbill",
			"PMingLiU",
			"PMingLiU-ExtB",
			"Poor Richard",
			"Posterama",
			"Pristina",
			"Quire Sans",
			"Raavi",
			"Rage Italic",
			"Ransom",
			"Ravie",
			"RefSpecialty",
			"Rockwell",
			"Rockwell Nova",
			"Rod",
			"Runic MT Condensed",
			"Sabon Next LT",
			"Sagona",
			"Sakkal Majalla",
			"san serif",
			"Script MT Bold",
			"Segoe Chess",
			"Segoe Print",
			"Segoe Script",
			"Segoe UI",
			"Segoe UI Symbol",
			"Selawik",
			"Shonar Bangla",
			"Showcard Gothic",
			"Shruti",
			"Signs MT",
			"SimHei",
			"Simplified Arabic Fixed",
			"SimSun",
			"SimSun-ExtB",
			"Sitka",
			"NSimSun",
			"Snap ITC",
			"Sports MT",
			"STCaiyun",
			"Stencil",
			"STFangsong",
			"STHupo",
			"STKaiti",
			"Stop",
			"STXihei",
			"STXingkai",
			"STXinwei",
			"STZhongsong",
			"Sylfaen",
			"Symbol",
			"Tahoma",
			"Tempo Grunge",
			"Tempus Sans ITC",
			"Temp Installer Font",
			"The Hand",
			"The Serif Hand",
			"Times New Roman",
			"Times New Roman Special",
			"Tisa Offc Serif Pro",
			"Traditional Arabic",
			"Transport MT",
			"Trebuchet MS",
			"Tunga",
			"Tw Cen MT",
			"Univers",
			"Urdu Typesetting",
			"Utsaah",
			"Vacation MT",
			"Vani",
			"Verdana",
			"Verdana Ref",
			"Vijaya",
			"Viner Hand ITC",
			"Vivaldi",
			"Vixar ASCI",
			"Vladimir Script",
			"Vrinda",
			"Walbaum",
			"Webdings",
			"Westminster",
			"Wide Latin",
			"Wingdings"
			};
	String fontStyleList [] = {"PLAIN","BOLD","ITALIC"};	
	String fontSizeList [] = {"8", "9", "10", "11", "12", "14", "16", "18", "20",
	        "22", "24", "26", "28", "36", "48", "72"};
	
	JButton ok,cancel;
	public void wordWrap(JTextArea textArea , boolean var) {
		if(var)
		{
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);//word will be shifted to new line if there is no place for it
		}
		else {
			textArea.setLineWrap(false);
			textArea.setWrapStyleWord(false);
		}
	}
	
	public void Font(JTextArea textArea) 
	{
		this.textArea = textArea;
		//comboBox_Initialization();
		//textField_Initialization();
		//lable_Initialization();
		//textArea_Initialization();
		//button_Initialization();
		//addComponents();
		//showFrame();
		fontchooser();
		//addActionListener();
	}



	private void fontchooser() {
		
		JOptionPane.showMessageDialog(null, fontChooser,"Select Font",JOptionPane.PLAIN_MESSAGE);
		textArea.setFont(fontChooser.getPreviewFont());
	}

	private void button_Initialization() {
		ok = new JButton("Apply");
		cancel = new JButton("Cancel");
		
	}

	private void addActionListener() {
		fontBox.addActionListener(this);
		fontStyleBox.addActionListener(this);
		fontSizeBox.addActionListener(this);
		
		ok.addActionListener(this);
		cancel.addActionListener(this);
		
	}

	private void addComponents() {
		Container container = getContentPane();
		textLabel.setBounds(150,30,300,30);
		textLabel.setFont(new Font("Arial",Font.BOLD,22));
		container.add(textLabel);
		
		fontLabel.setBounds(90, 80, 70, 20);
		fontTextField.setBounds(90,100,100,25);
		//fontTextField.setFont(new Font("Arial",Font.BOLD,12));
		fontBox.setBounds(90,130,100,30);
		container.add(fontLabel);
		container.add(fontTextField);
		container.add(fontBox);
		
		fontStyleLabel.setBounds(200, 80, 70, 20);
		fontStyleField.setBounds(200,100,100,25);
		fontTextField.setFont(new Font("Arial",Font.BOLD,12));
		fontStyleBox.setBounds(200,130,100,30);
		container.add(fontStyleLabel);
		container.add(fontStyleField);
		container.add(fontStyleBox);
		
		fontSizeLabel.setBounds(320, 800, 70, 20);
		fontSizeField.setBounds(320,100,100,25);
		fontSizeBox.setBounds(320,130,100,30);
		container.add(fontSizeLabel);
		container.add(fontSizeField);
		container.add(fontSizeBox);
		
		sampleLabel.setBounds(200,200,100,30);
		container.add(sampleLabel);
		
		sampleTextArea.setBounds(200,240,220,100);
		container.add(sampleTextArea);
		
		ok.setBounds(320, 360, 80, 30);
		container.add(ok);
		
		cancel.setBounds(410, 360, 80, 30);
		container.add(cancel);
	}

	private void textArea_Initialization() {
		sampleTextArea = new JTextArea("ABCDEabcde");
		sampleTextArea.setEditable(false);
		sampleTextArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	private void comboBox_Initialization() {
		fontBox = new JComboBox<String>(fontList);
		fontBox.setSelectedItem("Arial");
		fontStyleBox = new JComboBox<String>(fontStyleList);
		fontStyleBox.setSelectedIndex(0);
		fontSizeBox = new JComboBox<String>(fontSizeList);
		fontSizeBox.setSelectedItem(0);
		
	}

	private void textField_Initialization() {
		fontTextField = new JTextField();
		fontTextField.setText(fontBox.getSelectedItem().toString());
		fontStyleField = new JTextField();
		fontStyleField.setText(String.valueOf(fontStyleBox.getSelectedItem().toString()));
		fontSizeField = new JTextField();
		fontSizeField.setText(String.valueOf(fontSizeBox.getSelectedItem().toString()));
	}

	private void lable_Initialization() {
		fontLabel = new JLabel("Font");
		fontStyleLabel = new JLabel("Font Style");
		fontSizeLabel = new JLabel("Font Size");
		sampleLabel = new JLabel("Sample");
		textLabel = new JLabel("Choose Your Font");
	}

	private void showFrame() {
		setTitle("Font");
		setSize(550,450);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		ImageIcon icon = new ImageIcon("C:\\Users\\Ahsan\\eclipse-workspace\\TextPad\\img\\notepad-icon-17545.png");
		setIconImage(icon.getImage());
		setLayout(null);
		setResizable(false);
		setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		fontTextField.setText(fontBox.getSelectedItem().toString());
		fontStyleField.setText(String.valueOf(fontStyleBox.getSelectedItem().toString()));
		fontSizeField.setText(String.valueOf(fontSizeBox.getSelectedItem().toString()));
		
		String font =  fontTextField.getText();
		String fontstyle =  fontStyleField.getText();
		int fontsize = Integer.parseInt(fontSizeField.getText());
		
		Font myfont = new Font("Arial",Font.PLAIN,8);
		
		if (fontstyle.equals("PLAIN")) {
			myfont = new Font(font, Font.PLAIN, fontsize);
			sampleTextArea.setFont(myfont);
			
			fontBox.setSelectedItem(font);
			fontStyleBox.setSelectedItem(fontstyle);
			fontSizeBox.setSelectedItem(fontsize);
		}
		else if (fontstyle.equals("BOLD")) {
			myfont = new Font(font, Font.BOLD, fontsize);
			sampleTextArea.setFont(myfont);
			
			fontBox.setSelectedItem(font);
			fontStyleBox.setSelectedItem(fontstyle);
			fontSizeBox.setSelectedItem(fontsize);
		}
		else if (fontstyle.equals("ITALIC")) {
			myfont = new Font(font, Font.ITALIC, fontsize);
			sampleTextArea.setFont(myfont);
			
			fontBox.setSelectedItem(font);
			fontStyleBox.setSelectedItem(fontstyle);
			fontSizeBox.setSelectedItem(fontsize);
		}
		
		if(e.getSource() == ok)
		{
			textArea.setFont(myfont);
			setVisible(false);
		}
		else if (e.getSource() == cancel) 
		{
			setVisible(false);
		}
		
	}


	
	
}
