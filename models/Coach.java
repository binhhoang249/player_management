public class Coach extends Person {
    private int coachID;
    private int experience;
    private int clubID;

    public Coach() {
        super(); 
    }

    public Coach(int coachID, String name, int age, String nationality, int experience, int clubID) {
        super(name, age, nationality); 
        this.coachID = coachID;
        this.experience = experience;
        this.clubID = clubID;   
    }

    public int getCoachID() {
        return coachID;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getClubID() {
        return clubID;
    }

    public void setClubID(int clubID) {
        this.clubID = clubID;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "coachID=" + coachID +
                ", " + super.toString() +
                ", experience=" + experience +
                ", clubID=" + clubID +
                '}';
    }
}
