import java.util.HashMap;
import java.util.Set;

class Film {

	private String seriesName;
	private HashMap<String, Integer> movies = new HashMap<>();

	public Film(String seriesName) {
		this.seriesName = seriesName;
	}

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

	public static String[] movieInput = {"Avengers", "Captain America", "Hulk"};
	public static HashMap<String, Film> movieMap = new HashMap<>();
	public static Film currentFilm;

	public static void main(String[] args) {

		for (String s: movieInput) {
			movieMap.put(s, new Film(s));
		}

		currentFilm = movieMap.get("Avengers");
		currentFilm.addMovie("Movie1", 1);
		currentFilm.addMovie("Movie2", 2);

		currentFilm = movieMap.get("Captain America");
		currentFilm.addMovie("Movie1", 3);
		currentFilm.addMovie("Movie2", 4);

		currentFilm = movieMap.get("Hulk");
		currentFilm.addMovie("Movie1", 5);
		currentFilm.addMovie("Movie2", 6);

		for (String s: movieInput) {
			currentFilm = movieMap.get(s);
			for (String key: currentFilm.getKeys()) {
				System.out.println(currentFilm.getNumber(key));
			}
		}
	}
}