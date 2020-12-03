import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phosphate here.
 * 
 * his Phosphate class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class Phosphate extends Particle
{
    public Phosphate(double x, double y) {
        super(x, y);
        setParticleSize(30);
        setMass(94.97 / 1000);
        scaleImage("images/phosphate.png");
    }    
}
