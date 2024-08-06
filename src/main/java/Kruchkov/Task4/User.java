package Kruchkov.Task4;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Table(name="user")
    public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(name = "username")
        private String username;


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

        public User(String username) {
            this.username = username;
        }

        public User(long id, String username) {
            this.id = id;
            this.username = username;
        }
    }


