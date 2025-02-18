package com.HabiernateAndJpaPractice.HibdernetAndJpa.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
@Table(
        name = "Product_Table",
        uniqueConstraints = {
                @UniqueConstraint(name = "sku_unique",columnNames = {"sku"})
        }
)
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 20)
    private String sku;

    private String title;
    private double price;
    private int quantity;

    @CreationTimestamp
    @Column(name = "`create`") // Escape the column name
    private LocalDateTime create;

    @UpdateTimestamp
    @Column(name = "`update`") // Escape the column name
    private LocalDateTime update;
}
