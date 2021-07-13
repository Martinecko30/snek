package snake;

import javax.swing.*; 

public class MyFrame extends JFrame { 
    public MyFrame(MyPanel myPanel){ 
        setVisible(true); 
        setTitle("Snek");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        add(myPanel); 
        pack(); 
    } 
}