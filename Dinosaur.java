import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dinosaur here.
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
    private static final int JUMP_STRENGTH = 15;
    private int ySpeed = 0;

    GreenfootImage[] idleRight = new GreenfootImage[48];
    GreenfootImage[] idleLeft = new GreenfootImage[48];
    
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
        if (Greenfoot.isKeyDown("up") && onGround())
        {
            ySpeed = -JUMP_STRENGTH;
        }

        // Gravity effect
        if (!onGround())
        {
            ySpeed += 1;
        }

        setLocation(getX(), getY() + ySpeed);
    }
    
    private boolean onGround()
    {
        // Customize this method based on your world setup
        return getY() >= getWorld().getHeight() - 1;
    }
}
