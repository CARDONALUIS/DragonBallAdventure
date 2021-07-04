import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


/**
 * Clase para crear objetos del tipo hakai el cual es un poder especial el cual utiliza
 * 
 * @author LECB
 * @version 1.9
 */
public class Hakai extends PoderEspecial
{
    int shotImage = 1;
    int speedShot = 10;
    int position;
    
    /**
     * Metodo que se encarga de direccionar el poder para que se diriga hasia donde apunta goku
     */
    public Hakai(int direction)
    {
     position = direction;    
    }
    
    /**
     * Metodo que se encarga de relaizar las acciones que va a desempeñar un objeto del tipo hakai 
     * el cual sera detectar las intersecciones con los demas objetos
     */
    public void act() 
    {

        setImage("Hakai.png");
        switch(position)
        {
            case 0:
                  if(getRotation()!=270)
                     setRotation(270);
                  break;
            case 1:
                    if(getRotation()!=90)
                       setRotation(90);
                    break;
            case 2:
                    if(getRotation()!=0)
                      setRotation(0);
                    break;
            case 3:
                    if(getRotation()!=180)
                       setRotation(180);
                    break;
        }
       

        move(speedShot);
        Actor roca = getOneObjectAtOffset(0,0,Roca1.class);
        Actor roca2 = getOneObjectAtOffset(0,0,Roca2.class);
        
        Frezer boss  =(Frezer)getOneIntersectingObject(Frezer.class);
        Cell boss2 = (Cell)getOneIntersectingObject(Cell.class);
        Kidbuu boss3 = (Kidbuu)getOneIntersectingObject(Kidbuu.class);
        
        if(roca != null || roca2 != null)
        InterRocas();
        else
        if(boss != null || boss2 != null || boss3 != null)
        interBossHakai();
        else
        limitPoder();
     }
     
     /**
      * Metodo que se encarga de saber si el poder especial intesecto con el enemigo y si es asi 
      * le decrementa cierta cantidad de vida y si llega cero se elimina
      */
     public void interBossHakai()
    {
        escenario esp = (escenario)getWorld();
        Frezer boss  =(Frezer)getOneIntersectingObject(Frezer.class);
        Cell boss2 = (Cell)getOneIntersectingObject(Cell.class);
        Kidbuu boss3 = (Kidbuu)getOneIntersectingObject(Kidbuu.class);
            
        for(int i = 0; i<5; i++)
        esp.lifeboss.decrementa();
        
        if(esp.lifeboss.obtenerValor() < 1)
            {
                esp.removeObject(boss);
                esp.removeObject(boss2);
                esp.removeObject(boss3);
                esp.crearRocas(3);
                esp.crearRocas2(2);
                esp.vidas.incrementar();
                esp.removeObject(esp.lifeboss);
                if(esp.puntos.obtenerValor() == 30 )
                {
                  GameOver t = new GameOver();
                  getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
                }
            }
            esp.removeObject(this); 
    }
} 