public class Matrix {
    private int nrows; //the number of rows of the matrix
    private int ncols; //the number of columns of the matrix
    private int[][] matrix; //2D array which acts as the actual matrix for the class


    public Matrix(int num_rows, int num_cols) {
        this.nrows = num_rows;
        this.ncols = num_cols;
        matrix = new int[this.ncols][this.nrows];
    }

    public Matrix(int[][] arr) {
        matrix = arr;

        this.ncols = matrix.length;
        this.nrows = matrix[0].length;
    }

    public Matrix transpose() {
        int[][] out = new int[this.nrows][this.ncols];

        for (int row = 0; row < this.nrows; row++){
            for (int col = 0; col < this.ncols; col++){
                out[row][col] = this.matrix[col][row];
            }
        }

       
        return new Matrix(out) ;
    }

    public String toString(){
        String out = "";
        for (int x = 0; x < matrix.length; x++){
            for (int y = 0; y < matrix.length; y++){
                out += this.matrix[x][y] + " ";
            }
            out += "\n";
        }

        return out;
    }

    public static void main(String[] args) {
        int [][] test  = {{1,2,3},{4,5,6},{7,8,9}};
        Matrix a = new Matrix(test);
        System.out.println(a);
        a = a.transpose();
        System.out.println(a);
    }
}
