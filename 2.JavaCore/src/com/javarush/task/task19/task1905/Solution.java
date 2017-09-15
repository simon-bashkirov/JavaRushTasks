package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();

    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
//        DataAdapter dataAdapter = new DataAdapter(new ACustomer(), new AContact());
//        System.out.println("getCompany: " + dataAdapter.getCompany());
//        System.out.println("getContactFirstName: " + dataAdapter.getContactFirstName());
//        System.out.println("getContactLastName: " + dataAdapter.getContactLastName());
//        System.out.println("getCountryCode: " + dataAdapter.getCountryCode());
//        System.out.println("getDialString: " + dataAdapter.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(", ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(", ")[0];
        }

        @Override
        public String getCountryCode() {
            String countryCode = null;
            for (String code : countries.keySet()) {
                if (countries.get(code).equals(customer.getCountryName())) countryCode = code;
            }
            return countryCode;
        }

        @Override
        public String getDialString() {
            String phoneNumber = contact.getPhoneNumber();
            return "callto://" + phoneNumber.substring(0,3) + phoneNumber.substring(4,7) + phoneNumber.substring(8,11) +
                    phoneNumber.substring(12,14) + phoneNumber.substring(15,17);
        }
    }

    public static interface RowItem {
        String getCountryCode();        //example UA
        String getCompany();            //example JavaRush Ltd.
        String getContactFirstName();   //example Ivan
        String getContactLastName();    //example Ivanov
        String getDialString();         //example callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.
        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan
        String getPhoneNumber();        //example +38(050)123-45-67
    }
}