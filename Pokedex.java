public class Pokedex{

	//Initializes count and the boolean to determine if the list is supposed to be in alphabetical order.
	public int count = 0;
	public boolean isOrganized = false;
	private Pokemon[] pokedex;
	private	String[] pokedexOrganized;

	//Constructor
	public Pokedex(int size){
		this.pokedex = new Pokemon[size];
		this.pokedexOrganized = new String[size];
	}

	public String[] listPokemon(){
		if(count == 0){
			return null;
		}
		String[] arrayPok = new String[count];


		if(isOrganized == false){
			for(int i = 0; i < count; i++){
				arrayPok[i] = pokedex[i].getSpecies();
			}
		}
		else{
			for(int i = 0; i < count; i++){
				arrayPok[i] = pokedexOrganized[i];
			}
		}

		return arrayPok;

	}

	//Adds the pokemon by using the count variable to ensure the list is not full,
	//and it uses the pokedex variable to ensure there are no duplicates by checking indexes in a for loop.
	//Increments count variable.

	public boolean addPokemon(String species){

		if(count >= pokedex.length){
			System.out.println("Max");
			return false;
		}

		for(int i = 0; i < count; i++){
			String duplicateCheck = pokedex[i].getSpecies();
			if(species.equals(duplicateCheck)){
				System.out.println("Duplicate");
				return false;
			}
		}

		pokedex[count] = new Pokemon(species);
		count++;
		isOrganized = false;
		return true;
	}

	//Conjures stats of the pokemon by using the Pokemon class and it's methods.
	//Checks if the pokemon exists in the pokedex. 
	public int[] checkStats(String species){

		if(count == 0) return null;

		int[] arrayStats = new int[3];
		for(int i = 0; i < count; i++){
			String x = pokedex[i].getSpecies();
			if(species.equals(x)){
				arrayStats[0] = pokedex[i].getAttack();
				arrayStats[1] = pokedex[i].getDefense();
				arrayStats[2] = pokedex[i].getSpeed();
			}
		}
		if(arrayStats[0] == 0){
			return null;
		}
		return arrayStats;
	}

	//Sorts the pokemon alphabetically by using a for loop and checking the indexes.
	//The compareToIgnoreCase is used to compare certain indexes and to ensure the list is in alphabetical order.
	//Once the pokemon are sorted alphabetically, the boolean isOrganized equals true in order to display the list
	//alphabetically in the listPokemon method. 
	public void sortPokemon(){

		String[] arraySort = new String[count];
		for(int i = 0; i < count; i++){
			arraySort[i] = pokedex[i].getSpecies();
		}

		for(int i = 0; i < count; i++){
			for(int j = 0; j < count; j++){
				if(i < j){
					String first = arraySort[j];
					String second = arraySort[i];
					int compare = first.compareToIgnoreCase(second);
					if(compare < 0){
						String placeholder = arraySort[i];
						arraySort[i] = arraySort[j];
						arraySort[j] = placeholder;
					}
				}
			}
		}
		for(int l = 0; l < count; l++){
			pokedexOrganized[l] = arraySort[l];
		}
		isOrganized = true;
	}
}
