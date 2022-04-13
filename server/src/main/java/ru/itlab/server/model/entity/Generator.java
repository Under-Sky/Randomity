package ru.itlab.server.model.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@ToString
@Entity
@Table(name = "generator")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Generator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nameOfGenerator;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String iconPath;

    @Column(nullable = false)
    private String bigImgPath;

    @Column(nullable = false)
    private String htmlPath;

    @ToString.Exclude
    @ManyToMany(mappedBy = "generators", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users = new ArrayList<>();

    @OneToOne(mappedBy = "generator", cascade = CascadeType.ALL, orphanRemoval = true)
    private GeneratorParam generatorParam;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Generator generator = (Generator) o;
        return id != null && Objects.equals(id, generator.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}