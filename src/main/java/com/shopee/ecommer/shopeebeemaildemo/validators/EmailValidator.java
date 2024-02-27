package com.shopee.ecommer.shopeebeemaildemo.validators;

import com.shopee.ecommer.shopeebeemaildemo.models.request.EmailDto;

import static com.shopee.ecommer.shopeebeemaildemo.constants.MessageErrors.EMAIL_SUBJECT_INVALID;
import static com.shopee.ecommer.shopeebeemaildemo.constants.MessageErrors.EMAIL_TO_INVALID;

public class EmailValidator extends CommonValidator{
    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    public void validateEmail(EmailDto emailDto) {
        //Check To User
        checkList().accept(emailDto.getEmailsTo(), EMAIL_TO_INVALID);
        emailDto.getEmailsTo().forEach(this::validateEmail);

        //Check Subject
        checkEmpty().accept(emailDto.getSubject(), EMAIL_SUBJECT_INVALID);
    }

    private void validateEmail(String email) {
        checkEmpty().accept(email, EMAIL_TO_INVALID);
        checkCondition().accept(!email.matches(EMAIL_REGEX), EMAIL_TO_INVALID);

    }

}
