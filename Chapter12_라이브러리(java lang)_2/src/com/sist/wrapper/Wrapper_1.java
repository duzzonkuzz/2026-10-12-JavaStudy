package com.sist.wrapper;
/*
 *   Wrapper 클래스 
 *     => 포장 클래스 
 *     => 기본 데이터형을 객체로 사용이 가능하게 만든 클래스 
 *        ---------- 클래스형으로 
 *     => 제네릭 사용이 가능하게 
 *        ---- 데이터형을 통일 
 *        ---- <클래스만> => <int>(X) => <Integer>
 *     => 8개의 기본을 클래스 
 *        byte   Byte 
 *        short  Short
 *        **int    Integer  parseInt
 *               -------
 *        **long   Long     parseLong
 *        float  Float 
 *        **double Double   parseDouble
 *        char   Character
 *               ---------
 *        **boolean Boolean parseBoolean
 *        
 *        =>  일부 기능을 직접 사용이 가능 만들었다 
 *        
 *     ==> 호환 
 *         Boxing 
 *           int num=100;
 *           Integer i=100; // 클래스에는 값이 아니라 => 주소 
 *         UnBoxing 
 *           Integer i=100;
 *           int ii=i;
 *        
 */
public class Wrapper_1 {
public static void main(String[] args) {
	int a=10;
	System.out.println(Integer.MAX_VALUE);
	System.out.println(Integer.MIN_VALUE);
	System.out.println(Integer.toBinaryString(a));  // 2진법 16진법 8진법
	System.out.println(Integer.toHexString(a));
	System.out.println(Integer.toOctalString(a));
	String s="100";
	System.out.println(Integer.parseInt(s));
	// 웹 / 윈도우 => 모든 데이터형이 String => 필요한 데이터형 변경 사용
}
}
