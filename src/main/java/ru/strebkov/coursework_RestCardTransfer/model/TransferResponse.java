package ru.strebkov.coursework_RestCardTransfer.model;

import java.util.Objects;

//@Data
//@AllArgsConstructor
public class TransferResponse {
    private  String operationId;

    public TransferResponse(String operationId) {
        this.operationId = operationId;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferResponse that = (TransferResponse) o;
        return Objects.equals(operationId, that.operationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId);
    }

    @Override
    public String toString() {
        return "TransferResponse{" +
                "operationId='" + operationId + '\'' +
                '}';
    }
}
