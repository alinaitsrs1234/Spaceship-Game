import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Bullet extends Actor
{
    public void act()
    {  
        if(this.getX() < 699)
        {
            moveRight();
        }
        else
        {
            this.getWorld().removeObject(this);
        }
    }
    
    public void moveRight()
    {
        this.setLocation(this.getX() + 5, this.getY()); 
    }
}
