package kz.Prudnikov.ATM;

import java.util.HashMap;
import java.util.Scanner;

public class ATM {

    private int balance = 0;
    public int answer;
    private boolean access = true, access2 = true, access3 = true;
    private boolean opt = true, opt2 = true, opt3 = true;
    private String nameFor = "";

    public int depositInAccount, password;


    public ATM() {
        Menu();
    }

    HashMap<String, Integer> login = (new DataBase()).getLoginP();
    HashMap<String, Integer> money = (new DataBase()).getMoneyP();
    Scanner scan = new Scanner(System.in);

    public void Menu() {
        Password();
        Options();

    }

    public void Password() {
        while (access) {
            System.out.println("Your Login:");
            String name = scan.nextLine();
            nameFor = name;

            while (access2) {
                if (login.containsKey(name)) {

                    while (access3) {
                        System.out.println("Your password: ");
                        if (scan.hasNextInt()) {
                            password = scan.nextInt();
                            int check = login.get(name);

                            if (login.containsValue(password) && password == check) {
                                access = false;
                                access2 = false;
                                access3 = false;
                            } else System.out.println("Incorrect password, try again");
                        } else {
                            System.out.println("Incorrect password, try again");
                        }
                        String err = scan.nextLine();
                    }
                } else {
                    System.out.println("Incorrect login, try again ");
                    break;
                }
            }
        }
    }

    public void Options() {
        while (opt2) {
            System.out.println("1. Check the balance\n" + "2. Withdraw money\n" + "3. Exit");
             answer = (new InputErrorCheck()).getAnswer();
            if(answer > 3 || answer <=0) {System.out.println("Incorrect input, try again");  answer = (new InputErrorCheck()).getAnswer(); }
            switchCase();
            }
        }

        public void switchCase () {
            depositInAccount = money.get(nameFor);
            while (opt3) {
                switch (answer) {
                    case (1):
                        System.out.println("Your balance is: " + depositInAccount);
                        System.out.println("2. Withdraw money\n" + "3. Exit");
                         answer = (new InputErrorCheck()).getAnswer();
                        if(answer > 3 || answer <=1) {System.out.println("Incorrect input, try again");  answer = (new InputErrorCheck()).getAnswer(); }
                        break;
                    case (2):
                        if (depositInAccount == 0) {
                            System.out.println("Your balance is 0 and you can not withdraw the money!");
                            answer = 1;
                            System.out.println("1. Check the balance\n" + "2. Withdraw money\n" + "3. Exit");
                            answer = (new InputErrorCheck()).getAnswer();
                            if(answer > 3 || answer <=0) {System.out.println("Incorrect input, try again");  answer = (new InputErrorCheck()).getAnswer(); }
                        } else {System.out.println("How match you want to withdraw?");
                            answer = (new InputErrorCheck()).getAnswer();
                        if(answer > depositInAccount) {System.out.println("In your account not enough money! Please choose another amount "); answer = 2; break; }
                        else{depositInAccount = depositInAccount - answer; answer = 1;}
                        }
                        break;
                    case(3):
                        new ChangeTheData(password, nameFor, depositInAccount);                                                   ///////// password, nameForRewrite, depositInAccount
                        System.out.println("Thank you, " + nameFor + ", see you next time!");
                        opt3 = false;
                        opt2 = false;
                }
            }
        }

}
