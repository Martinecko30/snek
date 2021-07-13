package snake;

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList; 
import java.util.Random;

public class Game {

    public static int WIDTH = 500; 
    public static int HEIGHT = 500; 
    public static Color COLOR = Color.BLUE; 
    private String direction = "left"; 
    private Random random = new Random(); 
    private ArrayList<Point> snake = new ArrayList<>(); 
    private Point fruit = new Point(150, 150); 
    private boolean fruitTaken = false; 
    private int score = 0;

    private Point createFruit(){
        fruit = new Point(random.nextInt(49) * 10, random.nextInt(49) * 10);
        return fruit;
    }
    public Game(){
        snake.add(new Point(200,250));
        snake.add(new Point(210,250));
        snake.add(new Point(220,250));
        snake.add(new Point(230,250));
        snake.add(new Point(240,250));
    } 
    public void move(int keyCode){
        snake.remove(0);
        Point hlava = snake.get(snake.size() - 1);
        switch (keyCode) {
            case 37:
                direction = "vlavo";
                snake.add(new snake.Point(hlava.getX()-10, hlava.getY()));
                break;
            case 38:
                direction = "hore";
                snake.add(new snake.Point(hlava.getX(), hlava.getY()-10));
                break;
            case 39:
                direction = "vpravo";
                snake.add(new snake.Point(hlava.getX()+10, hlava.getY()));
                break;
            case 40:
                direction = "dole";
                snake.add(new snake.Point(hlava.getX(), hlava.getY()+10));
                break;
            default:
                direction = "vpravo";
                break;
        }
    } 
    public void takeFruit(){ 
        Point hlava = snake.get(snake.size() - 1);
        if (hlava.getX()==fruit.getX()&&hlava.getY()==fruit.getY()) {
            createFruit();
            score++;
        }
    } 
    public boolean gameOver(){
        Point hlava = snake.get(snake.size() - 1);
        int hlavaX = hlava.getX();
        int hlavaY = hlava.getY();
        if (hlavaX>500||hlavaX<0||hlavaY>500||hlavaY<0) {
            return true;
        } else {
            return false;
        }
    } 
    public void drawSnake(Graphics g){ 
        //TODO
        for(Point snek : snake){
            g.fillRect(snek.getX(), snek.getY(), 10, 10);
        }
    } 
    public void drawFruit(Graphics g){ 
        g.setColor(COLOR.RED);
        g.fillOval(fruit.getX(), fruit.getY(), 10, 10);
    } 

    public void drawScore(Graphics g){
        String s=String.valueOf(score);
        Font font = new Font("Calibri", Font.PLAIN, 30);
        g.setFont(font);
        g.setColor(COLOR.BLACK);
        g.drawString(s, 1, 20);
    }
}