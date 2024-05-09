package sbu.cs;

import java.util.ArrayList;
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
    public static List <List <Integer>> ParallelizeMatMul (List <List <Integer>> matrix_A, List <List <Integer>> matrix_B)
    {
        int p = matrix_A.size ();
        int r = matrix_B.getFirst ().size ();

        if (p % 2 != 0 || r % 2 != 0)
        {
            throw new IllegalArgumentException ("Dimensions of matrices A and B must be even.");
        }

        //set the matrix default value to zero
        List <List <Integer>> tempMatrixProduct = new ArrayList <> (p);
        for (int i = 0; i < p; i++)
        {
            List <Integer> row = new ArrayList <> (r);
            for (int j = 0; j < r; j++)
            {
                row.add (0);
            }
            tempMatrixProduct.add (row);
        }

        int quarterSize = p / 2;

        //create and start threads for each quarter
        Thread[] threads = new Thread[4];
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                int startRow = i * quarterSize;
                int endRow   = startRow + quarterSize;
                int startCol = j * quarterSize;
                int endCol   = startCol + quarterSize;

                BlockMultiplier blockMultiplier = new BlockMultiplier (matrix_A, matrix_B, tempMatrixProduct, startRow, endRow, startCol, endCol);

                threads[i * 2 + j] = new Thread (blockMultiplier);
                threads[i * 2 + j].start ();
            }
        }

        //wait for all threads to finish their task
        for (Thread thread : threads)
        {
            try
            {
                thread.join ();
            }
            catch (InterruptedException e)
            {
                System.out.println (e.getMessage ());
            }
        }

        return tempMatrixProduct;
    }

    public static void main(String[] args) {
        // Test your code here
    }
}
