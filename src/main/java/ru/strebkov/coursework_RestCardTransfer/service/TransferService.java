package ru.strebkov.coursework_RestCardTransfer.service;

import org.springframework.stereotype.Service;
import ru.strebkov.coursework_RestCardTransfer.exception.ErrorConfirmation;
import ru.strebkov.coursework_RestCardTransfer.exception.ErrorInputData;
import ru.strebkov.coursework_RestCardTransfer.logger.SmsLogger;
import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferResponse;
import ru.strebkov.coursework_RestCardTransfer.repository.TransferRepository;
import ru.strebkov.coursework_RestCardTransfer.repository.TransferRepositoryInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class TransferService {
    private final TransferRepositoryInterface repository;
    private SmsLogger smsLogger;

    private File clientLogFile = new File("src/main/resources/static/clientLog.log");
    private double commissionOfTheBank = 1;


    public TransferService(TransferRepositoryInterface repository) {
        this.repository = repository;
        smsLogger = SmsLogger.getInstance();
    }

    public TransferResponse postTransfer(TransferModel transferModel) {
        final String transferId = Integer.toString(repository.getOperationId());

        try (FileWriter writerClientLog = new FileWriter(clientLogFile, true)) {
            final String cardFrom = transferModel.getCardFromNumber();
            final String cardTo = transferModel.getCardToNumber();
            final String cvv = transferModel.getCardFromCVV();final String period = transferModel.getCardFromValidTill();
            final Integer amountRub = transferModel.getAmount().getValue() / 100;

            cardsCheck(cardFrom, cardTo);
            cvvCheck(cvv);
            dateCheck(period);
            amountCheck(amountRub);

            double commissionRub = (double) amountRub * commissionOfTheBank / 100;

            repository.addTransfer(transferId, transferModel);
            final String codeUuid = UUID.randomUUID().toString();
            repository.addCode(transferId, codeUuid);

            writerClientLog.write(smsLogger.logTransferModel(
                    transferModel,
                    amountRub,
                    commissionRub,
                    codeUuid));

        } catch (IOException e) {
            e.getMessage();
        }

        return new TransferResponse(transferId);
    }


    public TransferResponse postConfirmOperation(ConfirmOperationModel confirmOperation) {
        final String operationId = confirmOperation.getOperationId();

        try (FileWriter writerClientLog = new FileWriter(clientLogFile, true)) {
        final TransferModel transferModel = repository.removeTransfer(operationId);
        if (transferModel == null) {
              throw  new ErrorConfirmation("Данные отсутствуют");
        }
        final String codeUuid = repository.removeCode(operationId);
        writerClientLog.write(smsLogger.logConfirmOperation(
                confirmOperation,
                codeUuid));

        } catch (IOException e) {
            e.getMessage();
        }
        return new TransferResponse(operationId);
    }


    private void cardsCheck(String cardFrom, String cardTo) {
        if (cardFrom == null) {
            throw new ErrorInputData("Номер карты отправителя обязателен");
        } else if (cardTo == null) {
            throw new ErrorInputData("Номер карты получателя обязателен");
        } else if (!cardFrom.matches("\\d{16}") || !cardTo.matches("\\d{16}")) {
            throw new ErrorInputData("Номер карты отправителя и получателя должен быть из 16 цифр");
        }
    }

    private void cvvCheck(String cvv) {
        if (cvv == null) {
            throw new ErrorInputData("CVC - код отправителя обязателен");
        } else if (!cvv.matches("\\d{3}")) {
            throw new ErrorInputData("CVC - код отправителя должен быть из 3 цифр");
        }
    }

    private void dateCheck(String period) {

        StringBuilder sb = new StringBuilder(period);
        int month = Integer.parseInt(sb.substring(0, 2));
        if (month > 12) {
            throw new ErrorInputData("Текущий месяц не может быть больше 12");
        }
        int year = Integer.parseInt("20" + sb.substring(3, 5));
        if (LocalDate.now().getYear() <= year) {
            if (LocalDate.now().getMonthValue() > month) {
                throw new ErrorInputData("Истекла дата действия карты отправителя");
            }
        } else {
            throw new ErrorInputData("Истекла дата действия карты отправителя");
        }
    }

    private void amountCheck(Integer amount) {
        if (amount <= 0) {
            throw new ErrorInputData("Необходимо указать сумму перевода");
        }
    }

}
