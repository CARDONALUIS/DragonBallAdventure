import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que representa el enemigo de cell
 * 
 * @author LECB
 * @version 1.9
 */
public class Cell extends Enemigo
{
    int  velocidad = 6;
    int direccion = 1;
    boolean cambia = false;
    
    @Override
    public void ataque()
    {
       int x = Greenfoot.getRandomNumber(30);
        
       if(x == 10)
        {
          BossAtack attack = new BossAtack(2);
          getWorld().addObject(attack,getX()-10,getY());
         }
    }
    
    /**
     * Metodo que se encarga de ejecutar este metodo mientras este el enemigo
     * escenario
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

