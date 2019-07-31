
package com.test;

/**
 * @author Administrator
 *
 */
public class Kv {
	private Integer id;
	private String key;
	private String value;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Kv() {
		super();
	}
	public Kv(String key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
	public Kv(Integer id, String key, String value) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
	}
	
}
