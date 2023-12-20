import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Floor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    GreenfootImage[] floorIdle = new GreenfootImage[53];
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Floor()
    {
        for(int i = 0; i < floorIdle.length; i++)
        {
            floorIdle[i] = new GreenfootImage("images/floor_idle/frame" + i + ".png");
            floorIdle[i].scale(100,100);
        }
        
        setImage(floorIdle[0]);
    }
    public void act()
    {
        // Add your action code here.
    }
}
