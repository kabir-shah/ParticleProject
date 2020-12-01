import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReactionItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Product extends Actor
{
    public int coefficient;
    public String particle;

    public Product(int c, String p) {
        coefficient = c;
        particle = p;
    }
}
