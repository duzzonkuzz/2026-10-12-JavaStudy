package com.sist.music;
//데이터형으로 사용
// 캡슐화
import lombok.Data;
@Data
public class Music {
private int mno;
private String title;
private String singer;
private String poster;
private String key; // youtube => 정규식 / 검색

}
