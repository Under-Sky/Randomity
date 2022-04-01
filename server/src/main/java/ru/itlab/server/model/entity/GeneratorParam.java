package ru.itlab.server.model.entity;

import javax.persistence.*;

@Entity
public class GeneratorParam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private Long minRange;

    @Column(nullable = false)
    private Long maxRange;

    @Column(nullable = false)
    private Long count;

    @Column(nullable = false)
    private Boolean isRepeat;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "generator_id")
    private Generator generator;

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }
}