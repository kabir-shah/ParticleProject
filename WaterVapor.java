import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class watervapor here.
 * 
 * This WaterVapor class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class WaterVapor extends Particle
{
    public WaterVapor(double x, double y) {
        super(x, y);
        setParticleSize(25);
        setMass(18.015 / 1000);
        scaleImage("images/watervapor.png");
    }    
}
