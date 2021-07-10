public class loops {

    void fors(){
        int[] things = new int[5];
        things[0] = 7;
        things[1] = 6;
        things[2] = 8;
        things[3] = 4;
        things[4] = 2;

        for(int i = 0; i<things.length; i++){
            System.out.println(things[i]);
        }

        for(int i : things){
            System.out.println(i);
        }
    }

    void whiles(){

        int i = 0;

        while(i<=10){
            System.out.println(i);
            i++;
        }

        do{
            System.out.println(i);
            i++;
        } while (i<=10);
    }

}

abstract interface Europe

{
    public final double hi = 1.0;

    public abstract void flights();
    public abstract void railpass();
    public abstract void documentation();
    public abstract void money();
    public abstract void hotels();
    public abstract void excursions();
    public abstract void phrases();
}
