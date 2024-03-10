package ru.strebkov.coursework_RestCardTransfer.model;

import java.util.Objects;

public class ConfirmOperationModel {
    private  String operationId;
    private  String code;

    public ConfirmOperationModel(){}

    public ConfirmOperationModel(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ConfirmOperationModel{" +
                "operationId='" + operationId + '\'' +
                ", code='" + code + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfirmOperationModel that = (ConfirmOperationModel) o;
        return Objects.equals(operationId, that.operationId) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationId, code);
    }
}
