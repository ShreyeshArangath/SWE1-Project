/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author User
 */


/*
Flow:check is scanned by the check reader
check verified by the system
if check is acceptd, the cashier is prompted to place it in he receipt printer
a line containing date, time, store identity, cashier identity, and order number are printed on the check

*/
import java.time.LocalDateTime;
import java.util.UUID;
public class Check extends PaymentMethod{
    private UUID checkNumber;

    public Check(double amountDue, LocalDateTime time, boolean isSuccessful, double amountPaid, UUID checkNumber) {
        super(amountDue, time, isSuccessful, amountPaid);
        this.checkNumber = checkNumber;
    }
    public void setCheckNumber(UUID checkNumber){
        this.checkNumber = checkNumber;
    }
    public UUID getCheckNumber(){
        return this.checkNumber;
    }
}
