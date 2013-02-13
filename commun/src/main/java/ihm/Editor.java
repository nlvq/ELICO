package ihm;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledEditorKit;

public class Editor {

	private static final Insets margins =
			new Insets(0, 0, 0, 0);

	//default constructor
	public Editor() {
		JFrame frame = new JFrame();
		JTextPane textPane = new JTextPane();
		JScrollPane scrollPane = new JScrollPane(textPane);

		JPanel north = new JPanel();

		JMenuBar menu = new JMenuBar();
		JMenu styleMenu = new JMenu();
		styleMenu.setText("Style");

		JToolBar bar = new JToolBar();

		// create a set of actions to use in both the menu and toolbar
		Action saveAction = new SaveAction();
		saveAction.putValue(Action.NAME, "Save");
		styleMenu.add(saveAction);
		bar.add(saveAction);

		Action openAction = new OpenAction();
		openAction.putValue(Action.NAME, "Open");
		styleMenu.add(openAction);
		bar.add(openAction);

		Action boldAction = new BoldAction();
		boldAction.putValue(Action.NAME, "Bold");
		styleMenu.add(boldAction);
		bar.add(boldAction);

		Action italicAction = new ItalicAction();
		italicAction.putValue(Action.NAME, "Italic");
		styleMenu.add(italicAction);
		bar.add(italicAction);

		Action underlineAction = new UnderlineAction();
		underlineAction.putValue(Action.NAME, "Underline");
		styleMenu.add(underlineAction);
		bar.add(underlineAction);

		menu.add(styleMenu);

		bar.setMargin(margins);

		// positions of components
		north.add(bar);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setJMenuBar(menu);
		frame.getContentPane().add(north, BorderLayout.NORTH);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

// minimal set of actions for editing styled text

//set text to bold


class BoldAction extends StyledEditorKit.StyledTextAction {

	private static final long serialVersionUID = -5477025095665411371L;

	public BoldAction() {
		super("font-bold");
	}

	public String toString() {
		return "Bold";
	}

	// invoked when "Bold" button is clicked
	public void actionPerformed(ActionEvent e) {
		JEditorPane editor = getEditor(e);
		if (editor != null) {
			StyledEditorKit kit = getStyledEditorKit(editor);
			MutableAttributeSet attr = kit.getInputAttributes();
			boolean bold = (StyleConstants.isBold(attr)) ? false : true;
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setBold(sas, bold);
			setCharacterAttributes(editor, sas, false);

		}
	}
}


//set text to italic
class ItalicAction extends StyledEditorKit.StyledTextAction {

	private static final long serialVersionUID = 7772556629062470869L;

	public ItalicAction() {
		super("font-italic");
	}

	public String toString() {
		return "Italic";
	}

	// invoked when "Italic" button is clicked
	public void actionPerformed(ActionEvent e) {
		JEditorPane editor = getEditor(e);
		if (editor != null) {
			StyledEditorKit kit = getStyledEditorKit(editor);
			MutableAttributeSet attr = kit.getInputAttributes();
			boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setItalic(sas, italic);
			setCharacterAttributes(editor, sas, false);
		}
	}
}

//set text to underlined
class UnderlineAction extends StyledEditorKit.StyledTextAction {

	private static final long serialVersionUID = -6228768835751837002L;

	public UnderlineAction() {
		super("font-underline");
	}

	public String toString() {
		return "Underline";
	}


	// invoked when "Underline" button is clicked
	public void actionPerformed(ActionEvent e) {
		JEditorPane editor = getEditor(e);
		if (editor != null) {
			StyledEditorKit kit = getStyledEditorKit(editor);
			MutableAttributeSet attr = kit.getInputAttributes();
			boolean underline = (StyleConstants.isUnderline(attr)) ? false : true;
			SimpleAttributeSet sas = new SimpleAttributeSet();
			StyleConstants.setUnderline(sas, underline);
			setCharacterAttributes(editor, sas, false);
		}
	}
}

class SaveAction extends StyledEditorKit.StyledTextAction {

	private static final long serialVersionUID = -6228768835751837002L;

	public SaveAction() {
		super("Save");
	}

	public String toString() {
		return "Save";
	}


	// invoked when "Underline" button is clicked
	public void actionPerformed(ActionEvent e) {
		// To Do
	}
}

class OpenAction extends StyledEditorKit.StyledTextAction {

	private static final long serialVersionUID = -6228768835751837002L;

	public OpenAction() {
		super("Open");
	}

	public String toString() {
		return "Open";
	}


	// invoked when "Underline" button is clicked
	public void actionPerformed(ActionEvent e) {
		// To Do
	}
}