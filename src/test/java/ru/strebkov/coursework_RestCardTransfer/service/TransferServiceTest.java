package ru.strebkov.coursework_RestCardTransfer.service;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferAmount;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferResponse;
import ru.strebkov.coursework_RestCardTransfer.repository.TransferRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Тест компонента Service")
@SpringBootTest
class TransferServiceTest {
    @Autowired
    private TransferService service;
    @Autowired
    private TransferRepository repository;
    private static long suiteStartTime;
    private long testStartTime;
    public static final String OPERATION_ID = "1";
    private static final String CODE = "6765";
    public static final TransferModel TRANSFER_REQUEST = new TransferModel(
            "1111111111111111",
            "12/25",
            "123",
            "2222222222222222",
            new TransferAmount(5000_00, "RUR"));
    public static final ConfirmOperationModel CONFIRM_OPERATION_REQUEST =
            new ConfirmOperationModel(OPERATION_ID, CODE);

    @BeforeAll
    public static void initSuite() {
        System.out.println("Running Test");
        suiteStartTime = System.nanoTime();
    }

    @AfterAll
    public static void completeSuite() {
        System.out.println("Test complete: " + (System.nanoTime() - suiteStartTime) / 1000000 + " ms");
    }

    @BeforeEach
    public void initTest() {
        System.out.println("Starting new Test");
        testStartTime = System.nanoTime();
    }

    @AfterEach
    public void finalizeTest() {
        System.out.println("Test complete:" + (System.nanoTime() - testStartTime) / 1000000 + " ms");
    }

    @DisplayName("Тест на перевод денежных средств и получения id")
    @Test
    void transfer() {
        TransferResponse expected = new TransferResponse(OPERATION_ID);
        TransferResponse actual = service.postTransfer(TRANSFER_REQUEST);

        assertEquals(expected, actual);
    }

    @DisplayName("Тест на получения кода подтверждения и id")
    @Test
    void confirmOperation() {
        repository.addTransfer("1", TRANSFER_REQUEST);
        TransferResponse expected = new TransferResponse(OPERATION_ID);

        TransferResponse actual = service.postConfirmOperation(CONFIRM_OPERATION_REQUEST);

        assertEquals(expected, actual);
    }

}