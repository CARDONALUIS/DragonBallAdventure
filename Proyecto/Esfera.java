import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de mantener los metodos que hara el accesorio esfera del dragon
 * 
 * @author LECB
 * @version 1.9
 */
public class Esfera extends Accesorio
{
    /**
     * Metodo que se encarga de incremetar el poder de la genkidama cada que goku intersecte con ella
     */
    public void act() 
    {
        escenario esc = (escenario)getWorld();
        Actor act =getOneIntersectingObject(Goku.class);
        if(act != null)
        {
              esc.genkidama.incrementar();
              
              getWorld().removeObject(this);
        }
    }    
}
