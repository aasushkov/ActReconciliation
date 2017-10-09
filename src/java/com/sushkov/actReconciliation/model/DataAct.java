package com.sushkov.actReconciliation.model;

/**
 * Created by sushkov on 02.06.2017.
 */
public class DataAct {

    private String numberDoc;
    private int numberRow;
    private double debet;
    private double credit;

    public DataAct(String numberDoc, int numberRow, double debet, double credit) {
        this.numberDoc = numberDoc;
        this.numberRow = numberRow;
        this.debet = debet;
        this.credit = credit;
    }

    public DataAct() {
    }

    public String getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(String numberDoc) {
        this.numberDoc = numberDoc;
    }

    public int getNumberRow() {
        return numberRow;
    }

    public void setNumberRow(int numberRow) {
        this.numberRow = numberRow;
    }

    public double getDebet() {
        return debet;
    }

    public void setDebet(double debet) {
        this.debet = debet;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "DataAct{" +
                "numberDoc='" + numberDoc + '\'' +
                ", numberRow=" + numberRow +
                ", debet=" + debet +
                ", credit=" + credit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DataAct)) return false;

        DataAct dataAct = (DataAct) o;

        if (numberRow != dataAct.numberRow) return false;
        if (Double.compare(dataAct.debet, debet) != 0) return false;
        if (Double.compare(dataAct.credit, credit) != 0) return false;
        return numberDoc != null ? numberDoc.equals(dataAct.numberDoc) : dataAct.numberDoc == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberDoc != null ? numberDoc.hashCode() : 0;
        result = 31 * result + numberRow;
        temp = Double.doubleToLongBits(debet);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(credit);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
