package com.mcann.dumenflix.entity;

import com.mcann.dumenflix.utility.enums.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tbl_movies")
public class MovieCard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String title;
	Long productionYear;
	byte rating;
	@Enumerated(EnumType.STRING)
	Genre genre;
	String imageUrl;
}