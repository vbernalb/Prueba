/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package llegacasasalvo;

import javax.swing.JFrame;

/**
 *
 * @author DANNA
 */
public class LlegaCasaSalvo extends JFrame{
    
    private void initUI(){
        add(new Board());
        setSize(1362,768);
        setTitle("Calle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public LlegaCasaSalvo(){
        initUI();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LlegaCasaSalvo ex = new LlegaCasaSalvo();
        ex.setVisible(true);
    }
    
}
