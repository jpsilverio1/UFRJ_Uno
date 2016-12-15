package main;

public interface ICard extends Comparable {
	public int getNumber();
	public Color getColor();
	public int getID();
	public int getScore();
	public Object getImage();
}
