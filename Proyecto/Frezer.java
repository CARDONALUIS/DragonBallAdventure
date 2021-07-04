import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de las acciones del personaje enemigo frezer
 * 
 * @author LECB
 * @version 1.9
 */
public class Frezer extends Enemigo
{
    int  velocidad = 4;
    int direccion = 1;
    boolean cambia = false;
    
    @Override
    public void ataque()
    {
       int x = Greenfoot.getRandomNumber(40);
        
       if(x == 10)
         {
          BossAtack attack = new BossAtack(2);
            getWorld().addObject(attack,getX()-10,getY());
         }
    }
    
    /**
     * Metodo que se encarga de las acciones que realizara frezer cuando aparesca 
     * 
     */
    public void act() 
    {
        
        if(getY()>=30 && !cambia)
        {
            direccion = -1;
        }
        else
        {
            cambia = true;
        }
        if(getY() <= getWorld().getHeight()-30 && cambia)
        {
            direccion = 1;
        }
        else
        {
            cambia = false;
        }
        setLocation(getX(),getY()+(velocidad*direccion));
        reglas();
        ataque();
        
    }    
    
    
    
}
