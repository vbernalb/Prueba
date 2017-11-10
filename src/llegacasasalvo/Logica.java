/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegacasasalvo;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author familia
 */
public class Logica {
    
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
       public int numeroA (){ // Genera valor aleatorio para imagen
         int valorEntero = (int) Math.floor(Math.random()*(5));
        return valorEntero;
    }
    
    public int numeroB (){ //Genera valor aleatorio para posicion
         int valorEntero = (int) Math.floor(Math.random()*(3));
        return valorEntero;
    }
    
    public int Pos (int a){ //Centra los personajes
        if(a==0){
            return (a*200)+28;
        }else if(a==1){
            return (a*200)+80;
        }else{
            return (a*200)+125;
        }
    }
    

}
