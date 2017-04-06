package ru.naissur.payments.model;

/**
 * naissur
 * 06.04.2017
 */
public class BaseEntity {
    private Integer id;

    BaseEntity() {
    }

    public BaseEntity(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isNew() {
        return this.id == null;
    }
}
