package org.launchcode.claimstracker.models.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BillFormDTO {

    @NotNull(message = "Please enter bill amount")
    @Min(1)
    private double amount;

    @NotBlank(message = "Bill must have a name")
    @Size(min = 1, max = 50, message = "Bill name must be between 1 and 50 characters.")
    private String name;

    @NotBlank(message = "Please pick a bill due date")
    private String billDueDate;

    @NotBlank(message = "Bill type must be between 1 and 50 characters.")
    @Size(min = 1, max = 50)
    private String type;

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

    public String getBillDueDate() {
        return billDueDate;
    }

    public void setBillDueDate(String billDueDate) {
        this.billDueDate = billDueDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}