package com.school;


import com.school.enums.TeacherType;

public class FullTimeTeacher extends Teacher {
    private double baseSalary;

    public FullTimeTeacher(String name, String lastName, String personalCode, double baseSalary) {
        super(name, lastName, personalCode);
        this.baseSalary= baseSalary;
        this.setType(TeacherType.FULL_TIME);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public Double calculateSalary() {
        return baseSalary - super.calculateInsurance(baseSalary) - super.calculateTax(baseSalary);
    }
}
