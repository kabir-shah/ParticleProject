import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * Hold the world of particles and handle their general behavior.
 */
public class ParticleWorld extends World
{
    public static final int width = 1000;
    public static final int height = 600;
    public static final int speed = 60; // Ticks per second.
    public static final double g = -9.8; // Gravitational constant (m/s/s)
    public static final Reaction[] reactions = {
        new Reaction( // O + o -> O2
            -1000,
            new Reactant[]{new Reactant(2, Oxygen.class)},
            new Product[]{new Product(1, "MolecularOxygen")}
        ),
        new Reaction( // O + 2H -> H2O
            -1000,
            new Reactant[]{new Reactant(1, Oxygen.class), new Reactant(2, Hydrogen.class)},
            new Product[]{new Product(1, "WaterVapor")}
        ),
        new Reaction( // 2O + C -> CO2
            -1000,
            new Reactant[]{new Reactant(2, Oxygen.class), new Reactant(1, Carbon.class)},
            new Product[]{new Product(1, "CarbonDioxide")}
        ),
        new Reaction( // CH4 + 2O2 -> CO2 + 2H2O
            -80000,
            new Reactant[]{new Reactant(2, MolecularOxygen.class), new Reactant(1, Methane.class)},
            new Product[]{new Product(1, "CarbonDioxide"), new Product(2, "WaterVapor")}
        )
    };
    
    private static List<Particle> particles = new ArrayList<Particle>(); // List of all particles in world.

    /**
     * Create a world.
     */
    public ParticleWorld()
    {
        super(width, height, 1);
        Greenfoot.setSpeed(speed); // Set the speed according to the attribute.
        
        // Create the sensors and menu items. Each particle has a certain letter attatched to it, if you press the letter and click, it will create the particle
        addObject(new Sensors(this), 500, 550);
        addObject(new MenuItem(this, "Carbon", 60, 25, "a"), 0, 0);
        addObject(new MenuItem(this, "CarbonDioxide", 90, 50, "b"), 0, 0);
        addObject(new MenuItem(this, "Glucose", 60, 75, "c"), 0, 0);
        addObject(new MenuItem(this, "Helium", 60, 100, "d"), 0, 0);
        addObject(new MenuItem(this, "Hydrogen", 70, 125, "e"), 0, 0);
        addObject(new MenuItem(this, "Methane", 60, 150, "f"), 0, 0);
        addObject(new MenuItem(this, "MolecularOxygen", 100, 175, "g"), 0, 0);
        addObject(new MenuItem(this, "Nitrogen", 70, 200, "h"), 0, 0);
        addObject(new MenuItem(this, "Oxygen", 60, 225, "i"), 0, 0);
        addObject(new MenuItem(this, "Phosphate", 90, 250, "j"), 0, 0);
        addObject(new MenuItem(this, "WaterVapor", 80, 275, "k"), 0, 0);
        
        // Loop and create particles of all types.
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
            else if (i < 97) {
                Particle particle = new MolecularOxygen(Greenfoot.getRandomNumber(width), Greenfoot.getRandomNumber(height));
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

    /**
     * Create a particle given a string name and initial position.
     */
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
            case "MolecularOxygen": {
                MolecularOxygen particle = new MolecularOxygen(x, y);
                particles.add(particle);
                addObject(particle, (int)x, (int)y);
                return particle;
            }
            default: {
                return null;
            }
        }
    }

    /**
     * Handle global events on the world.
     */
    public void act() {
        // Check if the mouse was dragged.
        if (Greenfoot.mouseDragged(this)) {
            // Get mouse coordinates.
            MouseInfo info = Greenfoot.getMouseInfo();
            
            // If there is a currently selected particle in the menu,
            // create a particle at the mouse location of that class.
            if (MenuItem.currentParticle != null) {
                createParticle(MenuItem.currentParticle, info.getX(), info.getY());
            }
        }
    }
}
