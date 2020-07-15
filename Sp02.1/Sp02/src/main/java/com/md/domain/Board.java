package com.md.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

	private int seq;
	private String writer;
	private String email;
	private String subject;
	private String content;
	private Date rdate;
	
}
