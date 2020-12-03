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
        ),
        new Reaction(
            -100,
            new Reactant[]{new Reactant(1, Oxygen.class), new Reactant(2, Hydrogen.class)},
            new Product[]{new Product(1, "WaterVapor")}
        ),
        new Reaction(
            -100,
            new Reactant[]{new Reactant(2, Oxygen.class), new Reactant(1, Carbon.class)},
            new Product[]{new Product(1, "CarbonDioxide")}
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
        addObject(new MenuItem(this, "Phosphate", 71, 100, "4"), 0, 0);
        for (int i = 0; i < 100; i++) {
            if (i < 18) {
                Particle particle = new Oxygen(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 50) {
                Particle particle = new Hydrogen(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 62) {
                Particle particle = new CarbonDioxide(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 67) {
                Particle particle = new WaterVapor(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 75) {
                Particle particle = new Phosphate(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 82) {
                Particle particle = new Helium(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 85) {
                Particle particle = new Carbon(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else if (i < 95) {
                Particle particle = new Glucose(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
            else {
                Particle particle = new Methane(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
                particles.add(particle);
                addObject(particle, (int)particle.getPositionX(), (int)particle.getPositionY());
            }
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
            case "Oxygen": {
                Oxygen particle = new Oxygen(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "WaterVapor": {
                WaterVapor particle = new WaterVapor(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Helium": {
                Helium particle = new Helium(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Hydrogen": {
                Hydrogen particle = new Hydrogen(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Nitrogen": {
                Nitrogen particle = new Nitrogen(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            case "Carbon": {
                Carbon particle = new Carbon(x, y);
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
