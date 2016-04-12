import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author Isaac Blasiman 
 * @version 4.5.2016
 */
public class MyWorld extends World
{
/**
 * Initialize world
 * Act()
 *    Generate World
 *    Draw world
 */

public boolean testVal = true;

 private boolean[][] world = new boolean[500][500];
 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 500x500 cells with a cell size of 1x1 pixels.
        super(500, 500, 1); 
        randomize();
        draw();
    }
    
    public void act() {
      
        generate();
        draw();
   
    }
    /**
     * Generate new world
     */
    public void generate() {
        // Set the loops from 1 to 498
        // Generate into a new world
        boolean[][] newWorld = new boolean[500][500];
        for (int i = 1; i<499; ++i) {
            for (int j = 1; j<499; ++j) {
                int numNeighbors = getNeighbors(i, j);
                
                // System.out.println("MyValue: " + world[i][j] + " and neighbors = " + numNeighbors);
                if (numNeighbors < 2 || numNeighbors > 3) {
                    // "kill" cell by putting "false" in newWorld[i][j]
                    // System.out.println("killing cell");
                    newWorld[i][j] = false;
                }
                else if (numNeighbors == 3) {
                    // create a new cell at [i][j]
                    // System.out.println("creating cell");                    
                    newWorld[i][j] = true;
                }
                else {
                    newWorld[i][j] = world[i][j];
                    // System.out.println("keeping cell");                    
                    // keep cell in the new world to be the same as the cell in the old world.
                }
            }
        }
        world = newWorld;
        testVal = false;
    }
    
    /**
     * Randomize world of cells
     */
    public void randomize() {
        for (int i = 0; i<500;i++) {
            for (int j = 0; j<500;j++) {
                // Populate world
                if(Math.random()<.2) {
                    world[i][j] = true;
                }
                else {
                world[i][j] = false;
                }
            }
        }
    }

    
    /**
     * Draw (display) world
     */
    
    public void draw()
    {
        Color black = Color.black;
        GreenfootImage b = getBackground();
        b.setColor(Color.white);
        b.fill();
        for(int i=0;i<500;i++) {
            for(int j=0;j<500;j++) {
                 if(world[i][j]) {
                     b.setColorAt(i,j,black); }
                }
            }
    }
    
    /**
     * Calculate and return the number of neighbors of a cell. Assumes that the cell isn't on an edge.
     * 
     * @param  xPos  The x position of the cell.
     * @param  yPos  The y position of the cell.
     */
    private int getNeighbors(int xPos, int yPos)
    {
        int numNeighbors = 0;
        if(world[xPos -1][yPos-1]) {
            ++numNeighbors;
        }
        if(world[xPos][yPos-1]) {
            ++numNeighbors;
        }
        if(world[xPos+1][yPos-1]) {
            ++numNeighbors;
        }
        if(world[xPos-1][yPos]) {
            ++numNeighbors;
        }
        // skip your own location
        if(world[xPos+1][yPos]) {
            ++numNeighbors;
        }
        if(world[xPos-1][yPos+1]) {
            ++numNeighbors;
        }
        if(world[xPos][yPos+1]) {
            ++numNeighbors;
        }
        if(world[xPos+1][yPos+1]) {
            ++numNeighbors;
        }
        return numNeighbors;
    }
    
    /**
     * Method to "kill a cell" at an XY location in the world.
     * 
     * @param  XPos  The x position of the cell.
     * @param  YPos  The y position of the cell.
     */
    private void killCell(int XPos, int YPos)
    {
        world[XPos][YPos] = false;
    }
    
    /**
     * Method to "breed a cell" at an XY location in the world.
     * 
     * @param  XPos  The x position of the cell.
     * @param  YPos  The y position of the cell.
     */
    private void breedCell(int XPos, int YPos)
    {
        world[XPos][YPos] = true;
    }
}
