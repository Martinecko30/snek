package snake;

import java.awt.*;

public class Snake { 
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> { 
            Game game = new Game(); 
            MyPanel panel = new MyPanel(game); 
            new MyFrame(panel); 
        }); 
    } 
}