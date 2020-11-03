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
            Assert.assertEquals(carDriverLess.getPositonOfCar().xPos, 1);
        } catch (CarApi.OutOfParkBoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void getPositonOfCar() {
        try {
            carDriverLess.move(1, CarApi.Orientation.NORTH);
            Assert.assertEquals(carDriverLess.getPositonOfCar().xPos, 1);
            Assert.assertEquals(carDriverLess.getPositonOfCar().yPos, 0);
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
