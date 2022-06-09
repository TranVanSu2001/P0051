
public class Main {

    public static void main(String[] args) {
        Manager m = new Manager();

        while (true) {
            m.menu();
            int choice = m.getChoice(1, 3);

            switch (choice) {
                case 1:
                    m.normalCalculate();
                    break;
                case 2:
                    m.BMIStandard();
                    break;
                case 3:
                    return;
            }
        }
    }
}
