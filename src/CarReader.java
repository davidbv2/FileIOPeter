import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by Grand Circus Student on 8/1/2017.
 */
public class CarReader {

    public static void main(String[] args) {

        ArrayList<Car> carsList = new ArrayList<Car>();//need a place to store cars from file

        try{
            Path carsPath = Paths.get("./cars.txt");// Paths object gives us a method to create a path, which says in our
            //current working directory, there is a file called 'cars.txt'.
            File carsFile = carsPath.toFile();//
            FileReader fileRdr = new FileReader(carsFile);
            BufferedReader in = new BufferedReader(fileRdr);

            //read in the first line
            String line = in.readLine();

            //as long as there's another line
            while (line != null){
                //break the line apart based on tabs
                String[] details = line.split("/t");// takes the line, splits it, puts it in a string array,

                if (details.length < 4){
                    System.out.println("Bad line format --halting read");
                    break;
                }

                //take the first item and put it into the car's Make
                String make = details[0];

                //take the second item and put it into the car's model
                String model = details[1];

                //take the third item and turn it into an int, put into Year
                int year = Integer.parseInt(details[2]); //takes string and converts string into an int

                //take the fourth item and turn it into a double, put into Price
                double price = Double.parseDouble(details[3]); //takes string and converts string into a double

                //construct a new car object from this data
                Car c = new Car(make,model,year,price);

                //add the new Car into ArrayList
                carsList.add(c);

                //read in the next line for the next iteration
                line = in.readLine();
            }

        } catch (IOException e){
            System.out.println(e);
            return;
        }

        //now we have a filled ArrayList of Cars
        //at least in theory

        //output this list
        //enhanced for (foreach) to go through list

        for (Car c: carsList){
            //toString does the formatting
            System.out.println(c);
        }
    }
}
