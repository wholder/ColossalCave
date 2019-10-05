import javax.swing.*;import javax.swing.text.BadLocationException;import javax.swing.text.DefaultCaret;import javax.swing.text.Document;import java.awt.*;import java.io.*;/** *  This class implments a scrolling text area display that tries to emulate the look of a teleprinter *  that uses colored, pin feed paper. * * @author Wayne Holder 2019 */class Teleprinter extends JTextArea implements Runnable {	private static final Color 	lGreen = new Color(194, 255, 239);	private static final Color	dGreen = new Color(70, 196, 162);	private	final PipedWriter		output = new PipedWriter();	private	final PipedReader 	input  = new PipedReader(output);	private	final PrintWriter		print = new PrintWriter(output);	private	Document 						doc;	Teleprinter () throws IOException {		doc = getDocument();		setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));		setOpaque(false);		DefaultCaret caret = (DefaultCaret) getCaret();		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);		setEditable(false);		setLineWrap(true);		setWrapStyleWord(true);		(new Thread(this)).start();	}	@Override	public void paintComponent (Graphics g) {		Font font = getFont();		FontMetrics fontMetrics = getFontMetrics(font);		int fontHeight = fontMetrics.getHeight();		int lineCount;		try {			int height = modelToView(getDocument().getEndPosition().getOffset() - 1).y;			lineCount = height / fontHeight + 1;		} catch (BadLocationException e) {			lineCount = 0;		}		Rectangle clip = g.getClipBounds();		int rowHeight = getRowHeight();		Insets insets = getInsets();		Rectangle rect = new Rectangle(0, insets.top, clip.width, rowHeight * 2);		for (int ii = 0; ii < lineCount + 1; ii += 4) {			g.setColor(lGreen);			g.fillRect(rect.x, rect.y, rect.width, rect.height);			g.setColor(dGreen);			g.fillRect(rect.x, rect.y, rect.width, 1);			rect.y += rect.height;			g.fillRect(rect.x, rect.y - 1, rect.width, 1);			rect.y += rect.height;		}		super.paintComponent(g);	}	@Override	public void setRows (int rows) {		super.setRows(rows);		for (int ii = 0; ii < rows; ii++) {			try {				doc.insertString(doc.getLength(), "\n", null);			} catch (Exception ex) {				ex.printStackTrace();			}		}	}	public void run () {		while (true) {			try {				Thread.sleep(2);				if (input.ready()) {					char cc = (char) input.read();					doc.insertString(doc.getLength(), Character.toString(cc), null);					setCaretPosition(getDocument().getLength());				}			} catch (Exception ex) {				ex.printStackTrace();			}		}	}	void appendText (String line) {		print.print(line);	}}