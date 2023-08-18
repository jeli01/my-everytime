package com.jeli.myeverytime.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class File {
    @Id @GeneratedValue
    private Long id;

    @Lob
    @Column(length = 65535)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;
}
