package main;

public class Card implements ICard{

	@Override
	public int getNumber() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	/**
	 * Necessario para a comparacao de listagem
	 */
	public int compareTo(Object o) {
		if (o instanceof Color){
			return getColor().compareTo((Color) o);
		}
		return compareTo(o);
	}
}
