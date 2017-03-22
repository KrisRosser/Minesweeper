package edu.jsu.mcis;


/**
 * This class represents a grid location in Minesweeper. Each location
 * can be either covered, uncovered, or flagged (all mutually 
 * exclusive). It can also have a mine (or not), and it is associated
 * with a hint, which is a number in [0, 8] representing the number
 * of mines that are adjacent to it.
 */
public class Location {
    public enum Type {COVERED, UNCOVERED, FLAGGED};
    private Type type;
    private boolean mine;
    private int hint;
    
    /**
     * This constructor creates a location with default settings
     * (type COVERED, mine false, hint 0).
     */
    public Location() {
		this.type = COVERED;
		this.mine = false;
		this.hint = 0;
    }
    
    /**
     * This method resets the location to its default settings 
     * (type COVERED, mine false, hint 0).
     */
    public void reset() {
		this.type = COVERED;
		this.mine = false;
		this.hint = 0;
    }
    
    public Type getType() { 
        //return Type.COVERED;
		return Type;
    }
    
    public void setType(Type t) { 
		this.type = t;
    }
    
    public boolean hasMine() { 
        //return false;
		return mine;
    }
    
    public void setMine(boolean m) { 
		this.mine = m;
    }

    public int getHint() { 
        //return 0;
		return hint;
    }
    
    public void setHint(int h) { 
		this.hint = h;
    }
}
