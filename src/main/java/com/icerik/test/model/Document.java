package com.icerik.test.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.UUID;

@Data
@ToString
@Entity
public class Document {

    @Id
    private UUID id;

    @Column
    private String name;

    @NaturalId
    @AttributeOverride(name = "id", column = @Column(name = "object_id"))
    @AttributeOverride(name = "type", column = @Column(name = "object_type"))
    private ObjectRef object;

    //TODO: how to add this field
    @ManyToOne
    @JoinColumn(name = "object_id", referencedColumnName = "object_id")
    @JoinColumn(name = "object_type", referencedColumnName = "object_type")
//    @Transient
    private Person person;

    public Document(){
        id = UUID.randomUUID();
    }
}
