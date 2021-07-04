import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de alojar los metodos de  los ataques de los enemigos
 * 
 * @author LECB 
 * @version 1.9
 */
public class BossAtack extends Actor
{
    
    int direccion;
    
    /**
     * Metodo constructor que se encarga de inicilializar la variable de instancia de direccion
     */
    public BossAtack(int dir)
    {
        direccion = dir;
        if(dir == 1)
        turn(0);
        else
        turn(180);
    }
    
    /**
     * Metodo que se ejecuta las acciones contenidas las cuales son de que si el ataque te intersecta te decrementa 1 vida
     * y redirecciona de posision a goku y si le quita el resto de vidas se acaba el juego
     */
    
    public void act() 
    {
        move(4);
        
        Goku go = (Goku)getOneObjectAtOffset(0,0,Goku.class);
        if(go != null)
        {
            escenario esc = (escenario)getWorld();
            getWorld().removeObject(go);
            esc.vidas.decrementar();
            getWorld().addObject(new Goku(),50,300);
            if(esc.vidas.obtenerValor()==0)
            {
                GameOver t = new GameOver();
                getWorld().addObject(t,((getWorld().getWidth()/2)+30),((getWorld().getHeight()/2)+150));
            }
            getWorld().removeObject(this);  
        }
        else
        {
            if((getX() >= getWorld().getWidth()-5)||(getX()<=5))
            {
                getWorld().removeObject(this);
            }
        }
        
    }    
}
