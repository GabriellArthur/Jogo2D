package jogo;

import jplay.Sprite;
import jplay.URL;

public class Tiro extends Sprite{
	
	public static final int LEFT = 1, RIGHT = 2, STOP = 3, UP = 4, DOWN = 5;
	protected static final int VELICIDADE_TIRO = 20;
	protected int caminho = STOP;
	protected boolean movendo = false;
	protected int direcao = 3;
	
	public Tiro(double x, double y, int caminho) {
		super(URL.sprite("flecha.png"),12);
		this.caminho = caminho;
		this.x = x;
		this.y = y;
	}
	
	public void mover() {
		if(caminho == LEFT) {
			this.x -= VELICIDADE_TIRO;
			if(direcao != 1) {
				setSequence(3, 6);
			}
			movendo = true;
		}
		if(caminho == RIGHT) {
			this.x += VELICIDADE_TIRO;
			if(direcao != 2) {
				setSequence(6, 9);
			}
			movendo = true;
		}
		if(caminho == UP) {
			this.y -= VELICIDADE_TIRO;
			if(direcao != 4) {
				setSequence(9, 12);
			}
			movendo = true;
		}
		if(caminho == DOWN ||caminho == STOP ) {
			this.y += VELICIDADE_TIRO;
			if(direcao != 5) {
				setSequence(0, 3);
			}
			movendo = true;
		}
		if(movendo) {
			update();
			movendo = false;
		}
	}
}
