package com.example.apk_skp_payroll.honor;

import java.util.List;

public class ModelDataHonor {

    private long id;
    private String user_id;
    private String servis_id;
    private String penjualan_id;
    private String created_at;
    private String updated_at;
    private Penjualan penjualan;
    private Servis servis;

    public List<Barang> getBarang() {
        return barang;
    }

    public void setBarang(List<Barang> barang) {
        this.barang = barang;
    }

    private List<Barang> barang;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getServis_id() {
        return servis_id;
    }

    public void setServis_id(String servis_id) {
        this.servis_id = servis_id;
    }

    public String getPenjualan_id() {
        return penjualan_id;
    }

    public void setPenjualan_id(String penjualan_id) {
        this.penjualan_id = penjualan_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public Penjualan getPenjualan() {
        return penjualan;
    }

    public void setPenjualan(Penjualan penjualan) {
        this.penjualan = penjualan;
    }

    public Servis getServis() {
        return servis;
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }

    






    public Integer getTotal_servis() {
        return total_servis;
    }

    public void setTotal_servis(Integer total_servis) {
        this.total_servis = total_servis;
    }

    public Integer getTotal_penjualan() {
        return total_penjualan;
    }

    public void setTotal_penjualan(Integer total_penjualan) {
        this.total_penjualan = total_penjualan;
    }

    public Integer getTotal_honor() {
        return total_honor;
    }

    public void setTotal_honor(Integer total_honor) {
        this.total_honor = total_honor;
    }

    private Integer total_servis;
    private Integer total_penjualan;
    private Integer total_honor;


}
