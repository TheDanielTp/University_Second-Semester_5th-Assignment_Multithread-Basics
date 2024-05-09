package sbu.cs;

import java.util.List;

public class MatrixMultiplication {

    // You are allowed to change all code in the BlockMultiplier class
    public static class BlockMultiplier implements Runnable
    {
        List <List <Integer>> matrixA;
        List <List <Integer>> matrixB;
        List <List <Integer>> tempMatrix;

        int startRow;
        int endRow;
        int startCol;
        int endCol;

        public BlockMultiplier (List <List <Integer>> matrixA, List <List <Integer>> matrixB,
                                List <List <Integer>> tempMatrix,
                                int startRow, int endRow, int startCol, int endCol)
        {
            this.matrixA = matrixA;
            this.matrixB = matrixB;

            this.tempMatrix = tempMatrix;

            this.startRow = startRow;
            this.endRow   = endRow;
            this.startCol = startCol;
            this.endCol   = endCol;
        }

        @Override
        public void run ()
        {
            for (int i = startRow; i < endRow; i++)
            {
                for (int j = startCol; j < endCol; j++)
                {
                    int sum = 0;
                    for (int k = 0; k < matrixB.size (); k++)
                    {
                        sum += matrixA.get (i).get (k) * matrixB.get (k).get (j);
                    }
                    tempMatrix.get (i).set (j, sum);
                }
            }
        }
    }

    /*
    Matrix A is of the form p x q
    Matrix B is of the form q x r
    both p and r are even numbers
    */
    public static List<List<Integer>> ParallelizeMatMul(List<List<Integer>> matrix_A, List<List<Integer>> matrix_B)
    {
        /*
        TODO
            Parallelize the matrix multiplication by dividing tasks between 4 threads.
            Each thread should calculate one block of the final matrix product. Each block should be a quarter of the final matrix.
            Combine the 4 resulting blocks to create the final matrix product and return it.
         */
        return null;
    }

    public static void main(String[] args) {
        // Test your code here
    }
}
