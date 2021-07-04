import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de alojar los metodos propios de la energia que obtienes
 * cuando aparece la estrella
 * 
 * @author LECB
 * @version 1.9
 */
public class Energia extends Accesorio
{
    /**
     * Metodo que se encarga de ejecutar las acciones que desempeña el accesorio de energia
     * el cual es proporcionarle a goku un poder especial
     */
   public void act() 
    {
        
        escenario esc = (escenario)getWorld();
        Actor act =getOneIntersectingObject(Goku.class);
        if(act != null)
        {
            for(int i=1;i<3;i++)
              esc.poder.incrementar();
              
              getWorld().removeObject(this);
        }
    }    
}
