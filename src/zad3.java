import java.util.*;

public class zad3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\n=== MENU TABLICOWE ===");
            System.out.println("1. Tablica 10 liczb: min, max, średnia, odwrócenie");
            System.out.println("2. Tablica 20 liczb: zliczanie wystąpień 1–10");
            System.out.println("3. Macierz 5x5: min/max kolumn");
            System.out.println("4. Kod binarny ZM (32 bity)");
            System.out.println("5. Kod ZM, ZU1, ZU2");
            System.out.println("6. Dodawanie i odejmowanie ZM/ZU1/ZU2");
            System.out.println("9. Macierz względnie pierwszych (boolean)");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();

            switch (wybor) {
                case 1 -> zadanie1();
                case 2 -> zadanie2();
                case 3 -> zadanie3();
                case 4 -> zadanie4();
                case 5 -> zadanie5();
                case 6 -> zadanie6();
                case 9 -> zadanie9();
                case 0 -> System.out.println("Zakończono program.");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 0);
    }

    static void zadanie1() {
        Random rand = new Random();
        int[] tab = new int[10];
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int suma = 0;

        System.out.print("Wylosowane liczby: ");
        for (int i = 0; i < tab.length; i++) {
            tab[i] = rand.nextInt(21) - 10;
            System.out.print(tab[i] + " ");
            suma += tab[i];
            if (tab[i] < min) min = tab[i];
            if (tab[i] > max) max = tab[i];
        }

        double srednia = suma / 10.0;
        int mniejsze = 0, wieksze = 0;
        for (int x : tab) {
            if (x < srednia) mniejsze++;
            else if (x > srednia) wieksze++;
        }

        System.out.printf("\nMin: %d, Max: %d\n", min, max);
        System.out.printf("Średnia: %.2f\n", srednia);
        System.out.println("Mniejszych od śr.: " + mniejsze);
        System.out.println("Większych od śr.: " + wieksze);
        System.out.print("Odwrotnie: ");
        for (int i = tab.length - 1; i >= 0; i--) System.out.print(tab[i] + " ");
        System.out.println();
    }

    static void zadanie2() {
        Random rand = new Random();
        int[] tab = new int[20];
        int[] licznik = new int[11];

        System.out.print("Wylosowane liczby: ");
        for (int i = 0; i < tab.length; i++) {
            tab[i] = rand.nextInt(10) + 1;
            System.out.print(tab[i] + " ");
            licznik[tab[i]]++;
        }

        System.out.println("\nWystąpienia:");
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + ": " + licznik[i]);
        }
    }

    static void zadanie3() {
        Random rand = new Random();
        int[][] macierz = new int[5][5];
        int[] minKol = new int[5];
        int[] maxKol = new int[5];
        Arrays.fill(minKol, Integer.MAX_VALUE);
        Arrays.fill(maxKol, Integer.MIN_VALUE);

        System.out.println("Macierz:");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                macierz[i][j] = rand.nextInt(11) - 5;
                System.out.printf("%3d", macierz[i][j]);
                if (macierz[i][j] < minKol[j]) minKol[j] = macierz[i][j];
                if (macierz[i][j] > maxKol[j]) maxKol[j] = macierz[i][j];
            }
            System.out.println();
        }

        System.out.println("Minima kolumn: " + Arrays.toString(minKol));
        System.out.println("Maksima kolumn: " + Arrays.toString(maxKol));
    }

    static void zadanie4() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę całkowitą: ");
        int n = scanner.nextInt();
        int[] bity = new int[32];

        int temp = n;
        for (int i = 31; i >= 0; i--) {
            bity[i] = temp & 1;
            temp >>= 1;
        }

        System.out.print("Liczba " + n + " binarnie (ZM): ");
        for (int bit : bity) System.out.print(bit);
        System.out.println();
    }

    static void zadanie5() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę całkowitą: ");
        int n = scanner.nextInt();

        System.out.println("ZM: " + Integer.toBinaryString(n));
        System.out.println("ZU1: " + Integer.toBinaryString(~n));
        System.out.println("ZU2: " + Integer.toBinaryString(~n + 1));
    }

    static void zadanie6() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj pierwszą liczbę: ");
        int a = scanner.nextInt();
        System.out.print("Podaj drugą liczbę: ");
        int b = scanner.nextInt();

        System.out.println("Dodawanie:");
        System.out.println("ZM: " + (a + b));
        System.out.println("ZU1: " + (a + b));
        System.out.println("ZU2: " + (a + b));

        System.out.println("Odejmowanie:");
        System.out.println("ZM: " + (a - b));
        System.out.println("ZU1: " + (a - b));
        System.out.println("ZU2: " + (a - b));
    }

    static void zadanie9() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę (> 0): ");
        int n = scanner.nextInt();
        boolean[][] tab = new boolean[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tab[i][j] = NWD(i + 1, j + 1) == 1;

        System.out.print("    ");
        for (int i = 1; i <= n; i++) System.out.printf("%2d ", i);
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.printf("%2d ", i + 1);
            for (int j = 0; j < n; j++) {
                System.out.print(" " + (tab[i][j] ? "+" : ".") + " ");
            }
            System.out.println();
        }
    }

    static int NWD(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}