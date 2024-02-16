package com.bikkadit.rating.RatingService.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "rating_service")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedback;
    private int rating;
}
