public class Coach extends Person {
    private int coachID;
    private int experience;
    private int clubID;

    public Coach() {
        super();
    }

    public Coach(int coachID, String name, int experience, int clubID, String nationality) {
        super(name, nationality);
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
        return coachID +
                ", " + super.toString() +
                ", " + experience +
                ", " + clubID;
    }
}
