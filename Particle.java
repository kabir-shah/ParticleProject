import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * The main particle superclass which encodes information for how
 * particles move and interact with each other, including forces and
 * reactions.
 * 
 * @author {Kabir Shah}
 */
public class Particle extends Actor
{
    private double m = 1; // Mass (in kg)
    private double x = 0; // X position (in m)
    private double y = 0; // Y position (in m)
    private double v_x = 0; // Velocity x component (in m/s)
    private double v_y = 0; // Velocity y component (in m/s)
    private int size = 10; // Size of image
    
    /**
     * Create a particle given initial coordinates.
     */
    public Particle(double xInit, double yInit) {
        x = xInit;
        y = yInit;
        scaleImage("images/ball.png");
    }
    
    /**
     * Set and scale the given image of a particle
     * depending on its size attribute.
     */
    public void scaleImage(String image) {
        setImage(image);
        getImage().scale(size, size);
    }
    
    /**
     * Return the size of a particle.
     */
    public double getParticleSize() {
        return size;
    }
    
    /**
     * Set the size of a particle.
     */
    public void setParticleSize(int newSize) {
        size = newSize;
    }
    
    /**
     * Return the mass of a particle.
     */
    public double getMass() {
        return m;
    }
    
    /**
     * Set the mass of a particle.
     */
    public void setMass(double newMass) {
        m = newMass;
    }
    
    /**
     * Return the X position of a particle.
     */
    public double getPositionX() {
        return x;
    }
    
    /**
     * Return the Y position of a particle.
     */
    public double getPositionY() {
        return y;
    }
    
    /**
     * Set the X velocity component of a particle.
     */
    public double getVelocityX() {
        return v_x;
    }
    
    /**
     * Set the Y velocity component of a particle.
     */
    public double getVelocityY() {
        return v_y;
    }
    
    /**
     * Set both components of the velocity of a particle.
     */
    public void setVelocity(double v_x_new, double v_y_new) {
        v_x = v_x_new;
        v_y = v_y_new;
    }
    
    /**
     * Simulate the effect of gravity.
     */
    public void gravity() {
        // Given the acceleration of gravity, obtain the change
        // in speed by dividing the gravitational by the ticks
        // per second of the world.
        v_y += ParticleWorld.g / ParticleWorld.speed;
    }
    
    /**
     * Simulate the effect of viscosity.
     */
    public void viscosity() {
        // TODO: implement this
        List<Particle> neighbors = getNeighbours(5, true, Particle.class);
        
        for (Particle neighbor : neighbors) {
            //neighbor.acc(-10 / (neighbor.getX() - getX()), -10 / (neighbor.getY() - getY()));
        }
    }
    
    /**
     * Simulate moving according to velocity, reactions, and collisions.
     */
    public void go() {
        // Move with velocity by scaling it according to
        // the ticks per second of the world.
        x += v_x / ParticleWorld.speed;
        y -= v_y / ParticleWorld.speed; // Negative because y coordinates are inverted in Greenfoot
        setLocation((int)x, (int)y); // Set the actual location to integers because coordinates are discrete.
        
        // React        
        boolean isConsumed = false; // Keep track of if this specific particle will be consumed.
        
        // Loop through every possible reaction.
        for (Reaction reaction : ParticleWorld.reactions) {
            boolean isReacting = true;
            double reactionEnergy = reaction.d_energy;
            double reactantEnergy = 0;
            List<Particle> consumed = new ArrayList<Particle>();
            
            // Loop through every possible reactant.
            for (Reactant reactant : reaction.reactants) {
                // Find nearby candidates for reactants.
                int numToReact = reactant.coefficient;
                List<Particle> neighbors = getNeighbours(10, true, reactant.particle);
                
                // If this particle is a potential reactant, mark it as consumed.
                if (!isConsumed && this.getClass() == reactant.particle) {
                    isConsumed = true;
                    neighbors.add(this);
                }
                
                // Check if the nearby reactants meet the criteria for the reaction.
                if (neighbors.size() < numToReact) {
                    // If they don't, flag that the reaction will not continue
                    // and the current particle will not be consumed under any circumstance.
                    isReacting = false;
                    isConsumed = false;
                    break;
                } else {
                    // Limit the number of reactants to the number required to react.
                    neighbors = neighbors.subList(0, numToReact);
                    
                    // Go through the consumed reactants for this type.
                    for (Particle neighbor : neighbors) {
                        // Calculate the energy of the reactants and add them because
                        // they will be required later. Add it to the list of total
                        // consumed reactants for this reaction.
                        double neighborVelocityX = neighbor.getVelocityX();
                        double neighborVelocityY = neighbor.getVelocityY();
                        double neighborVelocity = Math.sqrt(neighborVelocityX * neighborVelocityX + neighborVelocityY * neighborVelocityY);
                        reactantEnergy += 0.5 * neighbor.getMass() * neighborVelocity * neighborVelocity;
                        consumed.add(neighbor);
                    }
                }
            }
            
            // Ensure that the energy requirements for the reaction are met.
            if (reactantEnergy < reactionEnergy) {
                isReacting = false;
            }
            
            // If the reaction is flagged to continue, run the simulation.
            if (isReacting) {
                // Begin by removing any consumed reactants from the world.
                ParticleWorld world = (ParticleWorld) getWorld();
                world.removeObjects(consumed);
                    
                if (reactionEnergy > 0) {
                    // Endothermic
                    for (Particle reactantParticle : consumed) {
                        
                    }
                } else {
                    // Exothermic reaction
                    // Calculate the energy allocated to be released per product and for the product itself.
                    double productEnergy = -reactionEnergy / reaction.products.length;
                    reactantEnergy /= reaction.products.length;
                    
                    // Loop through every product.
                    for (Product product : reaction.products) {
                        // Loop through the total number of products of this type
                        // required to be created.
                        for (int i = 0; i < product.coefficient; i++) {
                            // Create the particle and find its surrounding particles.
                            Particle productParticle = world.createParticle(product.particle, x, y);
                            List<Particle> surroundings = productParticle.getNeighbours(50, true, Particle.class);
                            int numSurroundings = surroundings.size();
                            
                            // Loop through the surrounding particles.
                            for (Particle surrounding : surroundings) {
                                // Calculate the magnitude of the velocity vector given
                                // the energy allocated to this surrounding particle
                                // and the mass of the surrounding particle.
                                double velocityMagnitude = Math.sqrt(2 * (productEnergy / product.coefficient / numSurroundings) / surrounding.getMass());
                                
                                // Ensure the velocity will not be infinite.
                                if (!Double.isInfinite(velocityMagnitude)) {
                                    // Calculate the direction of the velocity vector
                                    // using the arctangent to the difference between
                                    // its coordinates and the product originating the
                                    // energy.
                                    double velocityAngle = Math.atan2(surrounding.getPositionY() - y, surrounding.getPositionX() - x);
                                    
                                    // Ensure this direction is a number.
                                    if (!Double.isNaN(velocityAngle)) {
                                        // Change the velocity of the surrounding particle
                                        // by the individual components of the velocity change
                                        // vector by using its magnitude and direction to calculate
                                        // individual components.
                                        surrounding.setVelocity(surrounding.getVelocityX() + velocityMagnitude * Math.cos(velocityAngle), surrounding.getVelocityY() + velocityMagnitude * Math.sin(velocityAngle));
                                    }
                                }
                            }
                            
                            // Calculate the magnitude of the velocity of the product
                            // given the energy allocated from the sum of energy of the
                            // reactants used to create it and the mass of the product.
                            double velocityMagnitude = Math.sqrt(2 * (reactantEnergy / product.coefficient) / productParticle.getMass());
                            
                            // Ensure the magnitude is not infinity.
                            if (!Double.isInfinite(velocityMagnitude)) {
                                // Generate a random direction.
                                double velocityAngle = Math.random() * 2 * Math.PI;
                                
                                // Set the velocity of the product given the magnitude and direction
                                // of the calculated velocity of the reactants.
                                productParticle.setVelocity(velocityMagnitude * Math.cos(velocityAngle), velocityMagnitude * Math.sin(velocityAngle));
                            }
                        }
                    }
                }
                
                // Print out the reaction of this particle to
                // show the user what is happening chemically.
                System.out.println(reaction);
                
                // If this particle was consumed in the reaction,
                // it won't be able to check its surroundings anymore,
                // so stop checking for any further reactions and let
                // the surrounding particles handle them.
                if (isConsumed) {
                    break;
                }
            }
        }
        
        // Only check for collision if the particle wasn't consumed
        // in a reaction.
        if (!isConsumed) {
            // Handle collision with particles
            // TODO: implement exclusion
            // Find a colliding particle.
            Particle colliding = (Particle) getOneIntersectingObject(Particle.class);
        
            // Ensure that there is a colliding particle.
            if (colliding != null) {
                // Using the mass and velocity vector of the current
                // particle and the colliding particle, use the formula
                // for Newtonian collisions to calculate the new velocities
                // of each and change them to that new value.
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
        
            // Handle collision with walls by checking if a particle
            // is at the border and negating its velocity to a fraction
            // of itself to simulate the decaying velocity as it hits the
            // edges of the container.
            if (x <= 0 || x >= ParticleWorld.width - 1) {
                v_x = -v_x * 0.999;
            }

            if (y <= 0 || y >= ParticleWorld.height - 1) {
                v_y = -v_y * 0.999;
            }
        }
    }
    
    /**
     * Simulate all forces, reactions, and collisions of this particle
     * per tick.
     */
    public void act() {
        gravity();
        go();
    }
}
