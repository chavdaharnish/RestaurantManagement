package com.example.restaurantmanagment;

public class Database {

    String id,punjabi,southindian,chinese,roti,chefname,chefpass;
    String foodname,pTikkaMasala,mpButterMasala,pPaneer,pMixPaneer,price,quantity,total;

    public String getfoodname() {
        return foodname;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getpTikkaMasala() {
        return pTikkaMasala;
    }

    public String getTotal() {
        return total;
    }

    public Database(String id, String foodname, String price, String quantity, String total) {
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.quantity = quantity;
        this.total = total;
    }

    public String getPrice() {
        return price;
    }

    public String getMpButterMasala() {
        return mpButterMasala;
    }

    public String getpPaneer() {
        return pPaneer;
    }

    public String getpMixPaneer() {
        return pMixPaneer;
    }

    public Database(String id, String foodname, String price, String quantity) {
        this.id = id;
        this.foodname = foodname;
        this.price = price;
        this.quantity = quantity;
    }

    public Database(String id, String pchhole, String pTikkaMasala, String mpButterMasala, String pPaneer, String pMixPaneer) {
        this.id = id;
        this.foodname = pchhole;
        this.pTikkaMasala = pTikkaMasala;
        this.mpButterMasala = mpButterMasala;
        this.pPaneer = pPaneer;
        this.pMixPaneer = pMixPaneer;
    }

    public Database() {

    }

    public Database(String id , String chefname , String chefpass) {
        this.id = id;
        this.chefname = chefname;
        this.chefpass = chefpass;
    }

    public String getChefname() {
        return chefname;
    }

    public String getChefpass() {
        return chefpass;
    }

    public String getId() {
        return id;
    }

    public String getPunjabi() {
        return punjabi;
    }

    public String getSouthindian() {
        return southindian;
    }

    public String getChinese() {
        return chinese;
    }

    public String getRoti() {
        return roti;
    }

}

