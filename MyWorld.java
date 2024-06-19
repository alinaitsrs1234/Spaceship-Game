import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    // Erzeugung von einem Attribut um eine Zahl zu merken, um zu mitzählen, wie oft 
    // die act-Methode aufgerufen wurde
    private int zaehler = 0; 

    // Mitzählen, damit ein Objekt der KLasse BonusBullet erst erscheint, nachdem 
    // 10 Meteor-Objekte erzeugt werden

    private int bonusZaehler = 0;

    public MyWorld()
    {  
        super(900, 700, 1); 

        this.fillWorld();
    }

    public void fillWorld()
    {
        // Reservierung vom Speicher für den Objekt
        BlueShip meinBlueShip;

        // Erzeugung vom Ship Onjekt
        meinBlueShip = new BlueShip();

        // Objekt einfügen
        this.addObject(new BlueShip(), 100, 350);

        Meteor meinMeteor;
        meinMeteor = new Meteor();
        this.addObject(new Meteor(), 999, 400);
    }

    public void act()
    {
        // Mitzählen, wie oft die act-Methode aufgerufen wurde
        zaehler = zaehler + 1;

        if (zaehler == 40)
        {
            Meteor meinMeteor;
            meinMeteor = new Meteor();
            this.addObject(new Meteor(), 999, Greenfoot.getRandomNumber(699)); 

            // Zähler auf 0 setzen, um wieder auf 40 act-Methoden kommen
            zaehler = 0;
            
            bonusZaehler = bonusZaehler + 1;
            if(bonusZaehler == 10)
            {
                BonusBullet meinBonus;
                meinBonus = new BonusBullet();
                this.addObject(new BonusBullet(), 999, Greenfoot.getRandomNumber(699));
                
                bonusZaehler = 0;
            }            
        }
    }

}
