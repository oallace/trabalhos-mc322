package mc322.lab07;

public class Highlights {
	int position[];
	String color;
	String image;
	
	Highlights(int iPos, int jPos, String color){
		this.position = new int[2];
		
		this.position[0] = iPos;
		this.position[1] = jPos;
		this.color = color;
		this.image = "caminhoImagem";
	}
	
	public int[] getPosition() {
		return this.position;
	}
	
	public void setPosition(int iPos, int jPos) {
		this.position[0] = iPos;
		this.position[1] = jPos;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getImage() {
		return this.image;
	}
}
