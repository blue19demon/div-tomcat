package com.test.tools;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 *
 */
public class StringUtils {

	private static Pattern p = Pattern.compile("\\{[^\\}]*\\}");

	public static String fistCharUpperCase(String src) {
		return src.substring(0, 1).toUpperCase() + src.substring(1);
	}

	public static String str2Package(String src) {
		return src.substring(0, src.length() - ".xml".length()).replaceAll("/", ".");
	}

	public static String getStrValue(String src) {
		Matcher m = p.matcher(src);
		String rs = null;
		while (m.find()) {
			String item = src.substring(m.start(), m.end());
			rs = item.substring(1, item.length() - 1);
		}
		return rs;
	}

}