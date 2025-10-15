import java.util.Scanner;

public class zad4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wybor;

        do {
            System.out.println("\n=== MENU TEKSTOWE ===");
            System.out.println("1. Liczenie wystąpień ostatniego znaku");
            System.out.println("2. Odwracanie łańcucha znaków");
            System.out.println("3. Sprawdzenie czy ciąg jest palindromem");
            System.out.println("4. Sumowanie cyfr w tekście");
            System.out.println("5. Sprawdzanie poprawności nawiasów");
            System.out.println("6. Szyfr Cezara");
            System.out.println("0. Wyjście");
            System.out.print("Wybierz opcję: ");
            wybor = scanner.nextInt();
            scanner.nextLine(); // czyści bufor

            switch (wybor) {
                case 1 -> zadanie1(scanner);
                case 2 -> zadanie2(scanner);
                case 3 -> zadanie3(scanner);
                case 4 -> zadanie4(scanner);
                case 5 -> zadanie5(scanner);
                case 6 -> zadanie6(scanner);
                case 0 -> System.out.println("Zakończono program.");
                default -> System.out.println("Nieprawidłowy wybór.");
            }
        } while (wybor != 0);
    }

    static void zadanie1(Scanner scanner) {
        System.out.print("Podaj ciąg znaków: ");
        String tekst = scanner.nextLine();
        if (tekst.isEmpty()) {
            System.out.println("Ciąg jest pusty.");
            return;
        }
        char ostatni = tekst.charAt(tekst.length() - 1);
        long licznik = tekst.chars().filter(c -> c == ostatni).count();
        System.out.println("Ostatni znak '" + ostatni + "' występuje " + licznik + " razy.");
    }

    static void zadanie2(Scanner scanner) {
        System.out.print("Podaj ciąg znaków: ");
        String tekst = scanner.nextLine();
        String odwrocony = new StringBuilder(tekst).reverse().toString();
        System.out.println("Odwrócony ciąg: " + odwrocony);
    }

    static void zadanie3(Scanner scanner) {
        System.out.print("Podaj ciąg znaków: ");
        String tekst = scanner.nextLine();
        String odwrocony = new StringBuilder(tekst).reverse().toString();
        if (tekst.equals(odwrocony)) {
            System.out.println("Ciąg jest palindromem.");
        } else {
            System.out.println("Ciąg nie jest palindromem.");
        }
    }

    static void zadanie4(Scanner scanner) {
        System.out.print("Podaj tekst: ");
        String tekst = scanner.nextLine();
        int suma = 0;
        for (char c : tekst.toCharArray()) {
            if (Character.isDigit(c)) {
                suma += Character.getNumericValue(c);
            }
        }
        System.out.println("Suma cyfr w tekście: " + suma);
    }

    static void zadanie5(Scanner scanner) {
        System.out.print("Podaj wyrażenie: ");
        String tekst = scanner.nextLine();
        int licznik = 0;
        for (char c : tekst.toCharArray()) {
            if (c == '(') licznik++;
            else if (c == ')') licznik--;
            if (licznik < 0) break;
        }
        if (licznik == 0) {
            System.out.println("OK");
        } else {
            System.out.println("Błędne sparowanie nawiasów");
        }
    }

    static void zadanie6(Scanner scanner) {
        System.out.print("Podaj tekst do zaszyfrowania: ");
        String tekst = scanner.nextLine();
        System.out.print("Podaj przesunięcie (np. 2 lub -2): ");
        int przesuniecie = scanner.nextInt();
        scanner.nextLine(); // czyści bufor

        StringBuilder wynik = new StringBuilder();
        for (char c : tekst.toCharArray()) {
            if (c == ' ') {
                wynik.append(' ');
            } else if (c >= 'a' && c <= 'z') {
                int poz = c - 'a';
                int nowaPoz = (poz + przesuniecie + 26) % 26;
                wynik.append((char) ('a' + nowaPoz));
            } else {
                wynik.append(c); // ignoruje inne znaki
            }
        }
        System.out.println("Zaszyfrowany tekst: " + wynik);
    }
}
