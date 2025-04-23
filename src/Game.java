import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Game {
    private static int wynik = 0;
    private static int maxWynik = 1;
    private String nick = "gracz" + (int)(Math.random() * (1000 - 1));

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    Scanner sc = new Scanner(System.in);

    public void MainMenu() {
        try {
            if(maxWynik == 1)
                System.out.print(BLUE + "---MAIN MENU---\n" + RESET + "Aktualny wynik: " + wynik + " / " + (maxWynik-1) +
                        " (" + (wynik/maxWynik) * 100 + "%)" + BLUE + "\nAby rozpocząć grę, wybierz jeden z trybów: \n" +
                        RESET + "* [D] Dodawanie\n" + "* [O] Odejmowanie\n* [M] Mnożenie\n* [DZ] Dzielenie" +
                        "\n* [P] Potęgowanie\n* [Z] Zakończ\n");
            else
                System.out.print(BLUE + "---MAIN MENU---\n" + RESET + "Aktualny wynik: " + wynik + " / " + maxWynik +
                        " (" + (wynik/maxWynik) * 100 + "%)" + BLUE + "\nAby rozpocząć grę, wybierz jeden z trybów: \n" +
                        RESET + "* [D] Dodawanie\n" + "* [O] Odejmowanie\n* [M] Mnożenie\n* [DZ] Dzielenie" +
                        "\n* [P] Potęgowanie\n* [Z] Zakończ\n");

            if (maxWynik == 1) maxWynik = 0;

            switch(sc.nextLine().toLowerCase()) {
                case "d" -> Dodawanie();
                case "o" -> Odejmowanie();
                case "m" -> Mnozenie();
                case "dz" -> Dzielenie();
                case "p" -> Potegowanie();
                case "z" -> Zakoncz();
                default -> {
                    System.out.print(YELLOW + new CustomException(CustomException.Reason.UnknownCommand) + RESET);
                    throw new CustomException(CustomException.Reason.UnknownCommand);
                }
            }
        } catch (IOException | CustomException e) {
            System.out.println(RED + "Wystąpił błąd: " + e.getMessage() + RESET);
        }
    }

    private void Dodawanie() {
        try {
            int a, b, c;
            System.out.print(BLUE + "--DODAWANIE--\nPodaj liczbę zadań, które chcesz zrobić w tej sesji (max. 20): " + RESET);
            int n = sc.nextInt();

            if(n <= 0) throw new CustomException(CustomException.Reason.ValueTooSmall);
            if(n > 20) throw new CustomException(CustomException.Reason.ValueTooBig);

            for (int i = 1; i <= n; i++) {
                a = (int) (Math.random() * 99 + 1);
                b = (int) (Math.random() * 99 + 1);
                System.out.print(BLUE + "Zadanie nr. " + i + ": " + a + " + " + b + " = " + RESET);
                c = sc.nextInt();
                if (c == (a + b)) {
                    System.out.print(GREEN + "Świetna robota! (+10 pkt.)\n" + RESET);
                    wynik += 10;
                } else {
                    System.out.print(RED + "Zła odpowiedź :( (+0 pkt.)\n" + RESET);
                }
                maxWynik += 10;
            }
            System.out.print(BLUE + "Wynik: " + wynik + " / " + maxWynik + " (" + (wynik * 100 / maxWynik) + "%)\n" + RESET);
            sc.nextLine();
            MainMenu();
        } catch (Exception e) {
            System.out.println(RED + "Błąd: " + e.getMessage() + RESET);
            sc.nextLine();
            MainMenu();
        }
    }

    private void Odejmowanie() {
        try {
            int a, b, c;
            System.out.print(BLUE + "--ODEJMOWANIE--\nPodaj liczbę zadań, które chcesz zrobić w tej sesji (max. 20): " + RESET);
            int n = sc.nextInt();

            if(n <= 0) throw new CustomException(CustomException.Reason.ValueTooSmall);
            if(n > 20) throw new CustomException(CustomException.Reason.ValueTooBig);

            for (int i = 1; i <= n; i++) {
                a = (int) (Math.random() * 99 + 1);
                b = (int) (Math.random() * 99 + 1);
                System.out.print(BLUE + "Zadanie nr. " + i + ": " + a + " - " + b + " = " + RESET);
                c = sc.nextInt();
                if (c == (a - b)) {
                    System.out.print(GREEN + "Świetna robota! (+10 pkt.)\n" + RESET);
                    wynik += 10;
                } else {
                    System.out.print(RED + "Zła odpowiedź :( (+0 pkt.)\n" + RESET);
                }
                maxWynik += 10;
            }
            System.out.print(BLUE + "Wynik: " + wynik + " / " + maxWynik + " (" + (wynik * 100 / maxWynik) + "%)\n" + RESET);
            sc.nextLine();
            MainMenu();
        } catch (Exception e) {
            System.out.println(RED + "Błąd: " + e.getMessage() + RESET);
            sc.nextLine();
            MainMenu();
        }
    }

    private void Mnozenie() {
        try {
            int a, b, c;
            System.out.print(BLUE + "--MNOŻENIE--\nPodaj liczbę zadań, które chcesz zrobić w tej sesji (max. 20): " + RESET);
            int n = sc.nextInt();

            if(n <= 0) throw new CustomException(CustomException.Reason.ValueTooSmall);
            if(n > 20) throw new CustomException(CustomException.Reason.ValueTooBig);

            for (int i = 1; i <= n; i++) {
                a = (int) (Math.random() * 12 + 1);
                b = (int) (Math.random() * 12 + 1);
                System.out.print(BLUE + "Zadanie nr. " + i + ": " + a + " * " + b + " = " + RESET);
                c = sc.nextInt();
                if (c == (a * b)) {
                    System.out.print(GREEN + "Świetna robota! (+10 pkt.)\n" + RESET);
                    wynik += 10;
                } else {
                    System.out.print(RED + "Zła odpowiedź :( (+0 pkt.)\n" + RESET);
                }
                maxWynik += 10;
            }
            System.out.print(BLUE + "Wynik: " + wynik + " / " + maxWynik + " (" + (wynik * 100 / maxWynik) + "%)\n" + RESET);
            sc.nextLine();
            MainMenu();
        } catch (Exception e) {
            System.out.println(RED + "Błąd: " + e.getMessage() + RESET);
            sc.nextLine();
            MainMenu();
        }
    }

    private void Dzielenie() {
        try {
            int a, b, c;
            System.out.print(BLUE + "--DZIELENIE--\nPodaj liczbę zadań, które chcesz zrobić w tej sesji (max. 20): " + RESET);
            int n = sc.nextInt();

            if(n <= 0) throw new CustomException(CustomException.Reason.ValueTooSmall);
            if(n > 20) throw new CustomException(CustomException.Reason.ValueTooBig);

            for (int i = 1; i <= n; i++) {
                b = (int) (Math.random() * 9 + 1);
                c = (int) (Math.random() * 12 + 1);
                a = b * c;
                System.out.print(BLUE + "Zadanie nr. " + i + ": " + a + " / " + b + " = " + RESET);
                int answer = sc.nextInt();
                if (answer == c) {
                    System.out.print(GREEN + "Świetna robota! (+10 pkt.)\n" + RESET);
                    wynik += 10;
                } else {
                    System.out.print(RED + "Zła odpowiedź :( (+0 pkt.)\n" + RESET);
                }
                maxWynik += 10;
            }
            System.out.print(BLUE + "Wynik: " + wynik + " / " + maxWynik + " (" + (wynik * 100 / maxWynik) + "%)\n" + RESET);
            sc.nextLine();
            MainMenu();
        } catch (Exception e) {
            System.out.println(RED + "Błąd: " + e.getMessage() + RESET);
            sc.nextLine();
            MainMenu();
        }
    }

    private void Potegowanie() {
        try {
            int a, b, c;
            System.out.print(BLUE + "--POTĘGOWANIE--\nPodaj liczbę zadań, które chcesz zrobić w tej sesji (max. 20): " + RESET);
            int n = sc.nextInt();

            if(n <= 0) throw new CustomException(CustomException.Reason.ValueTooSmall);
            if(n > 20) throw new CustomException(CustomException.Reason.ValueTooBig);

            for (int i = 1; i <= n; i++) {
                a = (int) (Math.random() * 10 + 1);
                b = (int) (Math.random() * 3 + 2);
                System.out.print(BLUE + "Zadanie nr. " + i + ": " + a + " ^ " + b + " = " + RESET);
                c = sc.nextInt();
                if (c == (int)Math.pow(a, b)) {
                    System.out.print(GREEN + "Świetna robota! (+10 pkt.)\n" + RESET);
                    wynik += 10;
                } else {
                    System.out.print(RED + "Zła odpowiedź :( (+0 pkt.)\n" + RESET);
                }
                maxWynik += 10;
            }
            System.out.print(BLUE + "Wynik: " + wynik + " / " + maxWynik + " (" + (wynik * 100 / maxWynik) + "%)\n" + RESET);
            sc.nextLine();
            MainMenu();
        } catch (Exception e) {
            System.out.println(RED + "Błąd: " + e.getMessage() + RESET);
            sc.nextLine();
            MainMenu();
        }
    }

    private void Zakoncz() throws IOException {
        System.out.print(BLUE + "Podaj swój nick (pozostaw puste, aby zachować \"" + nick + "\"): " + RESET);
        String input = sc.nextLine();
        if(!input.isEmpty()) {
            nick = input;
        }
        Zapis();
    }

    private void Zapis() throws IOException {
        Path path = Paths.get(System.getProperty("user.home"), "Documents", "SUPERMATMA", nick);
        if (!Files.exists(path)) Files.createDirectories(path);
        Path filePath = path.resolve(nick + "_wyniki.txt");
        if (!Files.exists(filePath)) Files.createFile(filePath);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        double procent = maxWynik == 0 ? 0 : ((double) wynik / maxWynik) * 100;

        String wpis = "----Data: " + LocalDateTime.now().format(formatter) + "----\n" +
                "Wynik: " + wynik + " / " + maxWynik + " (" + String.format("%.2f", procent) + "%)\n";

        Files.write(filePath, wpis.getBytes(), StandardOpenOption.APPEND);
        System.out.print(BLUE + "Dane zapisane! Dziękujemy za dzisiejszą grę!" + RESET);
    }
}
