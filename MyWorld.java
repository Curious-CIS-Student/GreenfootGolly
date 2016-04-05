import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
/**
 * Initialize world
 * Act()
 *    Generate World
 *    Draw world
 */

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
    
}
