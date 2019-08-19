package com.doheum.board.model;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("board")
public class BoardVO {
	private int i;
	private String title;
	private String content;
	private String r_datetime;
}
