
public class Pokemon {
	
	//Attribute fields
	private String species;
	private int attack;
	private int defense;
	private int speed;
	
	//Modifier Methods
	public void grow(int boost){
		this.attack += boost;
	}
	public void harden(int boost){
		this.defense += boost;
	}
	public void haste(int boost){
		this.speed += boost;
	}
	public String getSpecies(){
		return species;
	}
	public void setSpecies(String spc){
		this.species = spc;
	}
	public int getAttack(){
		return attack;
	}
	public void setAttack(int atk){
		this.attack = atk;
	}
	public int getDefense(){
		return defense;
	}
	public void setDefense(int def){
		this.defense = def;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int spd){
		this.speed = spd;
	}
	//Constructor
	public Pokemon(String species){
		this.species = species;
		this.attack = (species.length()*4) + 2; 
		this.defense = (species.length()*2) + 7;
		this.speed = (species.length()*3) + 5; 
	}
}
