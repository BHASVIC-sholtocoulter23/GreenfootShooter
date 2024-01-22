import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected GreenfootImage sprite = new GreenfootImage("ppl1.png");
   
    
    
    protected int xVel = 0;
    protected int yVel = 0;
    protected int walkSpeed = 0;
    protected int jumpStrength = 5;
    
    protected final int drag = 1;
    protected final int gravity = 1;
    
    public Player()
    {
        this.setImage(sprite);
    }
    
    public void act()
    {
        movement();
        
    }
    
    private void movement(){
        
        if(Greenfoot.isKeyDown("w") && isTouching(Block)){
            yVel -= jumpStrength;
        }
        if(this.getY() < 400){
            gravity();
        }
        else if(yVel < 0){
            yVel = 0;
        }
        
        this.setLocation(getX(), getY()+yVel);
    }
    private void gravity(){
        yVel += gravity;
    }
        
   
}
