package ru.strebkov.coursework_RestCardTransfer.exception;

public class ErrorTransfer extends  RuntimeException{
    public ErrorTransfer(String msg) {
        super(msg);
    }
}
