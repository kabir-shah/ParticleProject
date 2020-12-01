import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ReactionItem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reactant extends Actor
{
    public int coefficient;
    public Class particle;

    public Reactant(int c, Class p) {
        coefficient = c;
        particle = p;
    }
}
