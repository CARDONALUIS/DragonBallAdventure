import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de crear objetosw del tipo de bonificacion las cuales son pedasos de carne
 * 
 * @author LECB 
 * @version 1.9
 */
public class Carne extends Bonificacion
{
    /**
     * Metodo que se encarga de que cada que goku interecte con este objeto de tipo carne 
     * aumenta en un su salud y remoeva el mismo objeto carne
     */
    public void act() 
    {
        // Add your action code here.
        escenario esc = (escenario)getWorld();
        Actor act =getOneIntersectingObject(Goku.class);
        if(act != null)
        {
              esc.vidas.incrementar();
              
              getWorld().removeObject(this);
        }  
    }    
}
