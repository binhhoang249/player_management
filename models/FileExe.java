import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class FileExe {
    private Path path;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public FileExe() {
    }

    public FileExe(Path path) {
        this.path = path;
    }

    public Object[] readFile() {
        try {
            List<String> lines = Files.readAllLines(path);

            return lines.toArray();
        } catch (IOException e) {
            e.printStackTrace();
            return new Object[0];
        }
    }

    public List<Coach> readCoaches(Path dataPath) {
        this.path = dataPath;

        // Reading from the file
        Object[] fileContents = readFile();

        List<Coach> coaches = new ArrayList<>();

        for (Object line : fileContents) {
            try {
                String[] parts = ((String) line).split(",");
                int coachID = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int experience = Integer.parseInt(parts[2].trim());
                int clubID = Integer.parseInt(parts[3].trim());
                String nationality = parts[4].trim();

                Coach coach = new Coach(coachID, name, experience, clubID, nationality);
                coaches.add(coach);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Error parsing coach data: " + e.getMessage());
            }
        }

        return coaches;
    }

    public List<Player> readPlayers(Path dataPath) {
        this.path = dataPath;

        // Reading from the file
        Object[] fileContents = readFile();
        List<Player> players = new ArrayList<>();
        for (Object line : fileContents) {
            try {

                //PARSE... DÙNG ĐỂ ÉP KIỂU
                //SPLIT SẼ CHIA CHUỖI THEO REGEX VÀ TRẢ VỀ STRING[]
                //TRIM XỬ LÝ KHOẢNG TRỐNG THỪA
                String[] parts = ((String) line).split(", ");
                int playerId = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                int age = Integer.parseInt(parts[2].trim());
                String nationality = parts[3].trim();
                double transferValue = Double.parseDouble(parts[4].trim());
                int jerseyNumber = Integer.parseInt(parts[5].trim());
                double height = Double.parseDouble(parts[6].trim());
                double weight = Double.parseDouble(parts[7].trim());

                // Parse clubsID array from the 8th part, assuming it's a string like "[1, 2]"
                String clubsIDString = parts[8];
                // SUBSTRING LẤY RA CHUỖI THEO MONG MUỐN CỦA MÌNH
                // VD: MÌNH CÓ STRING [1 2 3 4 5] ĐỂ TRẢ RA 1 2 3 4 5 MÌNH DÙNG SUBSTRING(INDEX BẮT ĐẦU: 0, VÀ INDEX KẾT THÚC)
                clubsIDString = clubsIDString.substring(1, clubsIDString.length() - 1); // Remove the square brackets
                String[] clubIdStrings = clubsIDString.split(" ");
                //SPLIT ĐỂ TRỞ THÀNH 1 CHUỖI TỪ 1 2 3 4 5 THÀNH [1,2,3,4,5]
                List<Integer> clubsID = new ArrayList<>();
                for (String clubIdString : clubIdStrings) {
                    int clubId = Integer.parseInt(clubIdString.trim());
                    clubsID.add(clubId);
                }
                // sử dụng lại array player lúc nãy để thêm vào nó
                Player player = new Player(playerId, name, age, nationality, transferValue, jerseyNumber, height, weight, clubsID);
                players.add(player);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Error parsing player data: " + e.getMessage() + e);
            }
        }

        return players;
    }

    public List<Club> readClubs(Path dataPath) {
        this.path = dataPath;

        // Reading from the file
        Object[] fileContents = readFile();

        List<Club> clubs = new ArrayList<>();
        for (Object line : fileContents) {
            try {
                String[] parts = ((String) line).split(",");
                int clubId = Integer.parseInt(parts[0].trim());
                String clubName = parts[1].trim();
                int yearFounded = Integer.parseInt(parts[2].trim());
                String stadium = parts[3].trim();

                Club club = new Club(clubId, clubName, yearFounded, stadium);
                clubs.add(club);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Error parsing club data: " + e.getMessage());
            }
        }

        return clubs;
    }
}
