import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Phosphate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Phosphate extends Particle
{
    public Phosphate(double x, double y) {
        super(x, y);
        setParticleSize(30);
        setMass(94.97);
        scaleImage("images/phosphate.png");
    }    
}
