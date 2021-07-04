import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga tener el metodo de vidas para goku
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class lifes extends Actor
{
   
    int c ;
    
    public lifes()
    {
        
    }
    
    /**
     * Metodo que se encarga de disminuir las vidad de goku y si llegan a cero se detiene el juego
     */
    public void Disminuir() 
    {
        
        c--;
        if(c==0)
        {
         Greenfoot.stop();   
        }
    }    
}
