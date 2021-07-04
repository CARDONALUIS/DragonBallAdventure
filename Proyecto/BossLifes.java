import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que se encarga de alojar los metodos que se encargaran de manipular la vida del enemigo
 * 
 * @author LECB
 * @version 1.9
 */
public class BossLifes extends Actor
{
    GreenfootImage imagen;
    int cont;
    String mensaje;
    int x,y;
    int height;
    int contenedor;
    
    /**
     * Metodo que se encarga de haser el recuadro de vida para el enemigo
     * 
     * @param c Es la cantidad de vida inicial del enemigo
     * @param x Es la poscion en x del recuadro que se realizara
     * @param y Es la posicion en y del reacuadro a raizar
     * 
     */
    public BossLifes(int c, int x, int y, int height)
    {
        cont = c;
        contenedor =c;
        imagen = new GreenfootImage(250,150);
        imagen.setColor(new Color(200,200,0,255));
        imagen.setFont(new Font("Verdana",false,false,24));
        this.x = x;
        this.y = y;
        this.height = height;
        dibuja();
    }
    
    /**
     * Metodo que se encarga de imprimir en pantalla el recuadro de las vidas del enemigo
     */
    public void dibuja()
    {
        imagen.clear();
        imagen.setColor(new Color(200,200,0,255));
        imagen.drawRect(x,y,contenedor,height);
        imagen.fillRect(x,y,cont,height);
        imagen.setColor(new Color(255,255,255,255));
        imagen.drawString(String.valueOf(cont),25,19);
        setImage(imagen);
        
    }
    
    /**
     * Metodo que se encarga de decrementar la vida del enemigo 
     */
    public void decrementa()
    {
        cont--;
        dibuja();
    }
    
    
    /**
     * Metodo que se encarga de obtener el valor actual de vida del enemigo
     */
    public int obtenerValor()
    {
        return cont;
    }
    
    public void act() 
    {
        // Add your action code here.
    }    
}
