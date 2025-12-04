package repository;

import entity.Card;
import repository.base.AbstractCrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CardRepository extends AbstractCrudRepository {

    public CardRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Object save(Object object) {
        Card card = (Card) object;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO cards (card_number, bank_name, user_id) VALUES (? , ? , ?)");
            ps.setString(1, card.getCardNumber());
            ps.setString(2, card.getBankName());
            ps.setInt(3, card.getUserId());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public Card remove(String cardNumber) {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from cards where card_number = ?");
            ps.setString(1, cardNumber);
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public ArrayList<Card> findBy(String column, Integer id) {
        ArrayList<Card> result = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("select card_number, bank_name, balance from " + getTableName() + " where " + column + " = ? and user_id = ?");
            statement.setString(1, column);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                result.add(new Card(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
            return result;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected Object getEntity(ResultSet resultSet) {
        Card card = new Card();
        try {
            card.setCardNumber(resultSet.getString(1));
            card.setBankName(resultSet.getString(2));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return card;
    }

    @Override
    public String getTableName() {
        return "cards";
    }


}
