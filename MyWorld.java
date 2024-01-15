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
    boolean gameIsOver = false;
    
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
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        gameIsOver = true;
    }
    
    public void act() {
        if(!gameIsOver) {
            if(cactusTimer.millisElapsed() > 3000){
                cactusTimer.mark();
                createCactus();
            }
        }
    }
    
    public void score()
    {
                
    }
}
