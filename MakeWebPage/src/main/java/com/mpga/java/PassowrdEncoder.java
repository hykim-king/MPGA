package com.mpga.java;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassowrdEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String rawPassword = "pcwkpcwk";
		String encodedPassword = encoder.encode(rawPassword);
		
		System.out.println(encodedPassword);

	}

}
