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
    //all the variables used later set as doubles at 0.
    private double sumKinetic = 0;
    private double temperature = 0;
    private double totalVelocity = 0;
    private double pressure = 0;
    private double timer = 0;
    //constructor of the class
    public Sensors(ParticleWorld world) {
        getImage().clear(); //clears the image of the sensor so it's not visible
    }
    //act method which executed every time the act button is pressed or continuously while running
    public void act() {
        timer += 1; //adds 1 to the timer every act
        if (timer % 100 == 0) { //checks if timer is divisible by 100, effectively makes the code below run once every 100 acts to slow it down
            List<Particle> particles = getWorld().getObjects(Particle.class); //gets the list of particles from the particle subclass
            sumKinetic = 0; //resets the values being measured before calculating
            pressure = 0;
            temperature = 0;
            for (int i = 0; i < particles.size(); i++){ //for loop that runs once for every particle on the screen
                //velocity is calculated using the velocity and mass of particles
                totalVelocity = Math.sqrt(particles.get(i).getVelocityY() * particles.get(i).getVelocityY() + particles.get(i).getVelocityX() * particles.get(i).getVelocityX());
                //total kinetic energy is calculated using totalvelocity
                sumKinetic += (particles.get(i).getMass()) * totalVelocity * totalVelocity;
            }
            //temperature is found using the total kinetic energy through the Maxwell-Boltzmann distribution
            temperature = sumKinetic / (1.38064852 * 1e-23 * 6.022*1e23 * (3* particles.size() - 3));
            //pressure is found using temperature and the ideal gas law
            pressure = particles.size() * 8.20573 * 101325 * temperature / 30000;
            //next 6 lines are used to round the values of temperature and pressure to 4 decimal points
            //multiplying the number and then rounding it means the numbers after the decimal point are kept
            //casting to a double and divviding by the same number as before results in conserving those numbers 
            temperature *= 10000; 
            temperature = (double) Math.round(temperature);
            temperature /= 10000;
            pressure *= 10000;
            pressure = (double) Math.round(pressure);
            pressure /= 10000;
            
            //show the text for pressure and temperature on the screen on the top right corner
            getWorld().showText("The pressure is: " + pressure + " Pa", 825, 75);  
            getWorld().showText("The temperature is: " + temperature + " K", 820, 50);  
        }
    }
}
