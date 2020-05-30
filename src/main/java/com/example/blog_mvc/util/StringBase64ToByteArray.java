package com.example.blog_mvc.util;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringBase64ToByteArray implements Converter<String, byte[]> {

	@Override
	public byte[] convert(String source) {
		byte[] byteSource = null;
		System.out.println("StringBase64ToByteArray is called");
		try {
			byteSource = Base64.getEncoder().encode(source.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return byteSource;
	}
}
