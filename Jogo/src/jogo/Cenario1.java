package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario1 extends Cenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	private Zumbi zumbi;
	
	public Cenario1(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario1.scn"));
		jogador = new Jogador(140,150);
		teclado = janela.getKeyboard();
		zumbi = new Zumbi(300,300);
		
		//Som.play(""); // som do jogo (adcionar) 
		run();
	}

	private void run() {
		while(true) {
			jogador.mover(janela,teclado);
			jogador.caminho(cena);
			//
			zumbi.caminho(cena);
			zumbi.perseguir(jogador.x, jogador.y);
			//
			cena.moveScene(jogador);
			
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			
			zumbi.x += cena.getXOffset();
			zumbi.y += cena.getYOffset();
			
			jogador.draw();
			zumbi.draw();
			//
			jogador.atirar(janela, cena, teclado, zumbi);
			zumbi.morrer();
			//
			janela.update();
			janela.delay(10);
			mudarCenario();
		}
	}
	
	private void mudarCenario() {
		if(tileCollision(15, jogador, cena)==true) {
			new Cenario2(janela);
		}
	}
}
