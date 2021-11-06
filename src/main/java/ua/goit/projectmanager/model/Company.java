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
@Table(name = "companies")
public class Company implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -7810157399176088175L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_company")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "companies_projects",
            joinColumns = {@JoinColumn(name = "id_company")},
            inverseJoinColumns = {@JoinColumn(name = "id_project")})
    private Set<Project> projects;

}
