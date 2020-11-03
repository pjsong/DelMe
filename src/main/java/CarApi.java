
public interface CarApi {
    class OutOfParkBoundException extends Exception {

    }

    enum Orientation{
        NORTH, SOUTH, EAST, WEST;
        public boolean isYPosPlus(){
            return equals(NORTH);
        }
        public boolean isYPosMinus(){
            return equals(SOUTH);
        }
        public boolean isXPosPlus(){
            return equals(EAST);
        }
        public boolean isXPosMinus(){
            return equals(WEST);
        }
        public Orientation turnClockWise(){
            if(equals(NORTH))return EAST;
            else if(equals(EAST))return SOUTH;
            else if(equals(SOUTH))return WEST;
            else if(equals(WEST))return NORTH;
            return this;
        }
    }


    void move(Integer steps, Orientation orientation) throws OutOfParkBoundException;
    Orientation turnClockWise(Orientation orientation);
    CarEnv.PositionOfCar getPositonOfCar();
}
