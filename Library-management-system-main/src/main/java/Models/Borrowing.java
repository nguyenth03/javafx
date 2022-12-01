/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;

/**
 *
 * @author 84563
 */
public class Borrowing {
    private String id , manaId ,UID,  bookName, borrowAt, refundAt, time_out, stautsName, username,statusId, accountId, bookId, manageId;
    private Text validate1, validate2, validate3, validate4, validate5;
    private int index, manaID;
    private DatePicker borrowID,refundD;
    
    public Borrowing(int id, int manaId, DatePicker txtBorrowAt, DatePicker txtRefundAt, Text validate1, Text validate2, Text validate3, Text validate4, Text validate5, String statusId, String accountId, String bookId) {
        this.index = id;
        this.manaID = manaId;
        this.borrowID = txtBorrowAt;
        this.refundD = txtRefundAt;
        this.validate1 = validate1;
        this.validate2 = validate2;
        this.validate3 = validate3;
        this.validate4 = validate4;
        this.validate5 = validate5;
        this.statusId = statusId;
        this.accountId = accountId;
        this.bookId = bookId;
    }
   
    public Borrowing() {
    }

    public Borrowing(String id, String UID, String bookName, String borrowAt, String refundAt, String time_out, String stautsName, String username, String statusId, String accountId, String bookId, String manageId) {
        this.id = id;
        this.UID = UID;
        this.bookName = bookName;
        this.borrowAt = borrowAt;
        this.refundAt = refundAt;
        this.time_out = time_out;
        this.stautsName = stautsName;
        this.username = username;
        this.statusId = statusId;
        this.accountId = accountId;
        this.bookId = bookId;
        this.manageId = manageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBorrowAt() {
        return borrowAt;
    }

    public void setBorrowAt(String borrowAt) {
        this.borrowAt = borrowAt;
    }

    public String getRefundAt() {
        return refundAt;
    }

    public void setRefundAt(String refundAt) {
        this.refundAt = refundAt;
    }

    public String getTime_out() {
        return time_out;
    }

    public void setTime_out(String time_out) {
        this.time_out = time_out;
    }

    public String getStautsName() {
        return stautsName;
    }

    public void setStautsName(String stautsName) {
        this.stautsName = stautsName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getManaId() {
        return manaId;
    }

    public Text getValidate1() {
        return validate1;
    }

    public Text getValidate2() {
        return validate2;
    }

    public Text getValidate3() {
        return validate3;
    }

    public Text getValidate4() {
        return validate4;
    }

    public Text getValidate5() {
        return validate5;
    }

    public int getIndex() {
        return index;
    }

    public int getManaID() {
        return manaID;
    }

    public DatePicker getBorrowID() {
        return borrowID;
    }

    public DatePicker getRefundD() {
        return refundD;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getManageId() {
        return manageId;
    }

    public void setManageId(String manageId) {
        this.manageId = manageId;
    }

    @Override
    public String toString() {
        return "Borrowing{" + "id=" + id + ", UID=" + UID + ", bookName=" + bookName + ", borrowAt=" + borrowAt + ", refundAt=" + refundAt + ", time_out=" + time_out + ", stautsName=" + stautsName + ", username=" + username + ", statusId=" + statusId + ", accountId=" + accountId + ", bookId=" + bookId + ", manageId=" + manageId + '}';
    }
//[Borrowing{id=null, manaId=null, borrowAt=null, refundAt=null, statusId=2, accountId=1, bookId=2, validate1=Text[id=validate1, text="Account cannot be empty !", x=0.0, y=0.0, alignment=LEFT, origin=BASELINE, boundsType=LOGICAL, wrappingWidth=282.13671875, font=Font[name=System Regular, family=System, style=Regular, size=12.0], fontSmoothingType=GRAY, fill=0xea210eff], validate2=Text[id=validate2, text="Borrow_at cannot be empty !", x=0.0, y=0.0, alignment=LEFT, origin=BASELINE, boundsType=LOGICAL, wrappingWidth=282.13671875, font=Font[name=System Regular, family=System, style=Regular, size=12.0], fontSmoothingType=GRAY, fill=0xea210eff], validate3=Text[id=validate3, text="Book cannot be empty !", x=0.0, y=0.0, alignment=LEFT, origin=BASELINE, boundsType=LOGICAL, wrappingWidth=282.13671875, font=Font[name=System Regular, family=System, style=Regular, size=12.0], fontSmoothingType=GRAY, fill=0xea210eff], validate4=Text[id=validate4, text="Refund_at cannot be empty !", x=0.0, y=0.0, alignment=LEFT, origin=BASELINE, boundsType=LOGICAL, wrappingWidth=282.13671875, font=Font[name=System Regular, family=System, style=Regular, size=12.0], fontSmoothingType=GRAY, fill=0xea210eff], validate5=Text[id=validate5, text="Status cannot be empty !", x=0.0, y=0.0, alignment=LEFT, origin=BASELINE, boundsType=LOGICAL, wrappingWidth=282.13671875, font=Font[name=System Regular, family=System, style=Regular, size=12.0], fontSmoothingType=GRAY, fill=0xea210eff], index=2, manaID=0, borrowID=DatePicker[id=txtBorrowAt, styleClass=combo-box-base date-picker], refundD=DatePicker[id=txtRefundAt, styleClass=combo-box-base date-picker]}]
//    @Override
//    public String toString() {
//        return "Borrowing{" + "id=" + id + ", manaId=" + manaId + ", borrowAt=" + borrowAt + ", refundAt=" + refundAt + ", statusId=" + statusId + ", accountId=" + accountId + ", bookId=" + bookId + ", validate1=" + validate1 + ", validate2=" + validate2 + ", validate3=" + validate3 + ", validate4=" + validate4 + ", validate5=" + validate5 + ", index=" + index + ", manaID=" + manaID + ", borrowID=" + borrowID + ", refundD=" + refundD + '}';
//    }

}
