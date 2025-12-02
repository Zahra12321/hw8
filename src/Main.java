import Service.UserService;
import entity.User;
import repository.UserRepository;
import util.ApplicationContext;

import java.util.Scanner;

public class Main {
    static Scanner intInput = new Scanner(System.in);
    static Scanner stringInput = new Scanner(System.in);

    public static void main(String[] args) {
        boolean logIn = true;


        while (logIn) {

            System.out.println("""
                    1. register
                    2. log in
                    3. exit
                    """);
            int choose = intInput.nextInt();

            switch (choose) {
                case 1:
                    ApplicationContext.userService.register();
                    /*while (logIn) {

                        //UserRepository.save();
                        //passengerRepository.save();
                    }*/
                    break;
                case 2:
                    if (ApplicationContext.userService.login()) {
                        //ApplicationContext.cardService.menu();
                    }
                    break;
                case 3:
                    return;
            }
        }
    }


}