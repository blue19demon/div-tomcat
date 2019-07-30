
package com.test.tag;

public abstract class TagSupport {
	
	public static final TagSupport FOREACH_TAG=new ForEachTag();
	public static final TagSupport OUT_TAG = new OutTag(); 
	public static final TagSupport CHOOSETAG_TAG = new ChooseTag(); 
	public abstract String tagName();
	
	public abstract String tagPrefix();
}
