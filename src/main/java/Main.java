import arraySortingGui.ArraySortingGuiFrame;
import oop.Car;
import oop.SportCar;
import oop.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

import static utils.Utils.quickSort;

public class Main {
    private static void dataPrimitives() {
        byte num1 = (byte) 254;
        short num2 = (short) 250000000;
        int num3 = 289000000;
        long num4 = 435_000_000_000L;

        float num5 = 10.7f;
        double num6 = 900.333;  // Default data type for decimals in Java is double

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

    private static void loops() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Iteration (for) " + i);
        }

        int i = 0;
        while (i < 10) {
            System.out.println("Iteration (while) " + i);
            i++;
        }

        i = 0;
        do {
            System.out.println("Iteration (do-while) " + i);
            i++;
        } while (i < 10);
    }

    private static void arrays() {
        int[] arrayOfIntegers = {1,2,3,4};
        OptionalDouble avg = Arrays.stream(arrayOfIntegers).average();
        avg.ifPresent(
                (double avgVal) -> System.out.printf("%s, %s%n\n", Arrays.toString(arrayOfIntegers), avgVal)
        );

        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);  // Set US locale to use colon in floats
        System.out.println("Enter array shape (rows, cols): ");
        String userInput = scanner.nextLine();
        System.out.printf("User input \"%s\"\n", userInput);
        String[] userArrayShape = userInput.split("\\s*,\\s*|\\s+");
        System.out.println("Array (of strings) " + Arrays.toString(userArrayShape));
        int rows = Integer.parseInt(userArrayShape[0]);
        int cols = Integer.parseInt(userArrayShape[1]);
        System.out.printf("User input: %d rows and %d cols\n\n", rows, cols);
        System.out.println("Enter value to fill the array with: ");
        float value = scanner.nextFloat();

        float[][] array = new float[rows][cols];
        for (int row = 0; row < rows; row++){
            for (int col = 0; col < cols; col++){
                array[row][col] = value;
            }
        }

        System.out.println("Results: ");
        for (int i = 0; i < rows; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private static void collections() {
        Collection<String> names = new ArrayList<>();
        int namesLen = 10;
        StringBuilder currentName = new StringBuilder("John");
        char[] letters = currentName.toString().toCharArray();
        Random gen = new Random();
        for (int i = 0; i < namesLen; i++) {
            names.add(currentName.toString());
            if (i + 1 < currentName.length()) {
                char prevChar = currentName.charAt(i);
                // Swap chars
                currentName.setCharAt(i, currentName.charAt(i+1));
                currentName.setCharAt(i+1, prevChar);
            }
            else {
                int randomIndex = gen.nextInt(0, letters.length);
                currentName.append(letters[randomIndex]);
            }
        }

        for (Iterator<String> iterator = names.iterator(); iterator.hasNext();) {
            String name = iterator.next();
            if (iterator.hasNext()) {
                System.out.printf("%s, ", name);
            } else {
                System.out.println(name);
            }
        }

        Map<String, Integer> nameToAge = new HashMap<>();
        for (String name : names) {
            nameToAge.put(name, gen.nextInt(10, 30));
        }

        System.out.println(nameToAge);
    }

    private static void classesAndInterfaces(){
        Vehicle car = new Car("Nissan", 200);
        car.start();
        car.start();
        System.out.println(car.getSpeed() + "\n");

        Vehicle sportCar = new SportCar("F1", 300, 100);
        sportCar.start();
        sportCar.start();
        System.out.println(sportCar.getSpeed());
    }

    private static void files() {
        File file = new File("src/main/resources/textFile.txt");
        if (!file.exists()) {
            try {
                boolean isCreated = file.createNewFile();
                if (isCreated) {
                    System.out.println("Successfully created file!");
                } else {
                    System.out.println("Cannot create the file.");
                    return;
                }
            } catch (IOException e) {
                System.out.println("Exception occurred during file creation.");
                return;
            }
        } else {
            System.out.println("File already exists, skipping creation stage...");
        }

        String textToWrite = "Java Practice!\nHello World!";
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(textToWrite);
            System.out.println("Wrote content to the file.");
        } catch (IOException e) {
            System.out.println("Cannot write to the file");
            return;
        }

        System.out.println("Reading contents of the file:");
        try (FileReader reader = new FileReader(file)) {
            StringBuilder readText = new StringBuilder();
            int charNum;
            int lettersRead = 0;
            while ((charNum = reader.read()) != -1) {
                readText.append((char) charNum);
                lettersRead++;
            }

            System.out.println(readText);
            System.out.printf("Read %d letters from the file.", lettersRead);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Exception occurred during file read.");
        }
    }

    private static void dynamicPolymorphism() {
        Vehicle[] garage = new Vehicle[10];
        int speed = 40;
        String name = "Car";
        for (int i = 0; i < garage.length; i++) {
            if (i % 2 == 0) {
                garage[i] = new Car(name+i, speed+i*10);
            } else {
                garage[i] = new SportCar("Sport"+name+i, speed+i*20, 100);
            }
        }

        for (Vehicle vehicle: garage) {
            vehicle.start();
            System.out.println("Speed: " + vehicle.getSpeed());
        }
    }

    private static void sortingAlgorithms() {
        int arrayLength = 1_000_000;
        double[] arrayToSort = new double[arrayLength];
        Random gen = new Random();
        for (int i = 0; i < arrayLength; i++) {
            arrayToSort[i] = gen.nextInt(-100, 100);
        }

        var startTimeMs = System.currentTimeMillis();

        quickSort(arrayToSort, 0, arrayToSort.length-1);
//        Arrays.sort(arrayToSort);

        var timePassedMs = System.currentTimeMillis() - startTimeMs;

        System.out.println(Arrays.toString(arrayToSort));
        System.out.println("Time passed: " + timePassedMs + " ms");
    }


    private static void javaSwingGui() {
        ArraySortingGuiFrame guiFrame = new ArraySortingGuiFrame();
    }

    public static void main(String[] args) {
//        dataPrimitives();
//        userInputAndArithmeticOperations();
//        conditionals();
//        loops();
//        arrays();
//        collections();
//        classesAndInterfaces();
//        files();
//        dynamicPolymorphism();
//        sortingAlgorithms();
        javaSwingGui();
    }
}
