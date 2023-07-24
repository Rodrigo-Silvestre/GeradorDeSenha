package modelo;

import java.util.Random;

public class GeradorDeSenha {

	private String senha;
	private int tamanhoDaSenha;
	private boolean numero;
	private boolean caracter;
	private boolean caracteresEspeciais;
	private final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final String NUMEROS = "1234567890";
	private final String CARACTERESESPECIAIS = "Çç!@#%&*()-_=+[{}]\\|<>,.;:?/'";
	
	public GeradorDeSenha() { }
	
	public void gerarSenha() {
		if (!verificacao()) return;
		Random gerador = new Random();
		String senha = "";
		String mergeCaracters = "";
		if (caracter && numero && caracteresEspeciais) {
			mergeCaracters = CARACTERES + NUMEROS + CARACTERESESPECIAIS;
		}
		else {
			if (caracter && numero) {
				mergeCaracters = CARACTERES + NUMEROS;
			}
			else {
				if (caracter && caracteresEspeciais) {
					mergeCaracters = CARACTERES + CARACTERESESPECIAIS;
				}
				else {
					if (numero && caracteresEspeciais) {
						mergeCaracters = NUMEROS + CARACTERESESPECIAIS;
					}
					else {
						if (caracter) {
							mergeCaracters = CARACTERES;
						}
						else {
							if (numero) {
								mergeCaracters = NUMEROS;
							}
							else {
								mergeCaracters = CARACTERESESPECIAIS;
							}
						}
					}
				}
			}
		}
		int indice;
		for (int i = 0; i < tamanhoDaSenha; i++) {
			indice = gerador.nextInt(mergeCaracters.length());
			senha += (char) mergeCaracters.charAt(indice);
		}
		this.senha = senha;
	}
	
	public String getSenha() {
		if (this.senha == null) {
			gerarSenha();
		}
		return senha;
	}

	public int getTamanhoDaSenha() {
		return tamanhoDaSenha;
	}

	public void setTamanhoDaSenha(int tamanhoDaSenha) {
		if (tamanhoDaSenha >= 1 && tamanhoDaSenha <= 50) {
			this.tamanhoDaSenha = tamanhoDaSenha;	
		}
	}

	public boolean isNumero() {
		return numero;
	}

	public void setNumero(boolean numero) {
		this.numero = numero;
	}

	public boolean isCaracter() {
		return caracter;
	}

	public void setCaracter(boolean caracter) {
		this.caracter = caracter;
	}

	public boolean isCaracteresEspeciais() {
		return caracteresEspeciais;
	}

	public void setCaracteresEspeciais(boolean caracteresEspeciais) {
		this.caracteresEspeciais = caracteresEspeciais;
	}

	private boolean verificacao() {
		if (getTamanhoDaSenha() < 1) return false;
		if (!isNumero() && !isCaracter() && !isCaracteresEspeciais()) return false;
		return true;
	}
}
