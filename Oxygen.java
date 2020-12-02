import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Oxygen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Oxygen extends Particle
{
    public Oxygen(double x, double y) {
        super(x, y);
        setParticleSize(20);
        setMass(16.001 / 1000);
        scaleImage("images/oxygen.png");
    }   
}
