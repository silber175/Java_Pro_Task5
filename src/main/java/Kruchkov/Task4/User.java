package Kruchkov.Task4;

import jakarta.persistence.*;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

    @Entity
    @Table(name="Users")


    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "username")
        private String username;



        @Autowired
        public User() {

        }


        public void setUserName(String username) {
            this.username = username;
        }

        public String getUsername() {
            return this.username;
        }

        public long getId() {
            return this.id;
        }


        @Autowired
        public User(String username) {
            this.username = username;
        }

        public User(long id, String username) {
            this.id = id;
            this.username = username;
        }
    }


