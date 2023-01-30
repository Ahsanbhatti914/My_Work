package SnakeGame;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GameDriver extends JFrame{
	
	public GameDriver() {
		setTitle("Snake Game");
		setSize(905, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon imageIcon = new ImageIcon(this.getClass().getClassLoader().getResource("snake.png"));
		setIconImage(imageIcon.getImage());
		
		GamePanel gamePanel = new GamePanel();
		gamePanel.setBackground(Color.DARK_GRAY);
		add(gamePanel);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GameDriver();
	}

}
