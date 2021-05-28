package CONTROLADOR;

public class WordCounter { //Concrete Observer
	
	private int NumberOfWords=0;
	
	public int getNumberOfWords() {
		return this.NumberOfWords;
	}
	
	public void notice(String test) {
		String words[] = test.split("\\s");
		this.NumberOfWords = words.length;

	}
	
}
