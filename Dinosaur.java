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
    private static final int JUMP_STRENGTH = 17; //how high the elephant jumps
    private int ySpeed = 0;
    private static final int GRAVITY = 1;
    private static final int GROUND_LEVEL = 100;

    GreenfootImage[] idleDead = new GreenfootImage[8];
    GreenfootImage[] idle = new GreenfootImage[10];
    GreenfootImage[] idleJump = new GreenfootImage[12];
    GreenfootImage[] idleRun = new GreenfootImage[9];
    
    private int animationFrame = 0;
    private int animationDelay = 5; 
    GreenfootSound jumpSound = new GreenfootSound("jumpSound.mp3");
    
    //Constructor
    public Dinosaur()
    {
        for(int i = 1; i < idleRun.length; i++)
        {
            idleRun[i] = new GreenfootImage("images/dinosaur_idle/Run (" + i + ").png");
            idleRun[i].scale(100,70);
        }
        
        setImage(idleRun[1]);
    }
    
    //Animates the dinosaur and all its actions
    public void animateDinosaurRun()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            // Change the animation frame every few acts
            if (animationFrame % animationDelay == 0)
            {
                setImage(idleRun[animationFrame / animationDelay % idleRun.length]);
            }
            animationFrame++;
        }
        else
        {
            // If not moving, display the first frame of the running animation
            setImage(idleRun[1]);
            animationFrame = 0;
        }
    }

    //All the actions code. 
    public void act()
    {
        animateDinosaurRun();
        jump();
        touchCactus();
        checkColision();
    }
    
    private void checkColision()
    {
        Actor cactus = getOneIntersectingObject(Cactus.class);
        if (cactus != null)
        {
            ((MyWorld)getWorld()).gameOver();
        }
    }
    
    //Makes the dinosaur jump.
    private void jump()
    {
        if (Greenfoot.isKeyDown("up") && onGround())
        {
            ySpeed = -JUMP_STRENGTH;
            jumpSound.play();
        }

        // Gravity effect
        if (!onGround())
        {
            ySpeed += GRAVITY;
        }

        setLocation(getX(), Math.min(getWorld().getHeight() - GROUND_LEVEL, getY() + ySpeed));
    }
    
    //returns to the floor when jumps down.
    private boolean onGround()
    {
        return getY() >= getWorld().getHeight() - GROUND_LEVEL;
    }
    
    //If the dinosaur touches the cactus then gameOver
    public void touchCactus()
    {
        if(isTouching(Cactus.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.createCactus();
        }
    }
}
