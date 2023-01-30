package SnakeGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeElapse implements ActionListener {

	static int dotEatTime;
	static int time;
	static int duplicateDotEatTime;
	public TimeElapse() {
		//dotEatTime = 10;
		//time = 0;
	}
	public TimeElapse(int dotEatTime) {
		this.dotEatTime = dotEatTime;
		duplicateDotEatTime = dotEatTime;
		time = 0;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		time++;
		dotEatTime--;
		setTime(time);
		if (dotEatTime < 0) {
			setDotEatTime(duplicateDotEatTime);
		}
		System.out.println(time);
		
	}
	void setTime(int time)
	{
		this.time = time;
	}
	 static int getTime()
	{
		return time;
	}
	 
	static void setDotEatTime(int dotTime)
	{
		dotEatTime = dotTime;
	}
	static int getDoteatTime()
	{
		return dotEatTime;
	}

}
