package ua.goit.projectmanager.model;

import com.sun.source.doctree.SeeTree;
import lombok.*;
import org.apache.ibatis.annotations.Many;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project implements BaseEntity<Long>, Serializable {


    @Serial
    private static final long serialVersionUID = 2373092481741317883L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name_project")
    private String name;

    @Column(name = "cost")
    private int cost;

    @Column(name = "create_date")
    private String createDate;
    @ManyToMany(mappedBy = "projects")
    private Set<Company> companies;
    @ManyToMany(mappedBy = "projects")
    private Set<Customer> customers;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "projects_developers",
            joinColumns = @JoinColumn(name = "id_project"),
            inverseJoinColumns = @JoinColumn(name = "id_developer")
    )
    private Set<Developer> developers;
}
