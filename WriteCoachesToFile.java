import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteCoachesToFile {
    public static void main(String[] args) {
        List<String> coaches = new ArrayList<>();
        coaches.add("1, Pep Guardiola, 15, 6, Spain");
        coaches.add("2, Jurgen Klopp, 20, 24, Germany");
        coaches.add("3, Zinedine Zidane, 8, 14, France");
        coaches.add("4, Jose Mourinho, 24, 28, Portugal");
        coaches.add("5, Carlo Ancelotti, 26, 14, Italy");
        coaches.add("6, Thomas Tuchel, 14, 20, Germany");
        coaches.add("7, Diego Simeone, 15, 47, Argentina");
        coaches.add("8, Mauricio Pochettino, 13, 8, Argentina");
        coaches.add("9, Antonio Conte, 16, 43, Italy");
        coaches.add("10, Massimiliano Allegri, 18, 43, Italy");
        coaches.add("11, Unai Emery, 16, 52, Spain");
        coaches.add("12, Ralph Hasenhüttl, 12, 23, Austria");
        coaches.add("13, Julian Nagelsmann, 7, 37, Germany");
        coaches.add("14, Brendan Rodgers, 13, 30, Northern Ireland");
        coaches.add("15, Mikel Arteta, 4, 42, Spain");
        coaches.add("16, Steven Gerrard, 5, 22, England");
        coaches.add("17, Xavi Hernandez, 2, 11, Spain");
        coaches.add("18, Hansi Flick, 3, 20, Germany");
        coaches.add("19, Erik ten Hag, 10, 42, Netherlands");
        coaches.add("20, Luis Enrique, 12, 53, Spain");

        String fileName = "coaches.txt";
        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file)) {
            if (file.exists()) {
                System.out.println("File already exists. Overwriting...");
            } else {
                System.out.println("File does not exist. Creating new file...");
                file.createNewFile();
            }
            for (String coach : coaches) {
                writer.write(coach + "\n");
            }
            System.out.println("File successfully written!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
