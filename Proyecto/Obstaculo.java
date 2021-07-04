import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase padre de los obsatculos que apareseran en el juego
 * 
 * @author LECB
 * @version 1.9
 */
public class Obstaculo extends Actor
{
    public void act() 
    {

    }    
    
    /**
     * Metodo que se encarga de de saber si la roca toco a goku y si es asi entonses le decrementa una vida a goku y si llega a cero mandar llamar a un objeto 
     * para terminar el juego
     */
    public void InterGoku()
    {
        Actor Goku = getOneObjectAtOffset(0,0,Goku.class);
        if(Goku != null)
        {
            escenario esc = (escenario)getWorld();
            getWorld().removeObject(Goku);
            esc.vidas.decrementar();
            getWorld().addObject(new Goku(),50,300);
            if(esc.vidas.obtenerValor() == 0)
            {
                GameOver t = new GameOver();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
                 
            }
            
            esc.quitarRocas();
            esc.crearRocas(3);
            esc.crearRocas2(2);
        }
    }
}
