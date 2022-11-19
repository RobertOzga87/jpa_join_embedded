package com.icerik.test.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Data
@ToString
@Entity
public class Person {
    @Id
    private UUID id;

    @Column
    private String name;

    @NaturalId
    @AttributeOverride(name = "id", column = @Column(name = "object_id"))
    @AttributeOverride(name = "type", column = @Column(name = "object_type"))
    private ObjectRef object;

    public Person(){
        id = UUID.randomUUID();
    }
}
