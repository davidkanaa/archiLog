package appDemo;

import java.util.Scanner;
import models.entities.Item;
import modules.searcher.Searcher;
import services.ServiceRegister;
import services.consumers.SoundCloud;
import services.consumers.Spotify;

/**
 * Created by davidkanaa on 16-01-31.
 */
public class SearchDemo {

    public static void main(String[] args) {

        // Search terms for the demo.
        //String terms = "Someone like you";

        // Creates Spotify and SoundCloud service consumers.
        Spotify api = new Spotify();
        SoundCloud api2 = new SoundCloud();

        // Adds the consumers to the register.
        ServiceRegister register = ServiceRegister.getInstance_();
        register.loadService(api);
        register.loadService(api2);

        // Creates a searcher.
        Searcher searcher = new Searcher();

        // Runs the search with the given terms (as a string).
        //searcher.search(args[0]);
        // The application ask the user for the name of the song        
        System.out.print("Search (song/artist): ");
        Scanner scan = new Scanner(System.in);
        String user_input = scan.nextLine();
        searcher.search(user_input);

        // Prints results to the console.
        for(Item i : searcher.getResults()){
            System.out.println(i);
        }
    }
}
