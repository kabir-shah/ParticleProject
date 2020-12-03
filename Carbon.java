import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Carbon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
