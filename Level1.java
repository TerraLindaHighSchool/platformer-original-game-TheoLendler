import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BrickWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    private final float GRAVITY = 0.0667f;
    private final GreenfootSound MUSIC = new GreenfootSound("zapsplat_024.mp3");
    private final int SPEED = 3;
    private final float JUMP_FORCE = 5.6f;
    private final int MAX_HEALTH = 3;
    private final int MAX_POWERUP = 3;
    private final Class NEXT_LEVEL = Level2.class;
    /**
     * Constructor for objects of class BrickWorld.
     * 
     */
    public Level1()
    {    
        // Create a new world with 1200x800 cells with a cell size of 1x1 pixels.
        super(1200, 800, 1, false); 
        prepare();
    }
    
    public void act()
    {
        spawn();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setPaintOrder(Player.class, Platform.class, Obstacle.class, Collectable.class,
            Door.class, HUD.class);
        Door door = new Door();
        addObject(door,1152,48);
        door.setLocation(1165,47);
        Player player = new Player(SPEED, JUMP_FORCE, GRAVITY, 
                           MAX_HEALTH, MAX_POWERUP, NEXT_LEVEL, MUSIC);
        addObject(player,24,756);
        addObject(new Floor(), 600, 800);
        addObject(new BrickWall(), 380, 500);
        addObject(new BrickWall(), 780, 300);       
        addObject(new BrickWall(), 960, 100);
        addObject(new SmBrickWall(), 1114,647);
        addObject(new SmBrickWall(), 880, 600);
        addObject(new SmBrickWall(), 420, 160);
        addObject(new SmBrickWall(), 1000, 200);
        addObject(new SmBrickWall(), 220, 280);
        addObject(new TrapDoor(), 60, 400);
        addObject(new Bomb(GRAVITY), 465, 115);
        addObject(new Bomb(GRAVITY), 1050, 765);
        addObject(new Gem(), 975, 160);
        addObject(new Gem(), 1030, 160);
    }
    
    private void spawn()
    {
        if(Math.random() < 0.0025)
        {
            addObject(new Rock(GRAVITY), Greenfoot.getRandomNumber(1200), -30);
        }
    }
}
