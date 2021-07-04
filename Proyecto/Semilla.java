import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que crea objetos del tipo bonificacion las cuales son semillas del ermitaño
 * 
 * @author LECB
 * @version 1.9
 */
public class Semilla extends Bonificacion
{
    /**
     * Metodo que se encarga de realizar acciones cada que aparece la semilla las cuales son 
     * que si goku las intersecta aumente en 3 su vida actual y tambien remover el objeto semilla
     */
    public void act() 
    {
        // Add your action code here.
        escenario esc = (escenario)getWorld();
        Actor act =getOneIntersectingObject(Goku.class);
        if(act != null)
        {
            for(int i=1;i<3;i++)
              esc.vidas.incrementar();
              
              getWorld().removeObject(this);
        }    
    }    
}
