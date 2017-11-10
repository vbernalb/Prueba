/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegacasasalvo;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author familia
 */
public class Personaje implements KeyListener{
        private int y;
        private int yi2;
        private int yc; //variable de copia
        private int x;
    
        public Personaje(){
            this.yi2 = 0;
            this.y = 200;
            this.yc = 200;
            this. x = 0;

        }

    public int getX() {
        return x;
    }

    public void moverx (int tiempo){ //Mueve al personaje en X
        if(tiempo>5000 && this.x<200){
            this.x += 1;
        }
        if(tiempo>15000 && this.x<400){
            this.x += 1;
        }
        if(tiempo>20000 && this.x<600){
            this.x += 1;
        }
        if(tiempo>23000 && this.x<750){
            this.x += 1;
        }
    }
    
        public void mover(){ //Mueve al personaje en Y
            int a = yc+=yi2;
            if((a>0)&&(a<568)){
                y+=yi2;    
                yc=y;
            }
        }   

            
        @Override
        public void keyPressed (KeyEvent e){ //Cuando se oprime la tecla
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
                this.yi2 =- 10;

        }
        if(key == KeyEvent.VK_DOWN){
                this.yi2 = 10;
        }
    }
    
        @Override
    public void keyReleased (KeyEvent e){ // Cuando se suelta la tecla
        int key = e.getKeyCode();
        if(key == KeyEvent.VK_UP){
                this.yi2 = 0;
        }
        if(key == KeyEvent.VK_DOWN){
                this.yi2 = 0;
        }
            
    }

    public int getY() {
        return y;
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
