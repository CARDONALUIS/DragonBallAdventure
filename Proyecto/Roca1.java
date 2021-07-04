import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que ser encarga de tener los metodos para los objetos de la clase roca1
 * 
 * @author LECB
 * @version 1.9
 */
public class Roca1 extends Obstaculo
{
    /**
     * Metodo que se encarga de realizar los movimientos de la roca1 y detectar intersecciones con goku
     */
    public void act() 
    {
        
        move(5);
        World m = getWorld();
        if(getX()>=m.getWidth()-10||getX()<=10)
        {
           turn(225);
        }
        
        if(getY()>=m.getHeight()-10||getY()<=10)
        {
           turn(225);
           
        }
        
        InterGoku();
       
        
    }  
}
