package com.testscripts;



	import java.util.HashMap;
	import java.util.Map.Entry;



	public class PalindromeHashMap {
	    public static void main(String[] args) {
	        String str="mom dad children mom dad dad";
	        String[] s1 = str.split(" ");
	        HashMap<String,Integer> hm = new HashMap<String, Integer>();
	        int max=0;
	      
	        for (int i=0;i<s1.length;i++)
	        {
	        	String rev = "";
	            String main=s1[i];
	            for (int j=0;j<main.length();j++)
	            {
	                rev=main.charAt(j)+rev;
	            }
	            if(main.equals(rev))
	            {
	                System.out.println("The palindrome are: "+main);
	                if(!hm.containsKey(main))
	                {
	                    hm.put(main,1);
	                }
	                else{
	                    int value=hm.get(main);
	                    hm.put(main,value+1);
	                    if(value+1>max)
	                    max=value+1;
	                }
	            }
	        }
	      
	        for( Entry<String, Integer> e:hm.entrySet())
	        {
	           if(e.getValue()==max)
	           {
	            System.out.println(e.getKey());
	           }
	        }
	        System.out.println(max);
	        System.out.println(hm);

	    }
	}


