package com.example.ogarkovbook;

import java.util.HashMap;

public class PhoneBook {
    private HashMap<String, String> phoneNumbers;

    public PhoneBook() {
        phoneNumbers = new HashMap<>();
        phoneNumbers.put("1234567890", "pass123");
        phoneNumbers.put("9876543210", "pass456");
    }

    public boolean numberExists(String phoneNumber) {
        return phoneNumbers.containsKey(phoneNumber);
    }

    public String getPassword(String phoneNumber) {
        return phoneNumbers.get(phoneNumber);
    }
}
