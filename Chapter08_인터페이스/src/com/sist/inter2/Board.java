package com.sist.inter2;

public interface Board {
public void write();
public void list();
public void detail();
public void update();
public void delete();
public default void paging()
{
	
}



}
