package com.mgmetehan.hibernate_exercises.model.inheritance.single;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.SQLDelete;

@Getter
@Setter
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "managers")
@Entity
@DiscriminatorValue("MANAGER")
@SQLDelete(sql = "UPDATE managers SET deleted = true WHERE id = ? AND version = ?")
public class Manager extends Employee {
    private int teamSize;
}