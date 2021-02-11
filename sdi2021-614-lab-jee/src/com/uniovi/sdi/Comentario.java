package com.uniovi.sdi;

public class Comentario {
private String texto;
private String author;
public Comentario() {
	
}
public Comentario(String texto, String author) {
	this.texto = texto;
	this.author = author;
}
public String getTexto() {
	return texto;
}
public void setTexto(String texto) {
	this.texto = texto;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
}
