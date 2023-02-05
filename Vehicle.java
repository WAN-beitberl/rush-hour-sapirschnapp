public class Vehicle {

    private int row;
    private int col;
    private int length;
    private boolean isHorizontal;

    public Vehicle(int row, int col, int length, boolean isHorizontal) {
        this.row = row;
        this.col = col;
        this.length = length;
        this.isHorizontal = isHorizontal;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getLength() {
        return length;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public int getMaxMoves() {
        if ( this.isHorizontal) {
            return 6 - row - length + 1;
        }
        else {
            return 6 - col - length + 1;
        }
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }



 /*   public boolean move(int spaces) {
        if (this.isHorizontal) {
            int newX =  row + spaces;
            if (newX >= 0 && newX + length <= 6) {
               row = newX;
                return true;
            }
        } else {
            int newY = col + spaces;
            if (newY >= 0 && newY + length <= 6) {
                col = newY;
                return true;
            }
        }
        return false;
    }*/
}
