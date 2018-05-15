package by.tc.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class Order implements Serializable {
    private static final long serialVersionUID = 5278126696384080927L;
    private int id;
    private Point start;
    private Point end;
    private String from;
    private String destination;
    private double price;
    private OrderStatus status;
    private int id_customer;
    private int id_driver;

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        return getId() == order.getId() &&
                Double.compare(order.getPrice(), getPrice()) == 0 &&
                getId_customer() == order.getId_customer() &&
                getId_driver() == order.getId_driver() &&
                Objects.equals(getStart(), order.getStart()) &&
                Objects.equals(getEnd(), order.getEnd()) &&
                Objects.equals(getFrom(), order.getFrom()) &&
                Objects.equals(getDestination(), order.getDestination()) &&
                getStatus() == order.getStatus();
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getStart(), getEnd(), getFrom(), getDestination(), getPrice(), getStatus(), getId_customer(), getId_driver());
    }
}
