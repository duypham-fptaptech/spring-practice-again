package com.example.springpracticeagain.entity;

import com.example.springpracticeagain.enums.StreetStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "streets")
public class Street {
    @Id
    private String id;
    private String name;

//    @ManyToOne
//    @JoinColumn(name = "district_id", referencedColumnName = "id")
//    private District districtId;
    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    @JsonBackReference
    private District districtId;

    private LocalDateTime createdAt;
    private String description;
    private StreetStatus status;
}
