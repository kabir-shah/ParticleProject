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
    private double averageKinetic = 0;
    private double temperature = 0;
    private double totalVelocity = 0;
    public Sensors(ParticleWorld world) {
        getImage().clear();
    }
    public void act() {
        List<Particle> particles = getWorld().getObjects(Particle.class);
        sumKinetic = 0;
        averageKinetic = 0;
        temperature = 0;
        for (int i = 0; i < particles.size(); i++){
            totalVelocity = Math.sqrt(particles.get(i).getVelocityY() * particles.get(i).getVelocityY() + particles.get(i).getVelocityX() * particles.get(i).getVelocityX());
            sumKinetic += 0.5 * (particles.get(i).getMass()) / 1000 * totalVelocity * totalVelocity;
        }
        averageKinetic = sumKinetic / particles.size();
        temperature = 2 * averageKinetic / (3 * 8.3145);
        getWorld().showText("The temperature is: " + temperature + " K", 500, 500);

    }
}
