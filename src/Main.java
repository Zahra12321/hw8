import Service.LoginMenu;
import util.ApplicationContext;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner intInput = new Scanner(System.in);
    static Scanner stringInput = new Scanner(System.in);

    public static void main(String[] args) {
        LoginMenu loginMenu = new LoginMenu();

        while (true) {

            System.out.println("""
                    1. register
                    2. log in
                    3. exit
                    """);
            int choose = intInput.nextInt();

            switch (choose) {
                case 1:
                    ApplicationContext.userService.register();

                    break;
                case 2:
                    Integer userId = ApplicationContext.userService.login();
                    if (userId != null) {
                        loginMenu.menu(userId);
                    }
                    break;
                case 3:
                    return;
            }
            String[] h = new String[5];
            Arrays.fill(h, "?");
        }
    }


}