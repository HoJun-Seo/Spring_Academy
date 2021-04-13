package com.example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PointDTO{
	private String name;
	private String kor;
	private String mat;
	private String eng;
	private String total;
	private double avg;
}
