package it.polito.tdp.parole.model;

import java.util.*;
import java.util.stream.Collectors;

public class Parole {
	
	TreeMap <String,String> IP;
	public Parole() {
		//TODO
		IP=new TreeMap <String,String> ();
	}

	public void addParola(String p) {
    IP.put(p,p);
	}
	
	public List<String> getElenco() {
		//TODO	
		List <String> a= new ArrayList <String> (IP.values());
		return a;
	}
	
	public void reset() {
		// TODO
		IP.clear();
	}
	
	public boolean contieneParola(String s) {
		if(IP.containsKey(s))
	    return true;
		return false;
	}
	
	public void eliminaParola(String s) {
		IP.remove(s);
	}
	//METODO PER PASSARE DA I VALUES DI UNA MAPPA A UNA LINKED LIST
	//METODO PER PASSARE DA UNA LINKED LIST ALLA SUA DESCRIZIOINE A STRINGA;
	
	public String toString() {
		String cercata="";
    List <String> a= new ArrayList <String> (IP.values());  
    LinkedList <String> b=new LinkedList <String>();
    for(int i=0;i<a.size();i++)
    	b.add(a.get(i));
    for (String s1:b)
    	cercata+=s1+"\n";
	return cercata;
	}
}
