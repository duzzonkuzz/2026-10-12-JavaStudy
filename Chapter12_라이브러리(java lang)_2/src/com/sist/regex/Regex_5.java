package com.sist.regex;

/*
 *   [A-Z] [a-z] [A-Za-z]
 *   [가-힣] 
 *   [0-9] 
 *   [A-Za-z가-힣0-9]
 *   
 *   => 제네릭 / 컬렉션 (2일) ******
 *   => IO (2) *****
 *   => 쓰레드 / 네트워크 (2) 
 *   => 람다 , 스트림 (1) **** / 데이터베이스 
 */
public class Regex_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("a".matches("[a-z]"));
        System.out.println("A".matches("[A-Z]"));
        System.out.println("박".matches("[가-힣]"));
        System.out.println("1".matches("[0-9]"));
        System.out.println("코메디".matches("^코[가-힣]*"));
        System.out.println("dog".matches("dog|cat|pig"));
        System.out.println("gif".matches("gif|jpg|png"));
        System.out.println("yes".matches("y(es)?"));
        System.out.println("yes".matches("ye?."));
        // 그룹 
        System.out.println("abcabc".matches("(abc)+"));
        System.out.println("abc".matches("(abc)*"));
        System.out.println("hahahe".matches("(ha)+he"));
        System.out.println("aabb".matches("(a+b+)*"));
        System.out.println("123123".matches("(\\d+)+"));
        System.out.println("123123".matches("([0-9]+)+"));
        System.out.println("a1b2c3".matches("(\\w\\d)+"));
        System.out.println("a1b2c3".matches("([a-z][0-9])+"));
        //                                      \w   \d
        System.out.println(" ".matches("\\s")); // space => 공백 
        System.out.println("1 2".matches("\\d\\s\\d"));
        System.out.println("a b".matches("\\w\\s\\w"));
        
        System.out.println("1+2".matches("\\d\\+\\d"));
        // \\? \\|  \ => \\
        System.out.println("a\\b".matches("\\w\\\\\\w"));
        System.out.println("c++".matches("\\w\\+\\+"));
        System.out.println("^abc$".matches("\\^(abc)\\$"));
	}

}