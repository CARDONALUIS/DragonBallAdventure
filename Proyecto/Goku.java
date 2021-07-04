import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Clase que se encarga de alojar los metodos de ejecucion de Goku
 * 
 * @author LECB
 * @version 1.9
 */
public class Goku extends Actor
{
    public static final int UP = 0;
    public static final int DOWN = 1;
    public static final int LEFTH = 2;
    public static final int RIGHT = 3;
    
    GreenfootImage p0, p1, p2, p3, p4;
    int directionShot = 2;
    boolean isShot = false;
    boolean isEspecial = false;
    boolean isEspecial2 = false;
    boolean isEspecial3 = false;
  
   
    public void Goku()
    {
        
    }
    
    /**
     * Metodo que se encarga de redireccionar de posicion de goku cada que 
     * precione una tecla de las de direccion del teclado
     */
    public void act() 
    {
        p0 = new GreenfootImage("GokuEsta.png");
        setImage(p0);
        if(Greenfoot.isKeyDown("up"))
        {
            setDireccion(UP);
            
            directionShot = 0;
        }
        
        if(Greenfoot.isKeyDown("down"))
        {
            
            setDireccion(DOWN);
            directionShot = 1;
        }
        
        if(Greenfoot.isKeyDown("left"))
        {
            setDireccion(LEFTH);
            directionShot = 3;
        }
        
        if(Greenfoot.isKeyDown("right"))
        {
            setDireccion(RIGHT);
            directionShot = 2;
        }
       
        setShot(directionShot);
    } 
    
    
    /**
     * Metodo que se encarga de detectar que teclas se preciono para disparar el poder especial respectivo
     *
     *@param direction Es la direccion a la que va a ir dirigido el disparo
     */
    public void setShot(int direction)
    {
        if(isShot && Greenfoot.isKeyDown("z"))
        {
            dispaDire(direction);
            
            shot s1 = new shot(direction);
            getWorld().addObject(s1,getX(),getY());
            isShot = false;
        }
        
        if(!isShot && !Greenfoot.isKeyDown("z"))
        {
         isShot = true;   
        }
        
     
        
        if(isEspecial && Greenfoot.isKeyDown("x"))
        {
            escenario esc= (escenario)getWorld();
            if(esc.hakai.obtenerValor()>0)
            {
                dispaDire(direction);
                Hakai s1 = new Hakai(direction);
                getWorld().addObject(s1,getX(),getY());
                isEspecial = false;
                esc.hakai.decrementar();
             
            }
        }
        
        
        if(isEspecial2 && Greenfoot.isKeyDown("c"))
        {
            escenario esc= (escenario)getWorld();
            if(esc.poder.obtenerValor()>0)
            {
                dispaDire(direction);
                Poder s1 = new Poder(direction);
                getWorld().addObject(s1,getX(),getY());
                isEspecial2 = false;
                esc.poder.decrementar();
                
            }
        }
        
        if(isEspecial3 && Greenfoot.isKeyDown("v"))
        {
            escenario esc= (escenario)getWorld();
            if(esc.genkidama.obtenerValor()>0)
            {
                dispaDire(direction);
                Genkidama s1 = new Genkidama(direction);
                getWorld().addObject(s1,getX(),getY());
                isEspecial3 = false;
                esc.genkidama.decrementar();
                
            }
        }
        
        
        if(!isEspecial && !Greenfoot.isKeyDown("x"))
        {
            isEspecial=true;
        }
        
        if(!isEspecial2 && !Greenfoot.isKeyDown("c"))
        {
            isEspecial2 = true;
        }
        
        if(!isEspecial3 && !Greenfoot.isKeyDown("v"))
        {
            isEspecial3 = true;
        }
            
        
    }
    
    /**
     * Metodo que se encarga de poner la imagen respectiva depende de la direccion que recibe
     *
     *@param disDir En en base a la direccion que recibio y se pondar la respectiva imagen dada la que recibe
     */
    public void dispaDire(int disDir)
    {
        switch(disDir)
            {
                case 0:
                 setImage(new GreenfootImage("GokuArr.png"));
                 break;
                case 1:
                setImage(new GreenfootImage("GokuAba.png"));
                 break;
                 case 2:
                 setImage(new GreenfootImage("GokuFin.png"));
                 break;
                 case 3:
                 setImage(new GreenfootImage("GokuIzq.png"));
                 break;
            }
    }
    
    
    /**
     * Metodo que se encarga de cambiar de imagen y volar segun la direccion que
     * 
     * @param direccion En base a esta parametro el cual hara que se mueva y ponga la imagen respectiva
     */
    public void setDireccion(int direccion)
    {
           p1 = new GreenfootImage("GokuFin.png");//derecha
           p2 = new GreenfootImage("GokuIzq.png");
           p3 = new GreenfootImage("GokuAba.png");
           p4 = new GreenfootImage("GokuArr.png");
           switch(direccion)
           {
            case UP:
             setImage(p4);

             if(Greenfoot.isKeyDown("space"))
                setLocation(getX(),getY()-10);
             else
                setLocation(getX(),getY()-1);
             break;
            case DOWN:
            setImage(p3);

            if(Greenfoot.isKeyDown("space"))
              setLocation(getX(),getY()+10);
            else
              setLocation(getX(),getY()+1);
             break;
            case LEFTH:

             setImage(p2);
             if(Greenfoot.isKeyDown("space"))
              setLocation(getX()-10,getY());
            else
              setLocation(getX()-1,getY());
             break;
            case RIGHT:
            setImage(p1);

             if(Greenfoot.isKeyDown("space"))
              setLocation(getX()+10,getY());
            else
              setLocation(getX()+1,getY());
              break;
           }
    }
}
