package sberMain.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Column()
    private String balance;

    @Column()
    private String accountNumber;

    @Column()
    private String inn;

    @ManyToOne()
    @JoinColumn(name = "inn")
    private Client client;

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }
}
