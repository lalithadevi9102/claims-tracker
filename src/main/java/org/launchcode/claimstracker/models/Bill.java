package org.launchcode.claimstracker.models;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@Entity
@Table(name = "bill")
public class Bill extends AbstractEntity {

    private double amount;

    private String name;

    @Transient
    private Date date;

    private String billDueDate;

    private String type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    //@NotNull(message = "User is required")
    private User user;

    public Bill(double amount, String billDueDate, String name, String type, User user) {
        this.amount = amount;
        this.billDueDate = billDueDate;
        this.name = name;
        this.type = type;
        this.user = user;
    }

    public Bill() {}

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(String billDueDate) {
        this.billDueDate = billDueDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toJson() {
        return "{" +
                "\"name\":" + "\"" + name + "\"" +
                ", \"amount\":" + amount +
                ", \"type\":" + "\"" + type + "\"" +
                '}';
    }

    public LocalDate convertDateStringToDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        LocalDate dueDate = LocalDate.parse(stringDate, formatter);
        return dueDate;
    }


}