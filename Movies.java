import java.util.HashMap;
import java.util.Set;

/*
 *	A 'Film' object is used as a movie series catalogue
 */
class Film {
	
	private HashMap<String, Integer> movies = new HashMap<>(); // Catalogue of all movies in the series

	public int getNumber(String s) {
		return movies.get(s);
	}

	public void addMovie(String name, int number) {
		movies.put(name, number);
	}

	public Set<String> getKeys() {
		return movies.keySet();
	}
}

public class Movies {

	// List of movie series
	public static String[] movieInput = {"Avengers", "Captain America", "Hulk"};
	
	// Map of the movie series names and their respective 'Film' catalogue objects
	public static HashMap<String, Film> movieMap = new HashMap<>();
	
	// Reference to the Film object
	public static Film currentFilm;

	public static void main(String[] args) {

		for (String s: movieInput) {
			// Creates a new entry in the map with the series name as the key, and a new 'Film' catalogue object as the value
			movieMap.put(s, new Film());
		}

		// Set the Film object reference to point to the Film object located at key = "Avengers"
		currentFilm = movieMap.get("Avengers");
		
		// Add movies to the catalogue
		currentFilm.addMovie("Movie1", 1);
		currentFilm.addMovie("Movie2", 2);

		currentFilm = movieMap.get("Captain America");
		currentFilm.addMovie("Movie1", 3);
		currentFilm.addMovie("Movie2", 4);

		currentFilm = movieMap.get("Hulk");
		currentFilm.addMovie("Movie1", 5);
		currentFilm.addMovie("Movie2", 6);

		// Print out all data from all movie series
		for (String s: movieInput) {
			// Sets the current film to the movie at current iteration
			currentFilm = movieMap.get(s);
			
			// Loops through all the movie titles located in the catalogue
			for (String key: currentFilm.getKeys()) {
				// Print the associated data with that movie title
				System.out.println(currentFilm.getNumber(key));
			}
		}
	}
}

