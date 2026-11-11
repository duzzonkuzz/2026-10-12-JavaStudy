package com.sist.wrapper;
/*
 *   int Integer / double Double / boolean Boolean 
 *   => float Float => Spring AI 
 *   => 유사도 검사 
 *      ======== 문자를 float을 변경 => RAG 
 *   char[] => String 
 *   
 *   => Wrapper는 기본형 / 클래스 
 */
public class Wrapper_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        double d=10.5;
        Integer i=(int)d; // Wrapper클래스의 형변환은 기본형으로 사용
        System.out.println(i);
        /*
         *   형변환 => 기본형으로 형변환 
         *   정수변환 : Integer.parseInt("10")
         *   실수변환 : Double.parseDouble("10.5")
         *   논리변환 : Boolean.parseBoolean("true")
         *   
         *    ==> IS NOT NULL
         */
        String[] s={"100","20","1","5",null};
        for(String ss:s)
        {
        	if(ss!=null)
        	{
        	  Integer a=Integer.parseInt(ss);
        	  System.out.println(a);
        	}
        }
	}

}