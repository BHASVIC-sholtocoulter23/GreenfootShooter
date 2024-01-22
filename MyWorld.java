import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        addObject(new Player(), 50, 50);
       
        for(int i=0;i<10;i++){
            addObject(new Block(), i*72, 500);
        }
        for(int i=0;i<2;i++){
            addObject(new Block(), i*72, 200);
        }
        for(int i=0;i<2;i++){
            addObject(new Block(), 400+i*72, 200);
        }
    }
}
