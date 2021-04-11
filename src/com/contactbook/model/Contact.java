package com.contactbook.model;

public class Contact implements Cloneable{
    private String lastName;
    private String firstName;
    private String patronymic;
    private String addressName;
    private int addressNumber;
    private String phoneNumber;
    private String info;

    public Contact() {
        // Empty constructor
    }

    public Contact(String lastName,
                   String firstName,
                   String patronymic,
                   String addressName,
                   int addressNumber,
                   String phoneNumber,
                   String info) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.patronymic = patronymic;
        this.addressName = addressName;
        this.addressNumber = addressNumber;
        this.phoneNumber = phoneNumber;
        this.info = info;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public int getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Boolean isMobilePhone() {
        return this.phoneNumber.contains("+380");
    }

    @Override
    public String toString() {
        return "Contact{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", addressName='" + addressName + '\'' +
                ", addressNumber=" + addressNumber +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", info='" + info + '\'' +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }
}
