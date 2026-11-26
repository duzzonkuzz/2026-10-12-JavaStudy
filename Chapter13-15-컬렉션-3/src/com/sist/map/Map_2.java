package com.sist.map;
import java.util.*;


public class Map_2 {
public static void main(String[] args) {
	Map<String,String> map=new HashMap<String, String>();
	map.put("boardList", "SELECT * From board");
	map.put("boardDetail", "Detail * From board");
	map.put("boardInsert", "SInsert * From board");
	map.put("boardUpdate", "Update * From board");
	map.put("boardDelete", "Detlete * Detlete");
	
	Set<String> set=map.keySet();
	for(String key:set)
	{
		System.out.println(key+":"+map.get(key));
	}
}
}
