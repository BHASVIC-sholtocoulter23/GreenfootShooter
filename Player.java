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

    
    
    protected float xVel = 0;
    protected float yVel = 0;
    protected int walkSpeed = 3;
    protected int jumpStrength = 17;
    
    protected final int drag = 1;
    protected final int gravity = 3;
    
    public Player()
    {
        this.setImage(sprite);
    }
    
    public void act()
    {
        movement();
        
    }
    
    private void movement(){

        if(getOneObjectAtOffset(0, sprite.getHeight()/2+2, Block.class) != null){
            yVel = 0;
            if(Greenfoot.isKeyDown("w")){
                yVel -= jumpStrength;
            }

        }
        else{
            gravity();
        }
        if(Greenfoot.isKeyDown("a") && xVel > -7){
            xVel -= walkSpeed;
        }
        if(Greenfoot.isKeyDown("d") && xVel < 7){
            xVel += walkSpeed;
        }
        if(xVel < 0){
            xVel += drag;
        }
        else if(xVel > 0){
            xVel -= drag;
        }
        
        this.setLocation(getX()+(int)xVel, getY()+(int)yVel);
    }
    private void gravity(){
        yVel += (float)gravity/4;
        if(getOneObjectAtOffset(0, -sprite.getHeight()/2+2, Block.class) != null && yVel < 0){
            yVel = 0;
        }
    }
        
   
}
