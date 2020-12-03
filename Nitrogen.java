import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nitrogen here.
 * 
 * This Nitrogen class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class Nitrogen extends Particle
{
    public Nitrogen(double x, double y) {
        super(x, y);
        setParticleSize(20);
        setMass(28 / 1000);
        scaleImage("images/Nitrogen.png");
    }
       
}
