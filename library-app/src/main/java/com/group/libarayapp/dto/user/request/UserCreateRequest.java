package com.group.libarayapp.dto.user.request;

public class UserCreateRequest {

    private String name;
    private Integer age; // Integer 의 경우는 null 포함이 가능, int 는 null 포함 불가능

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
