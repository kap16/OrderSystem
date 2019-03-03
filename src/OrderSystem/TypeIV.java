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
public class TypeIV extends Pipe {

    /* 
     * Creates a new instance of Type 4 Pipe 
     */
    public TypeIV() {
    }

    /**
     * Constructs a new Type 4 Pipe
     * @param length the desired length of the customer's piping.
     * @param diameter the desired outer diameter of the customer's piping.
     * @param grade the grade of plastic to be used
     * @param insulation determine if the pipe has insulation
     * @param reinforcement determine if the pipe is reinforced
     * @param chemicalResistance determine if the pipe have chemical resistant
     * @param colours the colours for the piping 
     */
    public TypeIV(double length, double diameter, int grade,
            boolean insulation, boolean reinforcement,
            boolean chemicalResistance) {
        super(length, diameter, grade, insulation,
                reinforcement, chemicalResistance);
    }

    @Override
    public double getCost() {
        double cost = getVolume(orderedLength, orderedRadius) * 
                costPerInches[orderedGrade];
        double chemResist = 0, insulated = 0;
        if (this.hasChemResist()) {
            chemResist = additionalCosts[4];
        }
        if (this.hasInsulation()) {
            insulated = additionalCosts[2];
        }
        double finalCost = cost + (cost * chemResist ) + 
                (cost * additionalCosts[1]) + (cost * insulated);
        return roundOff(finalCost);
    }
}
