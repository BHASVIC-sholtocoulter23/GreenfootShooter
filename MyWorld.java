import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int worldWidth = 1000;
    private int worldHeight = 800;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1); 
        addObject(new Player(), 70, 70);
        
        
        
        createBlock(worldWidth+1, 0, worldWidth, 'h');
        createBlock(worldWidth+1, 0, 0, 'h');
        createBlock(worldHeight+1, 0, 0, 'v');
        createBlock(worldHeight+1, worldWidth, 0, 'v');

        
        createBlock(2, 0, 200, 'h');
        createBlock(2, 400, 200, 'h');
        createBlock(2, 400, 650, 'h');
        createBlock(2, 450, 550, 'h');
    }
    private void createBlock(int length, int xPos, int yPos, char rotation){
        if(rotation == 'h'){
            for(int i=0;i<length;i++){
                addObject(new Block(), xPos+i*72, yPos);
            }
        }
        else{
                for(int i=0;i<length;i++){
                addObject(new Block(), xPos, yPos+i*72);
            }
            
        }
    }
}
