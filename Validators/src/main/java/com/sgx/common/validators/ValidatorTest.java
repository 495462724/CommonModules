package com.sgx.common.validators;

import com.sgx.common.validators.beans.TestBean;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * Created by sunguoxing on 2014/12/29.
 */
public class ValidatorTest {

    public static void main(String[] args) {
        TestBean testBean = new TestBean();
//        testBean.setId(4);
        testBean.setName("abcdefghijklmn");
        testBean.setSgx("sg3x");
        ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
        Validator validator = vf.getValidator();
        Set<ConstraintViolation<TestBean>> result =  validator.validate(testBean);
        for (ConstraintViolation<TestBean> constraintViolation : result) {
            System.out.println(constraintViolation.getMessage());
        }
    }
}
