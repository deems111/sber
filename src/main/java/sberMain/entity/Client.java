package sberMain.entity;

import sberMain.entity.Account;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column()
    private long inn;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    public Client() {}

    public Client(long inn) {
        this.inn = inn;
    }

    public long getInn() {
        return inn;
    }

    public void setInn(long inn) {
        this.inn = inn;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}