package com.game.src.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
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
	private BufferedImage background_5 = null;
	private BufferedImage background_win = null;
	
	
	public static Player p;
	public static boolean two_player = false;
	//public static boolean active = true; 
	private Controller c;
	private P_Mode p_mode;
	private Menu menu;
	private Health h;
	private Death death;
	private Record record;
	private Prepare prepare;
	private Explain explain;
	private Enemy enemy;
	private Win win;
	
	private int passtime = 0;
	private boolean shoot_lock = false;
	
	public LinkedList<String> full_record =  new LinkedList<String>();
	
	public static enum STATE{
		Choose_Mode,
		MENU,
		HELP,
		GAME,
		DEATH,
		PREPARE,
		RESTART,
		RECORD,
		WIN
	};
	public static STATE state = STATE.Choose_Mode;
	
	
	public void init() {
		requestFocus();	//Don't need to press window
		BufferedImageLoader loader = new BufferedImageLoader();
		try {
			spriteSheet = loader.loadImage("/man.png");
			background_1 = loader.loadImage("/background4.png");
			background_2 = loader.loadImage("/background2.png");
			background_3 = loader.loadImage("/background3.png");
			background_4 = loader.loadImage("/record.png");
			background_5 = loader.loadImage("/background1.png");
			background_win = loader.loadImage("/win.png");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		this.addKeyListener(new KeyInput(this));
		this.addMouseListener(new MouseInput());
		
		p = new Player(200,200,this);
		c = new Controller(this);
		c.addStair(new Stair(p.getX()-32, p.getY()+64, this));
		p_mode = new P_Mode();
		menu = new Menu();
		h = new Health(this);
		death = new Death(this, p);
		record = new Record();
		prepare = new Prepare(p);
		explain = new Explain();
		enemy = new Enemy(this);
		win = new Win();
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
			if(two_player == true) {
				enemy.tick(p, h);
			}
		}else if(state == STATE.DEATH) {
			death.tick(this, p);
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
			if(two_player == true) {
				enemy.render(g);
			}
			
		}else if(state == STATE.Choose_Mode) {
			g.drawImage(background_2,0,0,null);
			p_mode.render(g);
		}else if(state == STATE.MENU) {
			g.drawImage(background_2,0,0,null);
			menu.render(g);
		}else if(state == STATE.HELP) {
			g.drawImage(background_5,0,0,null);
			explain.render(g);
		}else if(state == STATE.DEATH) {
			g.drawImage(background_3,0,0,null);	
			death.render(g);
			enemy.removeAllBullet();
		}else if(state == STATE.PREPARE) {
			g.drawImage(background_1,0,0,null);	
			prepare.render(g);
		}else if(state == STATE.RESTART) {
			h.setHealth(100);
			
			p.setX(300);
			p.setY(300);
			c.addStair(new Stair(p.getX()-32, p.getY()+64, this));
			
			death.reset_get();
			p.set_current(p.get_initial());
			//record = new Record();
			state = STATE.GAME;
		}else if(state == STATE.RECORD) {
			g.drawImage(background_4,0,0,null);
			record.render(g, p, this);
			
		}else if(state == STATE.WIN) {
			g.drawImage(background_win,0,0,null);
			win.render(g,this);
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
			if(key == KeyEvent.VK_A) {
				enemy.setVelX(-5);
			}else if(key == KeyEvent.VK_D) {
				enemy.setVelX(5);
			}
			if(key == KeyEvent.VK_SPACE && shoot_lock==false) {
				enemy.addBullet(new Bullet(enemy.getX()+23, this));
				shoot_lock = true;
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
			
			int key = e.getKeyCode();
			
			if(key == KeyEvent.VK_RIGHT) {
				p.setVelX(0);
			}else if(key == KeyEvent.VK_LEFT) {
				p.setVelX(0);
			}
			if(key == KeyEvent.VK_SPACE) {
				shoot_lock = false;
			}
			if(key == KeyEvent.VK_A) {
				enemy.setVelX(0);
			}else if(key == KeyEvent.VK_D) {
				enemy.setVelX(0);
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
