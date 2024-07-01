import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteClubsToFile {
    public static void main(String[] args) {
        List<String> clubs = new ArrayList<>();
        clubs.add("1, AS Monaco, 1924, Stade Louis II");
        clubs.add("2, Paris Saint-Germain, 1970, Parc des Princes");
        clubs.add("3, Molde, 1911, Aker Stadion");
        clubs.add("4, Red Bull Salzburg, 1933, Red Bull Arena");
        clubs.add("5, Borussia Dortmund, 1909, Signal Iduna Park");
        clubs.add("6, Manchester City, 1880, Etihad Stadium");
        clubs.add("7, Genk, 1988, Luminus Arena");
        clubs.add("8, Chelsea, 1905, Stamford Bridge");
        clubs.add("9, Werder Bremen, 1899, Weser-Stadion");
        clubs.add("10, Wolfsburg, 1945, Volkswagen Arena");
        clubs.add("11, Barcelona, 1899, Camp Nou");
        clubs.add("12, Inter Miami, 2018, DRV PNK Stadium");
        clubs.add("13, Sporting CP, 1906, Estádio José Alvalade");
        clubs.add("14, Real Madrid, 1902, Santiago Bernabéu Stadium");
        clubs.add("15, Juventus, 1897, Allianz Stadium");
        clubs.add("16, Al Nassr, 1955, Mrsool Park");
        clubs.add("17, Santos, 1912, Vila Belmiro");
        clubs.add("18, Al-Hilal, 1957, King Fahd International Stadium");
        clubs.add("19, Lech Poznań, 1922, Stadion Miejski");
        clubs.add("20, Bayern Munich, 1900, Allianz Arena");
        clubs.add("21, Groningen, 1971, Hitachi Capital Mobility Stadium");
        clubs.add("22, Celtic, 1887, Celtic Park");
        clubs.add("23, Southampton, 1885, St Mary's Stadium");
        clubs.add("24, Liverpool, 1892, Anfield");
        clubs.add("25, El Mokawloon, 1973, Arab Contractors Stadium");
        clubs.add("26, Basel, 1893, St. Jakob-Park");
        clubs.add("27, Fiorentina, 1926, Stadio Artemio Franchi");
        clubs.add("28, Roma, 1927, Stadio Olimpico");
        clubs.add("29, Tottenham Hotspur, 1882, Tottenham Hotspur Stadium");
        clubs.add("30, Leicester City, 1884, King Power Stadium");
        clubs.add("31, Norwich City, 1902, Carrow Road");
        clubs.add("32, Millwall, 1885, The Den");
        clubs.add("33, Leyton Orient, 1881, Brisbane Road");
        clubs.add("34, Bayern Munich, 1900, Allianz Arena");
        clubs.add("35, Metz, 1932, Stade Saint-Symphorien");
        clubs.add("36, Al Nassr, 1955, Mrsool Park");
        clubs.add("37, RB Leipzig, 2009, Red Bull Arena");
        clubs.add("38, Novara, 1908, Stadio Silvio Piola");
        clubs.add("39, Udinese, 1896, Stadio Friuli");
        clubs.add("40, Sampdoria, 1946, Stadio Luigi Ferraris");
        clubs.add("41, Sporting CP, 1906, Estádio José Alvalade");
        clubs.add("42, Manchester United, 1878, Old Trafford");
        clubs.add("43, Juventus, 1897, Allianz Stadium");
        clubs.add("44, Olimpija Ljubljana, 2005, Stadion Stožice");
        clubs.add("45, Benfica, 1904, Estádio da Luz");
        clubs.add("46, Rio Ave, 1939, Estádio dos Arcos");
        clubs.add("47, Atlético Madrid, 1903, Wanda Metropolitano");
        clubs.add("48, Lyon, 1950, Parc Olympique Lyonnais");
        clubs.add("49, Al-Ittihad, 1927, King Abdullah Sports City");
        clubs.add("50, Dinamo Zagreb, 1945, Stadion Maksimir");
        clubs.add("51, Tottenham Hotspur, 1882, Tottenham Hotspur Stadium");
        clubs.add("52, Sevilla, 1890, Ramón Sánchez Pizjuán Stadium");
        clubs.add("53, Paris Saint-Germain, 1970, Parc des Princes");
        clubs.add("54, AC Milan, 1899, San Siro");

        String fileName = "clubs.txt";
        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file)) {
            if (file.exists()) {
                System.out.println("File already exists. Overwriting...");
            } else {
                System.out.println("File does not exist. Creating new file...");
                file.createNewFile();
            }
            for (String club : clubs) {
                writer.write(club + "\n");
            }
            System.out.println("File successfully written!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
