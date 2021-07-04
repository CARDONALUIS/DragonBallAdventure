import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de crear objeto de tipo Gameover
 * 
 * @author LECB
 * @version 1.9
 */
public class GameOver extends Actor
{
    GreenfootImage imagen;
    String mensaje;
    
    /**
     * Metodo que se encarga de poner el mensaje de juego terminado
     */
    public GameOver()
    {
        imagen = new GreenfootImage(400,200);
        imagen.setColor(new Color(250,100,0,255));
        imagen.setFont(new Font("Verdana",true,true,24));
        imagen.drawString("Juego Terminado",70,20);
        setImage(imagen);
        Greenfoot.stop();
        
        
    }
    
    
    public void act() 
    {

    }    
}
