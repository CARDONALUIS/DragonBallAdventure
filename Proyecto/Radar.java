import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de tener y ejecutar los metodos de radar
 * 
 * @author LECB 
 * @version 1.9
 */
public class Radar extends Accesorio
{
    /**
     * Metodo que se encaraga de ejcutar las acciones que desempeña el radar, el cuales es de 
     * incrementar el poder especial llamado hakai
     * 
     */
    public void act() 
    {
        escenario esc = (escenario)getWorld();
        Actor act =getOneIntersectingObject(Goku.class);
        if(act != null)
        {
            for(int i=1;i<5;i++)
              esc.hakai.incrementar();
              
              getWorld().removeObject(this);
        }
    }    
}
