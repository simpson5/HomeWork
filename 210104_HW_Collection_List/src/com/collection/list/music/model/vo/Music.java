package com.collection.list.music.model.vo;

public class Music {
	private String title;
	private String singer;
	
	public Music() {
	}
	
	public Music(String title, String singer) {
		this.title = title;
		this.singer = singer;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	@Override
	public String toString() {
		return "[title=" + title + ", singer=" + singer + "]\n";
	}
	
	//특정 곡을 삭제할려면 equals가 true가 되야함
	//제목과 가수 따로 비교
	@Override
	public boolean equals(Object obj) {
		//Music 형변환자 타입 검사
		if (!(obj instanceof Music))
			return false;
		Music other = (Music) obj;
		//제목이나 가수 둘 중 하나라도 같으면 true
		if (title.equals(other.title) || singer.equals(other.singer))
			return true;
		else {
			return false;
		}
	}
	
	//둘다 같을 경우를 확인하는 equals
	public boolean equals2(Object obj) {
		//Music 형변환자 타입 검사
		if (!(obj instanceof Music))
			return false;
		Music other = (Music) obj;
		//제목 가수 둘다 같아야 한다
		if (title.equals(other.title) && singer.equals(other.singer))
			return true;
		else {
			return false;
		}
	}
}
