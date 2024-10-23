package Fabricas;

public abstract class FabricaSprite {

	protected String rutaSprite;

	protected FabricaSprite(String rutaASprite) {
		this.rutaSprite=rutaASprite;
	}

	public Sprite[] spriteMario() {
		Sprite[] spriteMario= new Sprite[20];
		spriteMario[0]=new Sprite(rutaSprite + "/mario_inmovil_derecha.png");
		spriteMario[1]=new Sprite(rutaSprite + "/mario_inmovil_izquierda.png");
		spriteMario[2]=new Sprite(rutaSprite + "/mario_caminando_derecha.gif");
		spriteMario[3]=new Sprite(rutaSprite + "/mario_caminando_izquierda.gif");
		spriteMario[4]=new Sprite(rutaSprite + "/mario_saltando_derecha.png");
		spriteMario[5]=new Sprite(rutaSprite + "/mario_saltando_izquierda.png");
		spriteMario[6]=new Sprite(rutaSprite + "/mario_flor_inmovil_derecha.png");
		spriteMario[7]=new Sprite(rutaSprite + "/mario_flor_inmovil_izquierda.png");
		spriteMario[8]=new Sprite(rutaSprite + "/mario_flor_caminando_derecha.gif");
		spriteMario[9]=new Sprite(rutaSprite + "/mario_flor_caminando_izquierda.gif");
		spriteMario[10]=new Sprite(rutaSprite + "/mario_flor_saltando_derecha.png");
		spriteMario[11]=new Sprite(rutaSprite + "/mario_flor_saltando_izquierda.png");
		spriteMario[12]=new Sprite(rutaSprite + "/super_mario_inmovil_derecha.png");
		spriteMario[13]=new Sprite(rutaSprite + "/super_mario_inmovil_izquierda.png");
		spriteMario[14]=new Sprite(rutaSprite + "/super_mario_caminando_derecha.gif");
		spriteMario[15]=new Sprite(rutaSprite + "/super_mario_caminando_izquierda.gif");
		spriteMario[16]=new Sprite(rutaSprite + "/super_mario_saltando_derecha.png");
		spriteMario[17]=new Sprite(rutaSprite + "/super_mario_saltando_izquierda.png");
        //agrego sprites de invencible
		spriteMario[18]=new Sprite(rutaSprite + "/mario_invencible_derecha.gif");
		spriteMario[19]=new Sprite(rutaSprite + "/mario_invencible_inmovil_izquierda.gif");


		return spriteMario;
	}

	public Sprite[] spriteBuzzyBeetle() {
		Sprite[] spriteBuzzyBeetle=new Sprite[2];
		spriteBuzzyBeetle[0]=new Sprite(rutaSprite + "/buzzy_beetle_derecha.gif");
		spriteBuzzyBeetle[1]=new Sprite(rutaSprite + "/buzzy_beetle_izquierda.gif");
		return spriteBuzzyBeetle;
	}

	public Sprite[] spriteGoomba() {
		Sprite[] spriteGoomba=new Sprite[1];
		spriteGoomba[0]=new Sprite(rutaSprite + "/goomba.gif");
		return spriteGoomba;
	}

	public Sprite[] spriteSpiny() {
		Sprite[] spriteSpiny=new Sprite[2];
		spriteSpiny[0]=new Sprite(rutaSprite + "/spiny-derecha.gif");
		spriteSpiny[1]=new Sprite(rutaSprite + "/spiny-izquierda.gif");
		return spriteSpiny;
	}

	public Sprite[] spriteLakitu() {
		Sprite[] spriteLakitu=new Sprite[3];
		spriteLakitu[0]=new Sprite(rutaSprite + "/lakitu_derecha.gif");
		spriteLakitu[1]=new Sprite(rutaSprite + "/lakitu_izquierda.gif");
		return spriteLakitu;
	}

	public Sprite[] spriteKoopaTroopa() {
		Sprite[] spriteKoopaTroopa=new Sprite[6];
		spriteKoopaTroopa[0]=new Sprite(rutaSprite + "/koopa_troopa_derecha.gif");
		spriteKoopaTroopa[1]=new Sprite(rutaSprite + "/koopa_troopa_izquierda.gif");
		spriteKoopaTroopa[2]=new Sprite(rutaSprite + "/koopa_troopa_caparazon.png");
		return spriteKoopaTroopa;
	}

	public Sprite[] spritePiranhaPlant() {
		Sprite[] spritePiranhaPlant=new Sprite[1];
		spritePiranhaPlant[0]=new Sprite(rutaSprite + "/piranha_plant.gif");
		return spritePiranhaPlant;
	}

	public Sprite[] spriteBloqueDePregunta() {
		Sprite[] spriteBloqueDePregunta=new Sprite[1];
		spriteBloqueDePregunta[0]=new Sprite(rutaSprite + "/bloque_de_pregunta.gif");
		return spriteBloqueDePregunta;
	}

	public Sprite[] spriteBloqueSolido() {
		Sprite[] spriteBloqueSolido=new Sprite[1];
		spriteBloqueSolido[0]=new Sprite(rutaSprite + "/bloque_solido.png");
		return spriteBloqueSolido;
	}

	public Sprite[] spriteVacio() {
		Sprite[] spriteVacio=new Sprite[1];
		spriteVacio[0]=new Sprite(rutaSprite + "/vacio.png");
		return spriteVacio;
	}

	public Sprite[] spriteTuberia() {
		Sprite[] spriteTuberia=new Sprite[1];
		spriteTuberia[0]=new Sprite(rutaSprite + "/tuberia.png");
		return spriteTuberia;
	}

	public Sprite[] spriteLadrilloSolido() {
		Sprite[] spriteLadrilloSolido=new Sprite[1];
		spriteLadrilloSolido[0]=new Sprite(rutaSprite + "/ladrillo_solido.png");
		return spriteLadrilloSolido;
	}

	public Sprite[] spriteMoneda() {
		Sprite[] spriteMoneda=new Sprite[1];
		spriteMoneda[0]=new Sprite(rutaSprite + "/moneda.gif");
		return spriteMoneda;
	}

	public Sprite[] spriteFlorDeFuego() {
		Sprite[] spriteFlorDeFuego=new Sprite[1];
		spriteFlorDeFuego[0]=new Sprite(rutaSprite + "/flor_de_fuego.gif");
		return spriteFlorDeFuego;
	}

	public Sprite[] spriteEstrella() {
		Sprite[] spriteEstrella=new Sprite[1];
		spriteEstrella[0]=new Sprite(rutaSprite + "/estrella.gif");
		return spriteEstrella;
	}

	public Sprite[] spriteChampinionVerde() {
		Sprite[] spriteChampinionVerde=new Sprite[1];
		spriteChampinionVerde[0]=new Sprite(rutaSprite + "/champinion_verde.png");
		return spriteChampinionVerde;
	}

	public Sprite[] spriteSuperChampinion() {
		Sprite[] spriteSuperChampinion=new Sprite[1];
		spriteSuperChampinion[0]=new Sprite(rutaSprite + "/super_champinion.png");
		return spriteSuperChampinion;
	}

	public Sprite[] spriteBolaDeFuego() {
		Sprite[] spriteBolaDeFuego=new Sprite[1];
		spriteBolaDeFuego[0]=new Sprite(rutaSprite + "/bola_de_fuego.gif");
		return spriteBolaDeFuego;
	}


}
