package com.github.siilas.pid.primeiro.trabalho.enums;

import lombok.Getter;

@Getter
public enum Environment {

	PROD("prod");
	
	private final String value;
	
	Environment(String value) {
		this.value = value;
	}
	
}
