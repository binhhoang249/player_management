
public class Club {
    private int ClubId;
    private String clubName;
    private int yearFounded;
    private String stadium;

    public int getClubId() {
        return ClubId;
    }

    public void setClubId(int clubId) {
        ClubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public int getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public Club() {
    }

    public Club(int ClubId, String clubName, int yearFounded, String stadium) {
        this.ClubId = ClubId;
        this.clubName = clubName;
        this.yearFounded = yearFounded;
        this.stadium = stadium;
    }


    @Override
    public String toString() {
        return ClubId +
                ", " + clubName +
                ", " + yearFounded +
                ", " + stadium +"\n";

    }
}
