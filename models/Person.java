public abstract class Person {
    protected String name;
    protected int age;
    protected String nationality;

    public Person(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Person() {

    }

    public Person(String name, int age, String nationality) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality){
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.age + ", " + this.nationality;
    }
}
