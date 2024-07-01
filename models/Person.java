public abstract class  Person {
    protected String name;
    protected int age;
    protected String nationality;

    public Person(){
        
    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getNationality(){
        return this.nationality;
    }


    @Override
    public String toString() {
        return this.name + ", Age: " + this.age +", nationality"+this.nationality;
    }
}
