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
    GreenfootImage[] cacti = new GreenfootImage[4];
    int cactusSpeed = 5;
    int imageIndex = 0;
    int animationCounter = 0;
    int animationDelay = 150;
    
    public Cactus()
    {
        for(int i = 1; i < cacti.length; i++)
        {
            cacti[i] = new GreenfootImage("images/cactus_idle/cactus (" + i + ").png");
        }
        
        setImage(cacti[Greenfoot.getRandomNumber(cacti.length)]);
    }
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation(x, y);
        
        move(-5);
    }
}
