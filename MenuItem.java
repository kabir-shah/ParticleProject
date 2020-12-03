import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Handle menu item UI with a currently selected item.
 * 
 * @author {Kabir Shah}
 */
public class MenuItem extends Actor
{
    public static String currentParticle; // Hold a string of the currently selected particle class name
    private String particle; // Hold a string of the particle name which this specific menu item represents.
    private String key; // Hold the key needed to select this particle.
    
    public MenuItem(ParticleWorld world, String particleName, int x, int y, String k) {
        particle = particleName;
        key = k;
        
        // Show text of the particle given the name and key required
        // to create it. Shift the x coordinate right by 10 to offset
        // the extra text created by the parenthesis and name of the key.
        world.showText(particleName + " (" + key + ")", x + 10, y);
        
        // Clear the image since this will be represented with text.
        getImage().clear();
    }
    
    /**
     * Handle events for this menu item.
     */
    public void act() 
    {
        // If the key to select this item is pressed, set the currently
        // selected particle to the particle of this menu item.
        // Note: We do not handle mouse presses because greenfoot
        // does not support mouse events on text items, and this
        // actor does not have an image representing it.
        if (Greenfoot.isKeyDown(key)) {
            currentParticle = particle;
        }
    }    
}
