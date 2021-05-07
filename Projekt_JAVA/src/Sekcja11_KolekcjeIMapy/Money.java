package Sekcja11_KolekcjeIMapy;

import java.util.Objects;

public class Money {
    protected final Double amount;
    protected final String currency;

    public Money(Double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }


    //wygenerowane automatycznie alt+insert
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return amount.equals(money.amount) &&
                currency.equals(money.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }
}
