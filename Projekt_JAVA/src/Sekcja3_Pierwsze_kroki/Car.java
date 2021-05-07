package Sekcja3_Pierwsze_kroki;

public class Car {
    private final String brand;

    public Car(String brand, int yearOfManufacture) {
        this.brand = brand;
        this.yearOfManufacture = yearOfManufacture;
    }

    private final int yearOfManufacture;
    private double mileage;
    private Person owner;

    public String getBrand() {
        return brand;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", mileage=" + mileage +
                ", owner=" + owner +
                '}';
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
