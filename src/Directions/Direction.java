package Directions;
import java.util.HashMap;

import Map.Row;


public abstract class Direction { 
	private static HashMap<Integer, Direction> map = new HashMap<Integer, Direction>(); 
	
	public static void setValue() {
		map.put(0, new Bottom());
		map.put(45, new RightBottom());
		map.put(90, new Right());
		map.put(135, new RightTop());
		map.put(180, new Top());
		map.put(225, new LeftTop());
		map.put(270, new Left());
		map.put(315, new LeftBottom());
		
	}
	
	public abstract boolean search(Row row, int xPos, int yPos, int postX, int postY);

	public static Direction giveObject(int degree) {
		setValue();
		return map.get(degree);
	}
}
