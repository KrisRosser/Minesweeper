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

    }
    
    /**
     * This method shoud handle the left- and right-clicks on the
     * labels. Remember that the very first time that a label is 
     * clicked (left or right), the count-up timer should start.
     * 
     * @param event the clicking mouse event
     */
    public void mouseClicked(MouseEvent event) {

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
        return null;
    }
    
    
    /**
     * These methods do not need true implementations.
     */
    public void mousePressed(MouseEvent event) {}
    public void mouseReleased(MouseEvent event) {}
    public void mouseEntered(MouseEvent event) {}
    public void mouseExited(MouseEvent event) {}
}