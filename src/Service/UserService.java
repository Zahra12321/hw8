package Service;

import entity.User;
import repository.UserRepository;

import java.util.Scanner;

public class UserService {
    static Scanner stringInput = new Scanner(System.in);
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register() {
        boolean registered = false;
        String username, password;
        while (!registered) {
            System.out.println("please enter a username:");
            username = stringInput.nextLine();
            User found = (User) userRepository.findBy("username", username);
            if (found == null) {
                System.out.println("please enter your password:");
                password = stringInput.nextLine();
                userRepository.save(new User(username, password));
                System.out.println("Registered successfully!");
                return;
            } else {
                System.out.println("Username has been taken!");
            }
        }
    }

    public boolean login() {
        boolean loggedIn = false;
        String username, password;
        while (true) {
            System.out.println("please enter a username:");
            username = stringInput.nextLine();
            User found = (User) userRepository.findBy("username", username);
            if (found.getUsername() != null) {
                while (true) {
                    System.out.println("please enter your password:");
                    password = stringInput.nextLine();
                    if (password.equals(found.getPassword())) {
                        System.out.println("login successful!");
                        return true;
                    } else {
                        System.out.println("Wrong password!");
                    }
                }
            } else {
                System.out.println("username not found!");
            }
        }
    }
}
