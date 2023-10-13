public class ToolStore  extends  NormalLoc{
    public ToolStore(Player player){
        super(player,"Mağaza");
    }
    @Override
    public boolean onLocation(){
        System.out.println("Mağazaya Hoşgeldiniz.");
        System.out.println("-1 Silahlar");
        System.out.println("-2 Zırhlar");
        System.out.println("-3 Çıkış Yap");
        System.out.print("Seçiminiz: ");
        int selectCase = input.nextInt();

        switch ( selectCase){
            case 1:
                printWeapon();
                buyWeapon();
                break;
            case 2:
                printArmor();
                break;
            case 3:
                System.out.println("Bir daha bekleriz.");
                return true;
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("Silahlar:  ");
        System.out.println(" ");
        for(Weapon w: Weapon.weapons()){
            System.out.println( w.getId()+" - " + w.getName()
                    + " - Para"+ w.getPrice()
                    + " , Hasar:  "+ w.getDamage() );
        }

    }

    public void buyWeapon(){

        System.out.println("Bir silah seçiniz: ");
        int selectWeaponID = input.nextInt();
        while(selectWeaponID < 1 || selectWeaponID > Weapon.weapons().length){
            System.out.println("Geçersiz değer, tekrar giriniz!");
            selectWeaponID = input.nextInt();
        }

        Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
        if( selectedWeapon != null ) {
            if (selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                System.out.println("Yeterli paranız yok.");
            }else{
                System.out.println(selectedWeapon.getName() + "silahını satın aldınız.!");
                int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                this.getPlayer().setMoney(balance);
                System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                this.getPlayer().getInventory().setWeapon(selectedWeapon);

            }
        }
    }
    public void printArmor(){
        System.out.println("Zırhlar");
    }


}
