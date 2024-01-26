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
    private GreenfootImage sprite = new GreenfootImage("ppl1.png");
    
    
    protected int playerX = 0;
    protected int playerY = 0;
    protected boolean facingRight = true;
    protected int usingGun = 1;
    protected MyWorld arena;
    
    private float xVel = 0;
    private float yVel = 0;
    private int walkSpeed = 2;
    private int jumpStrength = 17;
    
    private final int drag = 1;
    private final int gravity = 3;
    
    private Gun gun; 
    
    public int getPlayerX(){
        return(playerX);
    }
    public int getPlayerY(){
        return(playerY);
    }
    public boolean facingRight(){
        return(facingRight);
    }
    
    public Player()
    {
        this.setImage(sprite);
        arena = (MyWorld)getWorld();
        gun = new Gun(this);
        arena.addObject(gun, 0, 0);
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
                   playerY = getY();
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
            facingRight = false;
        }
        if(Greenfoot.isKeyDown("d") && xVel < 7 && getOneObjectAtOffset(sprite.getWidth()/2+10, 0, Block.class) == null){
            xVel += walkSpeed;
            facingRight = true;
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
        if((yVel > 0 && touchingGround())||(yVel < 0 && touchingRoof())){
            yVel = 0;
        }
        if((xVel > 0 && wallRight())||(xVel < 0 && wallLeft())){
            xVel = 0;
        }
    }
    private boolean touchingGround(){
        if((getOneObjectAtOffset((-sprite.getWidth()/2)+5, sprite.getHeight()/2, Block.class) != null || 
            getOneObjectAtOffset((sprite.getWidth()/2)-5, sprite.getHeight()/2, Block.class) != null)){
            return(true);
        }
        return(false);
    }
    private boolean touchingRoof(){
        if((getY()-30 <=0 || 
            (getOneObjectAtOffset((-sprite.getWidth()/2)+5, -sprite.getHeight()/2, Block.class) != null || 
             getOneObjectAtOffset((sprite.getWidth()/2)-5, -sprite.getHeight()/2, Block.class) != null))){
            return(true);
        }
        return(false);
    }
    private boolean wallRight(){
        if((getOneObjectAtOffset(sprite.getWidth()/2, (sprite.getHeight()/2)-5, Block.class) != null || 
            getOneObjectAtOffset(sprite.getWidth()/2, (-sprite.getHeight()/2)+5, Block.class) != null)){
            return(true);
        }
        return(false);
    }
    private boolean wallLeft(){
        if((getOneObjectAtOffset(-sprite.getWidth()/2, (sprite.getHeight()/2)-5, Block.class) != null || 
            getOneObjectAtOffset(-sprite.getWidth()/2, (-sprite.getHeight()/2)+5, Block.class) != null)){
            return(true);
        }
        return(false);
    }
        
   
}
