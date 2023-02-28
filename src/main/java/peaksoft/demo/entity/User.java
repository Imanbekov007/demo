package peaksoft.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    @Id //primary key
    @SequenceGenerator(name = "user_id_gen",
            sequenceName = "user_id_seq",
    allocationSize = 1)
    @GeneratedValue(generator = "user_id_gen",strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private int age;
    private String email;
}
