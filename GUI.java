package standaard;


import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;


public class GUI implements ActionListener{
	
	
	
	JFrame window;
	
	// TEXT AREA
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	
	//GRAPHIC LABEL
	JLabel label;
	ImageIcon ii = null;
	
	//TOP MENU BAR
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	
	//FILE MENU
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	
	//EDIT MENU
	JMenuItem iUndo, iRedo;
	
	//FORMAT MENU
	JMenuItem iWrap, iFontArial, iFontTMR, iFontImpact, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
	
	//COLOR MENU
	JMenuItem iColor1, iColor2, iColor3, iColor4;
	
	Function_File file = new Function_File(this);
	Function_Format format = new Function_Format(this);
	Function_Color color = new Function_Color(this);
	Function_Edit edit = new Function_Edit(this);
	
	UndoManager um = new UndoManager();
	


	public static void main(String[] args) {
		
		new GUI();

	}
	public GUI() {
		
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		
		
		format.selectedFont = "Arial";
		format.creatFont(16);
		format.wordWrap();
		color.changeColor("White") ;
		
		window.setVisible(true);
		
		
	}
	
	public void createWindow() {
		
		window = new JFrame("Notepad Air");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
        // Create a new frame

        
        // Create an image instance from the image that you want to use as icon for your app.
        Image icon = Toolkit.getDefaultToolkit().getImage(".\\images\\nairlogoNEW.png");  
        window.setIconImage(icon);
		
//		ImageIcon logo = new ImageIcon(getClass().getClassLoader().getResource("nairlogo.png"));
//		window.setIconImage(logo.getImage());
	}
	public void createTextArea() {
		
		textArea = new JTextArea();
		textArea.getDocument().addUndoableEditListener(
				new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		

		
		scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
//		window.add(textArea);
		
	}
	public void createMenuBar() {
		
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
	}
	
	public void createFileMenu() {
		
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		menuFile.add(iNew);
		
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		menuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		menuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("Save As");
		menuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		menuFile.add(iExit);
	}
	
	public void createEditMenu() {
		
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		menuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		menuEdit.add(iRedo);
	}
	
	public void createFormatMenu() {
		
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		menuFormat.add(iWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial"); 
		menuFont.add(iFontArial);
		
		iFontTMR = new JMenuItem("Times New Roman");
		iFontTMR.addActionListener(this);
		iFontTMR.setActionCommand("Times New Roman"); 
		menuFont.add(iFontTMR);
		
		iFontImpact = new JMenuItem("Impact");
		iFontImpact.addActionListener(this);
		iFontImpact.setActionCommand("Impact"); 
		menuFont.add(iFontImpact);
		
		menuFontSize = new JMenu("Font Size");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("size8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("size12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("size16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("size20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("size24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("size28");
		menuFontSize.add(iFontSize28);
		
	}
	
	public void createColorMenu() {
		
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		menuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		menuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Gray");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Gray");
		menuColor.add(iColor3);
		
		iColor4 = new JMenuItem("Terminal");
		iColor4.addActionListener(this);
		iColor4.setActionCommand("Terminal");
		menuColor.add(iColor4);
		
	}
	

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command = e.getActionCommand();		
		
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "Save": file.save(); break;
		case "Save As": file.saveAs(); break;
		case "Exit": file.exit(); break;
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		case "Word Wrap": format.wordWrap(); break;
		case "Arial": format.setFont(command); break; // u can also use "Arial" in the command section
		case "Times New Roman": format.setFont(command); break; // u can also use "Times New Roman" in the command section 
		case "Impact": format.setFont(command); break; // u can also use "Impact" in the comman section
		case "size8": format.creatFont(8); break;
		case "size12": format.creatFont(12); break;
		case "size16": format.creatFont(16); break;
		case "size20": format.creatFont(20); break;
		case "size24": format.creatFont(24); break;
		case "size28": format.creatFont(28); break;
		case "White": color.changeColor(command); break;
		case "Black" : color.changeColor(command); break;
		case "Gray" : color.changeColor(command); break;
		case "Terminal": color.changeColor(command); break;
		}
		

			
		
	}
	

}
