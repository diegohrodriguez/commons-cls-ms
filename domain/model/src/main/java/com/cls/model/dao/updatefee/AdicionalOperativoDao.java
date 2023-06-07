package com.cls.model.dao.updatefee;

import lombok.Data;
import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Immutable
@Table(name="additional_operations")
public class AdicionalOperativoDao {
    @Id()
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Column(name = "operation_id")
    private Integer operationId;
    @Column(name = "variable")
    private String variable;
}
