package com.mcann.dumenflix.dto.request;

import com.mcann.dumenflix.utility.enums.Genre;

public record MovieFilterRequestDto(
		Genre genre,
		Long minProductionYear,
		Long maxProductionYear,
		Integer rating
) {
}