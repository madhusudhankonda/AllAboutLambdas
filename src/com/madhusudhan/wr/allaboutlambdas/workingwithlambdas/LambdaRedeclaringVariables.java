package com.madhusudhan.wr.allaboutlambdas.workingwithlambdas;

public class LambdaRedeclaringVariables {

	private static String className = "Class Name";
	
	public interface IComponent{
		String name();
	}
	
	private void testComp(IComponent comp) {
		System.out.println("Name: "+comp.name());
	}
	private void testLocalVariable() {
		  final String myName = "Modified Name";;
		  IComponent cc = () -> {
		    // Error! Redeclaring the variable
//		    String myName = null;    
		    return myName;
		  };
		}

	private void getDefaultName() {
		
	}

	public static void main(String[] args) {
		LambdaRedeclaringVariables scope = new LambdaRedeclaringVariables();
		
		IComponent comp = () -> "Default Name";
		scope.testComp(comp);
		String name = "Main Name";
		IComponent comp1 = () -> {return name;};
		scope.testComp(comp1);
		IComponent comp2 = () -> {return className;};
		scope.testComp(comp2);
	}
	
}
