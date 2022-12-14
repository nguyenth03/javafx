/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Date;
import javafx.beans.property.*;

/**
 *
 * @author PC
 */
public class Borrow {
    private final IntegerProperty index;
    private final IntegerProperty id;
    private final StringProperty borrowAt;
    private final IntegerProperty time_out;
    private final StringProperty refundAt;
    private final FloatProperty amount_of_pay;
    private final IntegerProperty manageId;
    private final IntegerProperty statusId;
    private final StringProperty statusName;

    public Borrow() {
        this.index = new SimpleIntegerProperty(this, "index");
        this.id = new SimpleIntegerProperty(this, "id");
        this.borrowAt = new SimpleStringProperty(this, "borrowAt");
        this.time_out = new SimpleIntegerProperty(this, "time_out");
        this.refundAt = new SimpleStringProperty(this, "refundAt");
        this.amount_of_pay = new SimpleFloatProperty(this, "amount_of_pay");
        this.manageId = new SimpleIntegerProperty(this, "manageId");
        this.statusId = new SimpleIntegerProperty(this, "statusId");
        this.statusName = new SimpleStringProperty(this, "statusName");
    }

    public int getIndex() {
        return id.get();
    }

    public void setIndex(int index) {
        this.index.set(index);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getBorrowAt() {
        return borrowAt.get();
    }

    public void setBorrowAt(String borrowAt) {
        this.borrowAt.set(borrowAt);
    }

    public int getTime_out() {
        return time_out.get();
    }

    public void setTime_out(int time_out) {
        this.time_out.set(time_out);
    }

    public String getRefundAt() {
        return refundAt.get();
    }

    public void setRefundAt(String refundAt) {
        this.refundAt.set(refundAt);
    }

    public float getAmount_of_pay() {
        return amount_of_pay.get();
    }

    public void setAmount_of_pay(float amount_of_pay) {
        this.amount_of_pay.set(amount_of_pay);
    }

    public int getManageId() {
        return manageId.get();
    }

    public void setManageId(int manageId) {
        this.manageId.set(manageId);
    }

    public int getStatusId() {
        return statusId.get();
    }

    public void setStatusId(int statusId) {
        this.statusId.set(statusId);
    }

    public int getStatusName() {
        return statusId.get();
    }

    public void setStatusName(int statusId) {
        this.statusId.set(statusId);
    }

    @Override
    public String toString() {
        return "Borrow{" + "id=" + id.get()
                + ", borrowAt=" + borrowAt.get()
                + ", time_out=" + time_out.get()
                + ", refundAt=" + refundAt.get()
                + ", amount_of_pay=" + amount_of_pay.get()
                + ", manageId=" + manageId.get()
                + ", statusId=" + statusId.get()
                + ", statusName=" + statusName.get()
                + '}';
    }
}
