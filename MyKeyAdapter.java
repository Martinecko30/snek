package snake;

import java.awt.event.*;

public class MyKeyAdapter extends KeyAdapter { 

    private int keyCode = KeyEvent.VK_LEFT; 

    @Override 
    public void keyPressed(KeyEvent e) { 
        keyCode = e.getKeyCode(); 
    } public int getKeyCode(){ 
        return keyCode; 
    } 
}