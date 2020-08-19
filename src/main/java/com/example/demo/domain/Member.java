package com.example.demo.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tbl_member")
@EqualsAndHashCode(of = "uid")
public class Member {
    @Id
    private String uid;
    private String upw;
    private String uname;

}
