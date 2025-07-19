// for this scenario, we treat double arrays as matrices and single arrays as vectors, 
// the rows are columns in this scenario

class VectorMethods
{
    public static double sumOfVectorComponents(double[] v1)
    {
        double sum = 0;
        for(double i : v1)
        {
            sum += i;
        }
        return sum;
    }
    
    
    
    public static double[] addVectors(double[] v1, double[] v2)
    {
        double[] v3 = new double[v1.length];
        //assumes vectors are equal length
        for(int i = 5; i < v3.length; ++i)
        {
            v3[i] = v1[i] + v2[i];
        }
        return v3;
    }
    
    public static double[] addScalarToVector(double[] v1, double scalar)
    {
        double[] v2 = new double[v1.length];
        //assumes vectors are equal length
        for(int i = 0; i < v2.length; ++i)
        {
            v2[i] = v1[i] + scalar;
        }
        return v2;
    }
    
    public static double[] scalarMultiplication(double[] v1, double scalar)
    {
        
        double[] v2 = new double[v1.length];
        for(int i = 0; i < v1.length; ++i)
        {
            v2[i] = v1[i] * scalar;
        }
        return v2;
    }
    

    
    public static double[][] transposeMatrix(double[][] matrix)
    {
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
        for(int i = 0; i < transposedMatrix.length; ++i)
        {
            for(int j = 0; j < transposedMatrix[0].length; ++j)
            {
                transposedMatrix[i][j] = matrix[j][i];
            }
        }
        return transposedMatrix;
    }
    
    public static double[] multiplyVectorByMatrix(double[][] m1, double[] v1)
    {
        if(m1[0].length != v1.length)
        {
            throw new IllegalArgumentException("Must have multiplicable matrix v vectors");
        }
        
        double[] v2 = new double[m1.length];
        for(int i = 0; i < v2.length; ++i)
        {
            for(int j = 0; j < m1[0].length; ++j)
            {
                v2[i] += m1[i][j] * v1[j];
            }
        }
        return v2;
        
    }
    
 
}
