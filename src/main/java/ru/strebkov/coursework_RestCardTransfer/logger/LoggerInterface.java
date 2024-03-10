package ru.strebkov.coursework_RestCardTransfer.logger;

import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;

public interface LoggerInterface {
        String logTransferModel(TransferModel model, Integer amount, double commissionOfTheBank, String stringUuid);
        String logConfirmOperation(ConfirmOperationModel confirmOperationModel, String stringUuid);
        String logError(String stringUuid);
    }

