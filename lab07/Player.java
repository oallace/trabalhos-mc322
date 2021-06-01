package mc322.lab07;

public class Player {
	
	private char team;
	
	private int score;
	
	
	Player(char team, int score){
		this.team = team;
		this.score = score;
	}
	
	public char getTeam() {
		return this.team;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void scoreChange(int change) {
		this.score += change;
	}
}
