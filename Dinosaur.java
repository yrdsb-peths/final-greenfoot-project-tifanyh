import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class create the dinosaur idle and its actions.
 * 
 * @author Tiffany Ho 
 * @version December 15 2023
 */
public class Dinosaur extends Actor
{
    /**
     * Act - do whatever the Dinosaur wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static final int JUMP_STRENGTH = 15; //how high the elephant jumps
    private int ySpeed = 0;
    private static final int GRAVITY = 1;
    private static final int GROUND_LEVEL = 100;

    GreenfootImage[] idleDead = new GreenfootImage[8];
    GreenfootImage[] idle = new GreenfootImage[10];
    GreenfootImage[] idleJump = new GreenfootImage[12];
    GreenfootImage[] idleRun = new GreenfootImage[8];
    GreenfootImage[] idleWalk = new GreenfootImage[10];
    
    //Constructor
    public Dinosaur()
    {
        
    }

    public void act()
    {
        jump();
    }
    
    private void jump()
    {
        if (Greenfoot.isKeyDown("space") && onGround())
        {
            ySpeed = -JUMP_STRENGTH;
        }

        // Gravity effect
        if (!onGround())
        {
            ySpeed += GRAVITY;
        }

        setLocation(getX(), Math.min(getWorld().getHeight() - GROUND_LEVEL, getY() + ySpeed));
    }
    private boolean onGround()
    {
        return getY() >= getWorld().getHeight() - GROUND_LEVEL;
    }
}
