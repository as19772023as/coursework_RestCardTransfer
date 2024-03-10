package ru.strebkov.coursework_RestCardTransfer.logger;

import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SmsLogger implements LoggerInterface {
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private static volatile SmsLogger INSTANCE = null;

    private SmsLogger() {
    }

    public static SmsLogger getInstance() {
        if (INSTANCE == null) {
            synchronized (SmsLogger.class) {
                if (INSTANCE == null)
                    INSTANCE = new SmsLogger();
            }
        }
        return INSTANCE;
    }

    @Override
    public String logTransferModel(TransferModel model, Integer amountRub, double commissionRub, String codeUuid) {
        return " [" + dtf.format(LocalDateTime.now()) + "] <" +
                "Перевод с карты: " + model.getCardFromNumber() +
                " на карту: " + model.getCardToNumber() +
                " в сумме: " + amountRub + " руб, " +
                "комиссия за перевод: " + commissionRub + " руб, " +
                "id:" + codeUuid +
                ">\n";
    }

    @Override
    public String logConfirmOperation(ConfirmOperationModel confirmOperationModel, String codeUuid) {
        return String.format("[Успешно: код операции: '%s']\n", codeUuid);
    }

    @Override
    public String logError(String stringUuid) {
        return String.format("[ERROR, код операции: '%s']\n", stringUuid);
    }

}
