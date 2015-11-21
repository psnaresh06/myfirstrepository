package javapractice;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorPractice {

	public static void main(String[] args) {
		Set<String> s=new HashSet<>();
        s.add("abc");
        s.add("xyz");
        System.out.println(s.size());
        Iterator<String> it=s.iterator();
        while(it.hasNext())
        {
        	System.out.println(it.next());
        }
	}

}
