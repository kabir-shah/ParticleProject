import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reaction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reaction extends Actor
{
    public double d_energy;
    public Reactant[] reactants;
    public Product[] products;
    
    public Reaction(double e, Reactant[] r, Product[] p) {
        d_energy = e;
        reactants = r;
        products = p;
    }
    public String toString() {
        return "The reactants: " + reactants + ". The products" + products;
    }
}
