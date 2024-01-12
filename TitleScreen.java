import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (Tiffany Ho) 
 * @version January 11 2024)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("Dinosaur Escape", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 300, 1); 

        addObject(titleLabel, 300, 60);
        prepare();
    }
    
    public void act()
    {
        //start the game if user presses the space bar.
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);

        }
    }
    
    
    private void prepare()
    {
        Label label2 = new Label("Use \u2190 and \u2192 to Move", 20);
        addObject(label2,300,270);

        Label label = new Label("Press <space> to start the game", 20);
        addObject(label,300,120);

        Label label3 = new Label("Avoid the cactus and keep moving to win!", 20);
        addObject(label3,300,100);

        Dinosaur dinosaur = new Dinosaur();
        addObject(dinosaur,300,170);
        
        Floor floor = new Floor();
        addObject(floor,299,222);
    }
}
