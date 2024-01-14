import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cactus is the enemy object.
 * 
 * @author (Tiffany Ho) 
 * @version (January 11 2024)
 */
public class Cactus extends Actor
{
    /**
     * Act - do whatever the cactus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] cacti = new GreenfootImage[7];
    int imageIndex = 0;
    int animationCounter = 0;
    int animationDelay = 3;
    int moveSpeed = 2;
    
    public Cactus()
    {
        // Add your action code here.
        for(int i = 1; i < cacti.length; i++)
        {
            cacti[i] = new GreenfootImage("images/cactus_idle/caactus (" + i + ").png");
            cacti[i].scale(100,70);
        }
        setImage(cacti[1]);
    }
    
    public void act()
    {
        animateCactus();
        setLocation(getX() - moveSpeed, getY());

        if(getX() < -getImage().getWidth()) 
        {
            setLocation(getWorld().getWidth(), Greenfoot.getRandomNumber(getWorld().getHeight()));
        }
    }
    
    public void animateCactus()
    {
        if(animationCounter == animationDelay) {
            setImage(cacti[imageIndex]);
            imageIndex = (imageIndex + 1) % cacti.length;
            animationCounter = 0;
        } else {
            animationCounter++;
        }
    }
    
    
}
