package com.icerik.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class ObjectRef {
    private String id;
    private String type;
}
