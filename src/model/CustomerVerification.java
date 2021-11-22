/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author shreyesh
 */
public class CustomerVerification {

    int phoneNumber;
    int memberPin;

    public CustomerVerification(int phoneNumber, int memberPin) {
        this.phoneNumber = phoneNumber;
        this.memberPin = memberPin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CustomerVerification)) {
            return false;
        }
        CustomerVerification verification = (CustomerVerification) o;
        return memberPin == verification.memberPin && phoneNumber == verification.phoneNumber;
    }

    @Override
    public int hashCode() {

        return Objects.hash(phoneNumber, memberPin);
    }
}
