import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }

    public static void main(String[] args) {

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of("darciKrve.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            return;
        } catch (IOException ioe){
            System.out.println("something went wrong");
            ioe.printStackTrace();
            return;
        }

        ArrayList<Osoba> osoby = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(",");
            osoby.add(new Osoba(
                    data[0],
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[3]),
                    BloodTypes.valueOf(BloodTypes.getEnumByString(data[4]))
            ));
        }
        Osoba personA, personB;
        for (int i = 0; i < 4000; i++) {
            personA = osoby.get(getRandomInt(osoby.size()));
            personB = osoby.get(getRandomInt(osoby.size()));
            //null pointer exception prevention: case: osoby.size == 0, returns null
            //if(personA == null || personB == null) break;
            personA.donateBlood(personB);
            //alt approach ;)
            //personA.bloodType.canBeDonatedAlternated(personB.bloodType);
            if(personA.bloodCap == 0)osoby.remove(personA);
        }
        System.out.println("Zbýva dárců: " + osoby.size());
    }
}