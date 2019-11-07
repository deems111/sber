package sberMain.entity;

import sberMain.entity.Account;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @Column()
    private String inn;

    @Column()
    private String name;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    public Client() {}

    public Client(String inn) {
        this.inn = inn;
    }

    public String  getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}