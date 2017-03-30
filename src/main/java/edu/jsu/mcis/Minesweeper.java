package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


/**
 * This class represents a graphical view of the Minesweeper grid. It
 * has a two-dimensional array of JLabels for the locations, a Ticker
 * object for the count-up timer, and a JLabel to display the current
 * available flags.
 *
 * It implements the MouseListener to apply to each label in the grid
 * so that right-clicking places flags and left-clicking uncovers the
 * location. It also implements the Observer interface so that it can
 * be an observer of the grid. This means it receives the messages 
 * produced by the grid. Those messages are as follows:
 *     row:col:mine
 *     row:col:flag
 *     row:col:unflag
 *     row:col:<hint> (where <hint> is an integer)
 * The main updating of the interface should be done in response to
 * those messages.
 */
public class Minesweeper extends JPanel implements MouseListener, Observer {
    /**
     * These constants can be used as the icons on labels.
     */
    private final ImageIcon FLAG_ICON = new ImageIcon(getClass().getClassLoader().getResource("flag.png"));
    private final ImageIcon MINE_ICON = new ImageIcon(getClass().getClassLoader().getResource("mine.png"));
    
    private Grid grid;
    private int flags;
    private JLabel[][] tile;
    private JLabel flagLabel;
    private Ticker ticker;
    private boolean enabled;
        
    /**
     * This constructor should create a new 8-by-8 board with 10 mines.
     */
    public Minesweeper() {
		this(8,8,10);
    }
    
    /**
     * This constructor creates a new board of the specified size and
     * mines. The number of initial flags should be the same as the 
     * number of mines. The labels (if covered) should have raised
     * bevel borders and should be size 50-by-50. Ideally, the layout
     * of the interface should look something like the following:
     *
     *     --------------------------------------
     *     |  Flags [ 8 ]       Time [ 00:27 ]  |
     *     |                                    |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |   |   |   |   | 1 |///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |   |   |   | 1 | 2 |///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |   |   |   | 1 | % |///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |   | 1 | 1 | 2 |///|///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |   | 1 | % |///|///|///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | | 1 | 2 |///|///|///|///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |///|///|///|///|///|///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     | |///|///|///|///|///|///|///|///|  |
     *     |  --- --- --- --- --- --- --- ---   |
     *     |                                    |
     *     --------------------------------------
     *
     * Each of the `tile` labels should have their names set
     * to "cell:i:j" where `i` is the row and `j` is the 
     * column. For instance, the 1 in the top row of the 
     * diagram would have the name of "cell:0:4".
     * 
     * The `flagLabel` should have its name set to "flags".
     * 
     * The `enabled` class variable should be initialized
     * to true.
     * 
     * @param width 
     * @param height 
     * @param mines 
     */
    public Minesweeper(int width, int height, int mines) {
		grid = new Grid(width, height, mines);
		grid.addObserver(this);
		tile = new JLabel[height][width];
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,5));
		panel.add(new JLabel("flags"));
		flags = mines;
		flagLabel = new JLabel(""+flags);
		panel.add(flagLabel);
		flagLabel.setName("flags");
		ticker = new Ticker();
		panel.add(ticker);
		ticker.setName("ticker");
		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(height, width));
				
		for(int i = 0; i < height; i++){
			for(int j = 0; j < width; j++){
				tile[i][j] = new JLabel();
				tile[i][j].setPreferredSize(new Dimension(50, 50));
				tile[i][j].setHorizontalAlignment(0);
				tile[i][j].setName("cell:" + i + ":" + j); 
				tile[i][j].setBorder(BorderFactory.createRaisedBevelBorder());
				add(tile[i][j]);
				tile[i][j].addMouseListener(this);
				gridPanel.add(tile[i][j]);
			}
		}
		enabled = true;
		setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(gridPanel, BorderLayout.CENTER);
		enabled = true;
		//Add the flag label with the number of flags
		//flagLabel = new JLabel();
		//flagLabel.setText(String.valueOf(flags));
		//flagLabel.setName("flags");
		//add(flagLabel);
		
		
		
		
		

    }
    
    /**
     * This method should interpret the message from the grid.
     *     String message = (String)arg;
     * It should accomplish this by splitting the message at the 
     * colon delimiters. Depending on the message, the interface 
     * should be updated.
     * 
     * The tooltip text should be updated on the cells to reflect
     * their current state (uncovered, covered, flagged, or mine).
     * 
     * @param o the observable (Grid object)
     * @param arg (the message, which is actually a String)
     */
    public void update(Observable o, Object arg) {
		String s = (String)arg;
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter(":");
		int row = scanner.nextInt();
		int col = scanner.nextInt();
		String info = scanner.next();
		
		if(info.equals("flag")) {
			tile[row][col].setToolTipText("flagged");
			tile[row][col].setIcon(FLAG_ICON);
			this.flagLabel.setText(""+flags);
		}
		else if(info.equals("unflag")) {
			tile[row][col].setToolTipText("uncovered");
			tile[row][col].setIcon(null);
			this.flagLabel.setText(""+flags);
		}
		else if(info.equals("mine")) {
			tile[row][col].setIcon(MINE_ICON);
		}
		else {
			tile[row][col].setToolTipText("covered");
			tile[row][col].setText(info);
		}
		tile[row][col].repaint();
		
    }
    
    /**
     * This method shoud handle the left- and right-clicks on the
     * labels. Remember that the very first time that a label is 
     * clicked (left or right), the count-up timer should start.
     * 
     * @param event the clicking mouse event
     */
    public void mouseClicked(MouseEvent event) {
		if(!ticker.isRunning()){
			ticker.start();
		}
		Point point = findSourceIndex(event);
		if(event.getButton() == MouseEvent.BUTTON1){	
			grid.uncoverAt(point.x, point.y);
		}	
		else if(event.getButton() == MouseEvent.BUTTON3){
			if(grid.isFlagAt(point.x, point.y)){
				grid.removeFlagAt(point.x, point.y);
				this.flags++;
			}
			else {
				grid.placeFlagAt(point.x, point.y);
				this.flags--;
			}
		}	
		Grid.Result result = grid.getResult();
		if(result == Grid.Result.WIN){
			JOptionPane pane = new JOptionPane();
			JOptionPane.showMessageDialog(null, "You Won" + ticker.getText());
			enabled = false;
			
		}
		if(result == Grid.Result.LOSE){
			JOptionPane pane = new JOptionPane();
			JOptionPane.showMessageDialog(null, "Game is Over");
			enabled = false;
		}
		

    }   
    
    /**
     * This is a private convenience method that returns the point
     * (x and y) representing the row and column of the label that
     * was the source of the event. It should return null if no such
     * label can be found (which should not be able to happen, but
     * the compiler demands a return in all cases).
     * 
     * @param event the mouse clicked event on a label
     * @return the point (x is row, y is column) of the label
     */
    private Point findSourceIndex(MouseEvent event) {
		Point p = new Point(-1, -1);
		Component c = (Component)event.getSource();
		if(c.getName().startsWith("cell")){
			String s = c.getName();
			Scanner scanner = new Scanner(s);
			scanner.useDelimiter(":");
			scanner.next();
			p.x = scanner.nextInt();
			p.y = scanner.nextInt();
		}
		return p;
        
    }
    
    
    /**
     * These methods do not need true implementations.
     */
    public void mousePressed(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
}
