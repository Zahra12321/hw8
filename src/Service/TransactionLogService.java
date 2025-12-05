package Service;


import entity.Card;
import entity.TransactionLog;
import repository.TransactionLogRepository;
import util.ApplicationContext;

public class TransactionLogService {
    private final TransactionLogRepository transactionLogRepository;

    public TransactionLogService(TransactionLogRepository transactionLogRepository) {
        this.transactionLogRepository = transactionLogRepository;
    }

    public void cardTransaction(TransactionLog tLog, int transactionTyp){
        switch (transactionTyp) {
            case 1, 2:
                ApplicationContext.cardRepository.processPaymentDB(tLog.getSrcCard(), tLog.getDestCard());
                ApplicationContext.transactionLogRepository.save(tLog);
                break;
            case 3:

                break;
            case 4:

                break;
        }
    }
}
