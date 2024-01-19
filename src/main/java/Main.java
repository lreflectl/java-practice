import java.util.Arrays;
import java.util.Locale;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Main {
    private static void dataPrimitives() {
        byte num1 = (byte) 254;
        short num2 = (short) 250000000;
        int num3 = 289000000;
        long num4 = 435_000_000_000L;

        float num5 = 10.00f;
        double num6 = 900.000d;

        char character = 'b';
        boolean isSome = true;
    }

    private static void userInputAndArithmeticOperations() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Input second number: ");
        int num2 = scanner.nextInt();

        long result1 = num1 + num2;
        long result2 = num1 - num2;
        long result3 = (long) num1 * num2;
        float result4 = (float) num1 / num2;
        int result5 = num1 % num2;
        double result6 = Math.pow(num1, num2);

        System.out.printf("Result of + is: %d\n", result1);
        System.out.printf("Result of - is: %d\n", result2);
        System.out.printf("Result of * is: %d\n", result3);
        System.out.printf("Result of / is: %f\n", result4);
        System.out.printf("Result of %% is: %d\n", result5);
        System.out.printf("Result of power is: %.0f\n\n", result6);
    }

    private static void conditionals() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Input second number: ");
        int num2 = scanner.nextInt();
        System.out.print("Input operation: ");
        int opSign = scanner.next().charAt(0);

        OptionalDouble result = OptionalDouble.empty();
        switch (opSign) {
            case '+':
                result = OptionalDouble.of(num1 + num2);
                break;
            case '-':
                result = OptionalDouble.of(num1 - num2);
                break;
            case '*':
                result = OptionalDouble.of(num1 * num2);
                break;
            case '/':
                if (num2 == 0) {
                    System.out.println("Zero division.");
                    break;
                }
                result = OptionalDouble.of((float) num1 / num2);
                break;
            default:
                System.out.printf("Unknown operation: %s\n", opSign);
        }
        if (result.isPresent()) {
            System.out.printf("%d %c %d = %.2f\n\n", num1, opSign, num2, result.getAsDouble());
        } else {
            System.out.println("Cannot perform the operation.\n");
        }
    }



    public static void main(String[] args) {
//        dataPrimitives();
//        userInputAndArithmeticOperations();
//        conditionals();
    }
}
