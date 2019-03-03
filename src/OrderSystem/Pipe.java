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

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Pipe{

    // Pipe features
    protected String Label;
    protected int orderedGrade;
    protected double orderedLength, orderedRadius;
    protected boolean Insulation, Reinforcement, ChemicalResistance;
    
    // cost per inch for every grade of plastic
    protected double[] costPerInches = {0, 0.3, 0.32, 0.35,0.40,0.46};
    // ifOneColour, ifTwoColours, IfInsulated, ifReinforced, ifChemResit
    protected double[] additionalCosts = {0.12, 0.17, 0.14, 0.15, 0.12};

    /* 
     *Creates a new instance of Pipe 
     */
    public Pipe() {
    }

    /**
     * Constructs a new Pipe
     * @param length the desired length of the customer's piping.
     * @param diameter the desired outer diameter of the customer's piping.
     * @param grade the grade of plastic to be used
     * @param insulation determine if the pipe has insulation
     * @param reinforcement determine if the pipe is reinforced
     * @param chemicalResistance determine if the pipe have chemical resistant
     */
    public Pipe(double length, double diameter, int grade,
            boolean insulation, boolean reinforcement,
            boolean chemicalResistance) {
        orderedLength = length;
        orderedRadius = diameter / 2;
        orderedGrade = grade;
        Insulation = insulation;
        Reinforcement = reinforcement;
        ChemicalResistance = chemicalResistance;
    }
    
    /**
     * @return the cost for a pipe
     */
    protected abstract double getCost();
    
    /**
     * @param value the number as a double
     * @return a rounded number to 2 decimal places
     */
    protected double roundOff(double value){ 
        //double num = Math.round(value * 100.0) / 100.0;
        
        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    /**
     * @param i the length in meters
     * @return converts the length to metres
     */
    protected double convertToInches(double i){
        return i * 39.37;
    }
    
    /**
     * @param length the length of the pipe
     * @param radius the radius of the pipe
     * @return the cost of the chosen inch
     */
    protected double getVolume(double length, double radius){
        double volume = Math.PI * convertToInches(length) * 
                (radius * radius) * 0.19;
        return volume;
    }
    
    /**
     * @param name label for the pipe
     */
    public void setLabel(String name) {
        Label = name;
    }

    /**
     * @return label for the pipe
     */
    public String getLabel() {
        return Label;
    }

    
    /**
     * @return grade for the pipe
     */
    public int getGrade() {
        return orderedGrade;
    }
    
    /**
     * @return label for the pipe
     */
    public double getLength() {
        return orderedLength;
    }

    /**
     * @return the radius the pipe
     */
    public double getRadius() {
        return orderedRadius;
    }

    /**
     * @return true if a pipe has inner insulation
     */
    public boolean hasInsulation() {
        return Insulation;
    }

    /**
     * @return true if a pipe is reinforced
     */
    public boolean isReinforced() {
        return Reinforcement;
    }

    /**
     * @return true if a pipe has chemical resistance
     */
    public boolean hasChemResist() {
        return ChemicalResistance;
    }

}
