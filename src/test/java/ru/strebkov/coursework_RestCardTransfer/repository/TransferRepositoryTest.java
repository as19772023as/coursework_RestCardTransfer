package ru.strebkov.coursework_RestCardTransfer.repository;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferAmount;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тест компонента Repository")
@SpringBootTest
class TransferRepositoryTest {
    @Autowired
    private TransferRepositoryInterface repository;
    private static long suiteStartTime;
    private long testStartTime;
    public static final String OPERATION_ID = "1";
    private static final String CODE = "3344";
    public static final TransferModel TRANSFER_REQUEST = new TransferModel(
            "1111111111111111",
            "12/25",
            "123",
            "2222222222222222",
            new TransferAmount(3000, "RUR"));
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

    @Test
    void getOperationId() {
        int expected = 1;
        assertEquals(repository.getOperationId(), expected);
    }

    @Test
    void addAndRemoveTransfer() {
        repository.addTransfer(OPERATION_ID, TRANSFER_REQUEST);
        TransferModel afterAdd = repository.removeTransfer(OPERATION_ID);
        assertEquals(afterAdd, TRANSFER_REQUEST);
    }

    @Test
    void addAndRemoveTransferNull() {
        TransferModel beforeAdd = repository.removeTransfer(OPERATION_ID);
        assertNull(beforeAdd);
    }

    @Test
    void addAndRemoveCode() {
        repository.addCode(OPERATION_ID, CODE);
        String afterAdd = repository.removeCode(OPERATION_ID);
        assertEquals(afterAdd, CODE);
    }

    @Test
    void addAndRemoveCodeNull() {
        String beforeAdd = repository.removeCode(OPERATION_ID);
        assertNull(beforeAdd);
    }

}