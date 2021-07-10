import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class objects {

    void Strings(){
        String firstName = "John";
        String lastName = "Smith";
    }

    void Arrays(){
        int[] numbers = new int[10];
        numbers[0] = 10;
        numbers[5] = -43;
        numbers[0] = 29;
        int temp = numbers.length;

        String[] words = new String[10];
        words[0] = "Hi";
        words[9] = "You";
    }

    void ArrayLists(){
        ArrayList<String> words = new ArrayList<>();
        words.add("Hi");
        words.add("Nope");
        words.remove(0);
        words.size();
        words.add(0, "Go");
    }

    void Maps(){
        HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("firstName", 50);
        myMap.put("a", 63);
        myMap.get("a");
        myMap.replace("a", 59);
        myMap.remove("firstName");
        myMap.size();
    }

    void Sets(){
        Set<String> hi = new HashSet<>();
        hi.add("hi");
        hi.remove("hi");
        hi.size();
    }

    void UserObjects(){
        Dog d = new Dog("John", 5, 6.75);
    }

}

class Dog{

    String name;
    int age;
    double height;

    Dog(String name, int age, double height){
        this.name = name;
        this.age = age;
        this.height = height;
    }

}
