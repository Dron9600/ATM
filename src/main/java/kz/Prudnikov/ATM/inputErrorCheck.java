package kz.Prudnikov.ATM;

import java.util.Scanner;

class InputErrorCheck {
    public int answer;

    Scanner scan = new Scanner(System.in);


    public InputErrorCheck() {
        boolean opt = true;
        while (opt)
            if (scan.hasNextInt()) {
                answer = Integer.parseInt(scan.nextLine());
                break;
            } else {System.out.println("Incorrect input, please try again"); scan.nextLine();}
    }

    public int getAnswer() {
        return answer;
    }

}
