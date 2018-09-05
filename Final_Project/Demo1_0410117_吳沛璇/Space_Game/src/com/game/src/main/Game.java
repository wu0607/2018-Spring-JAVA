package com.game.src.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Game extends Canvas implements Runnable{

	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH /9 * 12;
	public static final int SCALE = 2;
	public final String TITLE = "2D NS-SHAFT";
	
	private boolean running = false;
	private Thread thread;
	
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage background_1 = null;
	private BufferedImage background_2 = null;
	private BufferedImage background_3 = null;
	private BufferedImage background_4 = null;

	
	private Player p;
	private Controller c;
	private Menu menu;
	private Health h;
	private Death death;
	private Record record;
	
	private int passtime = 0;
	
	public LinkedList<String> full_record =  new LinkedList<String>();
	
	public static enum STATE{
		MENU,
		GAME,
		DEATH,
		RESTART,
		RECORD
	};
	public static STATE state = STATE.MENU;
	
	
	public void init() {
		requestFocus();	//Don't need to press window
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/man.png");
			background_2 = loader.loadImage("/background2.png");
			background_3 = loader.loadImage("/background3.png");
			background_4 = loader.loadImage("/record.png");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
		
		p = new Player(200,200,this);
		c = new Controller(this);
		c.addStair(new Stair(p.getX()-32, p.getY()+64, this));
		menu = new Menu();
		h = new Health(this);
		death = new Death();
		record = new Record();
		
		
	}
	private synchronized void start() {
		if(running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	private synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try{
			thread.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks = 60.0;
		double ns = 1000000000/amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		
		//this would be the game loop(heart)	
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				updates ++ ;
				delta -- ;
			}
			render();
			frames ++ ;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " Ticks, Fps " + frames);
				passtime += 1;
				System.out.print(" "+passtime+" ");
				updates = 0;
				frames = 0;
			}
			
		}
		stop();
	}
	
	private void tick() {
		if(state == STATE.GAME) {
			p.tick();
			c.tick(p, h, passtime);
		}
	}
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();	//this = Canvas class
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//////////////////////////////////
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		//g.drawImage(background,0,0,null);
		
		if(state == STATE.GAME) {
			//g.drawImage(background,0,0,null);
			p.render(g);
			c.render(g);
			h.render(g);
			
		}else if(state == STATE.MENU) {
			g.drawImage(background_2,0,0,null);
			menu.render(g);
		}else if(state == STATE.DEATH) {
			g.drawImage(background_3,0,0,null);	
			death.render(g);
			
		}else if(state == STATE.RESTART) {
			h.setHealth(100);
			
			//p.set_name(JOptionPane.showInputDialog("Please enter your name"));
			//p.set_current(JOptionPane.showInputDialog("Please enter your current weight"));
			//p.set_initial(p.get_current());
			//p.set_ideal(JOptionPane.showInputDialog("Please enter your ideal weight"));
			p.setX(300);
			p.setY(300);
			c.addStair(new Stair(p.getX()-32, p.getY()+64, this));
			
			record.reset_get();
			state = STATE.GAME;
		}else if(state == STATE.RECORD) {
			g.drawImage(background_4,0,0,null);
			record.render(g, p, this);
		}
		
		//////////////////////////////////
		g.dispose();
		bs.show();
		
	}
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		if(state == STATE.GAME) {
			if(key == KeyEvent.VK_RIGHT) {
				p.setVelX(5);
			}else if(key == KeyEvent.VK_LEFT) {
				p.setVelX(-5);
			}
		}
		//else if(key == KeyEvent.VK_UP) {
		//	p.setVelY(-5);
		//}else if(key == KeyEvent.VK_DOWN) {
		//	p.setVelY(5);
		//}
	}
	public void keyReleased(KeyEvent e) {
		if(state == STATE.GAME) {
			c.addStair(new Stair(Math.random()*550, 840, this));
			
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT) {
				p.setVelX(0);
			}else if(key == KeyEvent.VK_LEFT) {
				p.setVelX(0);
			}
			//else if(key == KeyEvent.VK_UP) {
			//	p.setVelY(0);
			//}
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		game.setMaximumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		game.setMinimumSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		
		JFrame frame = new JFrame(game.TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		game.start();
	}
	
	public BufferedImage getSpriteSheet() {	
		return spriteSheet;
	}
	
}
