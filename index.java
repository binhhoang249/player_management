import java.nio.file.Path;
import java.util.List;

public class index {
    public static List<Club> clubs;
    public static List<Coach> coaches;
    public static List<Player> players;

    public static void main(String[] args) {
      
        readData();
        // Chào mừng đến với trình quản lý cầu thủ, clb, và các huấn luyện viên, bạn muốn làm gì
        // 1. Điều chỉnh các cầu thủ

        // Sau khi điều chỉnh dữ liệu mà em muốn (Thêm, sửa, xoá)
        // writeData();
    }


    // public static void welcome() {
    //     switch (scanner 1) {
    //         case 1
    //             coachInformation()
    //             break;
        
    //         default:
    //             break;
    //     }
    // }


    public static void readData() {

        Path clubPath = Path.of("./data/clubs.txt");
        Path coachPath = Path.of("./data/coaches.txt");
        Path playerPath = Path.of("./data/players.txt");
        FileExe fileExe = new FileExe();
        clubs = fileExe.readClubs(clubPath);
        coaches = fileExe.readCoaches(coachPath);
        players = fileExe.readPlayers(playerPath);

        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i));
        }

    }
}
