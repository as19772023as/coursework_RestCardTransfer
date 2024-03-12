package ru.strebkov.coursework_RestCardTransfer;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferAmount;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferResponse;

import java.util.Objects;

@Testcontainers
@DisplayName("Проверка работоспособности REST-SERVICE")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CourseworkRestCardTransferApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final String ENDPOINT_TRANSFER = "/transfer";
    private static final String ENDPOINT_CONFIRM = "/confirmOperation";
    private static final String HOST = "http://localhost:";
    private static final int PORT = 5500;
    public static final String OPERATION_ID = "1";
    private static final String CODE = "1234";
    private static Integer portRandom;
    public static final TransferModel TRANSFER_REQUEST = new TransferModel(
            "1111111111111111",
            "12/25",
            "123",
            "2222222222222222",
            new TransferAmount(5000, "RUR"));
    public static final ConfirmOperationModel CONFIRM_OPERATION_REQUEST =
            new ConfirmOperationModel(OPERATION_ID, CODE);
    @Container
    private final static GenericContainer<?> container = new GenericContainer<>("myapp_cours:1.0").
            withExposedPorts(PORT);

    @BeforeAll
    public static void setUp() {
        portRandom = container.getMappedPort(PORT);
    }

    @DisplayName("Тест на возвращаемый ответ  REST-SERVICE  метод postTransfer() №1")
    @Test
    void contextLoadsTestOne() throws Exception {
        ResponseEntity<Object> forTransfer = restTemplate.postForEntity(HOST + portRandom +
                ENDPOINT_TRANSFER, TRANSFER_REQUEST, Object.class);

        String expected = new JSONObject(Objects.requireNonNull(forTransfer.getBody()).toString())
                .get("operationId").toString();

        Assertions.assertEquals(expected, OPERATION_ID);
    }

    @DisplayName("Тест на возвращаемый ответ  REST-SERVICE  метод postTransfer() №2")
    @Test
    void contextLoadsTestTwo() {
        TransferResponse transferResponse = new TransferResponse("1");
        String expected = "{\"operationId\":\"1\"}";

        ResponseEntity<String> actual = restTemplate.postForEntity(HOST +
                portRandom + ENDPOINT_TRANSFER, transferResponse, String.class);

        Assertions.assertEquals(expected, actual.getBody());
    }

    @DisplayName("Тест на возвращаемый ответ  REST-SERVICE  метод postConfirmOperation()")
    @Test
    void contextLoadsConfirmOperation() throws JSONException {
        ResponseEntity<Object> forConfirmOperation = restTemplate.postForEntity(HOST + portRandom +
                ENDPOINT_CONFIRM, CONFIRM_OPERATION_REQUEST, Object.class);

        String expected = new JSONObject(Objects.requireNonNull(forConfirmOperation.getBody()).toString())
                .get("operationId").toString();

        Assertions.assertEquals(expected, OPERATION_ID);
    }

}
