import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Floor is where the dinosaur acts on.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Floor extends Actor
{
    GreenfootImage[] floorIdle = new GreenfootImage[53];
    int imageIndex = 0;
    int animationCounter = 0;
    int animationDelay = 3;
    
    /**
     * Act - do whatever the Floor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Floor()
    {
        for(int i = 0; i < floorIdle.length; i++)
        {
            floorIdle[i] = new GreenfootImage("images/floor_idle/frame" + i + ".png");
            floorIdle[i].scale(600,200);
        }
        
        setImage(floorIdle[0]);
        animateFloor();
    }
    
    public void animateFloor()
    {
        if(animationCounter == animationDelay)
        {
            setImage(floorIdle[imageIndex]);
            imageIndex = (imageIndex + 1) % floorIdle.length;
            animationCounter = 0;
        }
        else
        {
            animationCounter++;
        }
    }
    
    public void act()
    {
        // Add your action code here.
        animateFloor();
    }
}
