package com.jeli.myeverytime.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;

    @Lob
    @Column(length = 65535)
    private String contents;

    private LocalDateTime createDate;

    private LocalDateTime updateDate;

    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private Member writer;
}
