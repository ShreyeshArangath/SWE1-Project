/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author matth
 */

public class OrderTimer {
    Timer timer;
    
    public OrderTimer(int seconds) {
        timer = new Timer();
        timer.schedule(new RemindTask(), seconds * 1000);
    }
    
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("Inventory order was sent to suppliers!");
            timer.cancel();
        }
    }
}
