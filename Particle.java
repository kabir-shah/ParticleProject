import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Particle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Particle extends Actor
{
    public static final double g = -9.8;
    private double m = 1;
    private double x = 0;
    private double y = 0;
    private double v_x = 0;
    private double v_y = 0;
    private int size = 10;
    
    public Particle(double xInit, double yInit) {
        //v_x = Greenfoot.getRandomNumber(10) - 5;
        //v_y = Greenfoot.getRandomNumber(10) - 5;
        x = xInit;
        y = yInit;
        getImage().scale(size, size);
    }
    
    public double getMass() {
        return m;
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
        v_y += g / ParticleWorld.speed;
    }
    
    public void viscosity() {
        // TODO: fix this
        List<Particle> neighbors = getNeighbours(5, true, Particle.class);
        
        for (Particle neighbor : neighbors) {
            //neighbor.acc(-10 / (neighbor.getX() - getX()), -10 / (neighbor.getY() - getY()));
        }
    }
    
    public void go() {
        x += v_x / ParticleWorld.speed;
        y -= v_y / ParticleWorld.speed;
        setLocation((int)x, (int)y);
        
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
        
        if (x <= 0 || x >= ParticleWorld.width - 1) {
            v_x = -v_x;
        }

        if (y <= 0 || y >= ParticleWorld.height - 1) {
            v_y = -v_y;
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
