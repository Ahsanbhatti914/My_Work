package SnakeGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener , KeyListener{

	ImageIcon snakeTitle;
	ImageIcon upMouth;
	ImageIcon downMouth;
	ImageIcon leftMouth;
	ImageIcon rightMouth;
	ImageIcon snakeBody;
	ImageIcon dot;
	
	boolean left;
	boolean right;
	boolean up;
	boolean down;
	boolean move;
	boolean gameOver;
	
	int [] snakeXposition = new int[750];
	int [] snakeYposition = new int[750];
	public int snakeLenght;
	
	int [] dotXpostion = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	int [] dotYpostion = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	int dotX;
	int dotY;
	
	int score;
	int highScore;
	int highestScore;
	int delay;
	int dotEatDelay;
	int time;
	
	Random random = new Random();
	javax.swing.Timer timer;
	javax.swing.Timer timeElapse;
	
	
	
	public GamePanel() {
		ImageIcon_Initialization();
		boolean_Initialization();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		snakeLenght = 3;
		score = 0;
		highScore = 0;
		highestScore = 0;
		delay = 50;
		dotEatDelay = 10;
		timer = new javax.swing.Timer(delay, this);
		timer.start();
		timeElapse = new javax.swing.Timer(1000, new TimeElapse(dotEatDelay));
		CreateDotRandomPosition();
	}

	private void ImageIcon_Initialization() {
		snakeTitle = new ImageIcon(this.getClass().getClassLoader().getResource("snaketitle.jpg"));
		upMouth = new ImageIcon(this.getClass().getClassLoader().getResource("upmouth.png"));
		downMouth = new ImageIcon(this.getClass().getClassLoader().getResource("downmouth.png"));
		leftMouth = new ImageIcon(this.getClass().getClassLoader().getResource("leftmouth.png"));
		rightMouth = new ImageIcon(this.getClass().getClassLoader().getResource("rightmouth.png"));
		snakeBody = new ImageIcon(this.getClass().getClassLoader().getResource("snakeimage.png"));
		dot = new ImageIcon(this.getClass().getClassLoader().getResource("enemy.png"));
		
	}
	
	private void boolean_Initialization() {
		left = false;
		right = true;
		up = false;
		down = false;
		move = false;
		gameOver = false;
		
	}

	private void CreateDotRandomPosition() {
		dotX = dotXpostion[random.nextInt(34)];
		dotY = dotYpostion[random.nextInt(23)];
		
		for (int i = snakeLenght-1; i >= 0; i--) {
			if(snakeXposition[i] == dotX && snakeYposition[i] == dotY)
			{
				CreateDotRandomPosition();
			}
		}
		
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);
		g.drawRect(24, 74, 851, 576);
		
		snakeTitle.paintIcon(this, g, 25,11);
		
		g.setColor(Color.BLACK);
		g.fillRect(25, 75, 850, 575);
		
		drawSnakePanel(g);
		
	}

	private void drawSnakePanel(Graphics g) {
		if (!move) 
		{
			snakeXposition[0] = 100;//head position
			snakeXposition[1] = 75;
			snakeXposition[2] = 50;
			
			snakeYposition[0] = 100;
			snakeYposition[1] = 100;
			snakeYposition[2] = 100;
			
		}
		
		if (left) 
		{
			leftMouth.paintIcon(this, g, snakeXposition[0], snakeYposition[0]);
		}
		if (right) 
		{
			rightMouth.paintIcon(this, g, snakeXposition[0], snakeYposition[0]);
		}
		if (up) 
		{
			upMouth.paintIcon(this, g, snakeXposition[0], snakeYposition[0]);
		}
		if (down) 
		{
			downMouth.paintIcon(this, g, snakeXposition[0], snakeYposition[0]);
		}
		
		for (int i = 1; i < snakeLenght; i++) {
			snakeBody.paintIcon(this, g, snakeXposition[i], snakeYposition[i]);
		}
		
		dot.paintIcon(this, g, dotX, dotY);
		checkGameOver(g);
		drawScoreBoard(g);
		
		g.dispose();
	}

	private void drawScoreBoard(Graphics g) {
		int min = 0; 
		int sec = 0; 
		sec = TimeElapse.getTime();
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.PLAIN, 15));
		g.drawString("Down : "+ TimeElapse.getDoteatTime(), 150, 30);
		g.drawString("Note : Eat in "+dotEatDelay+" sec, otherwise decrease in length ", 52, 50);
		
		g.drawString("High Score : " + highestScore, 600, 30);
		if (sec >= 60) {
			min = TimeElapse.getTime()/60;
			sec = TimeElapse.getTime()%60;
		}
		g.drawString("Time : "+ min + "," + sec , 600, 50);
		g.drawString("Score : "+score, 750, 30);
		g.drawString("Length : "+snakeLenght, 750, 50);
		
		//System.out.println(new TimeElapse().getTime());
		
	}

	private void checkGameOver(Graphics g) {
		if(gameOver)
		{
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 50));
			g.drawString("GAME OVER", 300, 300);
			
			g.setFont(new Font("Arial", Font.PLAIN, 20));
			g.drawString("Press SPACE to restart", 340, 350);
		}
		


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for (int i = snakeLenght; i > 0; i--) 
		{
			snakeXposition[i] = snakeXposition[i-1];
			snakeYposition[i] = snakeYposition[i-1];
		}
		//e.g:kis tarf snake ko move krna chahiye
		if (left) 
		{
			snakeXposition[0] = snakeXposition[0]-25;
		}
		if (right) 
		{
			snakeXposition[0] = snakeXposition[0]+25;
		}
		if (up) 
		{
			snakeYposition[0] = snakeYposition[0]-25;
		}
		if (down) 
		{
			snakeYposition[0] = snakeYposition[0]+25;
		}
		
		//e.g:agr right boundry ko touch krta hai to left sy nikaly
		if (snakeXposition[0] > 850) {
			snakeXposition[0]=25;
		}
		if (snakeXposition[0] < 25) {
			snakeXposition[0]=850;
		}
		if (snakeYposition[0] > 625) {
			snakeYposition[0]=75;
		}
		if (snakeYposition[0] < 75) {
			snakeYposition[0]=625;
		}
		
		eatDot();
		downTime();
		collideWithBody();
		repaint();
	}

	private void downTime() {
		if(TimeElapse.getDoteatTime() == 0)
		{
			if (snakeLenght > 3) {
				snakeLenght--;
				score--;
				highScore--;
				TimeElapse.setDotEatTime(dotEatDelay);
			}
			else {
				timer.stop();
				timeElapse.stop();
				gameOver = true;
			}
		}
		
	}

	private void collideWithBody() {
		for (int i = snakeLenght-1; i > 0; i--) {
			if(snakeXposition[0] == snakeXposition[i] && snakeYposition[0] == snakeYposition[i])
			{
				highestScore = highScore;
				timer.stop();
				gameOver = true;
			}
		}
		
	}

	private void eatDot() {
		if(snakeXposition[0] == dotX && snakeYposition[0] == dotY)
		{
			CreateDotRandomPosition();
			snakeLenght++;
			score++;
			TimeElapse.setDotEatTime(dotEatDelay);
			
			if(score > highScore)
			{
				highScore = score;
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) 
		{
			settings();
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE && gameOver) 
		{
			reStart();
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT && !right) 
		{
			left = true;
			right = false;
			up = false;
			down = false;
			move = true;
			
			
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT && !left) 
		{
			left = false;
			right = true;
			up = false;
			down = false;
			move = true;
			
			
		}
		if (e.getKeyCode() == KeyEvent.VK_UP && !down) 
		{
			left = false;
			right = false;
			up = true;
			down = false;
			move = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN && !up) 
		{
			left = false;
			right = false;
			up = false;
			down = true;
			move = true;
		}
		
		if (move) {
			timeElapse.start();
			
		}
		
	}

	private void settings() {
		timer.stop();
		timeElapse.stop();
		
		int var = JOptionPane.showConfirmDialog(null, "Do you want to change in settings?","SETTINGS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(var == JOptionPane.YES_OPTION)
		{
			boolean flag = true;
			
			do 
			{
				String speed = JOptionPane.showInputDialog("Snake speed in msec ");
				try 
				{  
					delay = Integer.parseInt(speed);
					flag = false;
				}
				catch(NumberFormatException e)
				{  
					JOptionPane.showMessageDialog(null, "Only digits are valid","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
				}
			}while(flag);
			
			if (delay == 0) {
				delay = 50;
			}

			timer.setDelay(delay);
			
			flag = true;
			do 
			{
				String downSpeed = JOptionPane.showInputDialog("Decrease in length in sec ");
				try 
				{  
					dotEatDelay = Integer.parseInt(downSpeed);
					flag = false;
				}
				catch(NumberFormatException e)
				{  
					JOptionPane.showMessageDialog(null, "Only digits are valid","ERROR MESSAGE",JOptionPane.ERROR_MESSAGE);
				}
			}while(flag);
			
			if (dotEatDelay == 0) {
				dotEatDelay = 10;
			}
			reStart();
		}
		else if(var == JOptionPane.NO_OPTION)
		{
			timer.start();
			timeElapse.start();
			return;
		}
		
	}

	private void reStart() {
		gameOver = false;
		score = 0;
		snakeLenght = 3;
		
		TimeElapse.setDotEatTime(dotEatDelay);
		
		left = false;
		right = true;
		up = false;
		down = false;
		move = false;
		timer.start();
		timeElapse.stop();
		new TimeElapse().setTime(0);
		CreateDotRandomPosition();
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	int getSnakeLength()
	{
		return snakeLenght;
	}
	
	void setSnakeLength(int length) {
		snakeLenght = length;
	}
	
	void setTime(int time)
	{
		this.time = time;
		
	}
	
	int getTime()
	{
		return this.time;
	}
	
}
