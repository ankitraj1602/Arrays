package com.company;

public class Contact {

    private String contactName;
    private int phoneNumber;

    public Contact(String contactName, int phoneNumber) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean searchContact(String contactName){
        if(this.contactName.equals(contactName)){
            return true;
        }
        else {
            return false;
        }
    }
}
