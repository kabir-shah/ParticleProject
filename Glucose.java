import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Glucose here.
 * 
 * This Glucose class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class Glucose extends Particle
{
    public Glucose(double x, double y) {
        super(x, y);
        setParticleSize(40);
        setMass(180.156 / 1000);
        scaleImage("images/glucose.png");
    }   
}
