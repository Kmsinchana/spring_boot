package com.example.verisioning_of_RestAPI.dto;

public class PaymentV2DTO {
    private float amount;
    private String currency;
    private double tax;
    private String refundPolicy;
    private PaymentMethod paymentMethod;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public String getRefundPolicy() {
        return refundPolicy;
    }

    public void setRefundPolicy(String refundPolicy) {
        this.refundPolicy = refundPolicy;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentV2DTO(float amount, String currency, double tax, String refundPolicy, PaymentMethod paymentMethod) {
        this.amount = amount;
        this.currency = currency;
        this.tax = tax;
        this.refundPolicy = refundPolicy;
        this.paymentMethod = paymentMethod;
    }
}
