/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OrderSystem;

/**
 *
 * @author up720776
 */
public class Test_TypeI extends Test_Pipe{
    
    /* 
     * Creates a new instance of Type 1 Test_Pipe 
     */
    public Test_TypeI(){   
    }
    
    /**
     * Constructs a new Type 1 Test_Pipe
     * @param length the desired length of the customer's piping.
     * @param diameter the desired outer diameter of the customer's piping.
     * @param grade the grade of plastic to be used
     * @param insulation determine if the pipe has insulation
     * @param reinforcement determine if the pipe is reinforced
     * @param chemicalResistance determine if the pipe have chemical resistant
     */
    public Test_TypeI(double length, double diameter, int grade,
            boolean insulation, boolean reinforcement,
            boolean chemicalResistance) {
        super(length, diameter, grade, insulation, 
                reinforcement, chemicalResistance);
    }
    
    @Override
    public String getType(){
        return "Type 1";
    }
    
    @Override
    public double getCost(){
        double cost = getVolume(orderedLength, orderedRadius) * 
                costPerInches[orderedGrade];
        double chemResist = 0;
        if (this.hasChemResist()){
           chemResist = additionalCosts[4];
        }
        double finalCost = cost + (cost*chemResist);
        return roundOff(finalCost);
    }
    
}
