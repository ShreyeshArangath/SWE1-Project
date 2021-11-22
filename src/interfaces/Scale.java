/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import java.util.Random;

/**
 *
 * @author shreyesh
 */
public class Scale {
    
    final int MAX_WEIGHT = 10;
    
    public double weighItem() {
        Random rand = new Random();
        return rand.nextDouble(MAX_WEIGHT);
    }
    
    public static void main(String[] args){
        Scale scale = new Scale();
        System.out.println(scale.weighItem());
    }
}
