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
    private double sumForce = 0;
    private double pressure = 0;
    public Sensors(ParticleWorld world) {
        getImage().scale(1000, 10);
    }
    public void act() {
        List<Particle> particles = getWorld().getObjects(Particle.class);
        sumKinetic = 0;
        sumForce = 0;
        pressure = 0;
        averageKinetic = 0;
        temperature = 0;
        for (int i = 0; i < particles.size(); i++){
            totalVelocity = Math.sqrt(particles.get(i).getVelocityY() * particles.get(i).getVelocityY() + particles.get(i).getVelocityX() * particles.get(i).getVelocityX());
            sumKinetic += 0.5 * (particles.get(i).getMass()) / 1000 * totalVelocity * totalVelocity;
        }
        averageKinetic = sumKinetic / particles.size();
        temperature = 2 * averageKinetic / (3 * 8.3145);
        temperature *= 10000;
        temperature = (double) Math.round(temperature);
        temperature /= 10000;
        getWorld().showText("The temperature is: " + temperature + " K", 850, 50);
        
        List<Particle> touchingParticles = getIntersectingObjects(Particle.class);
        for (int j = 0; j < touchingParticles.size(); j++) {
            sumForce += touchingParticles.get(j).getMass() * Math.sqrt(touchingParticles.get(j).getVelocityY() * touchingParticles.get(j).getVelocityY() + touchingParticles.get(j).getVelocityX() * touchingParticles.get(j).getVelocityX());
        }
        pressure = sumForce / 3000;
        pressure *= 100;
        pressure = (double) Math.round(pressure);
        pressure /= 100;
        getWorld().showText("The pressure is: " + pressure + " Pa", 830, 70);
    }
}
