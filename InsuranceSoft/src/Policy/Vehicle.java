package Policy;

import java.io.Serializable;

public class Vehicle implements Serializable {
    int plateNb;
    int modelYear;
    String manufacture;
    int estimatedValue;
    int carDamage;

    public Vehicle(int plateNb, int modelYear, String manufacture, int estimatedValue, int carDamage) {
        this.plateNb = plateNb;
        this.modelYear = modelYear;
        this.manufacture = manufacture;
        this.estimatedValue = estimatedValue;
        this.carDamage = carDamage;
    }

    public void setPlateNb(int plateNb) {
        this.plateNb = plateNb;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public void setEstimatedValue(int estimatedValue) {
        this.estimatedValue = estimatedValue;
    }

    public void setCarDamage(int carDamage) {
        this.carDamage = carDamage;
    }

    public int getPlateNb() {
        return plateNb;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getManufacture() {
        return manufacture;
    }

    public int getEstimatedValue() {
        return estimatedValue;
    }

    public int getCarDamage() {
        return carDamage;
    }

    @Override
    public String toString() {
        return
                "plateNb: " + plateNb +
                "\nmodelYear: " + modelYear +
                "\nmanufacture: " + manufacture + '\'' +
                "\nestimatedValue: " + estimatedValue +
                "\ncarDamage: " + carDamage;
    }
}
