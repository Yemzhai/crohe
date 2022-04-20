package crohe.kz.crm.entity;

import crohe.kz.crm.enumeration.StaffEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private StaffEnum position;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String login;
    private String password;

    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id", nullable = false)
    private List<Storage> storages;
}
