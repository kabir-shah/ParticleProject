import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Helium here.
 * This Helium class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
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
