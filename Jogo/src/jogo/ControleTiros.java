package jogo;

import java.util.LinkedList;

import jplay.Scene;

public class ControleTiros {

	LinkedList<Tiro> tiros = new LinkedList<>();
	
	public void adicionaTiro(double x,double y, int caminho, Scene cena) {
		Tiro tiro = new Tiro(x, y, caminho);
		tiros.addFirst(tiro);
		cena.addOverlay(tiro);
		somDisparo();
	}
	
	public void run(Ator inimigo) {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
			
			if (tiro.collided(inimigo)) {
				tiro.x = 10_000;
				inimigo.energia -= 250;
			}
		}
	}
	//Polimorfismo de sobrecarga
	public void run() {
		for (int i = 0; i < tiros.size(); i++) {
			Tiro tiro = tiros.removeFirst();
			tiro.mover();
			tiros.addLast(tiro);
		}
	}
	
	private void somDisparo() {
		Som.sonsTemporarios("flecha.wav");
	}
}
