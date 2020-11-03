
public interface CarApi {
    class OutOfParkBoundException extends Exception {

    }

    enum Orientation{
        NORTH, SOUTH, EAST, WEST;
        public boolean isYPosPlus(){
            return this.equals(NORTH);
        }
        public boolean isYPosMinus(){
            return this.equals(SOUTH);
        }
        public boolean isXPosPlus(){
            return this.equals(EAST);
        }
        public boolean isXPosMinus(){
            return this.equals(WEST);
        }
    }


    void move(Integer steps, Orientation orientation) throws OutOfParkBoundException;

    CarEnv.PositionOfCar getPositonOfCar();
}
