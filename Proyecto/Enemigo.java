import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase padre de los diferentes enemigos que estaran en el juego
 * 
 * 
 * @author LECB
 * @version  1.9
 * 
 */

public abstract class Enemigo extends Actor
{
    /**
     * Metodo que se encarga de hacer los ataques del enemigo cada que se de un numero random
     * 
     */
    public abstract void ataque();
    
    public void act() 
    {
                      
    }
    
    /**
     * Metodo que se encarga de comprobar las vidas de goku.
     * 
     */  
    public void reglas()
    {
        Goku n = (Goku)getOneIntersectingObject(Goku.class);
        if(n!=null)
        {
            escenario esc = (escenario)getWorld();
            esc.removeObject(n);
            esc.addObject(new Goku(),50,300);
            esc.vidas.decrementar();
            if(esc.vidas.obtenerValor() == 0)
            {
                GameOver t =new GameOver();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
                
            }
        }
        
    } 
   
    

}
