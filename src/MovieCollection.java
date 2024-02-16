import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class MovieCollection {
    ArrayList<Movie> movies = new ArrayList<>();

    public MovieCollection () {
        try {
            File myFile = new File("src\\data.txt");
            Scanner fileScanner = new Scanner(myFile);
            while (fileScanner.hasNext()) {
                String data = fileScanner.nextLine();
                String[] splitData = data.split(",");
                String name = splitData[0];
                String cast = splitData[1];
                String[] splitCast = cast.split("\\|");
                String castString = "";
                for (int i = 0; i < splitCast.length; i++) {
                    castString += splitCast[i] + " ";
                }
                String director = splitData[2];
                String overview = splitData[3];
                int runtime = Integer.parseInt(splitData[4]);
                double userRating = Double.parseDouble(splitData[5]);
                Movie movie = new Movie(name, castString, director, overview, runtime, userRating);
                movies.add(movie);
                for (int i = 0; i < movies.size(); i++) {
                    Movie movieI = movies.get(i);
                    int movieIdx = i;
                    for (int j = i; j < movies.size(); j++) {
                        if (movies.get(i).getTitle().compareTo(movieI.getTitle()) < 0) {
                            movieI = movies.get(j);
                            movieIdx = j;
                        }
                    }
                    Movie temp = movies.get(i);
                    movies.set(i, movies.get(movieIdx));
                    movies.set(movieIdx, temp);
                }
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public void mainMenu () {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Movie Finder!");
        String menuOption = "";
        while (!menuOption.equals("q")) {
            System.out.println("------------ Main Menu ----------");
            System.out.println("- search (t)itles");
            System.out.println("- search (c)ast");
            System.out.println("- (q)uit");
            System.out.print("Enter choice: ");
            menuOption = scanner.nextLine();

            if (menuOption.equals("t")) {
                System.out.println(searchTitles());
            } else if (menuOption.equals("c")) {
                System.out.println(searchCast());
            } else if (menuOption.equals("q")) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    public String searchTitles () {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a key search item, or the title of the movie!");
        String userInput = scan.nextLine();
        ArrayList<Integer> possibleIndexes = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < movies.size(); i++) {
            System.out.println("TESTING, DELETE LATER - For loop is running on index " + i);
            if (movies.get(i).getTitle().indexOf(userInput) > 0) {
                possibleIndexes.add(i);
                System.out.println(count + ". " + movies.get(i).getTitle());
                count++;
            }
        }
        if (possibleIndexes.size() == 0) {
            return "No matches found! Please try again!";
        } else {
            System.out.println("Please enter the specified number of the movie you want to search from this list.");
            count = scan.nextInt();
            int requestedIdx = possibleIndexes.get(count - 1);
            Movie requestedMovie = movies.get(requestedIdx);
            return "Title: " + requestedMovie.getTitle() + "\nRuntime: " + requestedMovie.getRuntime() + "\nDirected By: " + requestedMovie.getDirector() + "\nCast: " + requestedMovie.getCast() + "\nOverview: " + requestedMovie.getOverview() + "\nUser Rating: " + requestedMovie.getUserRating();
        }
    }

    public String searchCast () {
        return "testing so far";
    }
}
