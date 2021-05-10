import java.util.HashMap;

public class Pacjent {

    private String imie;
    private String nazwisko;
    private String nrUbezpieczenia;
    private String nrNFZ;
    private String nrPWZlekarza;
    private String pesel;
    private String dataUrodzenia;
    private String plec;
    private final HashMap<String, Pacjent>mapa = new HashMap<>();

    public Pacjent(String imie, String nazwisko, String nrUbezpieczenia, String nrNFZ, String nrPWZlekarza, String pesel, String dataUrodzenia, String plec)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrUbezpieczenia = nrUbezpieczenia;
        this.dataUrodzenia = dataUrodzenia;
        this.nrNFZ = nrNFZ;
        this.pesel = pesel;
        this.plec = plec;
        this.nrPWZlekarza = nrPWZlekarza;
    }

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public String getPesel() {
        return pesel;
    }

    public String getNrPWZlekarza() {
        return nrPWZlekarza;
    }

    public String getNrNFZ() {
        return nrNFZ;
    }

    public String getPlec() {
        return plec;
    }

    public String getNrUbezpieczenia() {
        return nrUbezpieczenia;
    }

    Pacjent(){}

    public String getImie()
    {
        return imie;
    }

    public String getNazwisko()
    {
        return nazwisko;
    }

    void dodaj(String imie, String nazwisko, String nrUbezpieczenia, String nrNFZ, String nrPWZlekarza, String pesel, String dataUrodzenia, String plec)
    {
        mapa.put(pesel, new Pacjent(imie, nazwisko, nrUbezpieczenia,nrNFZ,nrPWZlekarza,pesel,dataUrodzenia,plec));
        System.out.println("\nDODANO PACJENTA\n");
    }

    void usun(String usuniecie)
    {
        for (String name : mapa.keySet()) {
            if(mapa.get(name).getPesel().equals(usuniecie))
                mapa.remove(name);
        }
        System.out.println("\nUSUNIĘTO POMYŚLNIE PACJENTA Z BAZY\n");
    }

    int wyswietl()
    {
        for (String name: mapa.keySet()) {
            System.out.println("\nIMIE: " + mapa.get(name).getImie() + "\nNAZWISKO: " + mapa.get(name).getNazwisko() + "\nPESEL: " + mapa.get(name).getPesel() + "\nDATA URODZENIA: " + mapa.get(name).getDataUrodzenia() + "\nPŁEĆ: " + mapa.get(name).getPlec() + "\nNR UBEZPIECZENIA: " + mapa.get(name).getNrUbezpieczenia() + "\nNR NFZ: " + mapa.get(name).getNrNFZ() + "\nNR PWZ LEKARZA: " + mapa.get(name).getNrPWZlekarza() +"\n");
        }
        if(mapa.size() == 0)
        {
            System.out.println("\nBRAK PACJENTÓW\n");
            return 1;
        }
        return 0;
    }

    void aktualizuj(String aktualizacja, String imie, String nazwisko, String nrUbezpieczenia, String nrNFZ, String nrPWZlekarza, String pesel, String dataUrodzenia, String plec)
    {
        for (String name : mapa.keySet()) {
            if(mapa.get(name).getPesel().equals(aktualizacja))
                mapa.remove(name);
        }
        mapa.put(aktualizacja, new Pacjent(imie, nazwisko,nrUbezpieczenia,nrNFZ,nrPWZlekarza,pesel,dataUrodzenia,plec));
        System.out.println("\nZAAAKTUALIZOWANO INFORMACJE O PACJENCIE\n");
    }

    String szukajPesel(String nrPesel)
    {
        int flag = 0;
        if(mapa.size() == 0)
        {
            System.out.println("\nBRAK PACJENTÓW\n");
            return "1";
        }
        else
        {
            for (String name: mapa.keySet())
            {
                if(nrPesel.equals(mapa.get(name).getPesel()))
                {
                    System.out.println("\nIMIE: " + mapa.get(name).getImie() + "\nNAZWISKO: " + mapa.get(name).getNazwisko() + "\nPESEL: " + mapa.get(name).getPesel() + "\nDATA URODZENIA: " + mapa.get(name).getDataUrodzenia() + "\nPŁEĆ: " + mapa.get(name).getPlec() + "\nNR UBEZPIECZENIA: " + mapa.get(name).getNrUbezpieczenia() + "\nNR NFZ: " + mapa.get(name).getNrNFZ() + "\nNR PWZ LEKARZA: " + mapa.get(name).getNrPWZlekarza() +"\n");
                    flag = 1;
                }
            }
            if(flag == 0  && !nrPesel.equals("-1"))
            {
                throw new WyjatekNieZnaleziono();
            }
        }
        return "0";
    }

    String szukajNazwisko(String nazwisko)
    {
        int flag = 0;
        if(mapa.size() == 0)
        {
            System.out.println("\nBRAK PACJENTÓW\n");
            return "1";
        }
        else
        {
            for (String name: mapa.keySet())
            {
                if(nazwisko.equals(mapa.get(name).getNazwisko()))
                {
                    System.out.println("\nIMIE: " + mapa.get(name).getImie() + "\nNAZWISKO: " + mapa.get(name).getNazwisko() + "\nPESEL: " + mapa.get(name).getPesel() + "\nDATA URODZENIA: " + mapa.get(name).getDataUrodzenia() + "\nPŁEĆ: " + mapa.get(name).getPlec() + "\nNR UBEZPIECZENIA: " + mapa.get(name).getNrUbezpieczenia() + "\nNR NFZ: " + mapa.get(name).getNrNFZ() + "\nNR PWZ LEKARZA: " + mapa.get(name).getNrPWZlekarza() +"\n");
                    flag = 1;
                }
            }
            if(flag == 0  && !nazwisko.equals("-"))
                throw new WyjatekNieZnaleziono();
        }
        return "0";
    }

    String szukajUbe(String szukaj)
    {
        int flag = 0;
        if(mapa.size() == 0)
        {
            System.out.println("\nBRAK PACJENTÓW\n");
            return "-1";
        }
        else
        {
            for (String name: mapa.keySet())
            {
                if(szukaj.equals(mapa.get(name).getNrUbezpieczenia()))
                {
                    System.out.println("\nIMIE: " + mapa.get(name).getImie() + "\nNAZWISKO: " + mapa.get(name).getNazwisko() + "\nPESEL: " + mapa.get(name).getPesel() + "\nDATA URODZENIA: " + mapa.get(name).getDataUrodzenia() + "\nPŁEĆ: " + mapa.get(name).getPlec() + "\nNR UBEZPIECZENIA: " + mapa.get(name).getNrUbezpieczenia() + "\nNR NFZ: " + mapa.get(name).getNrNFZ() + "\nNR PWZ LEKARZA: " + mapa.get(name).getNrPWZlekarza() +"\n");
                    flag = 1;
                }
            }
            if(flag == 0  && !szukaj.equals("-1"))
               throw new WyjatekNieZnaleziono();
        }
        return "0";
    }
}
