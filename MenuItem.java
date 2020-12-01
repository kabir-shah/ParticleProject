import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuItem extends Actor
{
    public static String currentParticle;
    private String particle;
    private String key;
    
    public MenuItem(ParticleWorld world, String particleName, int x, int y, String k) {
        particle = particleName;
        key = k;
        world.showText(particleName + " (" + key + ")", x + 10, y);
        getImage().clear();
    }
    
    /**
     * Act - do whatever the MenuItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.isKeyDown(key)) {
            currentParticle = particle;
        }
    }    
}
