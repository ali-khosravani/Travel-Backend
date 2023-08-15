package com.p3soft.travel.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter

public class TourPackage {
    public TourPackage(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Id
    private String code;
    @Column
    private String name;

    public TourPackage() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TourPackage that)) return false;
        return Objects.equals(code, that.code) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        return "TourPackage{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
