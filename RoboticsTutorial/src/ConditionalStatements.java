public class ConditionalStatements {

    void ifElse(){
        int x = 5;
        if(x == 5){
            System.out.println("x is equal to 5");
        }

        if(x != 6){

        }

        String g = "Hi my age is 6";

        if(!g.equals("Hi")){
            System.out.println("No!");
        }
        else if(g.equals("Hi")){
            System.out.println("Yay!");
        }
        else{
            System.out.println("Nothing works!");
        }

    }

    void switchCase(){

        String t = "boy";

        switch (t){
            case "t": {
                System.out.println("Found it!");
                break;
            }
            case "boy": {
                System.out.println("Found it! It's boy!");
                break;
            }
            default: {
                System.out.println("Couldn't find it. :(");
            }
        }

    }

}
