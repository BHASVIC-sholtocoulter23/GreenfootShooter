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
    protected int walkSpeed = 2;
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
        if(Greenfoot.isKeyDown("a") && xVel > -7 && getOneObjectAtOffset(-sprite.getWidth()/2-10, 0, Block.class) == null){
            xVel -= walkSpeed;
        }
        if(Greenfoot.isKeyDown("d") && xVel < 7 && getOneObjectAtOffset(sprite.getWidth()/2+10, 0, Block.class) == null){
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
        if(yVel >= 0 && (getOneObjectAtOffset(-sprite.getWidth()/2, sprite.getHeight()/2, Block.class) != null || getOneObjectAtOffset(sprite.getWidth()/2, sprite.getHeight()/2, Block.class) != null)){
            yVel = 0;
        }
        else if(yVel < 0 && (getY()-30 <=0 || (getOneObjectAtOffset(-sprite.getWidth()/2, -sprite.getHeight()/2, Block.class) != null || getOneObjectAtOffset(sprite.getWidth()/2, -sprite.getHeight()/2, Block.class) != null))){
            yVel = 0;
        }
    }
        
   
}
