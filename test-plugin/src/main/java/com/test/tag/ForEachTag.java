package com.test.tag;

/**
 * @author Administrator
 *
 */
public class ForEachTag extends BaseTagSupport {

	@Override
	public String tagName() {
		return "forEach";
	}

	@Override
	public String tagPrefix() {
		return "c";
	}

}
