import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CarbonDioxide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CarbonDioxide extends Particle
{
    public CarbonDioxide(double x, double y) {
        super(x, y);
        setParticleSize(20);
        setMass(44.01);
        scaleImage("images/carbondioxide.png");
    }    
}
