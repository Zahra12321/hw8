package util;

import Service.CardService;
import Service.UserService;
import repository.CardRepository;
import repository.UserRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ApplicationContext {
    private static ApplicationContext CTX;
    public static final Connection connection;
    public static final UserRepository userRepository;
    public static final UserService userService;
    public static final CardRepository cardRepository;
    public static final CardService cardService;

    static {
        connection = getInstance().getConnection();
        userRepository = new UserRepository(connection);
        userService = new UserService(userRepository);
        cardRepository = new CardRepository(connection);
        cardService = new CardService(cardRepository);
    }

    public static UserService getUserService(){
        return userService;
    }

    private ApplicationContext(){}

    public static ApplicationContext getInstance() {
        if (CTX == null){
            CTX = new ApplicationContext();
        }
        return CTX;
    }

    public Connection getConnection() {
        if (connection == null){
            try {
                return DriverManager.getConnection(
                        ApplicationProperties.DATABASE_URL,
                        ApplicationProperties.DATABASE_USERNAME,
                        ApplicationProperties.DATABASE_PASSWORD
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }
}
