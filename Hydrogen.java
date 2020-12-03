import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hydrogen here.
 * 
 * This Hydrogen class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class Hydrogen extends Particle
{
    public Hydrogen(double x, double y) {
        super(x, y);
        setParticleSize(5);
        setMass(1.001 / 1000);
        scaleImage("images/hydrogen.jpg");
    } 
}
