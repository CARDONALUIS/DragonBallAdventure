import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Clase que se encarga de tener los metodos del disparo que realiza el goku
 * 
 * @author LECB
 * @version 1.9
 */
public class shot extends Actor
{
    
    
    
    int speedShot = 6;
    int position;
    GreenfootImage p1;
    
   
    /**
     * Metodo que se encarga de dar a la variable position la direccion a la cual esta apuntado goku
     * 
     * @param direction Es la direccion de goku en el momento que se manda llamar el metodo
     */
    public shot(int direction)
    {
        position = direction;
    }
    
    /**
     * Metodo que se ejecuta cuando esta en ejeccion goku el cual mantiene el movimiento y las intersecciones de 
     * los objetos a los que les dispara
     */
    public void act() 
    {
        
        
        switch(position)
        {
            
            case 0:
                  setLocation(getX(),getY()-speedShot);
                  break;
            case 1: 
                  setLocation(getX(),getY()+speedShot);
                  break;
            case 2:
                   setLocation(getX()+speedShot,getY());
                  break;      
            case 3:
                   setLocation(getX()-speedShot,getY());
                  break;
        }
        
        Actor roca = getOneObjectAtOffset(0,0,Roca1.class);
        Actor roca2 = getOneObjectAtOffset(0,0,Roca2.class);
        
        Frezer boss  =(Frezer)getOneIntersectingObject(Frezer.class);
        Cell boss2 = (Cell)getOneIntersectingObject(Cell.class);
        Kidbuu boss3 = (Kidbuu)getOneIntersectingObject(Kidbuu.class);
        if(roca != null || roca2 != null)
        {
            
            interRocas();
          
        }
        else if(boss != null || boss2 != null || boss3 != null)
        {
            interBoss();
           
        }
        else
        {
            limiteShot();
            
        }
        
        
    }   
    
    /**
     * Metod que se encarga de saber si un disparo ha superado el limite de la pantalla para que desaparesca
     */
    public void limiteShot()
    {
       if(getX()>=getWorld().getWidth()-5||(getX() <= 5))
            {
                getWorld().removeObject(this);
            }
            else
            {
                if(getY ()>=getWorld().getHeight()-5 || (getY()<=5))
            
                {
                    getWorld().removeObject(this);    
                }    
            }     
    }
     
   /**
    * Metodo que se encarga de ejecutar mas metodos para los cuales se desencadenan apartir de la cantidad de puntos que obtengas
    */
    public void interRocas()
    {
         Actor roca = getOneObjectAtOffset(0,0,Roca1.class);
         Actor roca2 = getOneObjectAtOffset(0,0,Roca2.class);
         
         escenario esp =(escenario)getWorld();
        
         esp.puntos.incrementar();
         if(roca != null)
         {
            esp.crearRocas(1);
            getWorld().removeObject(roca);
            
            
         }
         else
         {
           esp.crearRocas2(1);
           getWorld().removeObject(roca2);
         }
          
         
         if(esp.puntos.obtenerValor() == 10)
         {
            esp.ponerJefe();
         }
         
         if(esp.puntos.obtenerValor() == 20)
         {
            esp.ponerJefe2();
         }
         
         if(esp.puntos.obtenerValor() == 30)
         {
            esp.ponerJefe3();
         }
         
         if(esp.puntos.obtenerValor() %2== 0)
         {
            
            esp.crearEnergia(1);
            
            
         }
         
         if(esp.puntos.obtenerValor() %4== 0)
         {
            esp.crearSemilla(1);
         }
         
         if(esp.puntos.obtenerValor() %3== 0)
         {
            esp.crearCarne(1);
         }
         
         if(esp.puntos.obtenerValor() %5== 0)
         {
            esp.crearRadar(1);
         }
         
         if(esp.puntos.obtenerValor() %6== 0)
         {
            esp.crearEsfera(1);
         }
         
         
         
         esp.removeObject(this);
    }
    
    /**
     * Metodo que se encarga de decrementar vidas en el enemigo cada que se le dispare y tambien removerlo 
     * cada que sus puntos de vidas bajen a cero
     */
    public void interBoss()
    {
        escenario esp = (escenario)getWorld();
        Frezer boss  =(Frezer)getOneIntersectingObject(Frezer.class);
        Cell boss2 = (Cell)getOneIntersectingObject(Cell.class);
        Kidbuu boss3 = (Kidbuu)getOneIntersectingObject(Kidbuu.class);
            
        esp.lifeboss.decrementa();
        if(esp.lifeboss.obtenerValor() == 0)
            {
                esp.removeObject(boss);
                esp.removeObject(boss2);
                esp.removeObject(boss3);
                esp.crearRocas(3);
                esp.crearRocas2(2);
                esp.vidas.incrementar();
                esp.removeObject(esp.lifeboss);
                if(esp.puntos.obtenerValor() >= 30 )
                {
                  GameOver t = new GameOver();
                  getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
                }
            }
            esp.removeObject(this); 
    }
    
}