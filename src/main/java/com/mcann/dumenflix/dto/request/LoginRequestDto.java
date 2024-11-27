package com.mcann.dumenflix.dto.request;

import jakarta.validation.constraints.NotNull;

public record LoginRequestDto(
		@NotNull
		String username,
		@NotNull
		String password
) {
}