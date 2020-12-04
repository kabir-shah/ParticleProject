import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represent a reactant of a reaction.
 */
public class Reactant extends Actor
{
    public int coefficient; // The stoichiometric coefficient of the product.
    public Class particle; // The particle class of a reactant.

    /**
     * Create a new reactant.
     */
    public Reactant(int c, Class p) {
        coefficient = c;
        particle = p;
    }
    
    // implements a toString method in order to print it out to the terminal
    public String toString() {
        return coefficient + particle.getSimpleName();
    }
}
