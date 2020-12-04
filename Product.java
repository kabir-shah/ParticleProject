import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Represent a product of a reaction.
 */
public class Product extends Actor
{
    public int coefficient; // The stoichiometric coefficient of the product.
    public String particle; // The particle of the product.

    /**
     * Create a new product.
     */
    public Product(int c, String p) {
        coefficient = c;
        particle = p;
    }
    public String toString() {
        return particle;
    }
}
