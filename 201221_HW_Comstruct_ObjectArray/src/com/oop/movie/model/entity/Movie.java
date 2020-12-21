package com.oop.movie.model.entity;

import java.util.Calendar;

public class Movie {
	private String movieTitle;
	private String director;
	private String[] casting = new String[5];
	private Calendar release;
	
	public Movie() {}	
	public Movie(String movieTitle) {
		this.movieTitle = movieTitle;
	}	
	public Movie(String movieTitle, String director) {
		this(movieTitle);
		this.director = director;
	}	
	public Movie(String movieTitle, String director, String[] casting) {
		this(movieTitle, director);
		this.casting = casting;
	}	
	public Movie(String movieTitle, String director, String[] casting, Calendar release) {
		this(movieTitle, director, casting);
		this.release = release;
	}	
	
	public String getMovieTitle() {
		return movieTitle;
	}
	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String[] getCasting() {
		return casting;
	}
	public void setCasting(String[] casting) {
		this.casting = casting;
	}
	public Calendar getRelease() {
		return release;
	}
	public void setRelease(Calendar release) {
		this.release = release;
	}
	
	public String information() {
		String str = this.movieTitle;
		if(this.director != null) str += ", "+ this.director;
			for(String x : this.casting) {
				if(x != null) {
					str += ","+ x;
				}
			}
			//Calander 년도, 달 값 가져오기.
			if(this.release != null) {
				str += ", "+ this.release.get(Calendar.YEAR)+"."+(this.release.get(Calendar.MONTH)-1);
			}
		return str;
	}
}
