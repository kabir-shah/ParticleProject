import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Helium here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Helium extends Particle
{
    public Helium(double x, double y) {
        super(x, y);
        setParticleSize(5);
        setMass(4 / 1000);
        scaleImage("images/Helium.jpg");
    }
        
}
