package com.md.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // dto구나 인식하게 만듦.
@AllArgsConstructor // 필드로 만든 생성자 생성.
@NoArgsConstructor // 기본생성자 생성.
public class Address {
	private long seq;
	private String name;
	private String addr;
	private Date rdate;
}
