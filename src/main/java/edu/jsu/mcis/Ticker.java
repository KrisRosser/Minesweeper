package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This class represents a count-up timer. It can be started, stopped,
 * and reset. It maintains the current elapsed time (in MM:SS form, 
 * where MM is minutes and SS is seconds) as its text (since it is a
 * JLabel). It updates this value every second using a 
 * javax.swing.Timer object.
 */
public class Ticker extends JLabel implements ActionListener {
    private Timer timer;
    private int seconds;
    private boolean running;
    
    /**
     * This constructor creates a new ticker at 0 seconds that is not
     * currently running and sets its name to "ticker".
     */
    public Ticker() {

    }
    
    /**
     * This method starts the timer.
     */
    public void start() {

    }
    
    /**
     * This method stops the timer.
     */
    public void stop() {

    }
    
    /**
     * This method stops the timer and resets the current time to 0.
     */
    public void reset() {

    }
    
    public boolean isRunning() {
        return false;
    }
    
    /**
     * This method returns the elapsed time in MM:SS format.
     * 
     * @return the elapsed time in MM:SS format
     */
    private String getTime() {
        return "";
    }
    
    /**
     * This method is called automatically by the javax.swing.Timer at
     * every interval. It should update the ticker appropriately.
     * 
     * @param event the event triggered by the timer
     */
    public void actionPerformed(ActionEvent event) {

    }
}