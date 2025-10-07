package com.example.admin_employee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "salary_details")
public class SalaryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double basicPay;          // Mandatory
    private Double hra;
    private Double conveyanceAllowance;
    private Double specialAllowance;
    private Double incentivePercent;
    private Double grossSalary;       // Mandatory
    private Double pfDeduction;
    private Double esiDeduction;
    private Double totalDeductions;   // Mandatory
    private Double netSalary;         // Mandatory
    private String paymentMode;
    private String bankName;
    private String bankAccountNumber;
    private String ifscCode;
    private String cancelledChequeFile;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBasicPay() {
        return basicPay;
    }

    public void setBasicPay(Double basicPay) {
        this.basicPay = basicPay;
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double hra) {
        this.hra = hra;
    }

    public Double getConveyanceAllowance() {
        return conveyanceAllowance;
    }

    public void setConveyanceAllowance(Double conveyanceAllowance) {
        this.conveyanceAllowance = conveyanceAllowance;
    }

    public Double getSpecialAllowance() {
        return specialAllowance;
    }

    public void setSpecialAllowance(Double specialAllowance) {
        this.specialAllowance = specialAllowance;
    }

    public Double getIncentivePercent() {
        return incentivePercent;
    }

    public void setIncentivePercent(Double incentivePercent) {
        this.incentivePercent = incentivePercent;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getPfDeduction() {
        return pfDeduction;
    }

    public void setPfDeduction(Double pfDeduction) {
        this.pfDeduction = pfDeduction;
    }

    public Double getEsiDeduction() {
        return esiDeduction;
    }

    public void setEsiDeduction(Double esiDeduction) {
        this.esiDeduction = esiDeduction;
    }

    public Double getTotalDeductions() {
        return totalDeductions;
    }

    public void setTotalDeductions(Double totalDeductions) {
        this.totalDeductions = totalDeductions;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getCancelledChequeFile() {
        return cancelledChequeFile;
    }

    public void setCancelledChequeFile(String cancelledChequeFile) {
        this.cancelledChequeFile = cancelledChequeFile;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
