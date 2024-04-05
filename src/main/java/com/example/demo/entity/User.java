package com.example.demo.entity;

public class User extends AbstractEntity{
        private String phoneNumber;
        private String lastName;
        private String password;



        public User (String phoneNumber, String lastName, String password) {
            this.phoneNumber = phoneNumber;
            this.lastName = lastName;
            this.password = password;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }






