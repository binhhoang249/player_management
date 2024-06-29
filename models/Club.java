
public class Club {
    private static int ClubId;
    private String clubName;
    private static int yearFounded;
    private String stadium;

    public Club(){}

    public Club(int ClubId, String clubName,int yearFounded, String stadium){
        Club.ClubId = ClubId;
        this.clubName = clubName;
        Club.yearFounded = yearFounded;
        this.stadium = stadium;
    }

    public int getID(){
        return Club.ClubId;
    }

    public String getName(){
        return this.clubName;
    }

    public void setName (String clubName){
        this.clubName = clubName;
    }

    public int getFounded(){
        return Club.yearFounded;
    }

    public String getStadium (){
        return this.stadium;
    }

    public void setStadium (String stadium){
        this.stadium = stadium;
    }

    @Override
    public String toString() {
        return "Club{" +
        "clubId=" + Club.ClubId +
        ", clubName='" + clubName + '\'' +
        ", yearFounded=" + yearFounded +
        ", stadium='" + stadium + '\'' +
        '}';

    }
}

    

