import java.util.ArrayList;

public class RushHour extends Game {

    private static final int GRID_SIZE = 6;
    private static final int EXIT_COLUMN = GRID_SIZE - 1;
    private int exitRow;

    private Board board;
    private ArrayList<Vehicle> vehicles;
    private Participant participant;


    public RushHour(Board board, int exitRow) {

        this.board = board;
        this.exitRow = exitRow;
        this.vehicles = new ArrayList<Vehicle>();
        initialPosition();
    }

    private void placeVehicle(int row, int col, char vehicle, int length, int direction)
    {
        		if (direction == 0) { // horizontal placement
            		for (int i = col; i < col+length; i++)
                        board.putInBoard(row,i,vehicle);
            	}
        		else { // vertical placement
            			for (int i = row; i < row+length; i++)
                            board.putInBoard(i,col,vehicle);

            		}
        	}
    public void initialPosition()
    {
        placeVehicle(0,2,'O',3,1);
        placeVehicle(2,3,'X',2,0);
        placeVehicle(2,5,'P',3,1);
        placeVehicle(3,1,'A',2,0);
        placeVehicle(3,3,'Q',3,1);
        placeVehicle(4,1,'J',2,1);
        placeVehicle(5,4,'C',2,0);
        }
    private boolean isValidMove(Vehicle vehicle, int row, int col)
    {
        // Check if the new position is within the bounds of the board
        if (row < 0 || row >=  GRID_SIZE || col < 0 || col >=  GRID_SIZE) {
            return false;
        }
        // Check if the new position is occupied by another vehicle
        for (Vehicle v : vehicles) {
            if (v.getRow() == row && v.getCol() == col) {
                return false;
            }
        }
        return true;
    }
    @Override
    public boolean check_isSolved() {
        return (participant.Get_Red_Car().getRow()==exitRow && participant.Get_Red_Car().getCol()==EXIT_COLUMN) ;
    }

    public void showBoard(){
        board.print();
        }

    public void play(Vehicle vehicle, int row, int col) {
        vehicle.setRow(row);
        vehicle.setCol(col);
        participant.move_any_car();
    }
    private boolean solve(int vehicleIndex) {

        if (check_isSolved()) {
            System.out.println("Solution found the player name"+ participant.getName() +" num of steps"+ participant.getNum_of_steps());
            return true;
        }

        Vehicle vehicle = vehicles.get(vehicleIndex);

        for (int i = 0; i < GRID_SIZE - vehicle.getLength() + 1 && i <= vehicle.getMaxMoves() ; i++) {
            int row = vehicle.getRow() + i;

            if (isValidMove(vehicle, row, vehicle.getCol())) {
               play(vehicle, row, vehicle.getCol());

                if (solve(vehicleIndex + 1)) {
                    return true;
                }

                play(vehicle, vehicle.getRow(), vehicle.getCol());
            }
        }

        return false;
    }

}
