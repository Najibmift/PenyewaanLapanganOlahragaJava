/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Najib
 */


public class Voli extends AbstractClass{
    Connection cn = db.mycon();
    public Statement st;
    public ResultSet rs;
    private int harga,total,lama,DP,sisa;
    private String kdBooking,lapangan,status,kasir,penyewa,masuk,keluar,keterangan;
    private java.sql.Date tglMain,tglBooking;
    public Voli(int harga, int lama, String lapangan, String status, String kasir, String penyewa, String masuk, String keluar,String keterangan, java.sql.Date tglMain, java.sql.Date tglBooking){
        this.harga = harga;
        this.lama = lama;
        this.lapangan = lapangan;
        this.status = status;
        this.kasir = kasir;
        this.penyewa = penyewa;
        this.masuk = masuk;
        this.keluar = keluar;
        this.keterangan = keterangan;
        this.tglBooking = tglBooking;
        this.tglMain = tglMain;
    }

    /**
     *
     * @return
     */
    @Override
    public int Total(){
        this.total = harga* lama;
        return total;
    }
    @Override
    public void simpan( int DP,int total, int sisa){
        this.total = total;
        this.sisa = sisa;
        this.DP = DP;
        try{
            st = cn.createStatement();
            rs = st.executeQuery("SELECT tgl_main, masuk, keluar, lapangan FROM tb_booking_voli WHERE tgl_main = '" + this.tglMain +"' and masuk ='" + this.masuk +"' and keluar ='"+ this.keluar+"' and lapangan='"+this.lapangan+"'");
            if(rs.next()){
               JOptionPane.showMessageDialog(null, "Data sudah ada , Dari jam "+rs.getString("masuk")+" - "+rs.getString("keluar")+", silahkan input data yang berbeda","Error", JOptionPane.ERROR_MESSAGE);
            }else{
                st.executeUpdate("insert into tb_booking_voli values('" +this.kdBooking+"', '"+ this.tglBooking+ "', '" +this.tglMain + "', '"+ 
                this.kasir + "','" + this.penyewa + "', '" + this.status + "', '" + this.lapangan+ "','" + this.harga+ "','" + this.masuk + "','" 
                + this.keluar + "','"+this.lama +"', '"+this.total+"', '" + this.DP + "','" +this.sisa+"', '"+ this.keterangan + "')");
                JOptionPane.showMessageDialog(null, "Berhasil disimpan!!");   
            }             
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Kesalahan pada saat menyimpan data: " + ex.getMessage());
        }
    }
    @Override
    public void update(int DP, int total, int sisa,String kdBooking){
        this.DP = DP;
        this.total = total;
        this.sisa = sisa;
        try{
            st = cn.createStatement();
            st.executeUpdate("update tb_booking_voli set tgl_booking = '" + this.tglBooking+ "',  tgl_main ='" + this.tglMain+ "', kasir = '"+ this.kasir+
                "', penyewa = '"+ this.penyewa +"', status = '" + this.status + "', lapangan = '" + this.lapangan + "', harga_sewa = '" + this.harga +"', masuk = '" + this.masuk +
                "', keluar = '" + this.keluar + "',lama = '" + this.lama + "',total = '" + this.total +"',dp = '" + this.DP + "',sisa = '" + this.sisa + "',keterangan = '" + this.keterangan +"'" +" where kd_booking = '" + kdBooking+"'");
            JOptionPane.showMessageDialog(null, "Data Berhasil  Diupdate!");          
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Kesalahan pada saat menyimpan data: " + ex.getMessage());
        }
    }
    public void delete(String kdBooking) throws SQLException{
        st = cn.createStatement();
        st.executeUpdate("DELETE FROM tb_booking_voli WHERE kd_booking='" + kdBooking + "'");
    }
    
    @Override
    public void generateKode(String kdBooking){
        this.kdBooking = kdBooking;
        try {
            st = db.mycon().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(kd_booking) FROM tb_booking_voli");
            rs.next();
            rs.getString("MAX(kd_booking)");
            if (rs.getString("MAX(kd_booking)") == null) {
                this.kdBooking = ("VOL-0001");    
            } else {
                long id = Long.parseLong(rs.getString("MAX(kd_booking)").substring(4, rs.getString("MAX(kd_booking)").length()));
                id++;
                this.kdBooking = ("VOL-" + String.format("%04d", id));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
    }
}
