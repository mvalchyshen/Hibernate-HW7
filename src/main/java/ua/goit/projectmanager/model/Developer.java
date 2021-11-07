package ua.goit.projectmanager.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "developers")
public class Developer implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = 1759221531278054728L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_developer")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "salary")
    private int salary;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "developers_skills",
            joinColumns = @JoinColumn(name = "id_developer"),
            inverseJoinColumns = @JoinColumn(name = "id_skill"))
    private Set<Skill> skills;

    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects;
}
