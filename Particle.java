
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends Actor
{
    private double m = 1;
    private double x = 0;
    private double y = 0;
    private double v_x = 0;
    private double v_y = 0;
    private int size = 10;
    
    public Particle(double xInit, double yInit) {
        x = xInit;
        y = yInit;
        scaleImage("images/ball.png");
    }
    
    public void scaleImage(String image) {
        setImage(image);
        getImage().scale(size, size);
    }
    
    public double getParticleSize() {
        return size;
    }
    
    public void setParticleSize(int newSize) {
        size = newSize;
    }
    
    public double getMass() {
        return m;
    }
    
    public void setMass(double newMass) {
        m = newMass;
    }
    
    public double getPositionX() {
        return x;
    }
    
    public double getPositionY() {
        return y;
    }
    
    public double getVelocityX() {
        return v_x;
    }
    
    public double getVelocityY() {
        return v_y;
    }
    
    public void setVelocity(double v_x_new, double v_y_new) {
        v_x = v_x_new;
        v_y = v_y_new;
    }
    
    public void gravity() {
        v_y += ParticleWorld.g / ParticleWorld.speed;
    }
    
    public void viscosity() {
        // TODO: fix this
        List<Particle> neighbors = getNeighbours(5, true, Particle.class);
        
        for (Particle neighbor : neighbors) {
            //neighbor.acc(-10 / (neighbor.getX() - getX()), -10 / (neighbor.getY() - getY()));
        }
    }
    
    public void go() {
        // Move with velocity
        x += v_x / ParticleWorld.speed;
        y -= v_y / ParticleWorld.speed;
        setLocation((int)x, (int)y);
        
        // React
        boolean isConsumed = false;
        
        for (Reaction reaction : ParticleWorld.reactions) {
            boolean isReacting = true;
            boolean willBeConsumed = false;
            List<Particle> consumed = new ArrayList<Particle>();
            
            for (Reactant reactant : reaction.reactants) {
                int numToReact = reactant.coefficient;
                List<Particle> neighbors = getNeighbours(10, true, reactant.particle);
                if (!isConsumed && this.getClass() == reactant.particle) {
                    willBeConsumed = true;
                    neighbors.add(this);
                }
                if (neighbors.size() < numToReact) {
                    isReacting = false;
                    willBeConsumed = false;
                    break;
                } else {
                    for (Particle neighbor : neighbors) {
                        consumed.add(neighbor);
                    }
                }
            }
            
            if (isReacting) {
                ParticleWorld world = (ParticleWorld) getWorld();
                world.removeObjects(consumed);
                
                if (willBeConsumed) {
                    isConsumed = true;
                }
                
                for (Product product : reaction.products) {
                    for (int i = 0; i < product.coefficient; i++) {
                        world.createParticle(product.particle, x, y);
                    }
                }
            }
        }
        
        if (!isConsumed) {
            // Handle collision with particles
            // TODO: implement exclusion
            Particle colliding = (Particle) getOneIntersectingObject(Particle.class);
        
            if (colliding != null) {
                double c_m = colliding.getMass();
                double c_v_x = colliding.getVelocityX();
                double c_v_y = colliding.getVelocityY();
                colliding.setVelocity(
                    2 * m * v_x / (m + c_m) + c_v_x * (c_m - m) / (m + c_m),
                    2 * m * v_y / (m + c_m) + c_v_y * (c_m - m) / (m + c_m)
                );
                v_x = v_x * (m - c_m) / (m + c_m) + 2 * c_m * c_v_x / (m + c_m);
                v_y = v_y * (m - c_m) / (m + c_m) + 2 * c_m * c_v_y / (m + c_m);
            }
        
            // Handle collision with walls
            if (x <= 0 || x >= ParticleWorld.width - 1) {
                v_x = -v_x;
            }

            if (y <= 0 || y >= ParticleWorld.height - 1) {
                v_y = -v_y;
            }
        }
    }
    
    /**
     * Act - do whatever the Particle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        gravity();
        go();
    }
}
