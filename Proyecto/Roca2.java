import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de alojar los metodos que realiza la roca en el escenario
 * 
 * @author LECB
 * @version 1.9
 */
public class Roca2 extends Obstaculo
{
    /**
     * Metodo que se encarga de realizar los movimientos de la roca cada que toquen el limite de la pantalla y saber si se intersecto con goku
     */
    public void act() 
    {
        move(2);
        World m = getWorld();
        if(getX()>=m.getWidth()-10||getX()<=10)
        {
           turn(180);
        }
        
        if(getY()>=m.getHeight()-10||getY()<=10)
        {
           turn(180);
           
        }
        
        InterGoku();
 
    }     
}
