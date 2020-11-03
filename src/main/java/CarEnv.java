import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CarEnv{
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class PositionOfCar{
        int xPos; int yPos;
        public boolean boundaryBroken(DimensionOfPark dimensionOfPark){
            return dimensionOfPark.outOfBoundary(this);
        }
    }
    @Data @AllArgsConstructor @NoArgsConstructor
    public static class DimensionOfPark{
        int xLen; int yLen;
        int startX;int startY;
        public boolean outOfBoundary(PositionOfCar positionOfCar){
            return positionOfCar.xPos>=xLen+startX
                    || positionOfCar.yPos>=yLen+startY
                    || positionOfCar.xPos<0
                    || positionOfCar.yPos<0;
        }
    }
}
