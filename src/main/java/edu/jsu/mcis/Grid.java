package edu.jsu.mcis;

import java.util.*;

/**
 * This class represents the grid in Minesweeper. It is composed of a
 * two-dimensional array of Location objects. It must initialize those 
 * locations with the correct hints and mine placement (which means it
 * also needs to know how many mines to place). It places mines 
 * randomly using the specified pseudorandom number generator.
 *
 * This class also implements a part of the Observer pattern. It is
 * the Observable component. That means that other objects can 
 * register themselves as observers of the Grid. It will then update
 * all observers whenever "something interesting" happens (e.g., 
 * when flags are placed or locations are uncovered). It communicates
 * with the observers by means of strings of the following form:
 * 
 *     row:col:info
 *
 * Possible values for `info` are `flag`, `unflag`, `mine`, and an 
 * integer value in the range [0, 8] representing the hint at the 
 * (`row`, `col`) location.
 */
public class Grid extends Observable {
    public enum Result {NONE, WIN, LOSE};
    
    private Location[][] location;
    private int mines;
    private Random random;

    public Grid() {

    }
    
    public Grid(int width, int height, int mines) {

    }
    
    /**
     * This constructor initializes the grid to the specified 
     * dimensions (height rows by width columns) with the specified
     * number of mines. All locations should be covered, and all mines
     * should be placed randomly such that all mines are in unique
     * locations. Hints should be calculated after mines are placed.
     * 
     * @param width the width of the grid (number of columns)
     * @param height the height of the grid (number of rows)
     * @param mines the number of mines
     * @param random the pseudorandom number generator
     */
    public Grid(int width, int height, int mines, Random random) {

    }
    
    /**
     * This method resets the grid to an initial fully-covered and
     * randomly reinitialized condition. All locations should be 
     * covered, and all mines should be placed randomly such that all 
     * mines are in unique locations. Hints should be calculated after 
     * mines are placed.
     */
    public void reset() {

    }
    
    /**
     * This method should place all mines randomly in unique 
     * locations.
     */
    private void placeMines() {

    }
    
    /**
     * This method should set the hints for each location based on the
     * adjacent mines.
     */
    private void placeHints() {

    }
    
    /**
     * This method returns a list of the adjacent neighbors of the 
     * (row, col) location. This list could contain the following 
     * numbers of elements:
     *     0 => if (row, col) is not a legal index
     *     3 => if (row, col) is a corner
     *     5 => if (row, col) is along a side
     *     8 => if (row, col) is an interior location
     *
     * @param row
     * @param col
     * @return a list of Location objects representing the adjacent neighbors of (row, col)
     */
    private List<Location> getNeighbors(int row, int col) {
        List<Location> neighbors = new ArrayList<>();
        return neighbors;
    }
    
    /**
     * This method returns true if (row, col) is a legal index.
     * 
     * @param row 
     * @param col 
     * @return whether (row, col) is a legal index
     */
    private boolean isLegalIndex(int row, int col) {
        return false;
    }
    
    /**
     * This method returns an integer representing the number of mines
     * contained in the list of neighboring locations.
     * 
     * @param neighbors the list of neighboring Locations
     * @return the hint associated with the list of neighbors
     */
    private int calculateHint(List<Location> neighbors) {
        int hint = 0;
        return hint;
    }
    
    public int getWidth() {
        return 0;
    }
    
    public int getHeight() {
        return 0;
    }
    
    public int getMines() {
        return 0;
    }
    
    /**
     * This method returns Result.LOSE if a mine in uncovered. It 
     * returns Result.WIN if all non-mine locations are uncovered.
     * It returns Result.NONE in all other cases.
     * 
     * @return the state of the Minesweeper game outcome
     */
    public Result getResult() {
        return Result.NONE;
    }
    
    /**
     * This method returns the location at (row, col).
     * 
     * @param row 
     * @param col 
     * @return the location at (row, col)
     */
    public Location getLocation(int row, int col) {
        return null;
    }
    
    /**
     * This method returns true if (row, col) is a legal index and
     * a flag is at (row, col).
     * 
     * @param row 
     * @param col 
     * @return whether a flag is at (row, col)
     */
    public boolean isFlagAt(int row, int col) {
        return false;
    }
    
    /**
     * This method places a flag at (row, col) if that location is a
     * legal index and if it is currently covered. It also calls the
     * `setChanged()` method of the Observable class and notifies
     * all observers with the message row:col:flag (using the 
     * appropriate row and col).
     * 
     * @param row 
     * @param col 
     */
    public void placeFlagAt(int row, int col) {
        
    }
    
    /**
     * This method removes a flag at (row, col) if that location is a
     * legal index and if it is currently flagged. It also calls the
     * `setChanged()` method of the Observable class and notifies
     * all observers with the message row:col:unflag (using the 
     * appropriate row and col).
     * 
     * @param row 
     * @param col 
     */
    public void removeFlagAt(int row, int col) {

    }
    
    /**
     * This method uncovers (row, col) if that location is a
     * legal index and if it is currently covered. It also calls the
     * `setChanged()` method of the Observable class and notifies
     * all observers. The message depends on whether the location 
     * contains a mine (row:col:mine) or not (row:col:hint). 
     * If the hint at this location is 0, then it also recursively
     * uncovers its 8 neighbors if they are legal indices, are 
     * currently covered, and contain no mine.
     * 
     * @param row 
     * @param col 
     */
    public void uncoverAt(int row, int col) {

    }
    
    /**
     * This method returns true if (row, col) is covered.
     * 
     * @param row 
     * @param col 
     * @return whether the location at (row, col) is covered
     */
    private boolean isCovered(int row, int col) {
        return false;
    }
    
    /**
     * This method returns true if (row, col) is flagged.
     * 
     * @param row 
     * @param col 
     * @return whether the location at (row, col) is flagged
     */
    private boolean isFlagged(int row, int col) {
        return false;
    }
}
