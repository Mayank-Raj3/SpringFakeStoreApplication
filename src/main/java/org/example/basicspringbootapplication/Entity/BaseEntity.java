package org.example.basicspringbootapplication.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @CreatedDate
    @Column(nullable = false,updatable = false)
    private Instant created ;
    @LastModifiedDate
    @Column(nullable = false)
    private Instant updated ;
    @PrePersist
    public void onCreate(){
        Instant now = Instant.now();
        this.created = now ;
        this.updated = now ;
    }
    @PreUpdate
    public void onUpdated(){
        this.updated = Instant.now() ;
    }

}
