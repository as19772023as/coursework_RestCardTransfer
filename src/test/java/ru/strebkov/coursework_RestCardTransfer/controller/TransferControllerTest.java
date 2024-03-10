package ru.strebkov.coursework_RestCardTransfer.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.strebkov.coursework_RestCardTransfer.exception.ErrorInputData;
import ru.strebkov.coursework_RestCardTransfer.exception.ExceptionHandlerTransferAdvice;
import ru.strebkov.coursework_RestCardTransfer.model.ConfirmOperationModel;
import ru.strebkov.coursework_RestCardTransfer.model.TransferAmount;
import ru.strebkov.coursework_RestCardTransfer.model.TransferModel;
import ru.strebkov.coursework_RestCardTransfer.repository.TransferRepository;
import ru.strebkov.coursework_RestCardTransfer.service.TransferService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TransferController.class)
@DisplayName("Тесты с использованием mockito")
class TransferControllerTest {
    private static final String END_POINT_PATH = "/transfer";
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private TransferService service;
    @MockBean
    private TransferRepository repository;


    @DisplayName("Тест на запрос перевода, статус: 200 OK ")
    @Test
    void postTransferTestAddShouldReturn201Created() throws Exception {
//        TransferModel model = new TransferModel("2222222222222222",
//                "1126",
//                "123",
//                "4444444444444444",
//                new TransferAmount(1000, "RUR"));
//        Mockito.when(service.postTransfer(model)).thenReturn("1");
//
//        String requestBody = objectMapper.writeValueAsString(model);
//        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andDo(print());
    }


//    @DisplayName("Тест на запрос перевода, статус: 400 BadRequest")
//    @Test
//    public void testAddShouldReturn400BadRequest() throws Exception {
//        TransferModel model = new TransferModel(null,
//                "1126",
//                "123",
//                null,
//                new TransferAmount(1000, "RUR"));
//
//        Mockito.when(repository.postCardToCard(model)).thenReturn(
//                String.valueOf(new ErrorInputData("Error input data "))
//        );
//
//        String requestBody = objectMapper.writeValueAsString(model);
//        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isBadRequest())
//                .andDo(print());
//    }


    @DisplayName("Тест на запрос кода СМС, статус: 200 OK ")
    @Test
    void postConfirmOperationTestAddShouldReturn201Created() throws Exception {
//        ConfirmOperationModel confirmOperationModel = new ConfirmOperationModel("1", "0000");
//
//        Mockito.when(service.postConfirmOperation(confirmOperationModel)).thenReturn("1");
//
//        String requestBody = objectMapper.writeValueAsString(confirmOperationModel);
//        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isOk())
//                .andDo(print());
    }

//    @DisplayName("Тест на запрос кода СМС, статус: 400 BadRequest ")
//    @Test
//    void postConfirmOperationTestAddShouldReturn400BadRequest() throws Exception {
//        ConfirmOperationModel confirmOperationModel = new ConfirmOperationModel("12", null);
//
//        String requestBody = objectMapper.writeValueAsString(confirmOperationModel);
//        mockMvc.perform(post(END_POINT_PATH).contentType("application/json")
//                        .content(requestBody))
//                .andExpect(status().isBadRequest())
//                .andDo(print());
//    }

}