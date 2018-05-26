
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;


import excepciones.PaginaYaExisteException;

public class Album {
	
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
		rusia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/rusia/akinfeev.jpg",1);
		rusia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/rusia/dzagoev.jpg",2);
		rusia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/rusia/erokhin.jpg",3);
		rusia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/rusia/fernandes.jpg",4);
		rusia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/rusia/kokorin.jpg",5);
		rusia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/rusia/kudryashov.jpg",6);
		rusia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/rusia/miranchuk.jpg",7);
		rusia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/rusia/poloz.jpg",8);
		rusia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/rusia/samedov.jpg",9);
		rusia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/rusia/smolnikov.jpg",10);
		rusia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/rusia/vasin.jpg",11);
		
		
		//Arabia Saudita
		Pagina arabia=new Pagina("./Archivos/imagenes/banderasRec/arabia sauditaRec.png","Arabia Saudita", 2,"Grupo A");
		arabia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-mayouf.jpg",12);
		arabia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-beraik.jpg",13);
		arabia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-dosari.jpg",14);
		arabia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-harbi.jpg",15);
		arabia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-jassim.jpg",16);
		arabia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-moasher.jpg",17);
		arabia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-sahlawi.jpg",18);
		arabia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-shahrani.jpg",19);
		arabia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-shamrani.jpg",20);
		arabia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-shehri.jpg",21);
		arabia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/hawsawi.jpg",22);
		
		//Egipto
		Pagina egipto=new Pagina("./Archivos/imagenes/banderasRec/egiptoRec.png","Egipto",3,"Grupo A");
		egipto.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/egipto/hadary.jpg",23);
		egipto.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/egipto/el-said.jpg",24);
		egipto.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/egipto/elmohamady.jpg",25);
		egipto.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/egipto/elneny.jpg",26);
		egipto.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/egipto/gabr.jpg",27);
		egipto.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/egipto/hegazi.jpg",28);
		egipto.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/egipto/kahraba.jpg",29);
		egipto.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/egipto/rabia.jpg",30);
		egipto.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/egipto/salah.jpg",31);
		egipto.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/egipto/sobhi.jpg",32);
		egipto.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/egipto/trezeguet.jpg",33);
		

		
		//Uruguay
		Pagina uruguay=new Pagina("./Archivos/imagenes/banderasRec/uruguayRec.png","Uruguay",4,"Grupo A");
		uruguay.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",34);
		uruguay.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/uruguay/stuani.jpg",35);
		uruguay.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/uruguay/suarez.jpg",36);
		uruguay.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/uruguay/sanchez.jpg",37);
		uruguay.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/uruguay/pereira.jpg",38);
		uruguay.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/uruguay/godin.jpg",39);
		uruguay.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/uruguay/lodeiro.jpg",40);
		uruguay.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/uruguay/gimenez.jpg",41);
		uruguay.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/uruguay/cavani.jpg",42);
		uruguay.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/uruguay/caceres.jpg",43);
		uruguay.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/uruguay/cRodriguez.jpg",44);
		
		

		
		//Portugal
		Pagina portugal=new Pagina("./Archivos/imagenes/banderasRec/portugalRec.png","Portugal",5,"Grupo B");
		portugal.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/portugal/patricio.jpg",45);
		portugal.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/portugal/aSilva.jpg",46);
		portugal.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/portugal/carvalho.jpg",47);
		portugal.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/portugal/cristiano.jpg",48);
		portugal.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/portugal/eliseu.jpg",49);
		portugal.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/portugal/fonte.jpg",50);
		portugal.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/portugal/guerreiro.jpg",51);
		portugal.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/portugal/moutinho.jpg",52);
		portugal.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/portugal/nani.jpg",53);
		portugal.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/portugal/pepe.jpg",54);
		portugal.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/portugal/silva.jpg",55);
		
		//Espa�a
		Pagina espana=new Pagina("./Archivos/imagenes/banderasRec/espanaRec.png","Espana",6,"Grupo B");
		espana.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/espana/DeGea.jpg",56);
		espana.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/espana/alba.jpg",57);
		espana.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/espana/asensio.jpg",58);
		espana.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/espana/busquet.jpg",59);
		espana.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/espana/carvajal.jpg",60);
		espana.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/espana/costa.jpg",61);
		espana.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/espana/iniesta.jpg",62);
		espana.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/espana/isco.jpg",63);
		espana.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/espana/morata.jpg",64);
		espana.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/espana/ramos.jpg",65);
		espana.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/espana/vitolo.jpg",66);
		
		//Marruecos
		Pagina marruecos=new Pagina("./Archivos/imagenes/banderasRec/marruecosRec.png","Marruecos",7,"Grupo B");
		marruecos.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/marruecos/mohamedi.jpg",67);
		marruecos.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/marruecos/alioui.jpg",68);
		marruecos.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/marruecos/amrabat.jpg",69);
		marruecos.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/marruecos/bouhaddouz.jpg",70);
		marruecos.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/marruecos/chafik.jpg",71);
		marruecos.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/marruecos/en-nesyri.jpg",72);
		marruecos.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/marruecos/fajr.jpg",73);
		marruecos.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/marruecos/hakimi.jpg",74);
		marruecos.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/marruecos/mendyl.jpg",75);
		marruecos.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/marruecos/saiss.jpg",76);
		marruecos.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/marruecos/ziyech.jpg",77);
		
		
		//Iran
		Pagina iran=new Pagina("./Archivos/imagenes/banderasRec/iranRec.png","Iran",8,"Grupo B");
		iran.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/iran/beiranvand.jpg",78);
		iran.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/iran/amiri.jpg",79);
		iran.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/iran/ansarifard.jpg",80);
		iran.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/iran/azmoun.jpg",81);
		iran.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/iran/ebrahimi.jpg",82);
		iran.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/iran/ghafouri.jpg",83);
		iran.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/iran/ghoddos.jpg",84);
		iran.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/iran/ghoochannejhad.jpg",85);
		iran.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/iran/hajsafi.jpg",86);
		iran.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/iran/jakanbakhsh.jpg",87);
		iran.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/iran/rezaeian.jpg",88);
		
		//Francia
		Pagina francia=new Pagina("./Archivos/imagenes/banderasRec/franciaRec.png","Francia",9,"Grupo C");
		francia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/francia/lloris.jpg",89);
		francia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/francia/dembele.jpg",90);
		francia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/francia/griezmann.jpg",91);
		francia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/francia/kurzawa.jpg",92);
		francia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/francia/lemar.jpg",93);
		francia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/francia/martial.jpg",94);
		francia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/francia/mbappe.jpg",95);
		francia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/francia/pogba.jpg",96);
		francia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/francia/rabiot.jpg",97);
		francia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/francia/umtiti.jpg",98);
		francia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/francia/varane.jpg",99);
		
		//Australia
		Pagina australia=new Pagina("./Archivos/imagenes/banderasRec/australiaRec.png","Australia",10,"Grupo C");
		australia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/australia/ryan.jpg",100);
		australia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/australia/behich.jpg",101);
		australia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/australia/cahill.jpg",102);
		australia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/australia/degenek.jpg",103);
		australia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/australia/jedinak.jpg",104);
		australia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/australia/juric.jpg",105);
		australia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/australia/kruse.jpg",106);
		australia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/australia/luongo.jpg",107);
		australia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/australia/mcgowan.jpg",108);
		australia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/australia/mooy.jpg",109);
		australia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/australia/wright.jpg",110);
		
		
		//Peru
		Pagina peru=new Pagina("./Archivos/imagenes/banderasRec/peruRec.png","Peru",11,"Grupo C");
		peru.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/peru/gallese.jpg",111);
		peru.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/peru/araujo.jpg",112);
		peru.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/peru/corzo.jpg",113);
		peru.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/peru/cueva.jpg",114);
		peru.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/peru/farfan.jpg",115);
		peru.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/peru/guerrero.jpg",116);
		peru.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/peru/polo.jpg",117);
		peru.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/peru/rodriguez.jpg",118);
		peru.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/peru/ruidiaz.jpg",119);
		peru.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/peru/trauco.jpg",120);
		peru.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/peru/yotun.jpg",121);
		
		//Dinamarca
		Pagina dinamarca=new Pagina("./Archivos/imagenes/banderasRec/dinamarcaRec.png","Dinamarca",12,"Grupo C");
		dinamarca.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/dinamarca/schmeichel.jpg",122);
		dinamarca.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/dinamarca/bjelland.jpg",123);
		dinamarca.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/dinamarca/christensen.jpg",124);
		dinamarca.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/dinamarca/cornelius.jpg",125);
		dinamarca.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/dinamarca/eriksen.jpg",126);
		dinamarca.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/dinamarca/jorgensen.jpg",127);
		dinamarca.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/dinamarca/kjaer.jpg",128);
		dinamarca.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/dinamarca/poulsen.jpg",129);
		dinamarca.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/dinamarca/schone.jpg",130);
		dinamarca.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/dinamarca/sisto.jpg",131);
		dinamarca.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/dinamarca/vestergaard.jpg",132);
		
		//Argentina
		Pagina argentina=new Pagina("./Archivos/imagenes/banderasRec/argentinaRec.png","Argentina",13,"Grupo D");
		argentina.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/argentina/romero.jpg",133);
		argentina.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/argentina/aguero.jpg",134);
		argentina.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/argentina/di maria.jpg",135);
		argentina.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/argentina/dybala.jpg",136);
		argentina.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/argentina/fazio.jpg",137);
		argentina.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/argentina/higuain.jpg",138);
		argentina.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/argentina/icardi.jpg",139);
		argentina.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/argentina/masherano.jpg",140);
		argentina.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/argentina/messi.jpg",141);
		argentina.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/argentina/otamendi.jpg",142);
		argentina.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/argentina/perez.jpg",143);
		
		//Islandia
		Pagina islandia=new Pagina("./Archivos/imagenes/banderasRec/islandiaRec.png","Islandia",14,"Grupo D");
		islandia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/islandia/halldorsson.jpg",144);
		islandia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/islandia/bjarnason.jpg",145);
		islandia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/islandia/bodvarsson.jpg",146);
		islandia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/islandia/finnbogason.jpg",147);
		islandia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/islandia/gislason.jpg",148);
		islandia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/islandia/gunnarsson.jpg",149);
		islandia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/islandia/hallfredsson.jpg",150);
		islandia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/islandia/ingason.jpg",151);
		islandia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/islandia/sigurdarson.jpg",152);
		islandia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/islandia/sigurdsson.jpg",153);
		islandia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/islandia/skulason.jpg",154);
		
		//Croacia
		Pagina croacia=new Pagina("./Archivos/imagenes/banderasRec/croaciaRec.png","Croacia",15,"Grupo D");
		croacia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/croacia/subasic.jpg",155);
		croacia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/croacia/kalinic.jpg",156);
		croacia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/croacia/kovacic.jpg",157);
		croacia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/croacia/kramaric.jpg",158);
		croacia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/croacia/mandzukic.jpg",159);
		croacia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/croacia/modric.jpg",160);
		croacia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/croacia/perisic.jpg",161);
		croacia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/croacia/pivaric.jpg",162);
		croacia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/croacia/rakitic.jpg",163);
		croacia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/croacia/strinic.jpg",164);
		croacia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/croacia/vida.jpg",165);
		
		//Nigeria
		Pagina nigeria=new Pagina("./Archivos/imagenes/banderasRec/nigeriaRec.png","Nigeria",16,"Grupo D");
		nigeria.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/nigeria/ezenwa.jpg",166);
		nigeria.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/nigeria/aina.jpg",167);
		nigeria.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/nigeria/balogun.jpg",168);
		nigeria.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/nigeria/echijile.jpg",169);
		nigeria.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/nigeria/ighalo.jpg",170);
		nigeria.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/nigeria/iheanacho.jpg",171);
		nigeria.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/nigeria/iwobi.jpg",172);
		nigeria.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/nigeria/mikel.jpg",173);
		nigeria.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/nigeria/musa.jpg",174);
		nigeria.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/nigeria/ndidi.jpg",175);
		nigeria.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/nigeria/omeruo.jpg",176);
		
		//Brasil
		Pagina brasil=new Pagina("./Archivos/imagenes/banderasRec/brasilRec.png","Brasil",17,"Grupo E");
		brasil.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/brasil/alisson.jpg",177);
		brasil.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/brasil/alves.jpg",178);
		brasil.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/brasil/casemiro.jpg",179);
		brasil.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/brasil/coutinho.jpg",180);
		brasil.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/brasil/firminho.jpg",181);
		brasil.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/brasil/jesus.jpg",182);
		brasil.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/brasil/marcelo.jpg",183);
		brasil.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/brasil/marquinhos.jpg",184);
		brasil.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/brasil/neymar.jpg",185);
		brasil.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/brasil/paulinho.jpg",186);
		brasil.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/brasil/silva.jpg",187);
		
		//Suiza
		Pagina suiza=new Pagina("./Archivos/imagenes/banderasRec/suizaRec.png","Suiza",18,"Grupo E");
		suiza.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/suiza/sommer.jpg",188);
		suiza.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/suiza/akanji.jpg",189);
		suiza.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/suiza/behrami.jpg",190);
		suiza.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/suiza/derdijok.jpg",191);
		suiza.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/suiza/djorou.jpg",192);
		suiza.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/suiza/embolo.jpg",193);
		suiza.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/suiza/lichtsteiner.jpg",194);
		suiza.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/suiza/mehmedi.jpg",195);
		suiza.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/suiza/rodriguez.jpg",196);
		suiza.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/suiza/shaqiri.jpg",197);
		suiza.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/suiza/xhaka.jpg",198);
		
		//Costa Rica
		Pagina costa=new Pagina("./Archivos/imagenes/banderasRec/costa ricaRec.png","Costa Rica",19,"Grupo E");
		costa.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/costa rica/navas.jpg",199);
		costa.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/costa rica/azofeifa.jpg",200);
		costa.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/costa rica/borges.jpg",201);
		costa.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/costa rica/calvo.jpg",202);
		costa.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/costa rica/guzman.jpg",203);
		costa.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/costa rica/matarrita.jpg",204);
		costa.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/costa rica/oviedo.jpg",205);
		costa.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/costa rica/urena.jpg",206);
		costa.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/costa rica/venegas.jpg",207);
		costa.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/costa rica/wallace.jpg",208);
		costa.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/costa rica/waston.jpg",209);
		
		//Serbia
		Pagina serbia=new Pagina("./Archivos/imagenes/banderasRec/serbiaRec.png","Serbia",20,"Grupo E");
		serbia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/serbia/stojkovic.jpg",210);
		serbia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/serbia/gacinovic.jpg",211);
		serbia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/serbia/ivanovic.jpg",212);
		serbia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/serbia/kolarov.jpg",213);
		serbia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/serbia/kostic.jpg",214);
		serbia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/serbia/milivojevic.jpg",215);
		serbia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/serbia/mitrovic.jpg",216);
		serbia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/serbia/nastasic.jpg",217);
		serbia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/serbia/prijovic.jpg",218);
		serbia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/serbia/rukavina.jpg",219);
		serbia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/serbia/vukovic.jpg",220);
		
		//Alemania
		Pagina alemania=new Pagina("./Archivos/imagenes/banderasRec/alemaniaRec.png","Alemania",21,"Grupo F");
		alemania.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/alemania/neuer.jpg",221);
		alemania.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/alemania/boateng.jpg",222);
		alemania.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/alemania/draxler.jpg",223);
		alemania.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/alemania/gotze.jpg",224);
		alemania.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/alemania/hummels.jpg",225);
		alemania.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/alemania/khedira.jpg",226);
		alemania.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/alemania/kroos.jpg",227);
		alemania.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/alemania/muller.jpg",228);
		alemania.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/alemania/ozil.jpg",229);
		alemania.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/alemania/sane.jpg",230);
		alemania.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/alemania/werner.jpg",231);
		
		//Mexico
		Pagina mexico=new Pagina("./Archivos/imagenes/banderasRec/mexicoRec.png","Mexico",22,"Grupo F");
		mexico.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/mexico/ochoa.jpg",232);
		mexico.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/mexico/chicharito.jpg",233);
		mexico.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/mexico/dos-santos.jpg",234);
		mexico.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/mexico/gallardo.jpg",235);
		mexico.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/mexico/gDosSantos.jpg",236);
		mexico.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/mexico/herrera.jpg",237);
		mexico.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/mexico/jimenez.jpg",238);
		mexico.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/mexico/layun.jpg",239);
		mexico.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/mexico/moreno.jpg",240);
		mexico.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/mexico/reyes.jpg",241);
		mexico.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/mexico/vela.jpg",242);
		
		//Suecia
		Pagina suecia=new Pagina("./Archivos/imagenes/banderasRec/sueciaRec.png","Suecia",23,"Grupo F");
		suecia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/suecia/olsen.jpg",243);
		suecia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/suecia/berg.jpg",244);
		suecia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/suecia/durmaz.jpg",245);
		suecia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/suecia/forsberg.jpg",246);
		suecia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/suecia/granqist.jpg",247);
		suecia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/suecia/jansson.jpg",248);
		suecia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/suecia/larsson.jpg",249);
		suecia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/suecia/lindelof.jpg",250);
		suecia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/suecia/olsson.jpg",251);
		suecia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/suecia/svensson.jpg",252);
		suecia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/suecia/thelin.jpg",253);
		
		//Corea del Sur
		Pagina corea=new Pagina("./Archivos/imagenes/banderasRec/coreaRec.png","Corea del Sur",24,"Grupo F");
		corea.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/corea/seunggyu.jpg",254);
		corea.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/corea/dongwon.jpg",255);
		corea.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/corea/heechan.jpg",256);
		corea.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/corea/jeongho.jpg",257);
		corea.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/corea/jinsu.jpg",258);
		corea.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/corea/kookyoung.jpg",259);
		corea.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/corea/shinwook.jpg",260);
		corea.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/corea/sungyueng.jpg",261);
		corea.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/corea/taehee.jpg",262);
		corea.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/corea/taehwi.jpg",263);
		corea.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/corea/younggwon.jpg",264);
		
		//Belgica
		Pagina belgica=new Pagina("./Archivos/imagenes/banderasRec/belgicaRec.png","Belgica",25,"Grupo G");
		belgica.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/belgica/courtois.jpg",265);
		belgica.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/belgica/bruyne.jpg",266);
		belgica.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/belgica/carrasco.jpg",267);
		belgica.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/belgica/fellaini.jpg",268);
		belgica.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/belgica/hazard.jpg",269);
		belgica.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/belgica/kompany.jpg",270);
		belgica.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/belgica/lukaku.jpg",271);
		belgica.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/belgica/mertens.jpg",272);
		belgica.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/belgica/meunier.jpg",273);
		belgica.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/belgica/nainggolan.jpg",274);
		belgica.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/belgica/vertonghen.jpg",275);
		
		//Panama
		Pagina panama=new Pagina("./Archivos/imagenes/banderasRec/panamaRec.png","Panama",26,"Grupo G");
		panama.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/panama/calderon.jpg",276);
		panama.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/panama/arroyo.jpg",277);
		panama.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/panama/barcenas.jpg",278);
		panama.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/panama/davis.jpg",279);
		panama.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/panama/godoy.jpg",280);
		panama.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/panama/gTorres.jpg",281);
		panama.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/panama/machado.jpg",282);
		panama.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/panama/murillo.jpg",283);
		panama.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/panama/quintero.jpg",284);
		panama.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/panama/tejada.jpg",285);
		panama.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/panama/torres.jpg",286);
		
		//Tunez
		Pagina tunez=new Pagina("./Archivos/imagenes/banderasRec/tunezRec.png","Tunez",27,"Grupo G");
		tunez.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/tunez/mathlouthi.jpg",287);
		tunez.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/tunez/akaichi.jpg",288);
		tunez.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/tunez/badri.jpg",289);
		tunez.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/tunez/chaalali.jpg",290);
		tunez.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/tunez/khazri.jpg",291);
		tunez.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/tunez/maaloul.jpg",292);
		tunez.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/tunez/meriah.jpg",293);
		tunez.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/tunez/naguez.jpg",294);
		tunez.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/tunez/sliti.jpg",295);
		tunez.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/tunez/touzghar.jpg",296);
		tunez.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/tunez/youssef.jpg",297);
		
		//Inglaterra
		Pagina inglaterra=new Pagina("./Archivos/imagenes/banderasRec/inglaterraRec.png","Inglaterra",28,"Grupo G");
		inglaterra.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/inglaterra/hart.jpg",298);
		inglaterra.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/inglaterra/alli.jpg",299);
		inglaterra.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/inglaterra/bertrand.jpg",300);
		inglaterra.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/inglaterra/cahill.jpg",301);
		inglaterra.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/inglaterra/henderson.jpg",302);
		inglaterra.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/inglaterra/kane.jpg",303);
		inglaterra.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/inglaterra/lingard.jpg",304);
		inglaterra.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/inglaterra/rose.jpg",305);
		inglaterra.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/inglaterra/sterling.jpg",306);
		inglaterra.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/inglaterra/vardy.jpg",307);
		inglaterra.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/inglaterra/walker.jpg",308);
		
		//Polonia
		Pagina polonia=new Pagina("./Archivos/imagenes/banderasRec/poloniaRec.png","Polonia",29,"Grupo H");
		polonia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/polonia/szczesny.jpg",309);
		polonia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/polonia/artur.jpg",310);
		polonia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/polonia/bartosz.jpg",311);
		polonia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/polonia/cionek.jpg",312);
		polonia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/polonia/glik.jpg",313);
		polonia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/polonia/grosicki.jpg",314);
		polonia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/polonia/krychowiak.jpg",315);
		polonia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/polonia/linetty.jpg",316);
		polonia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/polonia/rybus.jpg",317);
		polonia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/polonia/piszczek.jpg",318);
		polonia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/polonia/teodorczyk.jpg",319);
		
		//Senegal
		Pagina senegal=new Pagina("./Archivos/imagenes/banderasRec/senegalRec.png","Senegal",30,"Grupo H");
		senegal.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/senegal/diaye.jpg",320);
		senegal.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/senegal/balde.jpg",321);
		senegal.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/senegal/gassama.jpg",322);
		senegal.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/senegal/konate.jpg",323);
		senegal.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/senegal/koulibaly.jpg",324);
		senegal.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/senegal/kouyate.jpg",325);
		senegal.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/senegal/mane.jpg",326);
		senegal.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/senegal/mbodj.jpg",327);
		senegal.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/senegal/ndoye.jpg",328);
		senegal.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/senegal/niang.jpg",329);
		senegal.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/senegal/sane.jpg",330);
		
		//Colombia
		Pagina colombia=new Pagina("./Archivos/imagenes/banderasRec/colombiaRec.png","Colombia",31,"Grupo H");
		colombia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/colombia/ospina.jpg",331);
		colombia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/colombia/arias.jpg",332);
		colombia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/colombia/bacca.jpg",333);
		colombia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/colombia/barrios.jpg",334);
		colombia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/colombia/cSanchez.jpg",335);
		colombia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/colombia/cZapata.jpg",336);
		colombia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/colombia/dSanchez.jpg",337);
		colombia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/colombia/dZapata.jpg",338);
		colombia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/colombia/falcao.jpg",339);
		colombia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/colombia/mina.jpg",340);
		colombia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/colombia/rodriguez.jpg",341);
		
		//Japon
		Pagina japon=new Pagina("./Archivos/imagenes/banderasRec/japonRec.png","Japon",32,"Grupo H");
		japon.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/japon/nishikawa.jpg",342);
		japon.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/japon/h. sakai.jpg",343);
		japon.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/japon/hasebe.jpg",344);
		japon.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/japon/honda.jpg",345);
		japon.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/japon/kagawa.jpg",346);
		japon.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/japon/kubo.jpg",347);
		japon.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/japon/morishige.jpg",348);
		japon.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/japon/nagatomo.jpg",349);
		japon.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/japon/okazaki.jpg",350);
		japon.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/japon/osako.jpg",351);
		japon.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/japon/sakai.jpg",352);
		
		
		
		
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


