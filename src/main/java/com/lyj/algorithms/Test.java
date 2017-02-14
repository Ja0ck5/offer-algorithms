package com.lyj.algorithms;


public class Test { 
		//1
        private static int a; 
        private int b; 
        
        public Test() {
			super();
			System.out.println("construct:Test5");
		}
		//2
        static { 
                Test.a = 3; 
                System.out.println(a); 
//                Test t = new Test(); 
//                t.f(); 
//                t.b = 1000; 
//                System.out.println(t.b); 
        } 
        //3
        static { 
                Test.a = 4; 
                System.out.println(a); 
        } 
        
        public static void main(String[] args) { 
//        	System.out.println("main");
        	Test test = new Test();
        } 
        //4
        static { 
                Test.a = 5; 
                System.out.println(a); 
        } 
        
        public void f() { 
                System.out.println("hhahhahah"); 
        } 
}