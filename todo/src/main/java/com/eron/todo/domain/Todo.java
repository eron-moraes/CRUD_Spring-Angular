package com.eron.todo.domain;

import java.time.LocalDateTime;

public class Todo {
	
	private Integer id;
	private String titulo;
	private String descricao;
	private LocalDateTime dataParaFinalizar;
	private Boolean finalizado = false;
	public Todo(Integer id, String titulo, String descricao, LocalDateTime dataParaFinalizar, Boolean finalizado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataParaFinalizar = dataParaFinalizar;
		this.finalizado = finalizado;
	}
	
	

}
