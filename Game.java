import java.util.Scanner;


public class Game {

    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz: ");
        System.out.println("Lütfen bir isim giriniz:");
        // String playerName = input.nextLine();
        Player player = new Player("Kağan");
        System.out.println("Sayın "+player.getName() + " bu oyuna hoşgeldiniz ");

        System.out.println("Lütfen bir karakter ID'si seçiniz:");
        player.selectChar();

        Location location  = null;

        while(true){
            player.printInfo();
            System.out.println("Bölgeler");
            System.out.println("1- Güvenli ev. Burası sizin için güvenli yer, düşman yoktur.");
            System.out.println("2- Mağaza: Silah veya zırh alabilirsiniz.");
            System.out.println("Lütfen gitmek istediğiniz bölgeyi seçiniz: ");
            int selectLoc = input.nextInt();
            switch(selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2: location = new ToolStore(player);
                    break;
                default: new SafeHouse(player);
            }
            if(!location.onLocation()){
                System.out.println("Oyun bitti.");
                break;
            }


        }

    }
}

