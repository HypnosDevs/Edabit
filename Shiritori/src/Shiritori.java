import java.util.*;
class Shiritori {
	public boolean game_over;
	private ArrayList<String> words;
	
	public Shiritori(){
		this.game_over = false;
		this.words = new ArrayList<>();
	}
	
	public Object play(String word){
		if(game_over)return "game over";
		else{
			int size =  words.size();
			if(size==0){
				words.add(word);
				return words.toArray(new String[0]);
			}
			for(String item:words){
				if(item.equals(word)){
					game_over = true;
					return "game over";
				}
			}
				String lastString = words.get(words.size()-1);
			if(lastString.charAt(lastString.length()-1) == (word.charAt(0))){
				words.add(word);
				return words.toArray(new String[0]);
			}
		}
		game_over = true;
		return "game over";
	}
	public String restart(){
		words.clear();
		game_over = false;
		return "game restarted";
	}
	public String[] getWords(){
		return words.toArray(new String[0]);
	}
}