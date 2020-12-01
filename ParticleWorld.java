import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class ParticleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ParticleWorld extends World
{
    public static final int width = 1000;
    public static final int height = 600;
    public static final int speed = 60;
    private List<Particle> particles = new ArrayList<Particle>();

    /**
     * Constructor for objects of class ParticleWorld.
     * 
     */
    public ParticleWorld()
    {    
        super(width, height, 1); 
        Greenfoot.setSpeed(speed);
        addObject(new MenuItem(this, Particle.class, 1), 0, 0);
        
        for (int i = 0; i < 100; i++) {
            Particle particle = new Particle(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
            particles.add(particle);
            addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
        }
    }
    
    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            try {
                Particle particle = (Particle) MenuItem.currentParticle.newInstance();
                particles.add(particle);
            
                MouseInfo info = Greenfoot.getMouseInfo();
                addObject(particle, info.getX(), info.getY());
            } catch (InstantiationException e) {
            } catch (IllegalAccessException e) {}
        }
    }
}
