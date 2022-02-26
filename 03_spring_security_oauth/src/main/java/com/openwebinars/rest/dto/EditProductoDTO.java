package com.openwebinars.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor @RequiredArgsConstructor
public class EditProductoDTO {

	private String nombre;
	private float precio;

}
