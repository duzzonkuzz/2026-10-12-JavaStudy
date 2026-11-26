package com.sist.map;
import java.util.*;
//클래ㅑ스 관리
interface I
{
	public void excute();
}
class A implements I
{

	@Override
	public void excute() {
		// TODO Auto-generated method stub
		System.out.println("A call");
	}}
	class B implements I
	{

		@Override
		public void excute() {
			// TODO Auto-generated method stub
			System.out.println("B call");
		}}
		class C implements I
		{
		
			@Override
			public void excute() {
				// TODO Auto-generated method stub
				System.out.println("C call");
			}}
			class D implements I
			{

				@Override
				public void excute() {
					// TODO Auto-generated method stub
					System.out.println("D call");
					
				}}
				//Spring
				class Container
				{
					Map<String, I> map = new HashMap<String, I>();
			// XML => class, id
					public Container()
					{
						map.put("a", new A());
						map.put("b", new B());
						map.put("c", new C());
						map.put("d", new D());
					}
					public I getBeen(String key)
					{
						return map.get(key);
					}
				
				}
public class Map_3 {
public static void main(String[] args) {
	Container c=new Container();
	I i=c.getBeen("a");
	System.out.println("i"+i);
	i.excute();
	
	 i=c.getBeen("b");
	 System.out.println("i"+i);
	i.excute();
	
	 i=c.getBeen("c");
	System.out.println("i"+i);
	i.excute();
	
	 i=c.getBeen("d");
	 System.out.println("i"+i);
	i.excute();
}
}