import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.Scanner;

public class BankovniUcet {

    Scanner sc = new Scanner(System.in);

    protected int cisloUctu = 1000000;
    protected boolean platebniKarta;
    protected String jmenoUcet;
    protected String adresaUcet;
    protected int castkaUcet;
    int volba;
    boolean konec;
    protected boolean SchvalenyUcet;

    BankovniUcet(int cisloUctu, boolean platebniKarta, String jmenoUcet, String adresaUcet, int castkaUcet, boolean schvalenyUcet) {
        this.cisloUctu = cisloUctu;
        this.platebniKarta = platebniKarta;
        this.jmenoUcet = jmenoUcet;
        this.adresaUcet = adresaUcet;
        this.castkaUcet = castkaUcet;
        SchvalenyUcet = schvalenyUcet;
    }

    public BankovniUcet() {

    }


    void spustAplikaci(){ // Hlavni cast, co spousti celou apliakci

        while(!SchvalenyUcet) {
            cisloUctu++;
            System.out.println("Vitejte v Bance, pojdme vam zalozit vas ucet!");
            System.out.println("-----------------");
            System.out.println("Zadejte vase jmeno:");
            jmenoUcet = sc.nextLine();
            System.out.println("-----------------");
            System.out.println("Zadejte adresu majitele: ");
            adresaUcet = sc.nextLine();
            System.out.println("-----------------");
            System.out.println("Mate fyzickou kartu?: (ano-ne)");
            String karta = sc.nextLine();

            if (karta.equals("ano")) {
                platebniKarta = true;
                SchvalenyUcet = true;
                HlavniMenu();
            } else if (karta.equals("ne")) {
                platebniKarta = false;
                SchvalenyUcet = true;
                HlavniMenu();
            } else {
                System.out.println("Neplatny udaj, pojdme to UDELAT ZNOVU");
                SchvalenyUcet = false;
            }

        }

    }

    void HlavniMenu(){ // Hlavni menu, ktere se zobrazi

        while(!konec) {
            System.out.println("Vitejte v hlavnim menu:");
            System.out.println("-----------------");
            System.out.println(" 1. Vlozit penize");
            System.out.println(" 2. Vybrat penize");
            System.out.println(" 3. Zobraz info o ucte");
            System.out.println(" 4. Zalozit si kontokorent");
            System.out.println(" 5. Spotrebitelsky uver");
            System.out.println("-----------------");

            System.out.println("Zadejte vasi volbu:");
            volba = sc.nextInt();

            switch (volba) {
                case 1:
                    VkladPenez();
                    break;

                case 2:
                    VyberPenez();
                    break;

                case 3:
                    ZobrazInfo();
                    break;

                case 4:
                    Kontokorent kontokorent = new Kontokorent(cisloUctu,platebniKarta,jmenoUcet,adresaUcet,castkaUcet,SchvalenyUcet,sc);
                    kontokorent.KontokorentUvod();
                    konec = true;
                    break;

                case 5:
                    SpotrebitelskyUver spotrebitelsky = new SpotrebitelskyUver(cisloUctu,platebniKarta,jmenoUcet,adresaUcet,castkaUcet,SchvalenyUcet,sc);
                    spotrebitelsky.SpotrebitelskyUverMenu();
                    konec = true;
                    break;

                default:
                    break;
            }
        }
    }

    void VkladPenez(){
        int Vklad;
        System.out.println("Zadejte hodnotu vkladu penez:");
        Vklad = sc.nextInt();
        this.castkaUcet = Vklad;
        System.out.println("Aktualni zustatek : " + castkaUcet);
    }

    void VyberPenez(){
        int vyber;
        System.out.println("Zadejte hodnotu vyberu penez:");
        vyber = sc.nextInt();

        if(vyber > this.castkaUcet){
            System.out.println("Mate vetsi vyber nez mate zustatek");
        }else{
            this.castkaUcet = this.castkaUcet - vyber;
            System.out.println("Aktualni zustatek : " + castkaUcet);
        }

    }

    void ZobrazInfo(){
        System.out.println("Info o vasem uctu:");
        System.out.println("Vase jmeno: "+this.jmenoUcet);
        System.out.println("Vas zustatek: "+castkaUcet);
        System.out.println("Vase adresa: "+this.adresaUcet);
        System.out.println("Fyzicka karta: "+this.platebniKarta);
        System.out.println("Cislo uctu: "+this.cisloUctu);
    }

    // GETTERY
    public int getCisloUctu() {
        return cisloUctu;
    }

    public boolean isPlatebniKarta() {
        return platebniKarta;
    }

    public String getJmenoUcet() {
        return jmenoUcet;
    }

    public String getAdresaUcet() {
        return adresaUcet;
    }

    public int getCastkaUcet() {
        return castkaUcet;
    }

    //SETTERY

    public void setCisloUctu(int cisloUctu) {
        this.cisloUctu = cisloUctu;
    }

    public void setPlatebniKarta(boolean platebniKarta) {
        this.platebniKarta = platebniKarta;
    }

    public void setJmenoUcet(String jmenoUcet) {
        this.jmenoUcet = jmenoUcet;
    }

    public void setAdresaUcet(String adresaUcet) {
        this.adresaUcet = adresaUcet;
    }

    public void setCastkaUcet(int castkaUcet) {
        this.castkaUcet = castkaUcet;
    }
}
