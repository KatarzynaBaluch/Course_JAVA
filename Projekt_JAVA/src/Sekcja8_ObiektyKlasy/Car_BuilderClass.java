package Sekcja8_ObiektyKlasy;

public class Car_BuilderClass {
    private String brand;
    private int yearOfManufacture;

    private Car_BuilderClass(){
    }

    public static class  Builder{
        private String brand;
        private int yearOfManufacture;

        public Builder()
        {

        }

        public Builder withBrand(String brand)
        {
            this.brand=brand;
            return this;
        }
        public  Builder withYearOfManufacture(int yearOfManufacture)
        {
            this.yearOfManufacture=yearOfManufacture;
            return  this;
        }

        public Car_BuilderClass build()
        {
            Car_BuilderClass car=new Car_BuilderClass();
            car.brand=brand.toLowerCase();
            car.yearOfManufacture=yearOfManufacture;
            return car;
        }
    }

}
