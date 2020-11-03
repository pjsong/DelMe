import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarDriverLessTest {
    CarEnv.DimensionOfPark dimensionOfPark;
    CarDriverLess carDriverLess;
    @Before
    public void init(){
        dimensionOfPark = new CarEnv.DimensionOfPark(0,0,3,3);
        carDriverLess = new CarDriverLess(new CarEnv.PositionOfCar(0, 0), CarApi.Orientation.NORTH, dimensionOfPark);
    }

    @Test
    public void move() {
        try {
            carDriverLess.move(1, CarApi.Orientation.NORTH);
            Assert.assertEquals(carDriverLess.getPositonOfCar().yPos, 1);
            Assert.assertEquals(carDriverLess.getPositonOfCar().xPos, 0);
            Exception exception = assertThrows(CarApi.OutOfParkBoundException.class, () -> {
                carDriverLess.move(2, CarApi.Orientation.SOUTH);
            });
            assertTrue(exception != null);
        } catch (CarApi.OutOfParkBoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getPositonOfCar() {
        try {
            int oldXPos = carDriverLess.getPositonOfCar().xPos;
            int oldYPos = carDriverLess.getPositonOfCar().yPos;
            carDriverLess.move(2, CarApi.Orientation.NORTH);
            carDriverLess.move(1, CarApi.Orientation.SOUTH);
            Assert.assertEquals(carDriverLess.getPositonOfCar().xPos, oldXPos);
            Assert.assertEquals(carDriverLess.getPositonOfCar().yPos, oldYPos+1);
        } catch (CarApi.OutOfParkBoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getOrientation() {
        try {
            carDriverLess.move(1, CarApi.Orientation.NORTH);
            Assert.assertEquals(carDriverLess.getOrientation(), CarApi.Orientation.NORTH);
        } catch (CarApi.OutOfParkBoundException e) {
            e.printStackTrace();
        }
    }
}
