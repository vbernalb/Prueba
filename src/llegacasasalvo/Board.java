/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegacasasalvo;


import Aleatorio.Aleatorio;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


/**
 *
 * @author DANNA
 */
public class Board extends JPanel implements ActionListener {
    
    
    private Personaje personaje;
    private Logica logica;
    private int secuencia;
    private Timer timer;
    private int cont;
    private int ac;
    private ArrayList<Integer> coo;
    private ArrayList<Integer> pos;
    private ArrayList<Integer> img;
    private int mv;
        
    

    public Board() {
        
        this.mv = 0;
        this.personaje = new Personaje();
        this.logica = new Logica();
        this.secuencia=0;
        this.timer = new Timer(10, this);
        this.cont =0;
        this.ac =0;
        this.coo = new ArrayList();
        this.pos = new ArrayList();
        this.img = new ArrayList();
        setFocusable(true);
        addKeyListener(new Teclado());
        
        this.timer.start(); 
    }
    
    public Image loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
    
 
    


    public void pinta (Graphics g, int coo, int posicion, int imagen){
        
        Image man = loadImage("man3.jpg");
        g.drawImage(man,personaje.getX(),personaje.getY() ,personaje.getX()+200, personaje.getY()+200 ,0,0,200, 200, this);
        g.setColor(Color.red);
        g.drawRect(personaje.getX(),personaje.getY(),200,200);
        Rectangle man1 = new Rectangle(personaje.getX(),personaje.getY(),200,200);
        int P = logica.Pos(posicion);
        if (imagen==0){
            Image ladron = loadImage("thie sprit.jpg");
            g.drawImage(ladron, coo , P,coo-200, P+200,0,0,200, 200, this);
            g.drawRect(coo-200,P,200,200);
            Rectangle ladronR = new Rectangle(coo-200,P,200,200);
            if(man1.intersects(ladronR)){
                g.setColor(Color.yellow);  //AQUI ESTOY TRATANDO DE CAMBIAR EL COLOR :C
                g.drawString("¡Oh no, te han robado!", 630, 360);
                this.timer.stop();
        }
        }if (imagen==1){
            Image mierda = loadImage("mierda.jpeg");
            g.drawImage(mierda, coo ,P,coo-200, P+200,0,0,200, 200, this);
            g.drawRect(coo-200,P,200,200);
            Rectangle mierdaR = new Rectangle(coo-200,P,200,200);
            if(man1.intersects(mierdaR)){
                this.timer.stop();
            }
        }if(imagen==2){
            Image hueco = loadImage("hueco.jpg");
            g.drawImage(hueco, coo , P,coo-200,P+200,0,0,200, 200, this);
            g.drawRect(coo-200,P,200,200);
            Rectangle huecoR = new Rectangle(coo-200,P,200,200);
            if(man1.intersects(huecoR)){
                this.timer.stop();
            }
        }if(imagen==3){
            Image rata = loadImage("Rata.jpg");
            g.drawImage(rata, coo , P,coo-200,P+200,0,0,200, 200, this);
            g.drawRect(coo-200,P,200,200);
            Rectangle rataR = new Rectangle(coo-200,P,200,200);
            if(man1.intersects(rataR)){
                this.timer.stop();
            }     
        }if (imagen==4){
            Image alcantarilla = loadImage("alcantarilla.jpg");
            g.drawImage(alcantarilla, coo , P,coo-200,P+200,0,0,200, 200, this);
            g.drawRect(coo-200,P,200,200);
            Rectangle alcantarillaR = new Rectangle(coo-200,P,200,200);
            if(man1.intersects(alcantarillaR)){
                this.timer.stop();
            }
        }
        
    }
    
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
        
        Image calle= loadImage("Calle.jpg");
        g.drawImage(calle, 0, 0,1362, 768 , 0, 0, 1362, 768, this);
            for(int i=0; i<ac; i++){
                pinta(g, coo.get(i), pos.get(i), img.get(i));
            }
            
        }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        this.cont +=10;
        if(this.cont%1000==0){
            this.cont=0;
            this.ac ++;
            this.coo.add(1542); //Coordenada final en X
            this.img.add(logica.numeroA()); // Valor aleatorio para imagen
            this.pos.add(logica.numeroB()); // Valor aleatorio para posicion
        }

        int a = 0;
        for (int i =0; i<ac; i++) {
            a = coo.get(i)-5;
            if(a<0){ // Elimina la imagen del arraylist cuando sale de la pantalla
                coo.remove(i); 
                img.remove(i);
                pos.remove(i);
                ac--;
            }else{
                coo.set(i,a);                
            }
        }
        
        this.mv += 10;
        personaje.moverx(this.mv); // Mueve en X cada determinado tiempo
        personaje.mover(); //Mueve en y 
        repaint(); 
    }

    
    private class Teclado extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            personaje.keyPressed(e);
        }
        
         public void keyReleased(KeyEvent e){
            personaje.keyReleased(e);
        }
        
    }
    
    
    
}
