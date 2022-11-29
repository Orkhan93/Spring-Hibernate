package spring.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 25)
    private String name;

    @Column(length = 35)
    private String surname;

    private int age;
    private double salary;
}
