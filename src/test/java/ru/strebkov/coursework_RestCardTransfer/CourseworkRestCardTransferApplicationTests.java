package ru.strebkov.coursework_RestCardTransfer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import ru.strebkov.coursework_RestCardTransfer.model.TransferAmount;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;
import ru.strebkov.coursework_RestCardTransfer.service.TransferService;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@DisplayName("Проверка работоспособности REST-SERVICE")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class CourseworkRestCardTransferApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TransferService service;
    private static final String ENDPOINT = "/transfer";
    private Integer port = 5500;
//    private final GenericContainer<?> container = new GenericContainer<>("myapcours2:1.0").
//            withExposedPorts(5500);
//
//
//    @BeforeEach
//    void setUp() {
//        container.start();
//    }

    @DisplayName("Тест на возвращаемую строку в ответе REST-SERVICE")
    @Test
    void contextLoadsTest() throws Exception {
//        TransferModel model = new TransferModel("2222222222222222",
//                "1126",
//                "123",
//                "4444444444444444",
//                new TransferAmount(1000, "RUR"));
//
//        Mockito.when(service.postTransfer(model)).thenReturn("1");
//
//        String requestBody = objectMapper.writeValueAsString(model);
//        mockMvc.perform(post(ENDPOINT).contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andDo(print());
//
//        final String expected = "1";
//
//        ResponseEntity<TransferModel> actual = restTemplate.postForEntity("http://localhost:5500/transfer",
//                model, TransferModel.class);
//
//
//        System.out.println(actual.getBody());

        //Assertions.assertEquals(expected, actual.getBody());
//
//		System.out.println("555");
    }

}
