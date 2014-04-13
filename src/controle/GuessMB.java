package controle;

import java.util.Random;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class GuessMB {

	private int numeroSecreto;
	private int tentativa;
	private Integer numeroTentativa;
	private String mensagem;
 
	public GuessMB() {
		geraNumeroAleatorio();
	}

	public String validaNumero(){
		if (tentativaValida()) {
			if (achouNumero()) {
				this.mensagem = "Parabéns, é mesmo, o número secreto é "+ this.numeroSecreto;
				geraNumeroAleatorio(); 
			}else{
				this.mensagem = "Você errou, tente novamente!";
			}
		}else{
			this.mensagem = "Infelizmente você não achou o número secreto que era "+ numeroSecreto;
			this.mensagem += " Tente de novo!";
			geraNumeroAleatorio(); 
		}
		this.numeroTentativa = null;
		return "index";
	}
	
	private boolean achouNumero() {
		if(this.numeroTentativa == numeroSecreto)
			return true;
		return false;
	}

	private boolean tentativaValida() {
		if(this.tentativa  < 2){
			this.tentativa++;
			return true;
		}
		return false;
	}

	private void geraNumeroAleatorio() {
		this.tentativa = 0;
		this.numeroSecreto = new Random().nextInt(10);
	}

	public int getNumeroSecreto() {
		return numeroSecreto;
	}

	public void setNumeroSecreto(int numeroSecreto) {
		this.numeroSecreto = numeroSecreto;
	}

	public Integer getNumeroTentativa() {
		return numeroTentativa;
	}

	public void setNumeroTentativa(Integer numeroTentativa) {
		this.numeroTentativa = numeroTentativa;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getTentativa() {
		return tentativa;
	}
	
	
}
