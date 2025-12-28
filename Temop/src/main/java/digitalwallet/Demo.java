package digitalwallet;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        OfferService offerService = OfferService.getInstance();
        DigitalWallet digitalWallet = new DigitalWallet(offerService);
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        while (x-- > 0) {
            String sc = scanner.next();
            String[] arr = sc.split(" ");
            if (arr[0].equalsIgnoreCase("CreateWallet")){
                digitalWallet.addWallet(arr[1], Double.parseDouble(arr[2]));
            }else if(arr[0].equalsIgnoreCase("TransferMoney")){
                digitalWallet.doPayment(arr[1],arr[2],Double.parseDouble(arr[3]));
            }
        }
        digitalWallet.showTransactions();

    }
}
