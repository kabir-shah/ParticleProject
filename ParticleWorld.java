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
        addObject(new MenuItem(this, "CarbonDioxide", 90, 25, "1"), 0, 0);
        addObject(new MenuItem(this, "Glucose", 60, 50, "2"), 0, 0);
        addObject(new MenuItem(this, "Methane", 60, 75, "3"), 0, 0);
        addObject(new MenuItem(this, "Phosphate", 71, 100, "4"), 0, 0);
        for (int i = 0; i < 100; i++) {
            Particle particle = new Particle(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
            particles.add(particle);
            addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
        }
    }
    
    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo info = Greenfoot.getMouseInfo();
            int x = info.getX();
            int y = info.getY();
            
            if (MenuItem.currentParticle != null) {
                switch (MenuItem.currentParticle) {
                    case "CarbonDioxide": {
                        CarbonDioxide particle = new CarbonDioxide(x, y);
                        particles.add(particle);
                        addObject(particle, x, y);
                        break;
                    }
                    case "Glucose": {
                        Glucose particle = new Glucose(x, y);
                        particles.add(particle);
                        addObject(particle, x, y);
                        break;
                    }
                    case "Methane": {
                        Methane particle = new Methane(x, y);
                        particles.add(particle);
                        addObject(particle, x, y);
                        break;
                    }
                    case "Phosphate": {
                        Phosphate particle = new Phosphate(x, y);
                        particles.add(particle);
                        addObject(particle, x, y);
                        break;
                    }
                }
            }
        }
    }
}
