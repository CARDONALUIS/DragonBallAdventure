import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Clase que se encarga de alojar los metodos del poder especial llamado Kienzan
 * 
 * @author LECB
 * @version 1.9
 */
public class Poder extends PoderEspecial
{
    int shotImage = 1;
    int speedShot = 4;
    int position;
    
    
    /**
     * Metodo que se encarga de dar la direccion segun como esta en el llamado y produce que el pode
     * se redireccione hasia donde apunta goku
     */
    public Poder(int direction)
    {
     position = direction;    
    }
    
    /**
     * Metodo que se encarga de ejecutar las acciones correspondientes del poder especial, primero determina la
     * posicion a la que se tendra que disparar y tiene la habilidad  de seguir una roca depende del area en donde esta
     * tambien acumula puntos
     */
    public void act() 
    {
        setImage("KienZan.png");
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
            case 3: //Izquierda
                    if(getRotation()!=180)
                       setRotation(180);
                    break;
        }
       
        
        List <Roca1> rocas = getObjectsInRange(200,Roca1.class);
        Iterator it = rocas.iterator();
        if(it.hasNext())
        {
            Roca1 r = (Roca1)it.next();
            if(r != null)
            {
              turnTowards(r.getX(),r.getY());
            }   
        }
        
        List <Roca2> rocas2 = getObjectsInRange(200,Roca2.class);
        Iterator it2 = rocas2.iterator();
        if(it2.hasNext())
        {
            Roca2 r2 = (Roca2)it2.next();
            if(r2 != null)
            {
              turnTowards(r2.getX(),r2.getY());
            }   
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
        interBossPoder();
        else
        limitPoder();
     }
    
     /**
      * Este metodo se encarga de decrementar sierta cantidad de vida al enemigo si este poder lo toca
      * y remover al enemigo si llega a cero
      */
     public void interBossPoder()
    {
        escenario esp = (escenario)getWorld();
        Frezer boss  =(Frezer)getOneIntersectingObject(Frezer.class);
        Cell boss2 = (Cell)getOneIntersectingObject(Cell.class);
        Kidbuu boss3 = (Kidbuu)getOneIntersectingObject(Kidbuu.class);
           
        esp.lifeboss.decrementa();
        if(esp.lifeboss.obtenerValor() < 0)
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


