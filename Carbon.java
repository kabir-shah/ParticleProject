import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carbon here.
 * This Carbon class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 *
 */
public class Carbon extends Particle
{
    public Carbon(double x, double y) {
        super(x, y);
        setParticleSize(15);
        setMass(12.01 / 1000);
        scaleImage("images/carbon.png");
    }  
}
