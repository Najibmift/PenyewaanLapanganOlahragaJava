/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.SQLException;

/**
 *
 * @author Najib
 */
abstract class AbstractClass {
    abstract int Total(); 
    abstract void simpan(int DP, int total ,int sisa);
    abstract void delete(String kdBooking) throws SQLException;
    abstract void update(int DP, int total, int sisa, String kdBooking);
    abstract void generateKode(String kdBooking);
}
