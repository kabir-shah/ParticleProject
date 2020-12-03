import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represent a reaction.
 */
public class Reaction extends Actor
{
    public double d_energy; // Hold the enthalpy change (in J/mol)
    public Reactant[] reactants; // Hold a list of reactants
    public Product[] products; // Hold a list of products
    
    /**
     * Create a new reaction.
     */
    public Reaction(double e, Reactant[] r, Product[] p) {
        // Initialize all attributes.
        d_energy = e;
        reactants = r;
        products = p;
    }
    
    /**
     * Convert a reaction to a string human-readable representation.
     */
    public String toString() {
        return "The reactants: " + reactants + ". The products" + products;
    }
}
