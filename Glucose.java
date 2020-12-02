import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Glucose here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
