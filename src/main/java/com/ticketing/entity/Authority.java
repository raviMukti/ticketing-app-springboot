package com.ticketing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Authority {
    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String authorityId;

    @ManyToOne
    @JoinColumn(name = "userName", nullable = false, foreignKey = @ForeignKey(name = "fk_authority_client"))
    private Client client;

    @Column(nullable = false)
    private String authorityName;

    public Authority(){

    }

    public String getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(String authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
}
