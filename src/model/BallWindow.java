package model;

import java.awt.Color;
import java.awt.Graphics;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class BallWindow extends JFrame {
	
	Ball[] balls = new Ball[5];
	
	public BallWindow () {
		Semaphore semap = new Semaphore(1);
		balls[0] = new Ball(100,100,Color.red, this,300,semap);
		balls[1] = new Ball(200,100,Color.yellow, this,200,semap);
		balls[2] = new Ball(300,100,Color.blue, this,400,semap);
		balls[3] = new Ball(400,100,Color.green, this,100,semap);
		balls[4] = new Ball(500,100,Color.cyan, this,120,semap);

		for (int i = 0; i< 5; i++) balls[i].start();
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600,700);
		this.setVisible(true);
	}
	
	public void paint(Graphics g) {
		for (int j=0 ; j<5 ; j++) balls[j].draw(g);
	}
	
}
