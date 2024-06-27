package bg.softuni.mobilele.models.dtos;

import java.math.BigDecimal;

public class ConversionResultDTO {
    private String from;
    private String to;
    private BigDecimal amount;
    private BigDecimal result;

    public ConversionResultDTO(String from, String to, BigDecimal amount, BigDecimal result) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.result = result;
    }

    public String getFrom() {
        return from;
    }

    public ConversionResultDTO setFrom(String from) {
        this.from = from;
        return this;
    }

    public String getTo() {
        return to;
    }

    public ConversionResultDTO setTo(String to) {
        this.to = to;
        return this;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public ConversionResultDTO setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    public BigDecimal getResult() {
        return result;
    }

    public ConversionResultDTO setResult(BigDecimal result) {
        this.result = result;
        return this;
    }
}
