import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarbonDioxide here.
 * This Carbon dioxide class describes the size and mass of the particle so other classes and methods can use it. It also sets the image of the particle. 
 */
public class CarbonDioxide extends Particle
{
    public CarbonDioxide(double x, double y) {
        super(x, y);
        setParticleSize(20);
        setMass(44.01 / 1000);
        scaleImage("images/carbondioxide.png");
    }    
}
