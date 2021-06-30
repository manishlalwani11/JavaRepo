package designpatterns;


class Vehicle {

    // mandatory parameters
    String engine;
    int wheels;

    //optional parameter
    String airbags;

    /**
     * Make constructor private so that no one should create obj of Vehicle class directly
     */
    private Vehicle(VehicleBuilder builder) {
        engine = builder.engine;
        wheels = builder.wheels;
        airbags = builder.airbags;
    }

    // only Getters
    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public String getAirbags() {
        return airbags;
    }

    public static class VehicleBuilder {
        // mandatory parameters
        String engine;
        int wheels;

        //optional parameter
        String airbags;

        /**
         * Only for mandatory parameters
         */
        public VehicleBuilder(String engine, int wheels) {
            this.engine = engine;
            this.wheels = wheels;
        }

        public VehicleBuilder setAirbags(String airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }
    }
}


public class BuilderPatternExample {


    public static void main(String[] args) {
        Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags("6").build();
        Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();

        System.out.println(car.getEngine());
        System.out.println(car.getWheels());
        System.out.println(car.getAirbags());

        System.out.println(bike.getEngine());
        System.out.println(bike.getWheels());
        System.out.println(bike.getAirbags());

    }
}


