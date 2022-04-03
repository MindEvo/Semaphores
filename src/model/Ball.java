package model;

import java.awt.*;
import java.util.concurrent.Semaphore;

import javax.swing.*;

class Ball extends Thread {
	Semaphore semap;
	int x;
	int y;
	Color c;
	BallWindow bWindow;
	int sleepTime;
	
	public Ball (int x, int y, Color c, BallWindow bWindow, int sleepTime, Semaphore semap) {
		super();
		this.x = x;
		this.y = y;
		this.c = c;
		this.bWindow = bWindow;
		this.sleepTime = sleepTime;
		this.semap = semap;
	}
	
	public void run() {
		try {
			semap.acquire();
		} catch (Exception e1) {}

		while (true) {
			bWindow.repaint();
			y = y + 10;
			
			try {
				sleep(sleepTime);
			} catch (Exception e) {}
			
			if (y > 550) break;
			
		}
		
		semap.release();
	
	}
	
	public void draw(Graphics g) {
		Color bc = bWindow.getBackground();
		g.setColor(bc);
		g.fillOval(x, y - 10, 50, 50);
		
		g.setColor(c);
		g.fillOval(x, y, 50, 50);
	}
	
}
