import java.util.Scanner;

class decadesOld {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter an age: ");
        int number = input.nextInt();
        number = number / 10;
        System.out.println("You are " + number + " Decades Old");
    }
}