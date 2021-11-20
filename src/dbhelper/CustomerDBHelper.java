package dbhelper;


import dbhelper.ReadFileUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import model.Customer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author shreyesh
 */
public class CustomerDBHelper {

    public HashMap<CustomerVerification, Customer> customers;
    final Customer defaultCustomer = new Customer("-1", "Test", 0, false, -1, -1);

    // If the customer does not exist then just return the default customer.
    public Customer getCustomer(int phoneNumber, int loyaltyPin) {
        return this.customers.getOrDefault(
                new CustomerVerification(phoneNumber, loyaltyPin), 
                defaultCustomer);
    }

    public void readCustomerDB() {
        ReadFileUtil r = new ReadFileUtil("customer.data");
        List<List<String>> data = r.readFile();
        this.customers = new HashMap<>();

        // userID, name, phoneNumber, isLoyalCustomer, memberPin, loyaltyPoints
        data.remove(0);
        for (List<String> record : data) {
            String userID = record.get(0);
            String name = record.get(1);
            int phoneNumber = Integer.parseInt(record.get(2));
            boolean isLoyalCustomer = Boolean.parseBoolean(record.get(3));
            int memberPin = Integer.parseInt(record.get(4));
            int loyaltyPoints = Integer.parseInt(record.get(5));

            Customer customer = new Customer(
                    userID,
                    name,
                    phoneNumber,
                    isLoyalCustomer,
                    memberPin,
                    loyaltyPoints
            );

            customers.put(
                    new CustomerVerification(phoneNumber, memberPin),
                    customer);
        }

    }
    
    
    public static void main(String[] args) {
        CustomerDBHelper db = new CustomerDBHelper();
        db.readCustomerDB();
        System.out.println(db.getCustomer(999999999, 11000).getName());
    }
}

class CustomerVerification {

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
