
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;


import java.io.Serializable;

import excepciones.PaginaYaExisteException;

public class Album implements Serializable,Constantes {
	
	/**
	 * Relacion con la primera pagina del album.
	 */
	private Pagina primero;
	
	/**
	 * Relacion con la ultima pagina del album.
	 */
	private Pagina ultimo;
	
	/**
	 * cantidad de paginas del album.
	 */
	private int cantidad;
	
	/**
	 * Relacion con la pagina actual del album.
	 */
	private Pagina actual;

	/**
	 * Constructor de la clase album.
	 */
	public Album() {

		primero = ultimo = null;
		cantidad = 0;
        
        
        try {
			rellenarAlbum();
		} catch (PaginaYaExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}
	
	/**
	 * Modifica la pagina actual del album.
	 * 	<b> post: </b> La pagina actual ha sido modificada.
	 * @param actual - nueva pagina actual.
	 */
	public void setActual(Pagina actual) {
		
	this.actual = actual;	
		
	}
	
	/**
	 * Entrega la pagina actual del album.
	 * @return Pagina actual del album.
	 */
	public Pagina getActual() {
		
	return actual;	
		
	}

	/**
	 * Modifica la ultima pagina del album.
	 * 		<b> post: </b> La pagina ultima ha sido modificada.
	 * @param ultimo - la nueva ultima pagina del album.
	 */
	public void setUltimo(Pagina ultimo) {

		this.ultimo = ultimo;

	}
    
	/**
	 * Entrega la pagina ultima del album.
	 * @return Pagina actual del album.
	 */
	public Pagina getUltimo() {

		return ultimo;

	} 
     

	/**
	 * Modifica la ultima pagina del album.
	 * 	 	<b> post: </b> La pagina ultima ha sido modificada.
	 * @param ultimo - La nueva ultima pagina del album.
	 */
	public void setPrimero(Pagina primero) {

		this.primero = primero;

	}
     
	 
	/**
	 * Entrega la pagina primera del album.
	 * @return Pagina primera del album.
	 */
	public Pagina getPrimero() {

		return primero;

	}
	
	

	/**
	 * Entrega la cantidad de paginas del album.
	 * @return cantidid de paginas.
	 */ 
	public int getCantidad() {

		return cantidad;

	}
	
	/**
	 * Verifica si el album esta vacio.
	 * @return true, si el album esta vacio - false, si no lo esta.
	 */
	public boolean isEmpty() {
		
	return primero==null;	
		
	}

	/**
	 * El metodo agrega una nueva pagina al album.<br>
	 *  <b> pre: </b> nuevo != null <br>
	 * <b> post: </b> La pagina es agregada correctamente.
	 * @param nuevo - La nueva pagina que se desea agregar.<br>
	 * @return La nueva pagina que se va a agregar.
	 * @throws PaginaYaExisteException - Se lanza cuando la pagina ya existe en el album.
	 */
	public Pagina agregarPagina(Pagina nuevo) throws PaginaYaExisteException {


	if (isEmpty()) {

		primero = ultimo = nuevo;
		primero.setSiguiente(ultimo);
			primero.setAnterior(ultimo);
			ultimo.setSiguiente(primero);
			ultimo.setAnterior(primero);
			cantidad++;

		} else {

			if (yaExiste(nuevo.getSeleccion())) {

			throw new PaginaYaExisteException(nuevo.getSeleccion());

			} else {

				ultimo.setSiguiente(nuevo);
				Pagina temp = ultimo;
				ultimo = nuevo;
				ultimo.setSiguiente(primero);
				primero.setAnterior(ultimo);
				ultimo.setAnterior(temp);
				cantidad++;
		}
		}

		return nuevo;

	}
      
	/**
	 * El metodo verifica si un pais en particular ya existe o no.
	 * @param pais - el pais que se verificara.
	 * @return true si el pais ya existe, false si el pais no existe.
	 */
	public boolean yaExiste(String pais) {

		boolean existe = false;

		int i = 0;

		Pagina Pagina = primero;

		if (Pagina != null) {
			while ((!(Pagina.getSeleccion()).equalsIgnoreCase(pais)) && i != cantidad && Pagina.getSiguiente() != null) {

				Pagina = Pagina.getSiguiente();
				i++;
 

				if (Pagina.getSeleccion().equalsIgnoreCase(pais)) {

					existe = true;
	                   }
			}

		}
		return existe;

	}

//	public Pagina buscarPagina(String pais)
//			throws PaginaNoRegistradaException, NoHayPaginaesRegistradasException {
//
//		Pagina sel = null;
//		int i = 0;
//
//		if (primero == null) {
//
//			throw new NoHayPaginaesRegistradasException();
//
//		} else {
//
//			if (yaExiste(pais)) {
//
//				if (primero.getPais().equalsIgnoreCase(pais)) {
//
//					sel = primero;
//
//				} else {
//
//					Pagina actual = primero.getNext();
//
//					if (actual != null) {
//						while ((!(actual.getPais().equalsIgnoreCase(pais)) && i != cantidad)
//								&& actual.getNext() != null) {
//
//							actual = actual.getNext();
//							i++;
//
//						}
//
//						if (actual.getPais().equalsIgnoreCase(pais)) {
//							sel = actual;
//						}
//
//					}
//				}
//			} else {
//
//				throw new PaginaNoRegistradaException(pais);
//
//			}
//		}
//		return sel;
//
//	}
//

//
//	public void modificarPagina(Pagina aModificar, String pais, String imagen, int puntos)
//			throws PaisYaExisteException {
//
//		if (yaExiste(pais) && !aModificar.getPais().equals(pais)) {
//
//			throw new PaisYaExisteException(pais);
//
//		} else {
//
//			aModificar.setPais(pais);
//			aModificar.setImagen(imagen);
//			aModificar.setPuntos(puntos);
//		}
//	}
	
	
	/**
	 * Este metodo se encargar de inicializar el album con sus respectivas paginas y laminas.<br>
	 * 
	 * @throws PaginaYaExisteException - cuando se trata de inicializar una pagina que ya existe.
	 */
	public void rellenarAlbum() throws PaginaYaExisteException {
		
		//Rusia
		Pagina rusia=new Pagina("./Archivos/imagenes/banderasRec/rusiaRec.png", "Rusia", 1, "Grupo A");
		rusia.getLaminas()[0]=Constantes.lAMINAS[0];
		rusia.getLaminas()[1]=Constantes.lAMINAS[1];
		rusia.getLaminas()[2]=Constantes.lAMINAS[2];
		rusia.getLaminas()[3]=Constantes.lAMINAS[3];
		rusia.getLaminas()[4]=Constantes.lAMINAS[4];
		rusia.getLaminas()[5]=Constantes.lAMINAS[5];
		rusia.getLaminas()[6]=Constantes.lAMINAS[6];
		rusia.getLaminas()[7]=Constantes.lAMINAS[7];
		rusia.getLaminas()[8]=Constantes.lAMINAS[8];
		rusia.getLaminas()[9]=Constantes.lAMINAS[9];
		rusia.getLaminas()[10]=Constantes.lAMINAS[10];
		
		
		//Arabia Saudita
		Pagina arabia=new Pagina("./Archivos/imagenes/banderasRec/arabia sauditaRec.png","Arabia Saudita", 2,"Grupo A");
		arabia.getLaminas()[0]=Constantes.lAMINAS[11];
		arabia.getLaminas()[1]=Constantes.lAMINAS[12];
		arabia.getLaminas()[2]=Constantes.lAMINAS[13];
		arabia.getLaminas()[3]=Constantes.lAMINAS[14];
		arabia.getLaminas()[4]=Constantes.lAMINAS[15];
		arabia.getLaminas()[5]=Constantes.lAMINAS[16];
		arabia.getLaminas()[6]=Constantes.lAMINAS[17];
		arabia.getLaminas()[7]=Constantes.lAMINAS[18];
		arabia.getLaminas()[8]=Constantes.lAMINAS[19];
		arabia.getLaminas()[9]=Constantes.lAMINAS[20];
		arabia.getLaminas()[10]=Constantes.lAMINAS[21];
		
		//Egipto
		Pagina egipto=new Pagina("./Archivos/imagenes/banderasRec/egiptoRec.png","Egipto",3,"Grupo A");
		egipto.getLaminas()[0]=Constantes.lAMINAS[22];
		egipto.getLaminas()[1]=Constantes.lAMINAS[23];
		egipto.getLaminas()[2]=Constantes.lAMINAS[24];
		egipto.getLaminas()[3]=Constantes.lAMINAS[25];
		egipto.getLaminas()[4]=Constantes.lAMINAS[26];
		egipto.getLaminas()[5]=Constantes.lAMINAS[27];
		egipto.getLaminas()[6]=Constantes.lAMINAS[28];
		egipto.getLaminas()[7]=Constantes.lAMINAS[29];
		egipto.getLaminas()[8]=Constantes.lAMINAS[30];
		egipto.getLaminas()[9]=Constantes.lAMINAS[31];
		egipto.getLaminas()[10]=Constantes.lAMINAS[32];
		

		
		//Uruguay
		Pagina uruguay=new Pagina("./Archivos/imagenes/banderasRec/uruguayRec.png","Uruguay",4,"Grupo A");
		uruguay.getLaminas()[0]=Constantes.lAMINAS[33];
		uruguay.getLaminas()[1]=Constantes.lAMINAS[34];
		uruguay.getLaminas()[2]=Constantes.lAMINAS[35];
		uruguay.getLaminas()[3]=Constantes.lAMINAS[36];
		uruguay.getLaminas()[4]=Constantes.lAMINAS[37];
		uruguay.getLaminas()[5]=Constantes.lAMINAS[38];
		uruguay.getLaminas()[6]=Constantes.lAMINAS[39];
		uruguay.getLaminas()[7]=Constantes.lAMINAS[40];
		uruguay.getLaminas()[8]=Constantes.lAMINAS[41];
		uruguay.getLaminas()[9]=Constantes.lAMINAS[42];
		uruguay.getLaminas()[10]=Constantes.lAMINAS[43];
		
		

		
		//Portugal
		Pagina portugal=new Pagina("./Archivos/imagenes/banderasRec/portugalRec.png","Portugal",5,"Grupo B");
		portugal.getLaminas()[0]=Constantes.lAMINAS[44];
		portugal.getLaminas()[1]=Constantes.lAMINAS[45];
		portugal.getLaminas()[2]=Constantes.lAMINAS[46];
		portugal.getLaminas()[3]=Constantes.lAMINAS[47];
		portugal.getLaminas()[4]=Constantes.lAMINAS[48];
		portugal.getLaminas()[5]=Constantes.lAMINAS[49];
		portugal.getLaminas()[6]=Constantes.lAMINAS[50];
		portugal.getLaminas()[7]=Constantes.lAMINAS[51];
		portugal.getLaminas()[8]=Constantes.lAMINAS[52];
		portugal.getLaminas()[9]=Constantes.lAMINAS[53];
		portugal.getLaminas()[10]=Constantes.lAMINAS[54];
		
		//Espa�a
		Pagina espana=new Pagina("./Archivos/imagenes/banderasRec/espanaRec.png","Espana",6,"Grupo B");
		espana.getLaminas()[0]=Constantes.lAMINAS[55];
		espana.getLaminas()[1]=Constantes.lAMINAS[56];
		espana.getLaminas()[2]=Constantes.lAMINAS[57];
		espana.getLaminas()[3]=Constantes.lAMINAS[58];
		espana.getLaminas()[4]=Constantes.lAMINAS[59];
		espana.getLaminas()[5]=Constantes.lAMINAS[60];
		espana.getLaminas()[6]=Constantes.lAMINAS[61];
		espana.getLaminas()[7]=Constantes.lAMINAS[62];
		espana.getLaminas()[8]=Constantes.lAMINAS[63];
		espana.getLaminas()[9]=Constantes.lAMINAS[64];
		espana.getLaminas()[10]=Constantes.lAMINAS[65];
		
		//Marruecos
		Pagina marruecos=new Pagina("./Archivos/imagenes/banderasRec/marruecosRec.png","Marruecos",7,"Grupo B");
		marruecos.getLaminas()[0]=Constantes.lAMINAS[66];
		marruecos.getLaminas()[1]=Constantes.lAMINAS[67];
		marruecos.getLaminas()[2]=Constantes.lAMINAS[68];
		marruecos.getLaminas()[3]=Constantes.lAMINAS[69];
		marruecos.getLaminas()[4]=Constantes.lAMINAS[70];
		marruecos.getLaminas()[5]=Constantes.lAMINAS[71];
		marruecos.getLaminas()[6]=Constantes.lAMINAS[72];
		marruecos.getLaminas()[7]=Constantes.lAMINAS[73];
		marruecos.getLaminas()[8]=Constantes.lAMINAS[74];
		marruecos.getLaminas()[9]=Constantes.lAMINAS[75];
		marruecos.getLaminas()[10]=Constantes.lAMINAS[76];
		
		
		//Iran
		Pagina iran=new Pagina("./Archivos/imagenes/banderasRec/iranRec.png","Iran",8,"Grupo B");
		iran.getLaminas()[0]=Constantes.lAMINAS[77];
		iran.getLaminas()[1]=Constantes.lAMINAS[78];
		iran.getLaminas()[2]=Constantes.lAMINAS[79];
		iran.getLaminas()[3]=Constantes.lAMINAS[80];
		iran.getLaminas()[4]=Constantes.lAMINAS[81];
		iran.getLaminas()[5]=Constantes.lAMINAS[82];
		iran.getLaminas()[6]=Constantes.lAMINAS[83];
		iran.getLaminas()[7]=Constantes.lAMINAS[84];
		iran.getLaminas()[8]=Constantes.lAMINAS[85];
		iran.getLaminas()[9]=Constantes.lAMINAS[86];
		iran.getLaminas()[10]=Constantes.lAMINAS[87];
		
		//Francia
		Pagina francia=new Pagina("./Archivos/imagenes/banderasRec/franciaRec.png","Francia",9,"Grupo C");
		francia.getLaminas()[0]=Constantes.lAMINAS[88];
		francia.getLaminas()[1]=Constantes.lAMINAS[89];
		francia.getLaminas()[2]=Constantes.lAMINAS[90];
		francia.getLaminas()[3]=Constantes.lAMINAS[91];
		francia.getLaminas()[4]=Constantes.lAMINAS[92];
		francia.getLaminas()[5]=Constantes.lAMINAS[93];
		francia.getLaminas()[6]=Constantes.lAMINAS[94];
		francia.getLaminas()[7]=Constantes.lAMINAS[95];
		francia.getLaminas()[8]=Constantes.lAMINAS[96];
		francia.getLaminas()[9]=Constantes.lAMINAS[97];
		francia.getLaminas()[10]=Constantes.lAMINAS[98];
		
		//Australia
		Pagina australia=new Pagina("./Archivos/imagenes/banderasRec/australiaRec.png","Australia",10,"Grupo C");
		australia.getLaminas()[0]=Constantes.lAMINAS[99];
		australia.getLaminas()[1]=Constantes.lAMINAS[100];
		australia.getLaminas()[2]=Constantes.lAMINAS[101];
		australia.getLaminas()[3]=Constantes.lAMINAS[102];
		australia.getLaminas()[4]=Constantes.lAMINAS[103];
		australia.getLaminas()[5]=Constantes.lAMINAS[104];
		australia.getLaminas()[6]=Constantes.lAMINAS[105];
		australia.getLaminas()[7]=Constantes.lAMINAS[106];
		australia.getLaminas()[8]=Constantes.lAMINAS[107];
		australia.getLaminas()[9]=Constantes.lAMINAS[108];
		australia.getLaminas()[10]=Constantes.lAMINAS[109];
		
		
		//Peru
		Pagina peru=new Pagina("./Archivos/imagenes/banderasRec/peruRec.png","Peru",11,"Grupo C");
		peru.getLaminas()[0]=Constantes.lAMINAS[110];
		peru.getLaminas()[1]=Constantes.lAMINAS[111];
		peru.getLaminas()[2]=Constantes.lAMINAS[112];
		peru.getLaminas()[3]=Constantes.lAMINAS[113];
		peru.getLaminas()[4]=Constantes.lAMINAS[114];
		peru.getLaminas()[5]=Constantes.lAMINAS[115];
		peru.getLaminas()[6]=Constantes.lAMINAS[116];
		peru.getLaminas()[7]=Constantes.lAMINAS[117];
		peru.getLaminas()[8]=Constantes.lAMINAS[118];
		peru.getLaminas()[9]=Constantes.lAMINAS[119];
		peru.getLaminas()[10]=Constantes.lAMINAS[120];
		
		//Dinamarca
		Pagina dinamarca=new Pagina("./Archivos/imagenes/banderasRec/dinamarcaRec.png","Dinamarca",12,"Grupo C");
		dinamarca.getLaminas()[0]=Constantes.lAMINAS[121];
		dinamarca.getLaminas()[1]=Constantes.lAMINAS[122];
		dinamarca.getLaminas()[2]=Constantes.lAMINAS[123];
		dinamarca.getLaminas()[3]=Constantes.lAMINAS[124];
		dinamarca.getLaminas()[4]=Constantes.lAMINAS[125];
		dinamarca.getLaminas()[5]=Constantes.lAMINAS[126];
		dinamarca.getLaminas()[6]=Constantes.lAMINAS[127];
		dinamarca.getLaminas()[7]=Constantes.lAMINAS[128];
		dinamarca.getLaminas()[8]=Constantes.lAMINAS[129];
		dinamarca.getLaminas()[9]=Constantes.lAMINAS[130];
		dinamarca.getLaminas()[10]=Constantes.lAMINAS[131];
		
		//Argentina
		Pagina argentina=new Pagina("./Archivos/imagenes/banderasRec/argentinaRec.png","Argentina",13,"Grupo D");
		argentina.getLaminas()[0]=Constantes.lAMINAS[132];
		argentina.getLaminas()[1]=Constantes.lAMINAS[133];
		argentina.getLaminas()[2]=Constantes.lAMINAS[134];
		argentina.getLaminas()[3]=Constantes.lAMINAS[135];
		argentina.getLaminas()[4]=Constantes.lAMINAS[136];
		argentina.getLaminas()[5]=Constantes.lAMINAS[137];
		argentina.getLaminas()[6]=Constantes.lAMINAS[138];
		argentina.getLaminas()[7]=Constantes.lAMINAS[139];
		argentina.getLaminas()[8]=Constantes.lAMINAS[140];
		argentina.getLaminas()[9]=Constantes.lAMINAS[141];
		argentina.getLaminas()[10]=Constantes.lAMINAS[142];
		
		//Islandia
		Pagina islandia=new Pagina("./Archivos/imagenes/banderasRec/islandiaRec.png","Islandia",14,"Grupo D");
		islandia.getLaminas()[0]=Constantes.lAMINAS[143];
		islandia.getLaminas()[1]=Constantes.lAMINAS[144];
		islandia.getLaminas()[2]=Constantes.lAMINAS[145];
		islandia.getLaminas()[3]=Constantes.lAMINAS[146];
		islandia.getLaminas()[4]=Constantes.lAMINAS[147];
		islandia.getLaminas()[5]=Constantes.lAMINAS[148];
		islandia.getLaminas()[6]=Constantes.lAMINAS[149];
		islandia.getLaminas()[7]=Constantes.lAMINAS[150];
		islandia.getLaminas()[8]=Constantes.lAMINAS[151];
		islandia.getLaminas()[9]=Constantes.lAMINAS[152];
		islandia.getLaminas()[10]=Constantes.lAMINAS[153];
		
		//Croacia
		Pagina croacia=new Pagina("./Archivos/imagenes/banderasRec/croaciaRec.png","Croacia",15,"Grupo D");
		croacia.getLaminas()[0]=Constantes.lAMINAS[154];
		croacia.getLaminas()[1]=Constantes.lAMINAS[155];
		croacia.getLaminas()[2]=Constantes.lAMINAS[156];
		croacia.getLaminas()[3]=Constantes.lAMINAS[157];
		croacia.getLaminas()[4]=Constantes.lAMINAS[158];
		croacia.getLaminas()[5]=Constantes.lAMINAS[159];
		croacia.getLaminas()[6]=Constantes.lAMINAS[160];
		croacia.getLaminas()[7]=Constantes.lAMINAS[161];
		croacia.getLaminas()[8]=Constantes.lAMINAS[162];
		croacia.getLaminas()[9]=Constantes.lAMINAS[163];
		croacia.getLaminas()[10]=Constantes.lAMINAS[164];
		
		//Nigeria
		Pagina nigeria=new Pagina("./Archivos/imagenes/banderasRec/nigeriaRec.png","Nigeria",16,"Grupo D");
		nigeria.getLaminas()[0]=Constantes.lAMINAS[165];
		nigeria.getLaminas()[1]=Constantes.lAMINAS[166];
		nigeria.getLaminas()[2]=Constantes.lAMINAS[167];
		nigeria.getLaminas()[3]=Constantes.lAMINAS[168];
		nigeria.getLaminas()[4]=Constantes.lAMINAS[169];
		nigeria.getLaminas()[5]=Constantes.lAMINAS[170];
		nigeria.getLaminas()[6]=Constantes.lAMINAS[171];
		nigeria.getLaminas()[7]=Constantes.lAMINAS[172];
		nigeria.getLaminas()[8]=Constantes.lAMINAS[173];
		nigeria.getLaminas()[9]=Constantes.lAMINAS[174];
		nigeria.getLaminas()[10]=Constantes.lAMINAS[175];
		
		//Brasil
		Pagina brasil=new Pagina("./Archivos/imagenes/banderasRec/brasilRec.png","Brasil",17,"Grupo E");
		brasil.getLaminas()[0]=Constantes.lAMINAS[176];
		brasil.getLaminas()[1]=Constantes.lAMINAS[177];
		brasil.getLaminas()[2]=Constantes.lAMINAS[178];
		brasil.getLaminas()[3]=Constantes.lAMINAS[179];
		brasil.getLaminas()[4]=Constantes.lAMINAS[180];
		brasil.getLaminas()[5]=Constantes.lAMINAS[181];
		brasil.getLaminas()[6]=Constantes.lAMINAS[182];
		brasil.getLaminas()[7]=Constantes.lAMINAS[183];
		brasil.getLaminas()[8]=Constantes.lAMINAS[184];
		brasil.getLaminas()[9]=Constantes.lAMINAS[185];
		brasil.getLaminas()[10]=Constantes.lAMINAS[186];
		
		//Suiza
		Pagina suiza=new Pagina("./Archivos/imagenes/banderasRec/suizaRec.png","Suiza",18,"Grupo E");
		suiza.getLaminas()[0]=Constantes.lAMINAS[187];
		suiza.getLaminas()[1]=Constantes.lAMINAS[188];
		suiza.getLaminas()[2]=Constantes.lAMINAS[189];
		suiza.getLaminas()[3]=Constantes.lAMINAS[190];
		suiza.getLaminas()[4]=Constantes.lAMINAS[191];
		suiza.getLaminas()[5]=Constantes.lAMINAS[192];
		suiza.getLaminas()[6]=Constantes.lAMINAS[193];
		suiza.getLaminas()[7]=Constantes.lAMINAS[194];
		suiza.getLaminas()[8]=Constantes.lAMINAS[195];
		suiza.getLaminas()[9]=Constantes.lAMINAS[196];
		suiza.getLaminas()[10]=Constantes.lAMINAS[197];
		
		//Costa Rica
		Pagina costa=new Pagina("./Archivos/imagenes/banderasRec/costa ricaRec.png","Costa Rica",19,"Grupo E");
		costa.getLaminas()[0]=Constantes.lAMINAS[198];
		costa.getLaminas()[1]=Constantes.lAMINAS[199];
		costa.getLaminas()[2]=Constantes.lAMINAS[200];
		costa.getLaminas()[3]=Constantes.lAMINAS[201];
		costa.getLaminas()[4]=Constantes.lAMINAS[202];
		costa.getLaminas()[5]=Constantes.lAMINAS[203];
		costa.getLaminas()[6]=Constantes.lAMINAS[204];
		costa.getLaminas()[7]=Constantes.lAMINAS[205];
		costa.getLaminas()[8]=Constantes.lAMINAS[206];
		costa.getLaminas()[9]=Constantes.lAMINAS[207];
		costa.getLaminas()[10]=Constantes.lAMINAS[208];
		
		//Serbia
		Pagina serbia=new Pagina("./Archivos/imagenes/banderasRec/serbiaRec.png","Serbia",20,"Grupo E");
		serbia.getLaminas()[0]=Constantes.lAMINAS[209];
		serbia.getLaminas()[1]=Constantes.lAMINAS[210];
		serbia.getLaminas()[2]=Constantes.lAMINAS[211];
		serbia.getLaminas()[3]=Constantes.lAMINAS[212];
		serbia.getLaminas()[4]=Constantes.lAMINAS[213];
		serbia.getLaminas()[5]=Constantes.lAMINAS[214];
		serbia.getLaminas()[6]=Constantes.lAMINAS[215];
		serbia.getLaminas()[7]=Constantes.lAMINAS[216];
		serbia.getLaminas()[8]=Constantes.lAMINAS[217];
		serbia.getLaminas()[9]=Constantes.lAMINAS[218];
		serbia.getLaminas()[10]=Constantes.lAMINAS[219];
		
		//Alemania
		Pagina alemania=new Pagina("./Archivos/imagenes/banderasRec/alemaniaRec.png","Alemania",21,"Grupo F");
		alemania.getLaminas()[0]=Constantes.lAMINAS[220];
		alemania.getLaminas()[1]=Constantes.lAMINAS[221];
		alemania.getLaminas()[2]=Constantes.lAMINAS[222];
		alemania.getLaminas()[3]=Constantes.lAMINAS[223];
		alemania.getLaminas()[4]=Constantes.lAMINAS[224];
		alemania.getLaminas()[5]=Constantes.lAMINAS[225];
		alemania.getLaminas()[6]=Constantes.lAMINAS[226];
		alemania.getLaminas()[7]=Constantes.lAMINAS[227];
		alemania.getLaminas()[8]=Constantes.lAMINAS[228];
		alemania.getLaminas()[9]=Constantes.lAMINAS[229];
		alemania.getLaminas()[10]=Constantes.lAMINAS[230];
		
		//Mexico
		Pagina mexico=new Pagina("./Archivos/imagenes/banderasRec/mexicoRec.png","Mexico",22,"Grupo F");
		mexico.getLaminas()[0]=Constantes.lAMINAS[231];
		mexico.getLaminas()[1]=Constantes.lAMINAS[232];
		mexico.getLaminas()[2]=Constantes.lAMINAS[233];
		mexico.getLaminas()[3]=Constantes.lAMINAS[234];
		mexico.getLaminas()[4]=Constantes.lAMINAS[235];
		mexico.getLaminas()[5]=Constantes.lAMINAS[236];
		mexico.getLaminas()[6]=Constantes.lAMINAS[237];
		mexico.getLaminas()[7]=Constantes.lAMINAS[238];
		mexico.getLaminas()[8]=Constantes.lAMINAS[239];
		mexico.getLaminas()[9]=Constantes.lAMINAS[240];
		mexico.getLaminas()[10]=Constantes.lAMINAS[241];
		
		//Suecia
		Pagina suecia=new Pagina("./Archivos/imagenes/banderasRec/sueciaRec.png","Suecia",23,"Grupo F");
		suecia.getLaminas()[0]=Constantes.lAMINAS[242];
		suecia.getLaminas()[1]=Constantes.lAMINAS[243];
		suecia.getLaminas()[2]=Constantes.lAMINAS[244];
		suecia.getLaminas()[3]=Constantes.lAMINAS[245];
		suecia.getLaminas()[4]=Constantes.lAMINAS[246];
		suecia.getLaminas()[5]=Constantes.lAMINAS[247];
		suecia.getLaminas()[6]=Constantes.lAMINAS[248];
		suecia.getLaminas()[7]=Constantes.lAMINAS[249];
		suecia.getLaminas()[8]=Constantes.lAMINAS[250];
		suecia.getLaminas()[9]=Constantes.lAMINAS[251];
		suecia.getLaminas()[10]=Constantes.lAMINAS[252];
		
		//Corea del Sur
		Pagina corea=new Pagina("./Archivos/imagenes/banderasRec/coreaRec.png","Corea del Sur",24,"Grupo F");
		corea.getLaminas()[0]=Constantes.lAMINAS[253];
		corea.getLaminas()[1]=Constantes.lAMINAS[254];
		corea.getLaminas()[2]=Constantes.lAMINAS[255];
		corea.getLaminas()[3]=Constantes.lAMINAS[256];
		corea.getLaminas()[4]=Constantes.lAMINAS[257];
		corea.getLaminas()[5]=Constantes.lAMINAS[258];
		corea.getLaminas()[6]=Constantes.lAMINAS[259];
		corea.getLaminas()[7]=Constantes.lAMINAS[260];
		corea.getLaminas()[8]=Constantes.lAMINAS[261];
		corea.getLaminas()[9]=Constantes.lAMINAS[262];
		corea.getLaminas()[10]=Constantes.lAMINAS[263];
		
		//Belgica
		Pagina belgica=new Pagina("./Archivos/imagenes/banderasRec/belgicaRec.png","Belgica",25,"Grupo G");
		belgica.getLaminas()[0]=Constantes.lAMINAS[264];
		belgica.getLaminas()[1]=Constantes.lAMINAS[265];
		belgica.getLaminas()[2]=Constantes.lAMINAS[266];
		belgica.getLaminas()[3]=Constantes.lAMINAS[267];
		belgica.getLaminas()[4]=Constantes.lAMINAS[268];
		belgica.getLaminas()[5]=Constantes.lAMINAS[269];
		belgica.getLaminas()[6]=Constantes.lAMINAS[270];
		belgica.getLaminas()[7]=Constantes.lAMINAS[271];
		belgica.getLaminas()[8]=Constantes.lAMINAS[272];
		belgica.getLaminas()[9]=Constantes.lAMINAS[273];
		belgica.getLaminas()[10]=Constantes.lAMINAS[274];
		
		//Panama
		Pagina panama=new Pagina("./Archivos/imagenes/banderasRec/panamaRec.png","Panama",26,"Grupo G");
		panama.getLaminas()[0]=Constantes.lAMINAS[275];
		panama.getLaminas()[1]=Constantes.lAMINAS[276];
		panama.getLaminas()[2]=Constantes.lAMINAS[277];
		panama.getLaminas()[3]=Constantes.lAMINAS[278];
		panama.getLaminas()[4]=Constantes.lAMINAS[279];
		panama.getLaminas()[5]=Constantes.lAMINAS[280];
		panama.getLaminas()[6]=Constantes.lAMINAS[281];
		panama.getLaminas()[7]=Constantes.lAMINAS[282];
		panama.getLaminas()[8]=Constantes.lAMINAS[283];
		panama.getLaminas()[9]=Constantes.lAMINAS[284];
		panama.getLaminas()[10]=Constantes.lAMINAS[285];
		
		//Tunez
		Pagina tunez=new Pagina("./Archivos/imagenes/banderasRec/tunezRec.png","Tunez",27,"Grupo G");
		tunez.getLaminas()[0]=Constantes.lAMINAS[286];
		tunez.getLaminas()[1]=Constantes.lAMINAS[287];
		tunez.getLaminas()[2]=Constantes.lAMINAS[288];
		tunez.getLaminas()[3]=Constantes.lAMINAS[289];
		tunez.getLaminas()[4]=Constantes.lAMINAS[290];
		tunez.getLaminas()[5]=Constantes.lAMINAS[291];
		tunez.getLaminas()[6]=Constantes.lAMINAS[292];
		tunez.getLaminas()[7]=Constantes.lAMINAS[293];
		tunez.getLaminas()[8]=Constantes.lAMINAS[294];
		tunez.getLaminas()[9]=Constantes.lAMINAS[295];
		tunez.getLaminas()[10]=Constantes.lAMINAS[296];
		
		//Inglaterra
		Pagina inglaterra=new Pagina("./Archivos/imagenes/banderasRec/inglaterraRec.png","Inglaterra",28,"Grupo G");
		inglaterra.getLaminas()[0]=Constantes.lAMINAS[297];
		inglaterra.getLaminas()[1]=Constantes.lAMINAS[298];
		inglaterra.getLaminas()[2]=Constantes.lAMINAS[299];
		inglaterra.getLaminas()[3]=Constantes.lAMINAS[300];
		inglaterra.getLaminas()[4]=Constantes.lAMINAS[301];
		inglaterra.getLaminas()[5]=Constantes.lAMINAS[302];
		inglaterra.getLaminas()[6]=Constantes.lAMINAS[303];
		inglaterra.getLaminas()[7]=Constantes.lAMINAS[304];
		inglaterra.getLaminas()[8]=Constantes.lAMINAS[305];
		inglaterra.getLaminas()[9]=Constantes.lAMINAS[306];
		inglaterra.getLaminas()[10]=Constantes.lAMINAS[307];
		
		//Polonia
		Pagina polonia=new Pagina("./Archivos/imagenes/banderasRec/poloniaRec.png","Polonia",29,"Grupo H");
		polonia.getLaminas()[0]=Constantes.lAMINAS[308];
		polonia.getLaminas()[1]=Constantes.lAMINAS[309];
		polonia.getLaminas()[2]=Constantes.lAMINAS[310];
		polonia.getLaminas()[3]=Constantes.lAMINAS[311];
		polonia.getLaminas()[4]=Constantes.lAMINAS[312];
		polonia.getLaminas()[5]=Constantes.lAMINAS[313];
		polonia.getLaminas()[6]=Constantes.lAMINAS[314];
		polonia.getLaminas()[7]=Constantes.lAMINAS[315];
		polonia.getLaminas()[8]=Constantes.lAMINAS[316];
		polonia.getLaminas()[9]=Constantes.lAMINAS[317];
		polonia.getLaminas()[10]=Constantes.lAMINAS[318];
		
		//Senegal
		Pagina senegal=new Pagina("./Archivos/imagenes/banderasRec/senegalRec.png","Senegal",30,"Grupo H");
		senegal.getLaminas()[0]=Constantes.lAMINAS[319];
		senegal.getLaminas()[1]=Constantes.lAMINAS[320];
		senegal.getLaminas()[2]=Constantes.lAMINAS[321];
		senegal.getLaminas()[3]=Constantes.lAMINAS[322];
		senegal.getLaminas()[4]=Constantes.lAMINAS[323];
		senegal.getLaminas()[5]=Constantes.lAMINAS[324];
		senegal.getLaminas()[6]=Constantes.lAMINAS[325];
		senegal.getLaminas()[7]=Constantes.lAMINAS[326];
		senegal.getLaminas()[8]=Constantes.lAMINAS[327];
		senegal.getLaminas()[9]=Constantes.lAMINAS[328];
		senegal.getLaminas()[10]=Constantes.lAMINAS[329];
		
		//Colombia
		Pagina colombia=new Pagina("./Archivos/imagenes/banderasRec/colombiaRec.png","Colombia",31,"Grupo H");
		colombia.getLaminas()[0]=Constantes.lAMINAS[330];
		colombia.getLaminas()[1]=Constantes.lAMINAS[331];
		colombia.getLaminas()[2]=Constantes.lAMINAS[332];
		colombia.getLaminas()[3]=Constantes.lAMINAS[333];
		colombia.getLaminas()[4]=Constantes.lAMINAS[334];
		colombia.getLaminas()[5]=Constantes.lAMINAS[335];
		colombia.getLaminas()[6]=Constantes.lAMINAS[336];
		colombia.getLaminas()[7]=Constantes.lAMINAS[337];
		colombia.getLaminas()[8]=Constantes.lAMINAS[338];
		colombia.getLaminas()[9]=Constantes.lAMINAS[339];
		colombia.getLaminas()[10]=Constantes.lAMINAS[340];
		
		//Japon
		Pagina japon=new Pagina("./Archivos/imagenes/banderasRec/japonRec.png","Japon",32,"Grupo H");
		japon.getLaminas()[0]=Constantes.lAMINAS[341];
		japon.getLaminas()[1]=Constantes.lAMINAS[342];
		japon.getLaminas()[2]=Constantes.lAMINAS[343];
		japon.getLaminas()[3]=Constantes.lAMINAS[344];
		japon.getLaminas()[4]=Constantes.lAMINAS[345];
		japon.getLaminas()[5]=Constantes.lAMINAS[346];
		japon.getLaminas()[6]=Constantes.lAMINAS[347];
		japon.getLaminas()[7]=Constantes.lAMINAS[348];
		japon.getLaminas()[8]=Constantes.lAMINAS[349];
		japon.getLaminas()[9]=Constantes.lAMINAS[350];
		japon.getLaminas()[10]=Constantes.lAMINAS[351];
		
		
		
		
		agregarPagina(rusia);
		agregarPagina(arabia);
		agregarPagina(egipto);
		agregarPagina(uruguay );
		agregarPagina(portugal);
		agregarPagina(espana);
		agregarPagina(marruecos);
		agregarPagina(iran);
		agregarPagina(francia);
		agregarPagina(australia);
		agregarPagina(peru);
		agregarPagina(dinamarca);
		agregarPagina(argentina);
		agregarPagina(islandia);
		agregarPagina(croacia);
		agregarPagina(nigeria);
		agregarPagina(brasil);
		agregarPagina(suiza);
		agregarPagina(costa);
		agregarPagina(serbia);
		agregarPagina(alemania);
		agregarPagina(mexico);
		agregarPagina(suecia);
		agregarPagina(corea);
		agregarPagina(belgica);
		agregarPagina(panama);
		agregarPagina(tunez);
		agregarPagina(inglaterra);
		agregarPagina(polonia);
		agregarPagina(senegal);
		agregarPagina(colombia);
		agregarPagina(japon);

		
		

	}
}


