import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BazaPacjentow {

    public static void main(String [] args) throws IOException {
        int choice;
        String nazw = "-", nrPesel = "-1", pwz = "-1";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Pacjent pacjent = new Pacjent();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("MENU:\n1.Dodaj nowy wpis Pacjenta.\n2.Usuń wpis Pacjenta.\n3.Aktualizuj wpis Pacjenta.\n4.Wyświetl całą bazę pacjentów.\n5.Wyszukaj pacjenta po peselu.\n6.Wyszukaj pacjenta po nazwisku.\n7.Wyszukaj pacjenta po numerze ubezpieczenia.\n8.Wyjdź.\nWybór: ");
            choice = scanner.nextInt();
            switch (choice)
            {
                case 1:
                {
                    try
                    {
                        System.out.print("Podaj imię pacjenta: ");
                        String imie = bufferedReader.readLine();
                        System.out.print("Podaj nazwisko pacjenta: ");
                        String nazwisko = bufferedReader.readLine();
                        System.out.print("Podaj numer ubezpieczenia pacjenta: ");
                        String nrUbezpieczenia = bufferedReader.readLine();
                        if(nrUbezpieczenia.length() != 13)
                            throw new WyjatekUbe();
                        System.out.print("Podaj numer NFZ pacjenta: ");
                        String nrNFZ = bufferedReader.readLine();
                        if(nrNFZ.length() != 2)
                            throw new WyjatekNFZ();
                        System.out.print("Podaj numer PWZ lekarza pacjenta: ");
                        String nrPWZlekarza = bufferedReader.readLine();
                        if(nrPWZlekarza.length() != 7)
                            throw new WyjatekPWZ();
                        System.out.print("Podaj pesel pacjenta: ");
                        String pesel = bufferedReader.readLine();
                        if(pesel.length() != 11)
                            throw new WyjatekPesel();
                        System.out.print("Podaj date urodzenia pacjenta w formacie DD-MM-RRRR odzielając myślnikami jak podano w przykładzie: ");
                        String dataUrodzenia = bufferedReader.readLine();
                        char a = dataUrodzenia.charAt(2), b = dataUrodzenia.charAt(5);
                        if(dataUrodzenia.length() != 10 && a != '-' && b != '-')
                            throw new WyjatekData();
                        System.out.print("Podaj plec pacjenta: ");
                        String plec = bufferedReader.readLine();
                        String pom = plec.toLowerCase();
                        if(!pom.equals("kobieta") && !pom.equals("mezczyzna") && !pom.equals("mężczyzna"))
                            throw new WyjatekPlec();
                        pacjent.dodaj(imie, nazwisko, nrUbezpieczenia, nrNFZ, nrPWZlekarza, pesel, dataUrodzenia, plec);
                    }
                    catch (RuntimeException exception)
                    {
                        System.out.println("Błąd !!!");
                    }
                    break;
                }
                case 2:
                {
                    if(pacjent.wyswietl() == 1)
                    {
                        System.out.println("Nie można nic usunąć\n");
                    }
                    else
                    {
                        System.out.print("\nPodaj pesel pacjenta z wyświetlonych pacjentów, aby go usunąć: ");
                        nrPesel = bufferedReader.readLine();
                        pacjent.usun(nrPesel);
                    }
                    break;
                }
                case 3:
                {
                    if(pacjent.wyswietl() == 1)
                    {
                        System.out.println("Nie można nic aktualizować\n");
                    }
                    else
                    {
                        try
                        {
                            System.out.print("\nPodaj pesel pacjenta z wyświetlonych pacjentów, aby go zaaktualizować: ");
                            nrPesel = bufferedReader.readLine();
                            if(nrPesel.length() != 11)
                                throw new WyjatekPesel();
                            System.out.println("\nAKTUALIZACJA PACJENTA O PESELU " + nrPesel + "\n");
                            System.out.print("Podaj imię pacjenta: ");
                            String imie = bufferedReader.readLine();
                            System.out.print("Podaj nazwisko pacjenta: ");
                            String nazwisko = bufferedReader.readLine();
                            System.out.print("Podaj numer ubezpieczenia pacjenta: ");
                            String nrUbezpieczenia = bufferedReader.readLine();
                            if(nrUbezpieczenia.length() != 13)
                                throw new WyjatekUbe();
                            System.out.print("Podaj numer NFZ pacjenta: ");
                            String nrNFZ = bufferedReader.readLine();
                            if(nrNFZ.length() != 2)
                                throw new WyjatekNFZ();
                            System.out.print("Podaj numer PWZ lekarza pacjenta: ");
                            String nrPWZlekarza = bufferedReader.readLine();
                            if(nrPWZlekarza.length() != 7)
                                throw new WyjatekPWZ();
                            System.out.print("Podaj date urodzenia pacjenta w formacie DD-MM-RRRR odzielając myślnikami jak podano w przykładzie: ");
                            String dataUrodzenia = bufferedReader.readLine();
                            char a = dataUrodzenia.charAt(2), b = dataUrodzenia.charAt(5);
                            if(dataUrodzenia.length() != 10 && a != '-' && b != '-')
                                throw new WyjatekData();
                            System.out.print("Podaj plec pacjenta: ");
                            String plec = bufferedReader.readLine();
                            String pom = plec.toLowerCase();
                            if(!pom.equals("kobieta") && !pom.equals("mezczyzna") && !pom.equals("mężczyzna"))
                                throw new WyjatekPlec();
                            pacjent.aktualizuj(nrPesel, imie, nazwisko, nrUbezpieczenia, nrNFZ, nrPWZlekarza, nrPesel, dataUrodzenia, plec);
                        }
                        catch (RuntimeException exception)
                        {
                            System.out.println("Błąd !!!");
                        }
                    }
                    break;
                }
                case 4:
                {
                    pacjent.wyswietl();
                    break;
                }
                case 5:
                {
                    if(!pacjent.szukajPesel(nrPesel).equals("1"))
                    {
                        try
                        {
                            System.out.print("\nPodaj pesel studenta, aby odnaleźć go w bazie: ");
                            nrPesel = bufferedReader.readLine();
                            if(nrPesel.length() != 11)
                                throw new WyjatekPesel();
                            pacjent.szukajPesel(nrPesel);
                            nrPesel = "-1";
                        }
                        catch (RuntimeException exception)
                        {
                            System.out.println("Błąd");
                        }
                    }
                    else
                    {
                        System.out.println("Nie można nic wyszukiwać\n");
                    }
                    break;
                }
                case 6:
                {
                    if(pacjent.szukajNazwisko(nazw).equals("1"))
                    {
                        System.out.println("Nie można nic wyszukiwać\n");
                    }
                    else
                    {
                        System.out.print("\nPodaj nazwisko pacjenta, aby odnaleźć go w bazie: ");
                        nazw = bufferedReader.readLine();
                        pacjent.szukajNazwisko(nazw);
                        nazw = "-";
                    }
                    break;
                }
                case 7:
                {
                    if(pacjent.szukajUbe(pwz).equals("-1"))
                    {
                        System.out.println("Nie można nic wyszukiwać\n");
                    }
                    else
                    {
                        System.out.print("\nPodaj numer ubezpieczenia, aby odnaleźć pacjenta w bazie: ");
                        pwz = bufferedReader.readLine();
                        pacjent.szukajUbe(pwz);
                        pwz = "-1";
                    }
                }
                default:
                {
                    if(choice > 8)
                        System.out.println("\nPodano błędną wartość\n");
                    if(choice == 8)
                        System.out.println("Dziękujemy za skorzystanie z programu !!!");
                }
            }
        }while (choice != 8);
    }
}