package com.gidae.restcrud.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table
public class Profile implements Serializable {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    @Column
    private String network;

    @Column
    private String userName;

    @Column
    private String url;

    @Column
    private LocalDateTime createDat;

    @Builder
    public Profile(String network, String userName, String url, LocalDateTime createDat) {
        this.network = network;
        this.userName = userName;
        this.url = url;
        this.createDat = createDat;
    }
}
