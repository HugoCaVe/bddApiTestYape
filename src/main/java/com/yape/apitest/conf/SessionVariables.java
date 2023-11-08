package com.yape.apitest.conf;

public enum SessionVariables {

    PATH("path"),
    FILTER_PERSONAL_INFORMATION("filterpersonalInformation"),
    FILTER_FIRST_NAME_PARAMETER("?firstname="),
    FILTER_LAST_NAME_PARAMETER("&lastname="),
    FILTER_CHECKIN_PARAMETER("?checkin="),
    FILTER_CHECKOUT_PARAMETER("&checkout="),
    FILTER_DATE_INFORMATION("filterdateInformation"),
    USER_NAME("usurname"),
    PASSWORD("password"),
    SESSION_TOKEN("token"),
    FIRST_NAME("firstname"),
    LAST_NAME("lastname"),
    TOTAL_PRICE("totalprice"),
    DEPOSIT_PAID("depositpaid"),
    START_DATE("checkin"),
    END_DATE("checkout"),
    ADDITIONAL_NEEDS("additionalneeds");

    private String key;
    private String value;

    SessionVariables(String key, String value) {
        this.key = key;
        this.value = value;
    }

    SessionVariables(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
