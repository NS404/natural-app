package com.ns.naturalapp.config;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class View {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "view",fetch = FetchType.EAGER)
    private List<Attribute> attributes;
    @OneToOne(mappedBy = "view",fetch = FetchType.EAGER)
    private Conditions condition;

    @Override
    public String toString() {
        return name;
    }
}
