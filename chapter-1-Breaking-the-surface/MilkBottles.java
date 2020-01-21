public class MilkBottles {
    public static void main(String[] args) {
        int milk = 10;
        String word = "bottles";

        while (milk > 0) {
            if (milk == 1) {
                word = "bottle";
            }
            System.out.println(milk + " " + word + " of milk on the wall");
            System.out.println(milk + " " + word + " of milk");
            System.out.println("take one down.");
            System.out.println("Pass it around.");
            milk = milk - 1;
        }
        System.out.println("NO MORE MILK!!");
    }
}
