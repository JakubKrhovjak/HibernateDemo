package com.example.hibernatedemo.entity.inheritnace;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by Jakub krhovják on 11/2/17.
 */
@Entity
@DiscriminatorValue("GOOD_CHILD")
public class GoodChild extends Parent {

    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
