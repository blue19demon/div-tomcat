
package com.test.tag;

public abstract class TagSupport {
	
	public static final TagSupport FOREACH_TAG=new ForEachTag();
	public static final TagSupport OUT_TAG = new OutTag(); 
	public static final TagSupport CHOOSE_TAG = new ChooseTag(); 
	public static final TagSupport IF_TAG = new IfTag(); 
	public abstract String tagName();
	
	public abstract String tagPrefix();
}
