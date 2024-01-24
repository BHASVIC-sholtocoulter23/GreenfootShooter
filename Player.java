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

    protected int worldWidth = 0;
    protected int worldHeight = 0;
    
    protected int playerX = 0;
    protected int playerY = 0;
    
    protected float xVel = 0;
    protected float yVel = 0;
    protected int walkSpeed = 2;
    protected int jumpStrength = 17;
    
    protected final int drag = 1;
    protected final int gravity = 3;
    
    
    public Player(int x, int y)
    {
        this.setImage(sprite);
        worldWidth = x;
        worldHeight = y;
    }
    
    public void act()
    {
        movement();
    }
    
    private void movement(){
    
        playerX = getX();
        playerY = getY();
        while(touchingGround()){
                   this.setLocation(playerX, playerY-1);
        }

        
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
        blockCollision();
        this.setLocation(getX()+(int)xVel, getY()+(int)yVel);
    }
    private void gravity(){
        yVel += (float)gravity/4;
    }
    private void blockCollision(){
        if(yVel > 0 && touchingGround()){
            yVel = 0;
        }
        else if(yVel < 0 && touchingRoof()){
            yVel = 0;
        }   
        if((xVel > 0 || xVel < 0) && touchingWall()){
            xVel = 0;
        }
    }
    private boolean touchingWall(){
        if((getOneObjectAtOffset(sprite.getWidth()/2, (sprite.getHeight()/2)-5, Block.class) != null || getOneObjectAtOffset(sprite.getWidth()/2, (-sprite.getHeight()/2)+5, Block.class) != null)){
            return(true);
        }
        else if((getOneObjectAtOffset(-sprite.getWidth()/2, (sprite.getHeight()/2)-5, Block.class) != null || getOneObjectAtOffset(-sprite.getWidth()/2, (-sprite.getHeight()/2)+5, Block.class) != null)){
            return(true);
        }
        return(false);
    }
    private boolean touchingGround(){
        if((getOneObjectAtOffset((-sprite.getWidth()/2)+5, sprite.getHeight()/2, Block.class) != null || getOneObjectAtOffset((sprite.getWidth()/2)-5, sprite.getHeight()/2, Block.class) != null)){
            return(true);
        }
        return(false);
    }
    private boolean touchingRoof(){
        if((getY()-30 <=0 || (getOneObjectAtOffset((-sprite.getWidth()/2)+5, -sprite.getHeight()/2, Block.class) != null || getOneObjectAtOffset((sprite.getWidth()/2)-5, -sprite.getHeight()/2, Block.class) != null))){
            return(true);
        }
        return(false);
    }
        
   
}
