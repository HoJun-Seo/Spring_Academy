package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PointDTO{
	private String name;
	private int kor;
	private int mat;
	private int eng;
	private int total;
	private double avg;
}
