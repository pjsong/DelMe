import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class CarDriverLess implements CarApi{
    private CarEnv.PositionOfCar carPos;
    private Orientation orientation;
    private CarEnv.DimensionOfPark dimensionOfPark;


    public void move(Integer steps, Orientation moveOrientation) throws OutOfParkBoundException {
        orientation = moveOrientation;
        if(orientation.isXPosPlus())carPos.xPos+=steps;
        else if(orientation.isXPosMinus())carPos.xPos-=steps;
        else if(orientation.isYPosPlus())carPos.yPos+=steps;
        else if(orientation.isYPosMinus())carPos.yPos-=steps;
        if(carPos.boundaryBroken(dimensionOfPark))throw new CarApi.OutOfParkBoundException();
    }

    public CarEnv.PositionOfCar getPositonOfCar() {
        System.out.println(carPos);
        return carPos;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
