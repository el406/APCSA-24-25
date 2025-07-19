import java.util.ArrayList;
import java.util.*;

public class Logistic {
    
    private double bias, trainingRate;
    private double[] weights;
    
    private double[][] dataset;
    private double[] solutionSet;
    
    public Logistic(double[][] dataset, double[] solutionSet, double trainingRate)
    {
        
        this.weights = new double[dataset[0].length];
        for(int i = 0; i < weights.length; ++i)
        {
            weights[i] = 1;
        }
        this.bias = 1;
        this.trainingRate = trainingRate;
        if(dataset.length != solutionSet.length)
        {
            throw new IllegalArgumentException("solution set must be mapped for all rows");
        }
        this.dataset = dataset;
        this.solutionSet = solutionSet;
    }
    
    public void newDataset(double[][] dataset, double[] solutionSet)
    {
        this.dataset = dataset;
        this.solutionSet = solutionSet;
    }
    
    
    public void train(int iterations)
    {
        for(int it = 0; it < iterations; ++it)
        {
            
            double[] predictions = VectorMethods.addScalarToVector(
               VectorMethods.multiplyVectorByMatrix(dataset, weights), bias);
            
            for(int i = 0; i < predictions.length; ++i)
            {
                predictions[i] = sigmoid(predictions[i]);   
            }
           //binaryLoss(predictions);
           // partial derivatives for gradient descent
           double[] lossVector = VectorMethods.addVectors(predictions , 
               VectorMethods.scalarMultiplication(solutionSet, -1));
           double length = predictions.length;
           double dbias = VectorMethods.sumOfVectorComponents(lossVector) * (1.0/length);
           
           double[] dweight = VectorMethods.scalarMultiplication(
               VectorMethods.multiplyVectorByMatrix(
               VectorMethods.transposeMatrix(dataset), 
               lossVector), (1.0/length));
               
           bias = bias - trainingRate * dbias;
           for(int i = 0; i < weights.length; ++i)
           {
               weights[i] = weights[i] - trainingRate * dweight[i];
           }
            
        }
    }
    
    public double[] predict(double[][] data)
    {
        double[] predictions = VectorMethods.addScalarToVector(
               VectorMethods.multiplyVectorByMatrix(data, weights), bias);
            for(int i = 0; i < predictions.length; ++i)
            {
                predictions[i] = sigmoid(predictions[i]);   
            }
        return predictions;
    }
    
    
    
    public void binaryLoss(double[] predictions)
    {
        double binaryLoss = 0;

        for(int i = 0; i < dataset.length; ++i)
        {
            binaryLoss += solutionSet[i] * Math.log(predictions[i] + 0.001) + (1 - solutionSet[i]) * Math.log(1 - predictions[i] + 0.0001);
        }
        System.out.println(binaryLoss);
    }
    
    

    
    public double sigmoid(double t)
    {
        return 1/(1 + Math.exp(-t));
    }
    
}
