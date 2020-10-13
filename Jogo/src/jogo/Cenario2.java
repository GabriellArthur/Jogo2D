package jogo;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;

public class Cenario2 extends Cenario{
	
	private Window janela;
	private Scene cena;
	private Jogador jogador;
	private Keyboard teclado;
	
	public Cenario2(Window window) {
		janela = window;
		cena = new Scene();
		cena.loadFromFile(URL.scenario("Cenario2.scn"));
		jogador = new Jogador(140,150);
		teclado = janela.getKeyboard();
		run();
	}

	private void run() {
		while(true) {
			jogador.mover(janela,teclado);
			jogador.caminho(cena);
			cena.moveScene(jogador);
			jogador.x += cena.getXOffset();
			jogador.y += cena.getYOffset();
			jogador.draw();
			jogador.atirar(janela, cena, teclado);
			janela.update();
			janela.delay(5);
		}
	}
}
