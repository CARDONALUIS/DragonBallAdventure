import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase padre de las clases de poderes especiales la cual proporciona habilidades
 * 
 * @author LECB 
 * @version  1.9
 */
public class PoderEspecial extends Actor
{
    public void act() 
    {
        
    }   
    /**
     * Metodo que se encarga saber si el poder especial intersecto con algun roca, si lo hase se crea otra en un
     * lugar diferente y aparte aumenta tus puntos
     */
    public void InterRocas()
    {
        Actor roca = getOneObjectAtOffset(0,0,Roca1.class);
        Actor roca2 = getOneObjectAtOffset(0,0,Roca2.class);
       
         escenario esp =(escenario)getWorld();
         if(roca != null)
         {
           getWorld().removeObject(roca);
           esp.crearRocas(1);
         }
         else
         {
           getWorld().removeObject(roca2);
           esp.crearRocas2(1);  
         }
         
         esp.puntos.incrementar();
         getWorld().removeObject(this);

        }
    
    /**
     * Metodo que se encarga de quitar el poder de la pantalla si llego al limite de esta
     */
    public void limitPoder()
    {
        if((getX() >= getWorld().getWidth()-5)||(getX()<=5))
        {
           getWorld().removeObject(this);
        }
        else
        {
            if((getY()>=getWorld().getHeight()-5)||(getY()<=5))
            {
                getWorld().removeObject(this);
            }
        }
    }
    
    
    
    
    
}
