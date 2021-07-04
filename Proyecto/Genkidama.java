import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de contener los metodos que realizara el poder especial llamado genkidama
 * 
 * @author LECB
 * @version 1.9
 */
public class Genkidama extends PoderEspecial
{
    int shotImage = 1;
    int speedShot = 4;
    int position;
    
    /**
     * Metodo que se encarga de saber a que direccion va a dirigirse el poder especial
     * 
     * @param direction Es un paramtero el cual servira para identificar a que direccion saldra el poder especial
     */
    public Genkidama(int direction)
    {
     position = direction;    
    }
    
    /**
     * Metoodo que se encarga de ejecutar lo que realizara el poder especial cuando aparesca el cual sera que detecte las intersecciones
     * con los diferentes objetos del juego 
     */
    public void act() 
    {

        setImage("Genkidama.png");
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
        interBossGenkidama();
        else
        limitPoder();
     } 
     
     /**
      * Este metodo se encarga de reducir en cierta cantidad la vida del enemigo y que si llega a cero se elimine
      */
      public void interBossGenkidama()
    {
        escenario esp = (escenario)getWorld();
        Frezer boss  =(Frezer)getOneIntersectingObject(Frezer.class);
        Cell boss2 = (Cell)getOneIntersectingObject(Cell.class);
        Kidbuu boss3 = (Kidbuu)getOneIntersectingObject(Kidbuu.class);
            
        for(int i = 0; i<10; i++)
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
