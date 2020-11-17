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
    public static final double g_x = 0;
    public static final double g_y = -9.8;
    private double m = 1;
    private double v_x = 0;
    private double v_y = 0;
    
    public Particle() {
        v_x = Greenfoot.getRandomNumber(10) - 5;
        v_y = Greenfoot.getRandomNumber(10) - 5;
    }
    
    public double mass() {
        return m;
    }
    
    public void acc(double d_v_x, double d_v_y) {
        v_x += d_v_x;
        v_y += d_v_y;
    }
    
    public void gravity() {
        acc(g_x, g_y);
    }
    
    public void viscosity() {
        // TODO: fix this
        List<Particle> neighbors = getNeighbours(5, true, Particle.class);
        
        for (Particle neighbor : neighbors) {
            neighbor.acc(-10 / (neighbor.getX() - getX()), -10 / (neighbor.getY() - getY()));
        }
    }
    
    public void go() {
        int x = getX();
        int y = getY();
        
        setLocation(x = (int)(x + v_x / ParticleWorld.speed), y);
        setLocation(x, y = (int)(y - v_y / ParticleWorld.speed));
        
        // TODO: implement exclusion
        Particle colliding = (Particle) getOneIntersectingObject(Particle.class);
        
        if (colliding != null) {
            double c_m = colliding.mass();
            colliding.acc(2 * m * v_x / (m + c_m), 2 * m * v_y / (m + c_m));
            v_x = v_x * (m - c_m) / (m + c_m);
            v_y = v_y * (m - c_m) / (m + c_m);
        }
        
        if (x == 0 || x == ParticleWorld.width - 1) {
            v_x = -v_x;
        }
        
        if (y == 0 || y == ParticleWorld.height - 1) {
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
