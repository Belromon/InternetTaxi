package by.tc.web.entity;

import java.util.Objects;

public class Driver extends User {
    private static final long serialVersionUID = 5939357586372428494L;
    private String carNumber;
    private String carModel;
    private boolean isFree;
    private Point location;
    private boolean isConfirmed;


    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Driver)) return false;
        if (!super.equals(o)) return false;
        Driver driver = (Driver) o;
        return isFree() == driver.isFree() &&
                isConfirmed() == driver.isConfirmed() &&
                Objects.equals(getCarNumber(), driver.getCarNumber()) &&
                Objects.equals(getCarModel(), driver.getCarModel()) &&
                Objects.equals(location, driver.location);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), getCarNumber(), getCarModel(), isFree(), location, isConfirmed());
    }
}
