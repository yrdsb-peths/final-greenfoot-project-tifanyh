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
     * Act - This is the cactus method. It generates the cacti randomizing 
     * between 4 images using a simple timer to generate them.
     * 
     */
    GreenfootImage[] cacti = new GreenfootImage[4];
    int cactusSpeed = 5;
    int imageIndex = 0;
    int animationCounter = 0;
    int animationDelay = 150;
    private static final int GROUND_LEVEL = 100;
    private int ySpeed = 0;
    private static final int GRAVITY = 1;
    int disappearCounter = 200;
    
    public Cactus()
    {
        for(int i = 1; i < cacti.length; i++)
        {
            cacti[i] = new GreenfootImage("images/cactus_idle/cactus (" + i + ").png");
            cacti[i].scale(35,45);
        }
        
        setImage(cacti[Greenfoot.getRandomNumber(cacti.length)]);
    }
    
    public void act()
    {
        // Add your action code here.
        int x = getX();
        int y = getY();
        setLocation(x, y);
        //moves the cactus if the donosaur moves as well so when the right arrow is pressed.
        if(Greenfoot.isKeyDown("right"))
        {
          move(-6); 
        }
        
        //Uses "gravity" to set it to be on the floor.
        if (!onGround())
        {
            ySpeed += GRAVITY;
        }

        setLocation(getX(), Math.min(getWorld().getHeight() - GROUND_LEVEL, getY() + ySpeed));
        
        //Makes the cactus disapear once it reaches the end
        if (disappearCounter > 0) {
            disappearCounter--;

            // If the disappear counter reaches zero, remove the cactus
            if (disappearCounter == 0) {
                getWorld().removeObject(this);
            }
        }
    }
    
    private boolean onGround()
    {
        return getY() >= getWorld().getHeight() - GROUND_LEVEL;
    }
    
    public void setSpeed(int spd)
    {
        cactusSpeed = spd;
    }
}
