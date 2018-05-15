package by.tc.web.entity;

import java.util.Objects;

public class Customer extends User {
    private static final long serialVersionUID = -8326118485430677310L;
    private int discount;

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return getDiscount() == customer.getDiscount();
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getDiscount());
    }
}
