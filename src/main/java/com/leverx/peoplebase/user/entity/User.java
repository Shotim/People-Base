package com.leverx.peoplebase.user.entity;

import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

import static javax.persistence.GenerationType.SEQUENCE;
import static lombok.AccessLevel.PRIVATE;

@Data
@FieldDefaults(level = PRIVATE)
@Entity
@Table(name = "people")
public class User {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    long id;

    @Column
    String name;

    @Column
    LocalDate dateOfBirth;
}