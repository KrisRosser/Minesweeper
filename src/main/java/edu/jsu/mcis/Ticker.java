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
		this.setName("ticker");
		this.seconds = 0;
		this.running = false;
		timer = new Timer(1000, new ActionListener(){
			@override
			timer.actionPerformed();
		}
    }
    
    /**
     * This method starts the timer.
     */
    public void start() {
		timer.start();
		this.running = true;
    }
    
    /**
     * This method stops the timer.
     */
    public void stop() {
		int holder = this.seconds;
		this.timer.cancel();
		this();
		this.seconds = holder;
		this.running = false;
    }
    
    /**
     * This method stops the timer and resets the current time to 0.
     */
    public void reset() {
		this.timer.cancel();
		this();
    }
    
    public boolean isRunning() {
        return running;
    }
    
    /**
     * This method returns the elapsed time in MM:SS format.
     * 
     * @return the elapsed time in MM:SS format
     */
    private String getTime() {
        int min = seconds / 60;
		int sec = seconds % 60;
		String s = "";
		if (min<10 && sec<10) s = "0" + Integer.toString(min) + ":" + "0" + Integer.toString(sec);
		else if(min<10) s = "0" + Integer.toString(min) + ":" + Integer.toString(sec);
		else if (sec<10) s = Integer.toString(min) + ":" + "0" + Integer.toString(sec);
		else s = Integer.toString(min) + ":" + Integer.toString(sec);
		return s;
    }
    
    /**
     * This method is called automatically by the javax.swing.Timer at
     * every interval. It should update the ticker appropriately.
     * 
     * @param event the event triggered by the timer
     */
    public void actionPerformed(ActionEvent event) {
		seconds++;
		this.getTime();
    }
}