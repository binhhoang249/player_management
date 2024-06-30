import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteCoachesToFile {
    public static void main(String[] args) {
        List<String> coaches = Arrays.asList(
            "1, Pep Guardiola, 15, 6, Spain",
            "2, Jurgen Klopp, 20, 24, Germany",
            "3, Zinedine Zidane, 8, 14, France",
            "4, Jose Mourinho, 24, 28, Portugal",
            "5, Carlo Ancelotti, 26, 14, Italy",
            "6, Thomas Tuchel, 14, 20, Germany",
            "7, Diego Simeone, 15, 47, Argentina",
            "8, Mauricio Pochettino, 13, 8, Argentina",
            "9, Antonio Conte, 16, 43, Italy",
            "10, Massimiliano Allegri, 18, 43, Italy",
            "11, Unai Emery, 16, 52, Spain",
            "12, Ralph Hasenhüttl, 12, 23, Austria",
            "13, Julian Nagelsmann, 7, 37, Germany",
            "14, Brendan Rodgers, 13, 30, Northern Ireland",
            "15, Mikel Arteta, 4, 42, Spain",
            "16, Steven Gerrard, 5, 22, England",
            "17, Xavi Hernandez, 2, 11, Spain",
            "18, Hansi Flick, 3, 20, Germany",
            "19, Erik ten Hag, 10, 42, Netherlands",
            "20, Luis Enrique, 12, 53, Spain"
        );

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
