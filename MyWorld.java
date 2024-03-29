import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Tiffany Ho
 * @version December 11 2023
 */

public class MyWorld extends World
{
    int level = 1;
    SimpleTimer cactusTimer = new SimpleTimer();
    SimpleTimer scoreTimer = new SimpleTimer(); 
    boolean gameIsOver = false;
    int score = 0;
    int cactusSpeed = 5;
    GreenfootSound death = new GreenfootSound("dinosaurDeath.mp3");
    GreenfootSound replay = new GreenfootSound("replay.mp3");
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 300, 1,false);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        createDinosaur();
        createFloor();
        createCactus();
    }
    
    public void createDinosaur()
    {
        Dinosaur dinosaur = new Dinosaur();
        addObject(dinosaur,100,200);
    }
    
    public void createFloor()
    {
        Floor floor = new Floor();
        addObject(floor,300,220);
    }
    
    public void createCactus()
    {
        Cactus cactus = new Cactus();
        int x = 600;
        int y = 190;
        addObject(cactus, x, y);
    }
    
    public boolean isGameOver()
    {
        return gameIsOver;
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 100);
        
        Label restartLabel = new Label("press space to restart", 30);
        addObject(restartLabel, 300, 150);
        gameIsOver = true;
        cactusTimer.mark();
        death.play();
    }
    
    public void act() 
    {
        if(gameIsOver)
        {
            if(Greenfoot.isKeyDown("space"))
            {
                gameIsOver = false;
                Greenfoot.setWorld(new MyWorld());
                replay.play();
            }
        }
        
        if(gameIsOver) return;
        
        //creates a cactus every 500 miliseconds only if the other cactus has left the screen
        //So that the screen does not get crawded with cactui.
        if (cactusTimer.millisElapsed() > 500) 
        {
            cactusTimer.mark();
            if (getObjects(Cactus.class).isEmpty()) 
            {
                createCactus();
            }
            int numberOfCacti = getObjects(Cactus.class).size();
            
            // Create a new cactus if there are less than two cacti on the screen
            if (numberOfCacti < 2) 
            {
                createCactus();
            }
        }
        
        //Creates the score text when right arrow key is down so it only goes
        //up if you keep moving
        if(Greenfoot.isKeyDown("right"))
        {
            if (scoreTimer.millisElapsed() > 1000) 
            {
                scoreTimer.mark();
                score += 100; // Increase the score by 100
                Label scoreLabel = new Label("Score: " + score, 30);
                showText("Score: " + score, 80, 20);
            }
            
            if (score > 500 && score <= 1000) 
            {
                cactusSpeed = 6;
            } 
            else if (score > 1000 && score <= 1500) 
            {
                cactusSpeed = 7;
            } 
            for (Cactus cactus : getObjects(Cactus.class)) 
            {
                cactus.setSpeed(cactusSpeed);
            }
        }
    }
}
