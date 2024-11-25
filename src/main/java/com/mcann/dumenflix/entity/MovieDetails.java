package com.mcann.dumenflix.entity;

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
@Table(name = "tbl_movie_details")
public class MovieDetails {
	@Id
	Long id;
	String description;
	String videoUrl;
	String producer;
	String director;
}