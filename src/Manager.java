
import java.util.Scanner;

public class Manager {

    final Scanner sc = new Scanner(System.in);

    public int getInt() {
        while (true) {
            try {
                int number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    return number;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.print("Please enter integer number: ");
            }
        }
    }

    public double checkDoubleNumber() {
        while (true) {
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number >= 0) {
                    return number;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.print("Please enter double number: ");
            }
        }
    }

    public double checkBMI(String massage) {
        while (true) {
            System.out.print(massage);
            try {
                double number = Double.parseDouble(sc.nextLine());
                if (number >= 0) {
                    return number;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
            }
        }
    }

    public int getChoice(int min, int max) {
        while (true) {
            int choice = getInt();
            if (choice < min || choice > max) {
                System.out.print("Please enter choice in range " + "[" + min + "-" + max + "]: ");
                continue;
            }
            return choice;

        }

    }

    public void menu() {
        System.out.println("======== Calculator Program ========");
        System.out.println("1. Normal Calculator");
        System.out.println("2. BMI Calculator");
        System.out.println("3. Exit");
        System.out.println("Please choice one option: ");
    }

    public String checkOperator() {

        while (true) {
            String operator = sc.nextLine();

            if (operator.isEmpty()) {
                System.out.println("Not empty");
                continue;
            }

            if (operator.equalsIgnoreCase("+")
                    || operator.equalsIgnoreCase("-")
                    || operator.equalsIgnoreCase("x")
                    || operator.equalsIgnoreCase("/")
                    || operator.equalsIgnoreCase("^")
                    || operator.equalsIgnoreCase("=")) {
                return operator;
            } else {
                System.out.println("Please input(+, -, x, /, ^)");
                System.out.print("Enter Operator: ");
            }

        }
    }

    public String checkStandard(double BMI) {
        if (BMI < 19) {
            return "Under-standard";
        }

        if (BMI > 19 && BMI < 25) {
            return "Standard";
        }

        if (BMI > 25 && BMI < 30) {
            return "Overweight";
        }

        if (BMI > 30 && BMI < 40) {
            return "Fat - should lose weight";
        }

        if (BMI > 40) {
            return "Very fat - should lose weight immediately";
        }

        return null;
    }

    public void normalCalculate() {
        System.out.println("----- Normal Calculate -----");
        System.out.print("Enter number: ");
        double memory = checkDoubleNumber();
        while (true) {
            System.out.print("Enter Operator: ");
            String operator = checkOperator();
            if (!operator.equalsIgnoreCase("=")) {
                System.out.print("Enter number: ");
                double num2 = checkDoubleNumber();
                memory = calculate(memory, operator, num2);
                if (operator.equalsIgnoreCase("/") && num2 == 0) {
                    return;
                }
            } else {
                calculate(memory, operator, 0);
                return;
            }
        }
    }

    public double calculate(double a, String operator, double b) {
        if (operator.equalsIgnoreCase("+")) {
            a = a + b;
            System.out.println("Memory: " + a);
            return a;
        }

        if (operator.equalsIgnoreCase("-")) {
            a = a - b;
            System.out.println("Memory: " + a);
            return a;
        }

        if (operator.equalsIgnoreCase("x")) {
            a = a * b;
            System.out.println("Memory: " + a);
            return a;
        }

        if (operator.equalsIgnoreCase("/")) {
            try {
                if (b == 0) {
                    throw new ArithmeticException();
                }
                a = a / b;
                System.out.println("Memory: " + a);
                return a;
            } catch (ArithmeticException ar) {
                System.out.println("Not divide 0");
            }
        }

        if (operator.equalsIgnoreCase("^")) {
            a = Math.pow(a, b);
            System.out.println("Memory: " + a);
            return a;
        }
        if (operator.equalsIgnoreCase("=")) {
            System.out.println("Memory: " + a);
            return a;
        }

        return -1;
    }

    public void BMIStandard() {
        System.out.println("----- BMI Calculator -----");
        double weight = checkBMI("Enter Weight(kg): ");
        double height = checkBMI("Enter Height(cm): ");
        double BMINumber = (weight * 10000) / (height * height);
        System.out.println("BMI Number: " + BMINumber);
        String standard = checkStandard(BMINumber);
        System.out.println("BMI Number: " + String.format("%.2f", BMINumber));
        System.out.println("BMI Status: " + standard.toUpperCase());
    }

    public double calculateBMI(double weight, double height) {
        return 0;
    }

}
