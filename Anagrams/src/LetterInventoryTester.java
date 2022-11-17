public class LetterInventoryTester {

    public static void main(String[] args) {
        LetterInventory letterInventory = new LetterInventory("Aaroh Sharma");
        System.out.println(letterInventory.subtract(new LetterInventory(
                "sharsodij")));
    }

}
