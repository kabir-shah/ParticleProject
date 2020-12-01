import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuItem extends Actor
{
    public static Class currentParticle = Particle.class;
    private Class particle;
    
    public MenuItem(ParticleWorld world, Class particleClass, int level) {
        particle = particleClass;
        world.showText(particle.getName(), 50, level * 15);
        getImage().clear();
    }
    
    /**
     * Act - do whatever the MenuItem wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mousePressed(this)) {
            currentParticle = particle;
        }
    }    
}
