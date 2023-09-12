package ticTacToe;

public class Player {
	private String name;
	private char symbol;
	
	public Player(String name, char symbol) {
		setName(name);
		setSymbol(symbol);
	}

	public void setSymbol(char symbole) {
		if(symbole=='\0') {
			return ;
		}
		this.symbol=symbole;
	}

	public void setName(String name) {
		if(!name.isEmpty()) {
			this.name=name;;
		}
	}
	
	public char getSymbol() {
		return symbol;
	}

	public String getName() {
		return name;
	}

}
