import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class index {
    public static List<Club> clubs;
    public static List<Coach> coaches;
    public static List<Player> players;
    private static final FileExe fileExe = new FileExe();

    public static void main(String[] args) {
        readData();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.print("Welcom to the player management, coach, club administration system. What would you like to do?\n");
            System.out.println("1. Club Information.");
            System.out.println("2. Player Information.");
            System.out.println("3. Coach Information.");
            System.out.println("4. Exit");
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    clubInformation();
                    break;
                case 2:
                    playerInformation();
                    break;
                case 3:
                    coachInformation();
                    break;
                case 4:
                    System.out.println("Exiting system");
                    System.out.println("Thank you for using my program.");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 4);
        input.close();
    }

    public static void clubInformation() {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("_____Welcom to the clubs management______");
            System.out.println("1. Add club");
            System.out.println("2. searchClub ");
            System.out.println("3. Update club");
            System.out.println("4. Delete club");
            System.out.println("5. Calculate the total transfer value of the club");
            System.out.println("6. Back to Main Menu");
            System.out.print("Please enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    addClub(input);
                    break;
                case 2:
                    searchClubWithInput(input);
                    break;
                case 3:
                    upDateCLub(input);
                    break;
                case 4:
                    deleteClubWithInput(input);
                    break;
                case 5:
                System.out.print("Enter club name to calculate total transfer value: ");
                input.nextLine(); 
                String clubName = input.nextLine().trim();
                double totalTransferValue = calculateTotalTransferValue(players, clubName);
                System.out.println("Total transfer value for club " + clubName + ": " + totalTransferValue);
                break;
                case 6:
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        } while (choice != 6);
    }

    // Đây là thêm câu lạc bộ vào arrayList có sẵn.
    public static void addClub(Scanner input) {
                                while (true) {
                                    try {
                                        input.nextLine();
                                        int clubId = clubs.getLast().getClubId();

                                        System.out.println("Enter club name: ");
                                        String clubName = input.nextLine();

                                        System.out.print("Enter the year founded: ");
                                        int yearFounded = input.nextInt();
                                        input.nextLine();

                                        System.out.print("Enter club stadium: ");
                                        String stadium = input.nextLine();

                                        clubId++;
                                        Club newClub = new Club(clubId, clubName, yearFounded, stadium);
                                        clubs.add(newClub);

                                        System.out.print("The information about the football club you just added "
                                                + clubs.get(clubs.size() - 1));
                                        
                                        
                                        Path clubPath = Path.of("./data/clubs.txt");
                                        // lấy path tới file clubs.txt
                                        fileExe.writeToFile(clubPath, fileExe.clubsToStringList(clubs));
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Invalid input. Please enter the correct information.");
                                        input.nextLine();
                                    }
                                }
                            }

    // Đây là phương thức cập nhật thông tin của câu lạc bộ theo tên câu lạc bộ.(đổi
    // tên, và đổi stadium)
    public static void upDateCLub(Scanner input) {
                            System.out.print("Enter the name of the club you want to update: ");
                            String clubName = input.nextLine();
                            boolean found = false;
                            for (Club club : clubs) {
                                if (club.getClubName().equalsIgnoreCase(clubName)) {
                                    System.out.print("Enter new club name: ");
                                    String newClubName = input.nextLine();
                                    club.setClubName(newClubName);
                                    System.out.print("Enter new stadium: ");
                                    String newStadium = input.nextLine();
                                    club.setStadium(newStadium);
                                    System.out.println("Club updated successfully.");
                                    found = true;
                                    break;
                                    }
                                    }
                                    if (!found) {
                                        System.out.println("Club with name \"" + clubName + "\" not found.");
                                    }
                                    }

    // Tìm và in ra thông tin cau lạc bộ bằng 2 cách đó là bằng tìm ID và tìm kiếm
    // bằng tên.
    public static void searchClubWithInput(Scanner input) {
                            boolean continueSearch;
                            do {
                                continueSearch = false;
                                System.out.println("Choose search option: ");
                                System.out.println("1. Search by ID");
                                System.out.println("2. Search by Club Name");
                                System.out.print("Enter your option: ");
                                int option = 0;
                                try {
                                    option = input.nextInt();
                                    input.nextLine();
                                } catch (InputMismatchException e) {
                                    System.out.println("Invalid input. Please enter a number.");
                                    input.nextLine();
                                    continue;
                                }
                                switch (option) {
                                    case 1:
                                        System.out.print("Enter club ID: ");
                                        try {
                                            int clubId = input.nextInt();
                                            input.nextLine(); 
                                            searchClub(clubId);
                                        } catch (InputMismatchException e) {
                                            System.out.println("Invalid input. Please enter a number.");
                                            input.nextLine(); 
                                        }
                                        break;
                                    case 2:
                                        System.out.print("Enter club name: ");
                                        String clubName = input.nextLine();
                                        searchClub(clubName);
                                        break;
                                    default:
                                        System.out.println("Invalid option.");
                                        continue;
                                }
                                System.out.print("Do you want to search again? (Y/N): ");
                                String choice = input.nextLine();
                                if (choice.equalsIgnoreCase("Y")) {
                                    continueSearch = true;
                                }
                                }while (continueSearch);
                                }        
// search theo ID của CLB
    public static void searchClub(int input) {
                            int clubID;
                            do {
                                try {
                                    clubID = input;

                                    Club foundClub = null;
                                    for (Club club : clubs) {
                                        if (club.getClubId() == clubID) {
                                            foundClub = club;
                                            break;
                                        }
                                    }

                                    if (foundClub != null) {
                                        System.out.println("Club found by ID:");
                                        System.out.println(foundClub);
                                    } else {
                                        System.out.println("Club with ID " + clubID + " not found.");
                                    }

                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid club ID (a number).");
                                        clubID = -1;
                                    }
                                } while (clubID == -1);
                            }
// search theo club name
    public static void searchClub(String input) {
                            String clubName;
                            boolean found;
                            do {
                                clubName = input;
                                found = false;
                                for (Club club : clubs) {
                                    if (club.getClubName().equalsIgnoreCase(clubName)) {
                                        System.out.println("Club found by Name:");
                                        System.out.println(club);
                                        found = true;
                                        break;
                                        }
                                    }
                                if (!found) {
                                    System.out.println("Club with name \"" + clubName + "\" not found.");
                                    break;
                                    }
                                } while (!found);
                            }

// phương thức xoá câu lạc bộ--sau đó write lại file txt.
public static void deleteClubWithInput(Scanner input) {
                        boolean continueDelete;
                            do {
                            continueDelete = false;
                            System.out.println("Choose delete option: ");
                            System.out.println("1. Delete by ID");
                            System.out.println("2. Delete by Club Name");
                            System.out.print("Enter your option: ");
                            for (int i = 0; i<clubs.size();i++){
                                System.out.println(clubs.get(i).toString());
                            }
                            int option = 0;
                            try {
                                option = input.nextInt();
                                input.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a number.");
                                input.nextLine();
                                continue;
                            }
                            switch (option) {
                                case 1:
                                    System.out.print("Enter club ID: ");
                                    try {
                                        int clubId = input.nextInt();
                                        input.nextLine(); 
                                        deleteClub(clubId);
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a number.");
                                        input.nextLine();
                                    }
                                    break;
                                case 2:
                                    System.out.print("Enter club name: ");
                                    String clubName = input.nextLine();
                                    deleteClub(clubName);
                                    break;
                                default:
                                    System.out.println("Invalid option.");
                                    continue;
                            }
                                    System.out.print("Do you want to delete another club? (Y/N): ");
                                    String choice = input.nextLine();
                                    if (choice.equalsIgnoreCase("Y")) {
                                        continueDelete = true;
                                    }
                                } while (continueDelete);
                                }

                                public static void deleteClub(int clubId) {
                                    boolean found = false;
                                    for (Club club : clubs) {
                                        if (club.getClubId() == clubId) {
                                            clubs.remove(club);
                                            System.out.println("Club deleted successfully.");
                                            found = true;
                                            break;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Club with ID " + clubId + " not found.");
                                    } else {
                                        Path clubPath = Path.of("./data/clubs.txt");
                                        fileExe.writeToFile(clubPath, fileExe.clubsToStringList(clubs));
                                        }
                                    }

                                    public static void deleteClub(String clubName) {
                                        for (Club club : clubs) {
                                            if (club.getClubName().equalsIgnoreCase(clubName)) {
                                                clubs.remove(club);
                                                System.out.println("Club deleted successfully.");
                                                Path clubPath = Path.of("./data/clubs.txt");
                                                fileExe.writeToFile(clubPath, fileExe.clubsToStringList(clubs));
                                                break;
                                            }
                                        }
                                    }


   
    public static void playerInformation() {
                                Scanner input = new Scanner(System.in);
                                int choice;
                                do {
                                    System.out.println("----- Player Management -----");
                                    System.out.println("1. Add Player");
                                    System.out.println("2. Search Player");
                                    System.out.println("3. Update Player");
                                    System.out.println("4. Delete Player");
                                    System.out.println("5. Back to Main Menu");
                                    System.out.print("Please enter your choice: ");

                                    try {
                                        choice = input.nextInt();
                                        switch (choice) {
                                            case 1:
                                                addPlayer(input);
                                                break;
                                            case 2:
                                                searchPlayerMenu(input);
                                                break;
                                            case 3:
                                                updatePlayer(input);
                                                break;
                                            case 4:
                                                deletePlayer(input);
                                                break;
                                            case 5:
                                                System.out.println("Returning to main menu...");
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                                                break;
                                        }
                                    } catch (InputMismatchException e) {
                                        System.out.println("Invalid input. Please enter a valid number.");
                                        input.nextLine();
                                        choice = 0;
                                    }
                                } while (choice != 5);
                            }

    public static void addPlayer(Scanner input) {
                                    input.nextLine();

                                    System.out.println("Enter player details:");         
                                    int playerId = players.getLast().getJerseyNumber();
                                    System.out.print("Name: ");
                                    String name = input.nextLine();

                                    System.out.print("Age: ");
                                    int age = input.nextInt();
                                    input.nextLine();

                                    System.out.print("Nationality: ");
                                    String nationality = input.nextLine();

                                    System.out.print("Transfer Value: ");
                                    double transferValue = input.nextDouble();

                                    System.out.print("Jersey Number: ");
                                    int jerseyNumber = input.nextInt();

                                    System.out.print("Height: ");
                                    double height = input.nextDouble();

                                    System.out.print("Weight: ");
                                    double weight = input.nextDouble();

                                    System.out.print("Number of Clubs: ");
                                    int numClubs = input.nextInt();
                                    input.nextLine();

                                    List<Integer> clubIds = new ArrayList<>();
                                    for (int i = 0; i < numClubs; i++) {
                                        System.out.print("Club ID " + (i + 1) + ": ");
                                        int clubId = input.nextInt();
                                        clubIds.add(clubId);
                                    }

                                    Player newPlayer = new Player(playerId, name, age, nationality, transferValue, jerseyNumber, height, weight, clubIds);
                                    players.add(newPlayer);
                                    Path playerPath = Path.of("./data/players.txt");
                                        // lấy path tới file player.txt
                                        fileExe.writeToFile(playerPath, fileExe.playersToStringList(players));
                                    

                                        System.out.println("Player added successfully.");
                                    }

    public static void updatePlayer(Scanner input) {
                                    input.nextLine();

                                    System.out.print("Enter player ID to update: ");
                                    int playerId = input.nextInt();
                                    input.nextLine();

                                    boolean found = false;
                                    for (Player player : players) {
                                        if (player.getPlayerId() == playerId) {
                                            System.out.println("Enter new details:");

                                            System.out.print("Name: ");
                                            String name = input.nextLine();
                                            player.setName(name);

                                            System.out.print("Age: ");
                                            int age = input.nextInt();
                                            input.nextLine();
                                            player.setAge(age);

                                            System.out.print("Nationality: ");
                                            String nationality = input.nextLine();
                                            player.setNationality(nationality);

                                            System.out.print("Transfer Value: ");
                                            double transferValue = input.nextDouble();
                                            player.setTransferValue(transferValue);

                                            System.out.print("Jersey Number: ");
                                            int jerseyNumber = input.nextInt();
                                            player.setJerseyNumber(jerseyNumber);

                                            System.out.print("Height: ");
                                            double height = input.nextDouble();
                                            player.setHeight(height);

                                            System.out.print("Weight: ");
                                            double weight = input.nextDouble();
                                            player.setWeight(weight);

                                            System.out.print("Number of Clubs: ");
                                            int numClubs = input.nextInt();
                                            input.nextLine();

                                            List<Integer> clubIds = new ArrayList<>();
                                            for (int i = 0; i < numClubs; i++) {
                                                System.out.print("Club ID " + (i + 1) + ": ");
                                                int clubId = input.nextInt();
                                                clubIds.add(clubId);
                                            }
                                            player.setClubsID(clubIds);
                                            Path playerPath = Path.of("./data/players.txt");
                                                                    // lấy path tới file player.txt
                                                                    fileExe.writeToFile(playerPath, fileExe.playersToStringList(players));

                                            System.out.println("Player updated successfully.");
                                            found = true;
                                            break;
                                            }
                                            }

                                            if (!found) {
                                                System.out.println("Player with ID " + playerId + " not found.");
                                            }
                                            }

    public static void searchPlayerMenu(Scanner input) {
                                            int choice;
                                            do {
                                                System.out.println("Search Player by:");
                                                System.out.println("1. Player ID");
                                                System.out.println("2. Player Name");
                                                System.out.println("3. Club ID");
                                                System.out.println("4. Club Name");
                                                System.out.println("5. Back to Player Menu");
                                                System.out.print("Enter your choice: ");

                                                try {
                                                    choice = input.nextInt();
                                                    input.nextLine();

                                                    switch (choice) {
                                                        case 1:
                                                            System.out.print("Enter player ID: ");
                                                            int playerId = input.nextInt();
                                                            input.nextLine();
                                                            searchPlayerById(playerId);
                                                            break;
                                                        case 2:
                                                            System.out.print("Enter player name: ");
                                                            String playerName = input.nextLine();
                                                            searchPlayerByName(playerName);
                                                            break;
                                                        case 3:
                                                            System.out.print("Enter club ID: ");
                                                            int clubId = input.nextInt();
                                                            input.nextLine();
                                                            searchPlayersByClubId(clubId);
                                                            break;
                                                        case 4:
                                                            System.out.print("Enter club name: ");
                                                            String clubName = input.nextLine();
                                                            searchPlayersByClubName(clubName);
                                                            break;
                                                        case 5:
                                                            System.out.println("Returning to Player Menu...");
                                                            break;
                                                        default:
                                                            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                                                            break;
                                                    }
                                                } catch (InputMismatchException e) {
                                                    System.out.println("Invalid input. Please enter a valid number.");
                                                    input.nextLine();
                                                    choice = 0;
                                                }
                                            } while (choice != 5);
                                        }

    public static void searchPlayerById(int playerId) {
                                        boolean found = false;
                                        for (Player player : players) {
                                            if (player.getPlayerId() == playerId) {
                                                System.out.println("Player found:");
                                                System.out.println(player);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("Player with ID " + playerId + " not found.");
                                        }
                                    }

                                    public static void searchPlayerByName(String playerName) {
                                        boolean found = false;
                                        for (Player player : players) {
                                            if (player.getName().equalsIgnoreCase(playerName)) {
                                                System.out.println("Player found:");
                                                System.out.println(player);
                                                found = true;
                                                break;
                                            }
                                        }
                                        if (!found) {
                                            System.out.println("Player with name \"" + playerName + "\" not found.");
                                        }
                                    }

    public static void searchPlayersByClubId(int clubId) {
                                    boolean found = false;
                                    for (Player player : players) {
                                        if (player.getClubsID().contains(clubId)) {
                                            System.out.println("Players in Club ID " + clubId + ":");
                                            System.out.println(player);
                                            found = true;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("No players found for Club ID " + clubId);
                                    }
                                    }

    public static void searchPlayersByClubName(String clubName) {
                                    boolean found = false;
                                    for (Player player : players) {
                                        for (int clubId : player.getClubsID()) {
                                            Club club = getClubById(clubId);
                                            if (club != null && club.getClubName().equalsIgnoreCase(clubName)) {
                                                System.out.println("Players in Club \"" + clubName + "\":");
                                                System.out.println(player);
                                                found = true;
                                                break;
                                            }
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("No players found for Club \"" + clubName + "\"");
                                    }
                                    }

    public static void deletePlayer(Scanner input) {
                                    for (int i = 0; i<players.size();i++)
                                    {
                                        System.out.println(players.get(i).toString());
                                    }
                                    System.out.print("Enter player ID to delete: ");
                                    int playerId = input.nextInt();
                                    input.nextLine();

                                    boolean found = false;
                                    Iterator<Player> iterator = players.iterator();
                                    while (iterator.hasNext()) {
                                        Player player = iterator.next();
                                        if (player.getPlayerId() == playerId) {
                                            iterator.remove();          
                                            System.out.println("Player with ID " + playerId + " deleted successfully.");
                                            found = true;
                                            Path playerPath = Path.of("./data/players.txt");
                                            // lấy path tới file player.txt
                                            fileExe.writeToFile(playerPath, fileExe.playersToStringList(players));
                                            break;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Player with ID " + playerId + " not found.");
                                    }
                                }

    private static Club getClubById(int clubId) {
                                    for (Club club : clubs) {
                                        if (club.getClubId() == clubId) {
                                            return club;
                                        }
                                    }
                                    return null;
                                }
    public static void coachInformation() {
                                Scanner input = new Scanner(System.in);
                                int choice;
                                do {
                                    System.out.println("----- Coach Management -----");
                                    System.out.println("1. Add Coach");
                                    System.out.println("2. Update Coach");
                                    System.out.println("3. Delete Coach");
                                    System.out.println("4. Print All Coaches");
                                    System.out.println("5. Exit");
                                    System.out.print("Please enter your choice: ");

                                    try {
                                        choice = input.nextInt();
                                        input.nextLine(); 

                                        switch (choice) {
                                            case 1:
                                                addCoach(input);
                                                break;
                                            case 2:
                                                updateCoach(input);
                                                break;
                                            case 3:
                                                deleteCoach(input);
                                                break;
                                            case 4:
                                                printAllCoaches();
                                                break;
                                            case 5:
                                                System.out.println("Exiting...");
                                                break;
                                            default:
                                                System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                                                break;
                                        }
                                    } catch (Exception e) {
                                        System.out.println("Error: " + e.getMessage());
                                        input.nextLine();
                                        choice = 0; 
                                    }
                                } while (choice != 5);
                                input.close();
                                }

    public static void addCoach(Scanner input) {
                                System.out.println("Enter coach details:");

                                try {
                                    System.out.print("Coach ID: ");
                                    int coachID = input.nextInt();
                                    input.nextLine();

                                    System.out.print("Name: ");
                                    String name = input.nextLine();

                                    System.out.print("Experience (years): ");
                                    int experience = input.nextInt();
                                    input.nextLine(); 

                                    System.out.print("Club ID: ");
                                    int clubID = input.nextInt();
                                    input.nextLine(); 

                                    System.out.print("Nationality: ");
                                    String nationality = input.nextLine();

                                    Coach newCoach = new Coach(coachID, name, experience, clubID, nationality);
                                    coaches.add(newCoach);

                                    System.out.println("Coach added successfully.");
                                    Path coachPath = Path.of("./data/coaches.txt");
                                                                fileExe.writeToFile(coachPath, fileExe.coachesToStringList(coaches));
                                } catch (Exception e) {
                                    System.out.println("Error adding coach: " + e.getMessage());
                                    input.nextLine(); 
                                }
                                }

    public static void updateCoach(Scanner input) {
                                System.out.print("Enter coach ID to update: ");
                                try {
                                    int coachId = input.nextInt();
                                    input.nextLine(); 

                                    boolean found = false;
                                    for (Coach coach : coaches) {
                                        if (coach.getCoachID() == coachId) {
                                            System.out.println("Enter new details for Coach ID " + coachId + ":");

                                            System.out.print("Name: ");
                                            String name = input.nextLine();
                                            coach.setName(name);

                                            System.out.print("Experience (years): ");
                                            int experience = input.nextInt();
                                            input.nextLine(); 
                                            coach.setExperience(experience);

                                            System.out.print("Club ID: ");
                                            int clubID = input.nextInt();
                                            input.nextLine(); 
                                            coach.setClubID(clubID);

                                            System.out.print("Nationality: ");
                                            String nationality = input.nextLine();
                                            coach.setNationality(nationality);

                                            System.out.println("Coach updated successfully.");
                                            Path coachPath = Path.of("./data/coaches.txt");
                                            fileExe.writeToFile(coachPath, fileExe.coachesToStringList(coaches));
                                            found = true;
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Coach with ID " + coachId + " not found.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error updating coach: " + e.getMessage());
                                    input.nextLine();
                                    }
                                    }

    public static void deleteCoach(Scanner input) {
                                for (int i = 0;i<coaches.size();i++){
                                    System.out.println(coaches.get(i).toString());
                                }
                                System.out.print("Enter coach ID to delete: ");
                                try {
                                    int coachId = input.nextInt();
                                    input.nextLine(); 

                                    boolean found = false;
                                    Iterator<Coach> iterator = coaches.iterator();
                                    while (iterator.hasNext()) {
                                        Coach coach = iterator.next();
                                        if (coach.getCoachID() == coachId) {
                                            iterator.remove();
                                            System.out.println("Coach with ID " + coachId + " deleted successfully.");
                                            Path coachPath = Path.of("./data/coaches.txt");
                                            fileExe.writeToFile(coachPath, fileExe.coachesToStringList(coaches));
                                            found = true;
                                            break;
                                        }
                                    }

                                    if (!found) {
                                        System.out.println("Coach with ID " + coachId + " not found.");
                                    }
                                } catch (Exception e) {
                                    System.out.println("Error deleting coach: " + e.getMessage());
                                    input.nextLine(); 
                                }
                                }

    public static void printAllCoaches() {
                                System.out.println("List of Coaches:");
                                for (Coach coach : coaches) {
                                    System.out.println(coach);
                                }
                                }
    public static double calculateTotalTransferValue(List<Player> players, String clubName) {
                                    double totalTransferValue = 0;
                                    String normalizedClubName = clubName.toLowerCase();
                                
                                    for (Player player : players) {
                                        for (int clubId : player.getClubsID()) {
                                            Club club = getClubById(clubId);
                                            if (club != null && club.getClubName().equalsIgnoreCase(normalizedClubName)) {
                                                totalTransferValue += player.getTransferValue();
                                                break;
                                            }
                                        }
                                    }
                                
                                    return totalTransferValue;
                                }
                                 
    public static Club getClubByID(int clubId){
                                    for (Club club : clubs) {
                                        if (club.getClubId() == clubId) {
                                            return club;
                                        }
                                    }
                                    return null;
                                }

    public static void readData() {
        Path clubPath = Path.of("./data/clubs.txt");
        Path coachPath = Path.of("./data/coaches.txt");
        Path playerPath = Path.of("./data/players.txt");
        clubs = fileExe.readClubs(clubPath);
        coaches = fileExe.readCoaches(coachPath);
        players = fileExe.readPlayers(playerPath);
    }
}
