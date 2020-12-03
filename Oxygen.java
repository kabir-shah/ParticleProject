import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oxygen here.
 * 
 * This Oxygen class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class Oxygen extends Particle
{
    public Oxygen(double x, double y) {
        super(x, y);
        setParticleSize(20);
        setMass(16.001 / 1000);
        scaleImage("images/oxygen.png");
    }   
}
