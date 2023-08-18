package com.jeli.myeverytime.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {
    @Id @GeneratedValue
    private Long id;

    private String loginId;
    private String password;
    private String nickname;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

}
