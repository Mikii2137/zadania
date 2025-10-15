import java.util.Scanner;

public class zadanie1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\n=== MENU PROGRAMU ===");
            System.out.println("1. Konwersja temperatury (Celsjusz → Fahrenheit)");
            System.out.println("2. Największa i najmniejsza z 3 liczb");
            System.out.println("3. Obliczanie BMI");
            System.out.println("4. Obliczanie podatku dochodowego");
            System.out.println("5. Obliczanie raty za sprzęt AGD");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> konwersjaTemperatury(scanner);
                case 2 -> minMaxLiczby(scanner);
                case 3 -> obliczBMI(scanner);
                case 4 -> obliczPodatek(scanner);
                case 5 -> obliczRatyAGD(scanner);
                case 0 -> System.out.println("Zakończono program.");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 0);
    }

    static void konwersjaTemperatury(Scanner scanner) {
        System.out.print("Podaj temperaturę w stopniach Celsjusza: ");
        double celsius = scanner.nextDouble();
        double fahrenheit = 1.8 * celsius + 32.0;
        System.out.printf("Temperatura w stopniach Fahrenheita: %.2f\n", fahrenheit);
    }

    static void minMaxLiczby(Scanner scanner) {
        System.out.print("Podaj pierwszą liczbę: ");
        int a = scanner.nextInt();
        System.out.print("Podaj drugą liczbę: ");
        int b = scanner.nextInt();
        System.out.print("Podaj trzecią liczbę: ");
        int c = scanner.nextInt();

        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));

        System.out.println("Największa liczba: " + max);
        System.out.println("Najmniejsza liczba: " + min);
    }

    static void obliczBMI(Scanner scanner) {
        System.out.print("Podaj wagę w kilogramach: ");
        double waga = scanner.nextDouble();
        System.out.print("Podaj wzrost w metrach: ");
        double wzrost = scanner.nextDouble();

        double bmi = waga / (wzrost * wzrost);
        System.out.printf("Twoje BMI wynosi: %.2f\n", bmi);

        if (bmi < 18.5) {
            System.out.println("Niedowaga");
        } else if (bmi <= 24.9) {
            System.out.println("Waga prawidłowa");
        } else {
            System.out.println("Nadwaga");
        }
    }

    static void obliczPodatek(Scanner scanner) {
        System.out.print("Podaj swój dochód: ");
        double dochod = scanner.nextDouble();
        double podatek;

        if (dochod <= 85528) {
            podatek = dochod * 0.18 - 556.02;
        } else {
            podatek = 14839.02 + (dochod - 85528) * 0.32;
        }

        if (podatek < 0) podatek = 0;
        System.out.printf("Należny podatek: %.2f zł\n", podatek);
    }

    static void obliczRatyAGD(Scanner scanner) {
        double cena;
        int raty;

        while (true) {
            System.out.print("Podaj cenę towaru (100 - 10000 zł): ");
            cena = scanner.nextDouble();
            if (cena >= 100 && cena <= 10000) break;
            System.out.println("Nieprawidłowa cena. Spróbuj ponownie.");
        }

        while (true) {
            System.out.print("Podaj liczbę rat (6 - 48): ");
            raty = scanner.nextInt();
            if (raty >= 6 && raty <= 48) break;
            System.out.println("Nieprawidłowa liczba rat. Spróbuj ponownie.");
        }

        double oprocentowanie;
        if (raty <= 12) {
            oprocentowanie = 0.025;
        } else if (raty <= 24) {
            oprocentowanie = 0.05;
        } else {
            oprocentowanie = 0.10;
        }

        double kwotaZOdsetkami = cena * (1 + oprocentowanie);
        double rataMiesieczna = kwotaZOdsetkami / raty;

        System.out.printf("Miesięczna rata wynosi: %.2f zł\n", rataMiesieczna);
    }
}