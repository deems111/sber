package sberMain.entity;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Column()
    private double balance;

    @Column()
    private long accountNumber;

    @ManyToOne()
    @JoinColumn(name = "inn")
    private Client client;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
