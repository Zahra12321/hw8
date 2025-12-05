package repository;

import entity.Card;
import entity.TransactionLog;
import repository.base.AbstractCrudRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionLogRepository extends AbstractCrudRepository {
    public TransactionLogRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected Object getEntity(ResultSet resultSet) {
        TransactionLog tLog;
        try {
            tLog = new TransactionLog(
                    new Card(resultSet.getString(2)),
                    new Card(resultSet.getString(3)),
                    resultSet.getInt(4),
                    resultSet.getString(5)
            );
            tLog.setId(resultSet.getInt(1));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tLog;
    }

    @Override
    public String getTableName() {
        return "transaction_log";
    }

    @Override
    public Object save(Object object) {
        TransactionLog tLog = (TransactionLog) object;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO " + getTableName() + "(src_card_num, dest_card_num, amount,status) VALUES (? , ? , ?,?)");
            ps.setString(1, tLog.getSrcCard().getCardNumber());
            ps.setString(2, tLog.getDestCard().getCardNumber());
            ps.setInt(3, tLog.getAmount());
            ps.setString(4, tLog.getStatus());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
