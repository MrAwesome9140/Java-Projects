public class classes {

    void doStuff(){
        Person p = new Person("Joe", 15, 'J');
        p.getAge();
        p.setAge(16);

        Scientist sc = new Scientist("Joe", 30, 'J', "Biologist", 10);
        sc.getType();
        sc.getAge();
    }

}

class Person{

    private String name;
    private int age;
    private char firstInitial;

    Person(String name, int age, char firstInitial){
        this.name = name;
        this.age = age;
        this.firstInitial = firstInitial;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int newAge){
        age = newAge;
    }

}

class Scientist extends Person{

    String type;
    int yearsWorking;

    Scientist(String name, int age, char firstInitial, String type, int yearsWorking){
        super(name, age, firstInitial);
        this.type = type;
        this.yearsWorking = yearsWorking;
    }

    public String getType(){
        return type;
    }

}
