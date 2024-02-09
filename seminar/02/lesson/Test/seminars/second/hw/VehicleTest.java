package seminars.second.hw;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleTest {

    Car car;
    Motorcycle motorcycle;

    @BeforeEach
    void setUp() {
        car = new Car("Audi", "A4", 2020);
        motorcycle = new Motorcycle("BMW", "M 1000 RR", 2019);
    }

    @Test
    void carIsVehicle() {
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    @Test
    void carHas4Wheels() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    @Test
    void motorcycleHas2Wheels() {
        assertThat(motorcycle.getNumWheels()).isEqualTo(2);
    }

    @Test
    void carReachesSpeed60InTestMode() {
        car.testDrive();

        assertThat(car.getSpeed()).isEqualTo(60);
    }

    @Test
    void motorcycleReachesSpeed75InTestMode() {
        motorcycle.testDrive();

        assertThat(motorcycle.getSpeed()).isEqualTo(75);
    }

    @Test
    void carStopsInParkMode() {
        car.testDrive();
        car.park();

        assertThat(car.getSpeed()).isEqualTo(0);
    }

    @Test
    void motorcycleStopsInParkMode() {
        motorcycle.testDrive();
        motorcycle.park();

        assertThat(motorcycle.getSpeed()).isEqualTo(0);
    }
}