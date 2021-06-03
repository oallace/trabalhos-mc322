package mc322.lab07;

public class Player {
	
	private char team;
	private String name;
	private int score;
	
	
	Player(char team, int score){
		this.team = team;
		this.score = score;
		this.name = "default"; // precisa receber o nome conforme o jogador
	}
	
	public char getTeam() {
		return this.team;
	}
	
	public int getScore() {
		return this.score;
	}

	public String getName()
	{
		return name;
	}
	
	public void scoreChange(int change) {
		this.score += change;
	}
}
