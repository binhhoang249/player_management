import java.util.ArrayList;
import java.util.List;

public class Player extends Person {
    private int playerId;
    private List<Integer> clubs; 
    private double transferValue;
    private int jerseyNumber;
    private double height;
    private double weight;

    public Player(int playerId, String name, int age, String nationality, double transferValue, int jerseyNumber, double height, double weight) {
        super(name, age, nationality); 
        this.playerId = playerId;
        this.clubs = new ArrayList<>();
        this.transferValue = transferValue;
        this.jerseyNumber = jerseyNumber;
        this.height = height;
        this.weight = weight;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void addClub(int clubId) {
        clubs.add(clubId);
    }

    public void removeClub(int clubId) {
        clubs.remove(Integer.valueOf(clubId));
    }

    public List<Integer> getClubs() {
        return clubs;
    }

    public double getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(double transferValue) {
        this.transferValue = transferValue;
    }

    public int getJerseyNumber() {
        return jerseyNumber;
    }

    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return super.toString() + ", playerId=" + playerId +
                ", transferValue=" + transferValue +
                ", jerseyNumber=" + jerseyNumber +
                ", height=" + height +
                ", weight=" + weight +
                ", clubs=" + clubs +
                '}';
    }
 }
