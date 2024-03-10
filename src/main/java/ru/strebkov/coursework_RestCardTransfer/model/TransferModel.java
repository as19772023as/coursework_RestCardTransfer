package ru.strebkov.coursework_RestCardTransfer.model;

import java.util.Objects;

public class TransferModel {
    private final String cardFromNumber;
    private final String cardFromValidTill;
    private final String cardFromCVV;
    private final String cardToNumber;
    TransferAmount amount;




    public TransferModel(String cardFromNumber, String cardFromValidTill, String cardFromCVV,
                         String cardToNumber,
                         TransferAmount amount
                         ) {
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardFromCVV = cardFromCVV;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public String getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public String getCardFromCVV() {
        return cardFromCVV;
    }

    public String getCardToNumber() {
        return cardToNumber;
    }

    public TransferAmount getAmount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransferModel that = (TransferModel) o;
        return Objects.equals(cardFromNumber, that.cardFromNumber)
                && Objects.equals(cardFromValidTill, that.cardFromValidTill)
                && Objects.equals(cardFromCVV, that.cardFromCVV)
                && Objects.equals(cardToNumber, that.cardToNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardFromNumber, cardFromValidTill, cardFromCVV, cardToNumber);
    }

    @Override
    public String toString() {
        return "TransferModel{" +
                "cardFromNumber='" + cardFromNumber + '\'' +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardFromCVV='" + cardFromCVV + '\'' +
                ", cardToNumber='" + cardToNumber + '\'' +
                amount.toString() +
                '}';
    }
}
