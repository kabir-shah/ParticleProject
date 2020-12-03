import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nitrogen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
