import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Methane here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Methane extends Particle
{
    public Methane(double x, double y) {
        super(x, y);
        setParticleSize(25);
        setMass(16.04);
        scaleImage("images/methane.png");
    }   
}
