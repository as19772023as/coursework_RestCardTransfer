package ru.strebkov.coursework_RestCardTransfer.model;

public class TransferAmount {
    private final Integer value;

    private final String currency;

    public TransferAmount(Integer value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public Integer getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "TransferAmount{" +
                "value=" + value +
                ", currency='" + currency + '\'' +
                '}';
    }
}
