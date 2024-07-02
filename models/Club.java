
public class Club {
    private int ClubId;
    private String clubName;
    private int yearFounded;
    private String stadium;

    public Club() {
    }

    public Club(int ClubId, String clubName, int yearFounded, String stadium) {
        this.ClubId = ClubId;
        this.clubName = clubName;
        this.yearFounded = yearFounded;
        this.stadium = stadium;
    }

    public int getClubID() {
        return this.ClubId;
    }

    public String getCLubName() {
        return this.clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getFounded() {
        return this.yearFounded;
    }

    public String getStadium() {
        return this.stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return ClubId +
                ", " + clubName +
                ", " + yearFounded +
                ", " + stadium;

    }
}
