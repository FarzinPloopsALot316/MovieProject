import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class MovieCollection {

    public MovieCollection () {
        ArrayList<Movie> movies = new ArrayList<>();
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
            }
        } catch(IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String mainMenu () {

    }
}
