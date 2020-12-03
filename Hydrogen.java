import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class hydrogen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hydrogen extends Particle
{
    public Hydrogen(double x, double y) {
        super(x, y);
        setParticleSize(5);
        setMass(1.001 / 1000);
        scaleImage("images/hydrogen.jpg");
    } 
}
