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
    
    String facing = "right";    
    public void act()
    {
            if(Greenfoot.isKeyDown("up"))
            {
                move(-3);
                facing = "up";
            }
            else if(Greenfoot.isKeyDown("down"))
            {
                move(3);
                facing = "down";
            }
    }
}
