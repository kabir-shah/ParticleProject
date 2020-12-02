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
    public static final double g = -9.8;
    public static final Reaction[] reactions = {
        new Reaction(
            -100,
            new Reactant[]{new Reactant(2, CarbonDioxide.class)},
            new Product[]{new Product(1, "Methane")}
        )
    };
    private static List<Particle> particles = new ArrayList<Particle>();

    /**
     * Constructor for objects of class ParticleWorld.
     * 
     */
    public ParticleWorld()
    {    
        super(width, height, 1); 
        Greenfoot.setSpeed(speed);
        addObject(new Sensors(this), 500, 550);
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

    public Particle createParticle(String name, double x, double y) {
        switch (name) {
            case "CarbonDioxide": {
                CarbonDioxide particle = new CarbonDioxide(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Glucose": {
                Glucose particle = new Glucose(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Methane": {
                Methane particle = new Methane(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Phosphate": {
                Phosphate particle = new Phosphate(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            default: {
                return null;
            }
        }
    }

    public void act() {
        if (Greenfoot.mouseDragged(this)) {
            MouseInfo info = Greenfoot.getMouseInfo();

            if (MenuItem.currentParticle != null) {
                createParticle(MenuItem.currentParticle, info.getX(), info.getY());
            }
        }
    }
}
