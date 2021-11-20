/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package interfaces;

/**
 *
 * @author User
 */

import java.util.UUID;
import model.Check;
public class CheckReader {

    public boolean scanCheck(Check check)
    {
        int result = verifyCheck(check.getCheckNumber());
        
        if(result == 0)
        {
            return true;
        }
        return false;
        
    }
    //return -1 if its less, 0 if it is equal, 1 if it is greater
    public int verifyCheck(UUID checkNumber)
    {
        UUID uuid = new UUID(0,0);
        return uuid.compareTo(checkNumber);
    }

}
