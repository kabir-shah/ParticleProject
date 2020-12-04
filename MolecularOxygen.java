import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MolecularOxygen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MolecularOxygen extends Particle
{
    public MolecularOxygen(double x, double y) {
        super(x, y);
        setParticleSize(23);
        setMass(32.001 / 1000);
        scaleImage("images/o2.png");
    }   
    
}
