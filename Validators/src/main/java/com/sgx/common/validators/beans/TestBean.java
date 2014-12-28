package com.sgx.common.validators.beans;


import com.sgx.common.validators.constraint.TestConstraint;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by sunguoxing on 2014/12/29.
 */
public class TestBean {

    @NotNull(message = "The id of employee can not be null")
    private Integer id;

    @NotNull(message = "The name of employee can not be null")
    @Size(min = 1,max = 10,message="The size of employee's name must between 1 and 10")
    private String name;

    @NotNull
    @TestConstraint(message = "is Not Sgx")
    private String sgx;

    public String getSgx() {
        return sgx;
    }

    public void setSgx(String sgx) {
        this.sgx = sgx;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestBean() {
    }
}
