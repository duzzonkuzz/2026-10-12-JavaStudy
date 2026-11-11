package com.sist.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 *   정규표현식 : 지정된 패턴을 가지고 문자열 검색 , 검사하는 클래스 
 *             ---------                   -----------
 *                                         유효성 검사
 *   문자열 패턴 
 *   정규식 => 자바 / 자바스크립트 / 오라클 
 *   정규식 기호 => 1) AI , 2) 데이터 크롤링 , 3) 데이터베이스 
 *   ---------
 *     1. [] 한개의 문자 => [abc]  => a|b|c
 *        [A-Z] [a-z] => [A-Za-z] : 알파벳 전체 
 *          | 범위 
 *        [0-9] : 숫자 전체 
 *        [가-힣] : 한글 전체 
 *     2. 숫자 : [0-9] , \d ==> \(\\)  => \\d
 *     3. \s : 공백
 *     4. \w : 한개의 알파벳 
 *     5. . : 임의의 한글자 
 *     6. ? : 한개거나 없음 
 *     7. * : 0개 이상 
 *     8. + : 1개 이상   [A-Z]+  [A-Z]*
 *     9. {n} : n개   ==> [A-Z]{3}
 *     10. {n,m} => 범위 => [0-9]{1,3}   1  12 123
 *         211.238.142.21 
 *         [0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}
 *         \\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}
 *     11. | => a|b => a이거나 b ==> [ab]
 *     12. ^ => 시작 ^[A-Z] /  [^A-Z] 
 *                            | => 제외 
 *     13. $ => 끝   [A-Z]$ 
 *     14. ((211.238.142).21)
 *         ------------------- 전체 : group()
 *          ------------- group(1)
 *         ==> split("\\|") , replaceAll("[^가-힣]","")
 */
public class Regex_1 {
    /*
     *     검색할 문자열 ==> res
     *         |
     *    Pattern.compile("맛있[A-Z]+") 문자열 형태 
     *                        ------한글이 0개 이거나 여러개 있는 문자열  
     *                |
     *           p.matcher(res)  
     *                |
     *              m.find()
     *                |
     *              m.group() => 검색된 문자열 반환 
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String res="맛있,맛있고,맛있게,맛있소,맛있다,맛없다,맛있습니다";
        // 맛있* 맛있+  맛있.
        Pattern p=Pattern.compile("맛있[가-힣]+");
        // Pattern객체 생성 => compile
        Matcher m=p.matcher(res);
        while(m.find())
        {
        	System.out.println(m.group());
        }
        
	}

}