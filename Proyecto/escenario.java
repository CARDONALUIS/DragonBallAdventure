import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;


/**
 * Clase que se encarga de crear o quitar todos los objetos que apareceran en el ecenario principal del juego
 * 
 * @author LECB
 * @version 1.9
 */
public class escenario extends World
{

    
    public lifes objLifes;
    Tablero puntos;
    Tablero vidas;
    Tablero poder;
    Tablero genkidama;
    Tablero hakai;
    BossLifes lifeboss;
    
    /**
     * Constructor de objetos de la clase escenario.
     */
    public escenario()
    {    
        
        super(800, 600, 1);
        setPaintOrder(GameOver.class,Tablero.class,Roca1.class,Goku.class);
        Goku n1 = new Goku();
        addObject(n1,50,300);
        crearRocas(3);
        crearRocas2(2);
        puntos = new Tablero(0,"Puntos: ");
        vidas = new Tablero(5,"Vidas: ");
        poder = new Tablero(0,"KienZan: ");
        genkidama = new Tablero(0,"Genkidama: ");
        hakai = new Tablero(0,"Hakai: ");
        addObject(puntos,100,85);
        addObject(vidas,210,85);
        addObject(poder,310,85);
        addObject(genkidama,440,85);
        addObject(hakai,590,85);
        
    }
    
    /**
     * Metodo que se encarga de crear rocas del tipo Roca1
     * 
     * @param numero Es la cantidad de rocas que se van a crear
     */
    public void crearRocas(int numero)
    {
        for(int i=0;i<numero;i++)
        {
            Roca1 r =new Roca1();
            int x = Greenfoot.getRandomNumber(400);
            int y = Greenfoot.getRandomNumber(400);
            x = x+150;
            y = y+100;
            addObject(r,x,y);
            
        }
    }
    
    /**
     * Metodo que se encarga de crear rocas del tipo Roca2
     * 
     * @param numero Es la cantidad de rocas que se van a crear 
     */
    public void crearRocas2(int numero)
    {
        for(int i=0;i<numero;i++)
        {
            Roca2 r =new Roca2();
            int x = Greenfoot.getRandomNumber(400);
            int y = Greenfoot.getRandomNumber(400);
            x = x+150;
            y = y+100;
            addObject(r,x,y);
            
        }
    }
    
    /**
     * Metodo que crea la estrella dentro del escenario
     * 
     * @param numero Es la cantidad de enerigas que podran aparecer.
     */
    public void crearEnergia(int numero)
    {
        for(int i=0; i<numero;i++)
        {
            Energia e = new Energia();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());
            addObject(e,x,y);
            
        }
    }
    
    /**
     * Metodo que se encarga de poner al primer enemigo o jefe
     */
    public void ponerJefe()
    {
        quitarRocas();
        
        Enemigo boss = new Frezer();
        addObject(boss,getWidth()-80,(getHeight()/2)+20);
        lifeboss = new BossLifes(50,0,0,50);
        addObject(lifeboss,750,85);
    }
    
    /**
     * Metodo que se encarga de poner el segundo enemigo o jefe
     */
    public void ponerJefe2()
    {
        quitarRocas();
        
        Enemigo boss = new Cell();
        addObject(boss,getWidth()-80,(getHeight()/2)+20);
        lifeboss = new BossLifes(75,0,0,50);
        addObject(lifeboss,750,85);
    }
    
    /**
     * Metodo que se encarga de poner el tercer enemigo o jefe
     */
    public void ponerJefe3()
    {
        quitarRocas();
        
        Enemigo boss = new Kidbuu();
        addObject(boss,getWidth()-80,(getHeight()/2)+20);
        lifeboss = new BossLifes(100,0,0,50);
        addObject(lifeboss,750,85);
    }
    
    /**
     * Metodo que se encarga de eliminar todas las rocas del ecenario
     * 
     */
    public void quitarRocas()
    {
        List <Roca1> rocas = getObjects(Roca1.class);
        Iterator i = rocas.iterator();
        while(i.hasNext())
        {
            Roca1 r = (Roca1)i.next();
            removeObject(r);
        } 
        
        List <Roca2> rocas2 = getObjects(Roca2.class);
        Iterator j = rocas2.iterator();
        while(j.hasNext())
        {
            Roca2 r2 = (Roca2)j.next();
            removeObject(r2);
        } 
    }
    
    /**
     * Metodo que se encarga de poner las semillas del ermitaño
     * 
     * @param numero Es la cantidad de semillas que se desean poner
     */
    public void crearSemilla(int numero)
    {
        for(int i=0; i<numero;i++)
        {
            Semilla e = new Semilla();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

             addObject(e,x,y);
            
        }
    }
    
    
    /**
     * Metodo que se encarga de poner la carne 
     * 
     * @param numero Es la cantidad de carne que se va aponer en pantalla
     */
    public void crearCarne(int numero)
    {
        for(int i=0; i<numero;i++)
        {
            Carne e = new Carne();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

             addObject(e,x,y);
            
        }
    }
    
    /**
     * Metodo que se encarga de poner radares del dragon en el escenario
     * 
     * @param numero Es la cantidad de radares a insertar
     */
    public void crearRadar(int numero)
    {
        for(int i=0; i<numero;i++)
        {
            Radar e = new Radar();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            addObject(e,x,y);
        }
    }
    
    /**
     * Metodo que se encarga de poner esferas del dragon en el escenario
     * 
     * @param numero Es la cantidad de esferas a insertar
     */
    public void crearEsfera(int numero)
    {
        for(int i=0; i<numero;i++)
        {
            Esfera e = new Esfera();
            int x = Greenfoot.getRandomNumber(getWidth());
            int y = Greenfoot.getRandomNumber(getHeight());

            addObject(e,x,y);
        }
    }
    
    
    
}
