import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de establecer un menu prinicpal
 * 
 * @author LECB 
 * @version 1.9
 */
public class MenuPrincipal extends World
{
    /**
     * Constructor de objetos de la clase MenuPrincipal.
     * 
     */
    public MenuPrincipal()
    {     
        super(800, 600, 1); 
    }
    
    /**
     * Metodo que pone la pantalla prinicpal y espera a que se preciona enter para comenzar el juego
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld(new escenario());
        }
        
    }
}
