package com.yape.apitest.utils;

public enum Headers {

    CONTENT_TYPE("Content-Type", "application/json"),
    AUTHORIZATION("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM="),
    ACCEPT("Accept","application/json");

    private String key;
    private String value;

    Headers(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
