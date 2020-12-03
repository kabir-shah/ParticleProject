import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Methane here.
 * This Methane class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class Methane extends Particle
{
    public Methane(double x, double y) {
        super(x, y);
        setParticleSize(25);
        setMass(16.04 / 1000);
        scaleImage("images/methane.png");
    }   
}
