package snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener { 
    private Game game; 
    private Timer timer = new Timer(100, this); 
    private MyKeyAdapter keyAdapter = new MyKeyAdapter(); 

    public MyPanel(Game game) { 
        this.game = game; 
        setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT)); 
        setFocusable(true); 
        addKeyListener(keyAdapter); 
        timer.start(); 
    } 

    @Override 
    public void actionPerformed(ActionEvent e){
        int keyCode = keyAdapter.getKeyCode();
        game.move(keyCode);
        
        if(game.gameOver()==false){
            repaint();
        } else if (game.gameOver()==true){
            timer.stop();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); 
        g.setColor(Game.COLOR); 
        game.drawSnake(g); 
        game.takeFruit(); 
        game.drawFruit(g);
        game.drawScore(g);
    }
}