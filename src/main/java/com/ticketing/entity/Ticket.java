package com.ticketing.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket {
    @Id
    private String ticketId;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String status;
}
