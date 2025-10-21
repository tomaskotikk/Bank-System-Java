import java.util.Scanner;

public class Kontokorent extends  BankovniUcet{

    Scanner sc = new Scanner(System.in);

    int KontoVolba;
    int KontoLimit = 10000;
    int PomocKonto;

    public Kontokorent(int cisloUctu, boolean platebniKarta, String jmenoUcet, String adresaUcet, int castkaUcet, boolean schvalenyUcet, Scanner sc) {
        super(cisloUctu, platebniKarta, jmenoUcet, adresaUcet, castkaUcet, schvalenyUcet);
        this.jmenoUcet = jmenoUcet;
    }

    @Override
    public void setJmenoUcet(String jmenoUcet) {
        super.setJmenoUcet(jmenoUcet);
    }

    @Override
    public String getJmenoUcet() {
        return super.getJmenoUcet();
    }

    void KontokorentUvod() {
        System.out.println("---------------------------");
        System.out.println("Víta vás KONTOKORENT");
        System.out.println("---------------------------");
        System.out.println("Vypiseme si vase aktualni statistiky na ucte:");
        System.out.println("Vase jmeno: "+ jmenoUcet);
        System.out.println("Castka na ucte : "+ castkaUcet);
        System.out.println("---------------------------");
        KontokorentMenu();
    }

    void KontokorentMenu(){
        while(true){
            System.out.println("Kontokorent Menu:");
            System.out.println("---------------------");
            System.out.println("1 - Vlozit penize");
            System.out.println("2 - Vybrat penize");
            System.out.println("3 - Zobraz info");
            System.out.println("4 - Zrusit Kontokorent");
            System.out.println("5 - Zpatky na hlavni Menu");
            System.out.println("---------------------");
            System.out.println("Zadejte vasi volbu : ");
            KontoVolba = sc.nextInt();

            switch(KontoVolba){


                case 1:
                    VkladPenez();
                    break;

                case 2:
                    VyberPenez();
                    break;

                case 3:
                    KontoInfo();
                    break;

                case 4:
                    zrusitKonto();
                    break;

                case 5:
                        BankovniUcet bankovniUcet = new BankovniUcet();
                        HlavniMenu();

                default:
                    System.out.println("spatny input");

            }
        }

    }

    void KontoInfo(){
        System.out.println("---------------------------------");
        System.out.println("Vitam te v info v Kontokorentu Info: ");
        System.out.println("---------------------------------");
        System.out.println("Zustatek na uctu: " + castkaUcet);
        System.out.println("Vas kontokorent limit : " + KontoLimit);
        System.out.println("Castku kterou musite splatit: "+ PomocKonto);
        System.out.println("Platebni karta: " + platebniKarta);
        System.out.println("Adresa: " + adresaUcet);
    }

    @Override
    void VyberPenez(){
        int vyber;
        System.out.println("Zadejte hodnotu vyberu penez:");
        vyber = sc.nextInt();

        if(vyber > this.castkaUcet + KontoLimit){
            System.out.println("Vetsi vyber nez mate zustatek a limit na kontokorentu");
        }
        if(vyber < this.castkaUcet){
            this.castkaUcet = this.castkaUcet - vyber;
            System.out.println("Aktualni zustatek : " + castkaUcet);
        }
        else if (vyber < this.castkaUcet + KontoLimit){
            System.out.println("Na zacatku musis splatit : "+PomocKonto);
            System.out.println("Zustatek predtim : " +castkaUcet);
            PomocKonto = vyber - this.castkaUcet;
            castkaUcet = castkaUcet - castkaUcet;
            System.out.println("Musis splatit: "+PomocKonto);
            System.out.println("Zustatek na ucte : "+castkaUcet);
            KontoLimit = KontoLimit - PomocKonto;
        }
    }

    void zrusitKonto(){
        if(PomocKonto > 0){
            System.out.println("Nejde zrusit Kontokorent, jeste musite splatit : "+PomocKonto);
        } else {
            System.out.println("USPESNE ZRUSENY KONTOKORENT");
            KontoLimit = 10000;
            PomocKonto = 0;
        }
    }

    @Override
    void VkladPenez() {

        int Vklad;
        System.out.println("Zadejte hodnotu vkladu penez:");
        Vklad = sc.nextInt();

        if(PomocKonto > 0){
            if(Vklad > PomocKonto){
                System.out.println("Splatil si :" + this.PomocKonto);
                Vklad = Vklad - PomocKonto;
                this.castkaUcet = Vklad;
                this.PomocKonto = 0;
                System.out.println("Novy zustatek : "+ castkaUcet);
                this.KontoLimit = 10000;
                System.out.println("Vas limit je znova: "+KontoLimit);
            } else if (Vklad < PomocKonto) {
                this.PomocKonto = this.PomocKonto - Vklad;
                System.out.println("Musis jeste splatit : "+this.PomocKonto);
            }
        }else{
            this.castkaUcet = this.castkaUcet + Vklad;
            System.out.println("Aktualni zustatek : " + castkaUcet);
        }
    }

}
