import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class watervapor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
