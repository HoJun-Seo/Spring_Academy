package com.example.ex01.model.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PointDTO {
	// 폼에 넘오는 매개변수와 멤버변수가 일치해야 자동맵핑됨.
	private String name;
	private int kor;
	private int eng;
	private int mat;
	private int total;
	private double avg;
	
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getKor() {
//		return kor;
//	}
//	public void setKor(int kor) {
//		this.kor = kor;
//	}
//	public int getEng() {
//		return eng;
//	}
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
//	public int getMat() {
//		return mat;
//	}
//	public void setMat(int mat) {
//		this.mat = mat;
//	}
//	public int getTotal() {
//		return total;
//	}
//	public void setTotal(int total) {
//		this.total = total;
//	}
//	public double getAvg() {
//		return avg;
//	}
//	public void setAvg(double avg) {
//		this.avg = avg;
//	}
	
	
}
