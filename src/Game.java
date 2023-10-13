import java.util.Scanner;

public class Game {

    private Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera Oyununa Hoşgeldiniz: ");
        System.out.println("Lütfen bir isim giriniz:");
        // String playerName = input.nextLine();
        Player player = new Player("Kağan");
        System.out.println("Sayın "+player.getName() + " bu oyuna hoşgeldiniz ");

        System.out.println("Lütfen bir karakter seçiniz:");
        player.selectChar();
    }
}
