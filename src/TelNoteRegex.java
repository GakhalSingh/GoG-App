import java.util.Scanner;



public class TelNoteRegex {
    public int menuItemValidate (int min, int max){
        String regex = "[1-9]{1}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg juist nummer in: ");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                int inputNum = Integer.parseInt(input);
                if(inputNum >= min && inputNum <= max){
                    return inputNum;
                }else{
                    System.out.println("Onjuist nummmer ingevoerd! Voer juist nummer in: ");
                }
            }else{
                System.out.println("Onjuist nummer ingevoerd! ");
            }
        }


    }

    public String naamValidate(){
        String regex = "[a-zA-Z0-9]{1,}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg naam in: ");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("Onjuist naam ingevoerd!");
            }
        }

    }

    public String jaartalValidate() {
        String regex = "[0-9]{1,}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg jaartal in: ");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("Onjuist jaartal ingevoerd! Opnieuw invoeren.");
            }
        }
    }

    public String auteurValidate(){
        String regex = "[a-zA-z]{1,}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg auteur in: ");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return input;
            }else{
                System.out.println("Onjuist auteur ingevoerd! Opnieuw invoeren. ");
            }
        }
    }

    public double prijsValidate(){
        String regex = "[0-9]{1,}";
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg prijs in: ");
            String input = scanner.nextLine();
            if(input.matches(regex)){
                return Integer.parseInt(input);
            }else{
                System.out.println("Onjuist prijs ingevoerd! Opnieuw invoeren. ");
            }
        }
    }

    public String gameplayValidate(){

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg review van gameplay in: ");
            String input = scanner.nextLine();
            if(input != null){
                return input;
            }else{
                System.out.println("Onjuist ingevoerd! Opnieuw invoeren. ");
            }
        }
    }

    public String graphicsValidate(){

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg review van graphic in: ");
            String input = scanner.nextLine();
            if(input != null){
                return input;
            }else{
                System.out.println("Onjuist ingevoerd! Opnieuw invoeren. ");
            }
        }
    }

    public String storylineValidate(){

        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Voeg review van storyline in: ");
            String input = scanner.nextLine();
            if(input != null){
                return input;
            }else{
                System.out.println("Onjuist ingevoerd! Opnieuw invoeren. ");
            }
        }
    }


}