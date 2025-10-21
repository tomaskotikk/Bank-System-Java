import java.util.Scanner;

public class SpotrebitelskyUver extends  BankovniUcet{

    Scanner sc = new Scanner(System.in);

    public SpotrebitelskyUver(int cisloUctu, boolean platebniKarta, String jmenoUcet, String adresaUcet, int castkaUcet, boolean schvalenyUcet, Scanner sc) {
        super(cisloUctu, platebniKarta, jmenoUcet, adresaUcet, castkaUcet, schvalenyUcet);
        this.jmenoUcet = jmenoUcet;
    }

    int volba;
    int uver;
    int splatbaUver;
    boolean jeUver = false;

    void SpotrebitelskyUverMenu() {
        System.out.println("Vitej v spotrebitelskem Uveru");
        System.out.println("-------------------------------");
        System.out.println("Vypiseme si vase aktualni statistiky na ucte:");
        System.out.println("Vase jmeno: "+ jmenoUcet);
        System.out.println("Castka na ucte : "+ castkaUcet);
        System.out.println("---------------------------");
        UverMenu();
    }

    void UverMenu(){
        while(true) {
            System.out.println("-------------------------------");
            System.out.println("UVER MENU");
            System.out.println("-------------------------------");
            System.out.println("1 - Vybrat uver");
            System.out.println("2 - Splatit uver");
            System.out.println("3 - Vypis info o ucte");
            System.out.println("4 - Zpatky do Hlavni menu");
            System.out.println("-------------------------------");
            System.out.println("Zadejte volbu: ");
            volba = sc.nextInt();

            switch(volba) {
                case 1:
                    zalozitUver();
                    break;

                case 2:
                    splatituUver();
                    break;

                case 3:
                    uverInfo();
                    break;

                case 4:
                    BankovniUcet bankovniUcet = new BankovniUcet();
                    HlavniMenu();
            }
        }
    }

    void zalozitUver(){
        System.out.println("Zadejte vysi uveru : ");
        uver = sc.nextInt();
        uver = uver;
        jeUver = true;
    }

    void splatituUver(){
        System.out.println("Zadejte castku, kolik chcete splatit : ");
        splatbaUver = sc.nextInt();

        if(this.uver > splatbaUver) {
            System.out.println("Splatili jste : "+splatbaUver);
            this.uver = this.uver - splatbaUver;
            System.out.println("Jeste chybi splatit: "+uver);
        } else if (this.uver < splatbaUver) {
            System.out.println("Uver Uspesne splacen");
            splatbaUver = splatbaUver - this.uver;
            this.castkaUcet = this.castkaUcet + splatbaUver;
            System.out.println("Na ucet jsme vam pripsali :" +splatbaUver);
            uver = 0;
        }
    }

    void uverInfo(){
        System.out.println("---------------------------------");
        System.out.println("Vitam te v info v Uver Info: ");
        System.out.println("---------------------------------");
        System.out.println("Zustatek na uctu: " + castkaUcet);
        System.out.println("Platebni karta: " + platebniKarta);
        System.out.println("Adresa: " + adresaUcet);
        System.out.println("Uver : "+uver);
        System.out.println("---------------------------------");
    }
}
