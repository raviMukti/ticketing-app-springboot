package com.ticketing.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Request {

    @Id @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String requestId;

    @Temporal(TemporalType.DATE)
    private Date requestDate;

    @Temporal(TemporalType.DATE)
    private Date requestProcessDate;

    @Temporal(TemporalType.DATE)
    private Date solveDate;

    @OneToOne
    @JoinColumn(name = "ticketId", nullable = false, foreignKey = @ForeignKey(name = "fk_request_ticket"))
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "clientId", nullable = false, foreignKey = @ForeignKey(name = "fk_request_client"))
    private Client client;
}
