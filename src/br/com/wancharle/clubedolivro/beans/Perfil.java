package br.com.wancharle.clubedolivro.beans;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.wancharle.clubedolivro.domain.Leitura;

@Named
@RequestScoped
public class Perfil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4605219583364954447L;

	
	@Inject
	private Sessao sessao;
	
	private String situacao;
	
	@Inject
	private void loadLeituras(){
		jaLi();
	}
	
	public String vouLer(){
		setSituacao("Livros que vou ler");
		sessao.loadLeituras(Leitura.VOU_LER);	
		return "/perfil.faces";
	} 
	
	public String jaLi(){
		sessao.loadLeituras(Leitura.JA_LI);	
		setSituacao("Livros que já li");	
		return "/perfil.faces";
	} 
	public String estouLendo(){
		sessao.loadLeituras(Leitura.ESTOU_LENDO);	
		setSituacao("Livros que estou lendo");	
		return "/perfil.faces";
	} 
    public String abandonei(){
		sessao.loadLeituras(Leitura.ABANDONEI);	
		setSituacao("Livros que abandonei");	
		return "/perfil.faces";
	} 

    public String favoritos(){
    	sessao.loadLeiturasFavoritas();
		setSituacao("Meus Livros Favoritos");	
		return "/perfil.faces";
	} 

	public String getSituacao() {
		return situacao;
	}


	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
}
