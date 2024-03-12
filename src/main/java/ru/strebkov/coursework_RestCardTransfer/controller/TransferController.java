package ru.strebkov.coursework_RestCardTransfer.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferResponse;
import ru.strebkov.coursework_RestCardTransfer.service.TransferService;

@CrossOrigin("https://serp-ya.github.io/")
@AllArgsConstructor
@RestController
public class TransferController {
    private final TransferService service;

    @PostMapping("/transfer")
    public TransferResponse postTransfer(@RequestBody TransferModel transferModel) {
        return  service.postTransfer(transferModel);
    }

    @PostMapping("/confirmOperation")
    public TransferResponse postConfirmOperation(@RequestBody ConfirmOperationModel confirmOperation) {
        return  service.postConfirmOperation(confirmOperation);
    }
}

