import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sensors here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sensors extends Actor
{
    public Sensors(ParticleWorld world) {
        world.showText("test", 500, 500);
    }
    public void act() {
        if (isTouching(Particle.class)){
            getWorld().showText("test2", 600, 550);
        }
    }
}
