import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Esta clase se encarga de poner los marcadores en la pantalla superior 
 * 
 * @author LECB
 * @version 1.9
 */
public class Tablero extends Actor
{
    GreenfootImage imagen;
    int cont;
    String mensaje;
    
    /**
     * Metodoo  que se encarga de crear el mensaje de cada tipo de puntaje 
     * 
     * @param c Es la cantidad que se va a añadir desde un inicio del llamado del metodo
     * @param msj Es el mensaje que se va imprimir en pantalla
     */
    public Tablero (int c, String msj)
    {
      cont = c;
      mensaje = msj;
      imagen = new GreenfootImage(250,150);
      imagen.setColor(new Color(200,200,0,255));
      imagen.setFont(new Font("Verdana",false ,false ,20));
      
      dibuja();
      
      
    }
    
    /**
     * Metodo que se encarga con de limpiar la pantalla y despues con la funcion establecidad pone el mensaje
     */
    public void dibuja()
    {
        imagen.clear();
        imagen.drawString(mensaje+cont,30,30);
        
        setImage(imagen);
    }
    
    
    /**
     * Metodo que se encarga de incrementar en uno el digito o contador del puntaje del mensaje
     */
    public void incrementar()
    {
        cont ++;
        
        dibuja();
    }
    
    /**
     * Metodo que se encarga de decrementar en uno el digito o contador del puntaje del mensaje
     */
    public void decrementar()
    {
      cont --;
      
      dibuja();      
    }
    
    /**
     * Metodo que se encarga de obtener el valor numerico el cual tiene un cierto puntaje
     */
    public int obtenerValor()
    {
        return cont;
    }
    
    
    public void act()
    {
        
    }
}
