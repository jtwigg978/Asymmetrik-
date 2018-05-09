package com.company;

public class ContactInfo {
    String name, phone, email;

    public ContactInfo() {}

    String getName() {
        return this.name;
    }

    String getPhone() { return this.phone; }

    String getEmail() {
        return this.email;
    }

    void setName(String value) {
        this.name = value;
    }

    void setPhone(String value) {
        this.phone = value;
    }

    void setEmail(String value) {
        this.email = value;
    }
}
