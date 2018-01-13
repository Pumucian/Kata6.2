package kata6.model;

public class Person {
    private final int id;
    private final String name, birthDate, mail;
    private final Character gender;
    private final float weight;
    
    public Person(int id, String name, Character gender, String birthDate, float weight, String mail){
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.mail = mail;
        this.gender = gender;
        this.weight = weight;
        
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getMail() {
        return mail;
    }

    public Character getGender() {
        return gender;
    }

    public float getWeight() {
        return weight;
    }
    
    

}
