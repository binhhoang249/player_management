import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WriteClubsToFile {
    public static void main(String[] args) {
        List<String> clubs = Arrays.asList(
            "1, AS Monaco, 1924, Stade Louis II",
            "2, Paris Saint-Germain, 1970, Parc des Princes",
            "3, Molde, 1911, Aker Stadion",
            "4, Red Bull Salzburg, 1933, Red Bull Arena",
            "5, Borussia Dortmund, 1909, Signal Iduna Park",
            "6, Manchester City, 1880, Etihad Stadium",
            "7, Genk, 1988, Luminus Arena",
            "8, Chelsea, 1905, Stamford Bridge",
            "9, Werder Bremen, 1899, Weser-Stadion",
            "10, Wolfsburg, 1945, Volkswagen Arena",
            "11, Barcelona, 1899, Camp Nou",
            "12, Inter Miami, 2018, DRV PNK Stadium",
            "13, Sporting CP, 1906, Estádio José Alvalade",
            "14, Real Madrid, 1902, Santiago Bernabéu Stadium",
            "15, Juventus, 1897, Allianz Stadium",
            "16, Al Nassr, 1955, Mrsool Park",
            "17, Santos, 1912, Vila Belmiro",
            "18, Al-Hilal, 1957, King Fahd International Stadium",
            "19, Lech Poznań, 1922, Stadion Miejski",
            "20, Bayern Munich, 1900, Allianz Arena",
            "21, Groningen, 1971, Hitachi Capital Mobility Stadium",
            "22, Celtic, 1887, Celtic Park",
            "23, Southampton, 1885, St Mary's Stadium",
            "24, Liverpool, 1892, Anfield",
            "25, El Mokawloon, 1973, Arab Contractors Stadium",
            "26, Basel, 1893, St. Jakob-Park",
            "27, Fiorentina, 1926, Stadio Artemio Franchi",
            "28, Roma, 1927, Stadio Olimpico",
            "29, Tottenham Hotspur, 1882, Tottenham Hotspur Stadium",
            "30, Leicester City, 1884, King Power Stadium",
            "31, Norwich City, 1902, Carrow Road",
            "32, Millwall, 1885, The Den",
            "33, Leyton Orient, 1881, Brisbane Road",
            "34, Bayern Munich, 1900, Allianz Arena",
            "35, Metz, 1932, Stade Saint-Symphorien",
            "36, Al Nassr, 1955, Mrsool Park",
            "37, RB Leipzig, 2009, Red Bull Arena",
            "38, Novara, 1908, Stadio Silvio Piola",
            "39, Udinese, 1896, Stadio Friuli",
            "40, Sampdoria, 1946, Stadio Luigi Ferraris",
            "41, Sporting CP, 1906, Estádio José Alvalade",
            "42, Manchester United, 1878, Old Trafford",
            "43, Juventus, 1897, Allianz Stadium",
            "44, Olimpija Ljubljana, 2005, Stadion Stožice",
            "45, Benfica, 1904, Estádio da Luz",
            "46, Rio Ave, 1939, Estádio dos Arcos",
            "47, Atlético Madrid, 1903, Wanda Metropolitano",
            "48, Lyon, 1950, Parc Olympique Lyonnais",
            "49, Al-Ittihad, 1927, King Abdullah Sports City",
            "50, Dinamo Zagreb, 1945, Stadion Maksimir",
            "51, Tottenham Hotspur, 1882, Tottenham Hotspur Stadium",
            "52, Sevilla, 1890, Ramón Sánchez Pizjuán Stadium",
            "53, Paris Saint-Germain, 1970, Parc des Princes",
            "54, AC Milan, 1899, San Siro"
        );

        try (FileWriter writer = new FileWriter("clubs.txt")) {
            for (String club : clubs) {
                writer.write(club + "\n");
            }
            System.out.println("File successfully written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
