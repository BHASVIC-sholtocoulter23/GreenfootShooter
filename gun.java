import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gun extends Actor
{
    private int gunX = 0;
    private int gunY = 0;
    private boolean facingRight = true;
    private Player player;
    
    public Gun(Player userPlayer){
        player = userPlayer;
    }
    
    public void act()
    {
        
        gunX = player.getPlayerX();
        
        // Add your action code here.
    }
}
