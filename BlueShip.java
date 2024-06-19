import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BlueShip extends Actor
{
    // Attribut: Wie viele Munitionen vorhanden sind
    private int shots = 10;
    
    // Nur alle 20 ms soll Munition gesammelt werden
    private int bonusTimer = 0;
    
    // Punktestand Zähler
    private int counter = 0;
    
    private int shieldCounter = 900;
    
    // Man soll erst nach 20 act-Methoden wieder schießen können
    private int shotTimer = 20;
    
    public BlueShip()
    {
        setRotation(90);
    }
    
    public void act()
    {
        moveShip();
    
        if(Greenfoot.isKeyDown("space") && shotTimer > 20)
        {
            if(shots > 0)
            {
                this.getWorld().addObject(new Bullet(), this.getX() + 60, this.getY());
                shots = shots -1;
                shotTimer = 0;
            }
        }
        
        // schotTimer nach oben zählen
        shotTimer = shotTimer + 1;
        
        // Munition auf dem Bildschirm anzeigen
        this.getWorld().showText("Shots:" + shots, 400, 40);
        
        if(Greenfoot.isKeyDown("enter") && shieldCounter > 1000)
        {
            Shield meinShield;
            meinShield = new Shield();
            this.getWorld().addObject(meinShield, this.getX(), this.getY());
            
            shieldCounter = 0;
        }
        
        shieldCounterUpAndMassageOnScreen();
        
        checkBulletCollected();
        
        // Counter nach oben zählen
        counter = counter + 1;
        this.getWorld().showText("Score: " + Integer.toString(counter), 700, 40);
        
        checkCollision();
    }
    
    public void shieldCounterUpAndMassageOnScreen()
    {
        shieldCounter = shieldCounter + 1;
        
        if(shieldCounter > 1000)
        {
            this.getWorld().showText("Shield Ready!", 100, 40);
        }
        else
        {
            getWorld().showText("", 100, 40);
        }
    }
    
    // Steuerung vom Schiff
     public void moveShip()
    {
        if (Greenfoot.isKeyDown("down")) {
            setLocation(getX(), getY ()+ 5);
        }
        if (Greenfoot.isKeyDown("up")) {
            setLocation(getX(), getY () -5);
        }
    }
    
    public void checkCollision()
    {
        // Reservierung vom Speicherplatz
        Actor meinMeteor;
        meinMeteor = this.getOneIntersectingObject(Meteor.class); 
        
        if(meinMeteor != null)
        {
            Explosion meineExplosion;
            meineExplosion = new Explosion();
            this.getWorld().addObject(meineExplosion, this.getX(), this.getY());
            
            this.getWorld().removeObject(this);
        }
    }
    
    public void shot()
    {
        this.getWorld().addObject(new Bullet(), this.getX() +50 , this.getY());
    }
    
    public void checkBulletCollected()
    {
       Actor meinBonus;
       meinBonus = this.getOneIntersectingObject(BonusBullet.class);
       
       if(meinBonus != null)
       {
           shots = shots + 5;
           this.getWorld().removeObject(meinBonus);
       }
    }
}
