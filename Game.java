public abstract class Game {

    public abstract void play(Vehicle vehicle, int row, int col);

    public abstract void initialPosition();

    public abstract boolean check_isSolved();

    public abstract void showBoard();
}
