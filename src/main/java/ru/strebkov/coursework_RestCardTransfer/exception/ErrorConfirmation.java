package ru.strebkov.coursework_RestCardTransfer.exception;

public class ErrorConfirmation extends  RuntimeException{
    public ErrorConfirmation(String msg) {
        super(msg);
    }
}
