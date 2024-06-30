public class Coach extends Person {
    private static int coachID ;
    private int experience;
    private int clubID;

    public Coach(){}

    public Coach (int coachID,String name,int age, String nationality,int experience, int clubID){
        super(name, age, nationality); 
        Coach.coachID = coachID;
        this.experience = experience;
        this.clubID = clubID;
    }

    public int getCoachID(){
        return Coach.coachID;
    }

    public int getExperience(){
        return this.experience;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }
}
