import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cactus is the enemy object.
 * 
 * @author (Tiffany Ho) 
 * @version (January 11 2024)
 */
public class cactus extends Actor
{
    /**
     * Act - do whatever the cactus wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] cacti = new GreenfootImage[7];
    
    public void act()
    {
        // Add your action code here.
        for(int i = 1; i < cacti.length; i++)
        {
            cacti[i] = new GreenfootImage("images/cactus_idle/caactus (" + i + ").png");
            cacti[i].scale(100,70);
        }
        setImage(cacti[1]);
    }
    
    public void animateCacti()
    {
        
    }
    
    
}
