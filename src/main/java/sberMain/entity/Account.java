package sberMain.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ACCOUNT", schema = "public")
public class Account {

    @Id
    @Column(name = "id", nullable = false, unique = true)
    private String id;

    @Column(nullable = false)
    private String balance;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "inn")
    private Client client;
}