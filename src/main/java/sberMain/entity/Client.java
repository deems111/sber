package sberMain.entity;

import lombok.*;
import sberMain.entity.Account;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CLIENT", schema = "public")
public class Client {

    @Id
    @Column(name = "inn", nullable = false, unique = true)
    private String inn;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> account;
}