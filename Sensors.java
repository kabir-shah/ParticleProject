import greenfoot.*; 
import java.util.List;
/**
 * Write a description of class Sensors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sensors extends Actor
{
    private double sumKinetic = 0;
    private double temperature = 0;
    private double totalVelocity = 0;
    private double pressure = 0;
    public Sensors(ParticleWorld world) {
        getImage().clear();
    }
    public void act() {
        List<Particle> particles = getWorld().getObjects(Particle.class);
        sumKinetic = 0;
        pressure = 0;
        temperature = 0;
        for (int i = 0; i < particles.size(); i++){
            totalVelocity = Math.sqrt(particles.get(i).getVelocityY() * particles.get(i).getVelocityY() + particles.get(i).getVelocityX() * particles.get(i).getVelocityX());
            sumKinetic += (particles.get(i).getMass()) * totalVelocity * totalVelocity;
        }
        temperature = sumKinetic / (1.38064852 * 1e-23 * (3* particles.size() - 3));
        pressure = particles.size() * 8.20573 * 101325 * temperature / 30000;
        getWorld().showText("The pressure is: " + pressure + " Pa", 825, 75);  
        getWorld().showText("The temperature is: " + temperature + " K", 650, 50);  
    }
}
