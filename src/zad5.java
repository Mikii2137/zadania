import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProgramZadan {

    // 1. Silnia (Factorial)
    public static long factorialIterative(int n) { 
        if (n < 0) return -1;
        if (n == 0 || n == 1) return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
    public static long factorialRecursive(int n) { 
        if (n < 0) return -1;
        if (n == 0) return 1;
        return n * factorialRecursive(n - 1);
    }

    // 2. Ciąg Fibonacciego (F0=1, F1=2)
    public static long fibonacciIterative(int n) {
        if (n < 0) return -1;
        if (n == 0) return 1; 
        if (n == 1) return 2; 

        long fnMinus2 = 1;
        long fnMinus1 = 2;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            fn = fnMinus2 + fnMinus1;
            fnMinus2 = fnMinus1;
            fnMinus1 = fn;
        }
        return fn;
    }
    public static long fibonacciRecursive(int n) {
        if (n < 0) return -1;
        if (n == 0) return 1;
        if (n == 1) return 2;
        return fibonacciRecursive(n - 2) + fibonacciRecursive(n - 1);
    }

    // 3. strpos
    public static int strpos(String text, char z) {
        if (text == null) return -1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == z) return i;
        }
        return -1;
    }

    // 4. flipCase
    public static String flipCase(String text) {
        if (text == null) return null;
        StringBuilder result = new StringBuilder(text.length());
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) result.append(Character.toLowerCase(c));
            else if (Character.isLowerCase(c)) result.append(Character.toUpperCase(c));
            else result.append(c);
        }
        return result.toString();
    }

    // 5. startsWith
    public static boolean startsWith(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str2.length() > str1.length()) return false;
        
        for (int i = 0; i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) return false;
        }
        return true;
    }

    // 6. strToInt
    public static int strToInt(String str) {
        if (str == null || str.isEmpty()) return 0;
        long result = 0;
        int sign = 1;
        int i = 0;
        int n = str.length();
        int numStart = i;

        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            if (str.charAt(i) == '-') sign = -1;
            i++; numStart = i;
        }

        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            result = result * 10 + digit;
            i++;
        }
        
        long mantissa = result;

        if (i < n && (str.charAt(i) == 'e' || str.charAt(i) == 'E')) {
            i++;
            int expSign = 1;
            if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                if (str.charAt(i) == '-') expSign = -1; 
                i++;
            }
            
            int exponent = 0;
            int expStart = i;
            
            while (i < n && Character.isDigit(str.charAt(i))) {
                exponent = exponent * 10 + (str.charAt(i) - '0');
                i++;
            }
            
            if (expSign == 1 && expStart < i) {
                long finalResult = mantissa;
                for (int k = 0; k < exponent; k++) {
                    if (finalResult > Integer.MAX_VALUE / 10 || finalResult < Integer.MIN_VALUE / 10) return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                    finalResult *= 10;
                }
                return (int)(finalResult * sign);
            }
        }
        if (numStart == i) return 0;
        
        result *= sign;
        
        if (result > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE) return Integer.MIN_VALUE;

        return (int)result;
    }

    // 7. strfind
    public static int strfind(String gdzie, String co) {
        if (gdzie == null || co == null) return -1;
        if (co.isEmpty()) return 0;

        int n = gdzie.length();
        int m = co.length();
        if (m > n) return -1;

        for (int i = 0; i <= n - m; i++) {
            boolean found = true;
            for (int j = 0; j < m; j++) {
                if (gdzie.charAt(i + j) != co.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) return i;
        }
        return -1;
    }

    // 8. wordCount
    public static int wordCount(String text) {
        if (text == null || text.isEmpty()) return 0;

        int count = 0;
        boolean inWord = false;

        for (char c : text.toCharArray()) {
            if (Character.isWhitespace(c)) inWord = false;
            else {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            }
        }
        return count;
    }

    // 9. podzielNaSlowa
    public static String[] podzielNaSlowa(String tekst) {
        if (tekst == null || tekst.isEmpty()) return new String[0];

        List<String> words = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (char c : tekst.toCharArray()) {
            if (Character.isWhitespace(c)) {
                if (currentWord.length() > 0) {
                    words.add(currentWord.toString());
                    currentWord.setLength(0);
                }
            } else currentWord.append(c);
        }

        if (currentWord.length() > 0) words.add(currentWord.toString());

        return words.toArray(new String[0]);
    }

    // 10. strFindAndCount
    public static int strFindAndCount(String gdzie, String co) {
        if (gdzie == null || co == null || co.isEmpty()) return 0;

        int count = 0;
        int n = gdzie.length();
        int m = co.length();

        if (m > n) return 0;

        for (int i = 0; i <= n - m; i++) {
            boolean match = true;
            for (int j = 0; j < m; j++) {
                if (gdzie.charAt(i + j) != co.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) count++;
        }
        return count;
    }

    // 11. strcut
    public static String strcut(String str, int start, int ile) {
        if (str == null || str.isEmpty() || ile <= 0) return str;

        int n = str.length();

        if (start < 0) start = 0;
        if (start >= n) return str;

        int cutEnd = start + ile;
        if (cutEnd > n) cutEnd = n;

        String part1 = str.substring(0, start);
        String part2 = str.substring(cutEnd);

        return part1 + part2;
    }

    // 12. Program analizujący tablicę (wykorzystuje strToInt i strFindAndCount)
    public static void runAnalysis(String[] zadania, String fraza) {
        long sumOfNumbers = 0;
        StringBuilder nonNumericConcatenation = new StringBuilder();
        int phraseCountInNonNumericCells = 0;
        List<String> nonNumericCells = new ArrayList<>();

        for (String cell : zadania) {
            boolean isNumberPrefix = false;
            if (cell != null && !cell.isEmpty()) {
                String trimmedCell = cell.trim();
                if (!trimmedCell.isEmpty()) {
                    char first = trimmedCell.charAt(0);
                    if (Character.isDigit(first) || first == '+' || first == '-') {
                        if (trimmedCell.length() > 1) {
                             char second = trimmedCell.charAt(1);
                            if (Character.isDigit(second) || (Character.isDigit(first) && first != '+' && first != '-')) {
                                isNumberPrefix = true;
                            }
                        } else if (Character.isDigit(first)) {
                            isNumberPrefix = true;
                        }
                    }
                }
            }

            if (isNumberPrefix) sumOfNumbers += strToInt(cell.trim()); 
            else nonNumericCells.add(cell.trim()); 
        }
        
        for (String cell : nonNumericCells) {
             nonNumericConcatenation.append(cell); 
             phraseCountInNonNumericCells += strFindAndCount(cell, fraza); 
        }

        String concatenatedString = nonNumericConcatenation.toString();
        int phraseCountInConcatenated = strFindAndCount(concatenatedString, fraza);
        
        double ratio = 0.0;
        if (phraseCountInConcatenated != 0) ratio = (double) phraseCountInNonNumericCells / phraseCountInConcatenated;

        System.out.println("--- Wyniki Zadania 12 ---");
        System.out.println("Pkt. 1: Suma liczb: " + sumOfNumbers);
        System.out.println("Pkt. 2: Łańcuch nieliczbowy: " + concatenatedString);
        System.out.println("Pkt. 3: Wystąpienia frazy w komórkach: " + phraseCountInNonNumericCells);
        System.out.println("Pkt. 4: Wystąpienia frazy w łańcuchu: " + phraseCountInConcatenated);
        System.out.printf("Pkt. 5: Stosunek (Pkt 3 / Pkt 4): %.6f%n", ratio);
        System.out.println("-------------------------");
    }

    // 13. poprzestawiaj
    public static String poprzestawiaj(String tekst, int[] kolejnosc) {
        if (tekst == null || kolejnosc == null || tekst.length() != kolejnosc.length) return tekst;

        int n = tekst.length();
        char[] result = new char[n];
        boolean[] usedPositions = new boolean[n];

        for (int i = 0; i < n; i++) {
            int newPos = kolejnosc[i];
            
            if (newPos < 0 || newPos >= n || usedPositions[newPos]) return "BŁĄD: Niepoprawna tablica kolejności"; 
            
            result[newPos] = tekst.charAt(i);
            usedPositions[newPos] = true;
        }
        return new String(result);
    }

    // 14. czyAnagram
    public static boolean czyAnagram(String t1, String t2) {
        if (t1 == null || t2 == null) return false;
        int[] charCounts = new int[26];

        for (char c : t1.toCharArray()) {
            if (Character.isLetter(c)) charCounts[Character.toLowerCase(c) - 'a']++;
        }

        for (char c : t2.toCharArray()) {
            if (Character.isLetter(c)) charCounts[Character.toLowerCase(c) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) return false;
        }
        return true;
    }

    // 15. HTMLColor2RGB
    public static int[] HTMLColor2RGB(String color) {
        if (color == null || color.length() != 7 || color.charAt(0) != '#') return new int[0];

        int[] rgb = new int[3];

        try {
            rgb[0] = Integer.parseInt(color.substring(1, 3), 16);
            rgb[1] = Integer.parseInt(color.substring(3, 5), 16);
            rgb[2] = Integer.parseInt(color.substring(5, 7), 16);
        } catch (NumberFormatException e) {
            return new int[0];
        }
        return rgb;
    }

    // -------------------------------------------------------------------------
    // --- GŁÓWNA METODA INTERAKTYWNA (main) ---
    // -------------------------------------------------------------------------

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n=========================================");
            System.out.println("Wybierz zadanie do przetestowania (1-15) lub 0 aby wyjść:");
            System.out.println(" 1. Silnia");
            System.out.println(" 2. Ciąg Fibonacciego");
            System.out.println(" 3. strpos(text, z)");
            System.out.println(" 4. flipCase(text)");
            System.out.println(" 5. startsWith(str1, str2)");
            System.out.println(" 6. strToInt(str)");
            System.out.println(" 7. strfind(gdzie, co)");
            System.out.println(" 8. wordCount(text)");
            System.out.println(" 9. podzielNaSlowa(tekst)");
            System.out.println("10. strFindAndCount(gdzie, co)");
            System.out.println("11. strcut(str, start, ile)");
            System.out.println("12. Program Analizujący Tablicę (Zadanie główne)");
            System.out.println("13. poprzestawiaj(tekst, kolejnosc)");
            System.out.println("14. czyAnagram(t1, t2)");
            System.out.println("15. HTMLColor2RGB(color)");
            System.out.println(" 0. Wyjście");
            System.out.println("=========================================");
            System.out.print("Wybór: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                System.out.println("--- TEST ZADANIA " + choice + " ---");

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Podaj n dla silni: ");
                            int nFact = scanner.nextInt();
                            System.out.println("Wynik iteracyjny: " + factorialIterative(nFact));
                            System.out.println("Wynik rekurencyjny: " + factorialRecursive(nFact));
                            break;
                        case 2:
                            System.out.print("Podaj n dla ciągu Fibonacciego (Fn): ");
                            int nFib = scanner.nextInt();
                            System.out.println("Wynik iteracyjny (F" + nFib + "): " + fibonacciIterative(nFib));
                            System.out.println("Wynik rekurencyjny (F" + nFib + "): " + fibonacciRecursive(nFib));
                            break;
                        case 3:
                            System.out.print("Podaj łańcuch (text): ");
                            String textPos = scanner.nextLine();
                            System.out.print("Podaj szukany znak (z): ");
                            String charStr = scanner.nextLine();
                            char z = charStr.length() > 0 ? charStr.charAt(0) : ' ';
                            System.out.println("strpos(\"" + textPos + "\", '" + z + "'): " + strpos(textPos, z));
                            break;
                        case 4:
                            System.out.print("Podaj łańcuch do zamiany wielkości liter: ");
                            String textFlip = scanner.nextLine();
                            System.out.println("flipCase(\"" + textFlip + "\"): " + flipCase(textFlip));
                            break;
                        case 5:
                            System.out.print("Podaj łańcuch główny (str1): ");
                            String str1 = scanner.nextLine();
                            System.out.print("Podaj prefiks (str2): ");
                            String str2 = scanner.nextLine();
                            System.out.println("startsWith(\"" + str1 + "\", \"" + str2 + "\"): " + startsWith(str1, str2));
                            break;
                        case 6:
                            System.out.print("Podaj łańcuch do konwersji (str): ");
                            String strInt = scanner.nextLine();
                            System.out.println("strToInt(\"" + strInt + "\"): " + strToInt(strInt));
                            break;
                        case 7:
                            System.out.print("Podaj łańcuch główny (gdzie): ");
                            String gdzieFind = scanner.nextLine();
                            System.out.print("Podaj łańcuch szukany (co): ");
                            String coFind = scanner.nextLine();
                            System.out.println("strfind(\"" + gdzieFind + "\", \"" + coFind + "\"): " + strfind(gdzieFind, coFind));
                            break;
                        case 8:
                            System.out.print("Podaj tekst do zliczenia słów: ");
                            String textCount = scanner.nextLine();
                            System.out.println("wordCount(\"" + textCount + "\"): " + wordCount(textCount));
                            break;
                        case 9:
                            System.out.print("Podaj tekst do podziału: ");
                            String textSplit = scanner.nextLine();
                            System.out.println("podzielNaSlowa(\"" + textSplit + "\"): " + Arrays.toString(podzielNaSlowa(textSplit)));
                            break;
                        case 10:
                            System.out.print("Podaj łańcuch główny (gdzie): ");
                            String gdzieCount = scanner.nextLine();
                            System.out.print("Podaj łańcuch szukany (co): ");
                            String coCount = scanner.nextLine();
                            System.out.println("strFindAndCount(\"" + gdzieCount + "\", \"" + coCount + "\"): " + strFindAndCount(gdzieCount, coCount));
                            break;
                        case 11:
                            System.out.print("Podaj łańcuch (str): ");
                            String strCut = scanner.nextLine();
                            System.out.print("Podaj pozycję początkową (start): ");
                            int startCut = scanner.nextInt();
                            System.out.print("Podaj liczbę znaków do wycięcia (ile): ");
                            int ileCut = scanner.nextInt();
                            System.out.println("strcut(\"" + strCut + "\", " + startCut + ", " + ileCut + "): " + strcut(strCut, startCut, ileCut));
                            break;
                        case 12:
                            String[] zadania = {"mamla", " mama ", "+12", "0001", "991-234-3",
                                                "-12e5", "-12e-5", "+zonmakm", "ax2", "amakotma"};
                            String fraza = "ma";
                            System.out.println("Wykonanie Zadania 12 na domyślnej tablicy:");
                            System.out.println("Tablica: " + Arrays.toString(zadania));
                            System.out.println("Fraza: \"" + fraza + "\"");
                            runAnalysis(zadania, fraza);
                            break;
                        case 13:
                            System.out.print("Podaj łańcuch do przestawienia (np. Egzamin): ");
                            String textShuffle = scanner.nextLine();
                            System.out.print("Podaj kolejność jako liczby oddzielone przecinkami (np. 0,1,4,3,2,6,5): ");
                            String kolStr = scanner.nextLine().replaceAll("\\s", "");
                            String[] kolArr = kolStr.split(",");
                            int[] kolejnosc = new int[kolArr.length];
                            for(int i = 0; i < kolArr.length; i++) {
                                kolejnosc[i] = Integer.parseInt(kolArr[i]);
                            }
                            System.out.println("Wynik: " + poprzestawiaj(textShuffle, kolejnosc));
                            break;
                        case 14:
                            System.out.print("Podaj pierwszy łańcuch (t1): ");
                            String t1 = scanner.nextLine();
                            System.out.print("Podaj drugi łańcuch (t2): ");
                            String t2 = scanner.nextLine();
                            System.out.println("czyAnagram(\"" + t1 + "\", \"" + t2 + "\"): " + czyAnagram(t1, t2));
                            break;
                        case 15:
                            System.out.print("Podaj kolor HTML (#RRGGBB, np. #FF0050): ");
                            String color = scanner.nextLine();
                            System.out.println("HTMLColor2RGB(\"" + color + "\"): " + Arrays.toString(HTMLColor2RGB(color)));
                            break;
                        case 0:
                            System.out.println("Zakończono program. Do widzenia! 👋");
                            break;
                        default:
                            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                            break;
                    }
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Błąd: Oczekiwano liczby całkowitej. Spróbuj ponownie.");
                    scanner.nextLine(); // Wyczyść błędne wejście
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Błąd: Niepoprawny format danych (np. za mało elementów w tablicy lub przekroczony zakres).");
                    scanner.nextLine(); 
                } catch (Exception e) {
                    System.out.println("Wystąpił nieoczekiwany błąd: " + e.getMessage());
                }
            } else {
                System.out.println("Nieprawidłowy wybór. Wprowadź numer zadania.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}
