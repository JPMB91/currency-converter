package com.alura.conversor;

public class Currency {
    private String base_code;
    private String target_code;
    private double conversion_result;
    private int amount;


    public Currency(String base_code, String target_code, int amount) {
        this.base_code = base_code;
        this.target_code = target_code;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return """
                El valor %d [%s] corresponde al valor final de => %.2f %s
               """
                .formatted(
                        this.amount,
                        this.base_code,
                        this.conversion_result,
                        this.target_code
                );
    }
}
