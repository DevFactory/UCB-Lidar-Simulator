package atmosphere;


import atmosphere.gui.GraphicsConfiguration;

/**
 * Created by Oscar on 6/24/15.
 */
public class MyMain {
    public static void main(String[] args){
        System.setProperty("user.language", "es");
        System.setProperty("user.country", "ES");
        System.out.println("-Duser.language=es -Duser.country=ES");
        
        new GraphicsConfiguration();
    }
}
