package com.sgx.common.validators.constraint.impl;

import com.sgx.common.validators.constraint.TestConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created by sunguoxing on 2014/12/29.
 */
public class TestConstraintValidator implements ConstraintValidator<TestConstraint, Object> {
    @Override
    public void initialize(TestConstraint test) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        if(value instanceof String) {
            String s = (String) value;
            if("sgx".equalsIgnoreCase(s)) {
                return true;
            }
        }
        return false;
    }
}
