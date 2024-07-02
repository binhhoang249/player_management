import java.nio.file.Path;
import java.util.InputMismatchException;
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
            System.out.println("5. Back to Main Menu");
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
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
        } while (choice != 5);
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
    }

    public static void coachInformation() {
    }

    public static void readData() {
        Path clubPath = Path.of("./data/clubs.txt");
        Path coachPath = Path.of("./data/coaches.txt");
        Path playerPath = Path.of("./data/players.txt");
        clubs = fileExe.readClubs(clubPath);
        coaches = fileExe.readCoaches(coachPath);
        players = fileExe.readPlayers(playerPath);

        /*
         * for (int i = 0; i < players.size(); i++) {
         * System.out.println(players.get(i));
         * }
         */
    }

}
