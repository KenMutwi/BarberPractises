package com.ken.mypractises;

public class Baberfruit {
    private int towelsIssued;
    private int towelsCollected;
    private int barber1Activity;
    private int barber2Activity;
    private int barber3Activity;

    public Baberfruit(int towelsIssued,int towelsCollected,int barber1Activity,int barber2Activity,int barber3Activity){
        this.setTowelsIssued(towelsIssued);
        this.setTowelsCollected(towelsCollected);
        this.setBarber1Activity(barber1Activity);
        this.setBarber2Activity(barber2Activity);
        this.setBarber3Activity(barber3Activity);

    }

    public int getTowelsIssued() {
        return towelsIssued;
    }

    public void setTowelsIssued(int towelsIssued) {
        this.towelsIssued = towelsIssued;
    }

    public int getTowelsCollected() {
        return towelsCollected;
    }

    public void setTowelsCollected(int towelsCollected) {
        this.towelsCollected = towelsCollected;
    }

    public int getBarber1Activity() {
        return barber1Activity;
    }

    public void setBarber1Activity(int barber1Activity) {
        this.barber1Activity = barber1Activity;
    }

    public int getBarber2Activity() {
        return barber2Activity;
    }

    public void setBarber2Activity(int barber2Activity) {
        this.barber2Activity = barber2Activity;
    }

    public int getBarber3Activity() {
        return barber3Activity;
    }

    public void setBarber3Activity(int barber3Activity) {
        this.barber3Activity = barber3Activity;
    }
}
