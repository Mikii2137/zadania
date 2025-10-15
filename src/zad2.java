import java.util.*;

public class zad2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\n=== MENU PROGRAMU ===");
            System.out.println("1. Liczby nieparzyste do n");
            System.out.println("2. Suma ciągu od A do B (3 pętle)");
            System.out.println("3. Potęgi liczby 2 nie większe niż n");
            System.out.println("4. Suma liczb aż do 0");
            System.out.println("5. Suma min + max i średnia");
            System.out.println("6. Gra: Za dużo, za mało");
            System.out.println("7. Rysowanie prostokąta");
            System.out.println("8. Rysowanie choinki");
            System.out.println("9. Suma cyfr i stosunek średnich");
            System.out.println("10. Dzielniki liczby");
            System.out.println("11. Czy liczba pierwsza?");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> zadanie1(scanner);
                case 2 -> zadanie2(scanner);
                case 3 -> zadanie3(scanner);
                case 4 -> zadanie4(scanner);
                case 5 -> zadanie5(scanner);
                case 6 -> zadanie6(scanner);
                case 7 -> zadanie7(scanner);
                case 8 -> zadanie8(scanner);
                case 9 -> zadanie9(scanner);
                case 10 -> zadanie10(scanner);
                case 11 -> zadanie11(scanner);
                case 0 -> System.out.println("Zakończono program.");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 0);
    }

    static void zadanie1(Scanner scanner) {
        System.out.print("Podaj liczbę całkowitą dodatnią: ");
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void zadanie2(Scanner scanner) {
        System.out.print("Podaj A: ");
        int a = scanner.nextInt();
        System.out.print("Podaj B (większe niż A): ");
        int b = scanner.nextInt();

        int suma = 0, i = a;
        while (i <= b) suma += i++;
        System.out.println("While: " + suma);

        suma = 0;
        i = a;
        do suma += i++; while (i <= b);
        System.out.println("Do-while: " + suma);

        suma = 0;
        for (i = a; i <= b; i++) suma += i;
        System.out.println("For: " + suma);
    }

    static void zadanie3(Scanner scanner) {
        System.out.print("Podaj liczbę całkowitą dodatnią: ");
        int n = scanner.nextInt();
        int p = 1;
        while (p <= n) {
            System.out.println(p);
            p *= 2;
        }
    }

    static void zadanie4(Scanner scanner) {
        int suma = 0, liczba;
        do {
            System.out.print("Podaj liczbę (0 kończy): ");
            liczba = scanner.nextInt();
            suma += liczba;
        } while (liczba != 0);
        System.out.println("Suma: " + suma);
    }

    static void zadanie5(Scanner scanner) {
        int suma = 0, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count = 0;
        while (true) {
            System.out.print("Podaj liczbę (0 kończy): ");
            int x = scanner.nextInt();
            if (x == 0) break;
            suma += x;
            count++;
            if (x < min) min = x;
            if (x > max) max = x;
        }
        if (count > 0) {
            System.out.println("Suma min + max: " + (min + max));
            System.out.println("Średnia: " + (suma / (double) count));
        } else {
            System.out.println("Brak danych.");
        }
    }

    static void zadanie6(Scanner scanner) {
        int liczba = new Random().nextInt(100) + 1;
        int strzal;
        do {
            System.out.print("Zgadnij liczbę (1-100): ");
            strzal = scanner.nextInt();
            if (strzal > liczba) System.out.println("Za dużo!");
            else if (strzal < liczba) System.out.println("Za mało!");
            else System.out.println("Gratulacje!");
        } while (strzal != liczba);
    }

    static void zadanie7(Scanner scanner) {
        System.out.print("Znak wypełnienia: ");
        char znak = scanner.next().charAt(0);
        System.out.print("x (kolumna): ");
        int x = scanner.nextInt();
        System.out.print("y (wiersz): ");
        int y = scanner.nextInt();
        System.out.print("a (wysokość): ");
        int a = scanner.nextInt();
        System.out.print("b (szerokość): ");
        int b = scanner.nextInt();

        for (int i = 1; i < y; i++) System.out.println();
        for (int i = 0; i < a; i++) {
            System.out.print(" ".repeat(x - 1));
            System.out.println(String.valueOf(znak).repeat(b));
        }
    }

    static void zadanie8(Scanner scanner) {
        System.out.print("Podaj wysokość choinki: ");
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(" ".repeat(n - i - 1));
            System.out.println("*".repeat(2 * i + 1));
        }
    }

    static void zadanie9(Scanner scanner) {
        System.out.print("Podaj liczbę całkowitą: ");
        int n = scanner.nextInt();
        int suma = 0, parzyste = 0, nieparzyste = 0, pCount = 0, npCount = 0;

        int temp = n;
        while (temp > 0) {
            int cyfra = temp % 10;
            suma += cyfra;
            if (cyfra % 2 == 0) {
                parzyste += cyfra;
                pCount++;
            } else {
                nieparzyste += cyfra;
                npCount++;
            }
            temp /= 10;
        }

        System.out.println("Suma cyfr: " + suma);
        if (pCount > 0 && npCount > 0) {
            double stosunek = (parzyste / (double) pCount) / (nieparzyste / (double) npCount);
            System.out.printf("Stosunek średnich: %.2f\n", stosunek);
        } else {
            System.out.println("Brak cyfr parzystych lub nieparzystych.");
        }
    }

    static void zadanie10(Scanner scanner) {
        System.out.print("Podaj liczbę całkowitą: ");
        int n = scanner.nextInt();
        System.out.print("Dzielniki: ");
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) System.out.print(i + " ");
        }
        System.out.println();
    }

    static void zadanie11(Scanner scanner) {
        System.out.print("Podaj liczbę całkowitą > 1: ");
        int n = scanner.nextInt();
        boolean pierwsza = n > 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                pierwsza = false;
                break;
            }
        }
        System.out.println(pierwsza ? "Liczba pierwsza" : "Nie jest pierwsza");
    }
}
