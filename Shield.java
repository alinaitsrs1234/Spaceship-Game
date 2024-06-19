import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Shield extends Actor
{
    private int zaehler = 0;
    
    public void act()
    {
        zaehler = zaehler + 1;
        
        if(zaehler > 500)
        {
            this.getWorld().removeObject(this);
            return;
        }
        
        moveWithBlueShip();
        checkCollision();
    }
    
    public void checkCollision()
    {
        Actor meinMeteor;
        meinMeteor = this.getOneIntersectingObject(Meteor.class);
        
        if(meinMeteor != null)
        {
            Explosion meineExplosion;
            meineExplosion = new Explosion();
            this.getWorld().addObject(meineExplosion, meinMeteor.getX(), meinMeteor.getY());
            this.getWorld().removeObject(meinMeteor);
        }
    }
    
    public void moveWithBlueShip()
    {
        // Zugriff auf Methoden des BlueShips 
        Actor meinBlueShip;
        meinBlueShip = this.getOneIntersectingObject(BlueShip.class);
        this.setLocation(meinBlueShip.getX(), meinBlueShip.getY());
    }
}
