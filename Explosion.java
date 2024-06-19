import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Explosion extends Actor
{
    // Mitzählen wie lange das Explosion Objekt schon existiert
    private int zaehler = 0;
    
    public void act()
    {
        zaehler = zaehler + 1;
        
        // Nach 100 act-Methoden soll das Explosion-Objekt verschwinden:
        if(zaehler > 100)
        {
            this.getWorld().removeObject(this);
        }
    }
}
