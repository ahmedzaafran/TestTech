package org.example.Enum;

public enum TaxType {
    BASIC(10), IMPORT(5), EXEMPT(0);

    private final int rate;

    TaxType(int rate) {
        this.rate = rate;
    }

    public int getRate() {
        return rate;
    }
}
