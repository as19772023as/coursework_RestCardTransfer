package ru.strebkov.coursework_RestCardTransfer.exception;

public class ErrorInputData extends  RuntimeException{
    public ErrorInputData(String msg) {
        super(msg);
    }
}
