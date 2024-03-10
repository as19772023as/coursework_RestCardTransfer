package ru.strebkov.coursework_RestCardTransfer.repository;

import org.springframework.stereotype.Repository;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class TransferRepository implements TransferRepositoryInterface {
    private final Map<String, TransferModel> transfers = new ConcurrentHashMap<>();
    private final Map<String, String> codes = new ConcurrentHashMap<>();
    private final AtomicInteger operationId = new AtomicInteger();

    @Override
    public int getOperationId() {
        return operationId.incrementAndGet();
    }

    @Override
    public void addTransfer(String id, TransferModel transferRequest) {
        transfers.put(id, transferRequest);
    }

    @Override
    public void addCode(String id, String code) {
        codes.put(id, code);
    }

    @Override
    public TransferModel removeTransfer(String id) {
        return transfers.remove(id);
    }

    @Override
    public String removeCode(String id) {
        return codes.remove(id);
    }

}
