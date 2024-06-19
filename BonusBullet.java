import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BonusBullet extends Actor
{
    public void act()
    {
        moveMeteor();
        
        if (this.getX() < 1)
        {
            getWorld().removeObject(this);
            // Die act-Methode muss abgebrocen werden, sonst wird die checkCollision 
            // Methode ausgeführt wird. Das Objekt gibt es aber nicht mehr
            // Abruch der act-Methode mit return
            return;
        }
        
    }
    
    public void moveMeteor () 
    {
        setLocation(this.getX() - 2, this.getY());
    }
}
