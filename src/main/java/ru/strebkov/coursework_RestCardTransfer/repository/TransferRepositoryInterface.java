package ru.strebkov.coursework_RestCardTransfer.repository;

import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;

public interface TransferRepositoryInterface {
    int getOperationId();
    void addTransfer(String id, TransferModel transferRequest);
    void addCode(String id, String code);
    TransferModel removeTransfer(String id);

    String removeCode(String id);
}
