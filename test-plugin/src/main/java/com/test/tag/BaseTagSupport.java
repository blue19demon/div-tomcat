
package com.test.tag;

/**
 * @author Administrator
 *
 */
public abstract class BaseTagSupport {
	
	public static final BaseTagSupport FOREACH_TAG=new ForEachTag();
	public static final BaseTagSupport OUT_TAG = new OutTag(); 
	public static final BaseTagSupport CHOOSE_TAG = new ChooseTag(); 
	public static final BaseTagSupport IF_TAG = new IfTag(); 
	/**
     * 标签名
     * @return xxx
     */
	public abstract String tagName();
	/**
     * 标签前缀
     * @return xxx
     */
	public abstract String tagPrefix();
}
