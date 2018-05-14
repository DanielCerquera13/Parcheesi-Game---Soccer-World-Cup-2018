package modelo;

public class Album {
	
	private Pagina primero;
	private Pagina ultimo;
	private int cantidad;

	public Album() {

		primero = ultimo = null;
		cantidad = 0;

	}

	public void setUltimo(Pagina ultimo) {

		this.ultimo = ultimo;

	}

	public Pagina getUltimo() {

		return ultimo;

	}

	public void setPrimero(Pagina primero) {

		this.primero = primero;

	}

	public Pagina getPrimero() {

		return primero;

	}

	public int getCantidad() {

		return cantidad;

	}

//	public Pagina agregarPagina() throws PaisYaExisteException {
//
//		Pagina nuevo = new Pagina();
//
//		Pagina actual = primero;
//
//		if (yaExiste(pais)) {
//
//			nuevo = null;
//			throw new PaisYaExisteException(pais);
//
//		} else {
//
//			if (actual == null) {
//
//				primero = nuevo;
//				
//
//			} else {
//
//				while (actual.getNext() != null) {
//
//					actual = actual.getNext();
//
//				}
//
//				actual.linkNext(nuevo);
//			
//			}
//			cantidad++;
//		}
//
//		
//		return nuevo;
//	}
//
//	public boolean yaExiste(String pais) {
//
//		boolean existe = false;
//
//		int i = 0;
//
//		Pagina Pagina = primero;
//
//		if (Pagina != null) {
//
//			while ((!(Pagina.getPais().equalsIgnoreCase(pais)) && i != cantidad) && Pagina.getNext() != null) {
//
//				Pagina = Pagina.getNext();
//				i++;
//
//			}
//
//			if (Pagina.getPais().equalsIgnoreCase(pais)) {
//
//				existe = true;
//
//			}
//		}
//		return existe;
//
//	}
//
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
//	public void eliminarPagina(String pais) throws PaginaNoRegistradaException {
//
//		if (yaExiste(pais)) {
//			if (primero.getPais().equalsIgnoreCase(pais)) {
//
//				primero = primero.getNext();
//
//			} else {
//
//				Pagina actual = primero.getNext();
//				Pagina anterior = primero;
//
//				while (!(actual.getPais().equalsIgnoreCase(pais))) {
//
//					actual = actual.getNext();
//					anterior = anterior.getNext();
//
//				}
//
//				anterior.linkNext(actual.getNext());
//
//			}
//			cantidad--;
//		} else {
//
//			throw new PaginaNoRegistradaException(pais);
//
//		}
//
//	}
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
	
	public void rellenarAlbum() {
		
		//Rusia
		Pagina rusia=new Pagina("./Archivos/imagenes/banderasRec/rusia.png", "Rusia", 1, "Grupo A");
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
		arabia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-mayouf.jpg",1);
		arabia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-beraik.jpg",2);
		arabia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-dosari.jpg",3);
		arabia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-harbi.jpg",4);
		arabia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-jassim.jpg",5);
		arabia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-moasher.jpg",6);
		arabia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-sahlawi.jpg",7);
		arabia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-shahrani.jpg",8);
		arabia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-shamrani.jpg",9);
		arabia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/al-shehri.jpg",10);
		arabia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/arabia saudita/hawsawi.jpg",11);
		
		//Egipto
		Pagina egipto=new Pagina("./Archivos/imagenes/banderasRec/egiptoRec.png","Egipto",3,"Grupo A");
		egipto.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/egipto/hadary.jpg",1);
		egipto.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/egipto/el-said.jpg",2);
		egipto.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/egipto/elmohamady.jpg",3);
		egipto.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/egipto/elneny.jpg",4);
		egipto.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/egipto/gabr.jpg",5);
		egipto.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/egipto/hegazi.jpg",6);
		egipto.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/egipto/kahraba.jpg",7);
		egipto.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/egipto/rabia.jpg",8);
		egipto.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/egipto/salah.jpg",9);
		egipto.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/egipto/sobhi.jpg",10);
		egipto.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/egipto/trezeguet.jpg",11);
		
		//Uruguay
		Pagina uruguay=new Pagina("./Archivos/imagenes/banderasRec/uruguayRec.png","Uruguay",4,"Grupo A");
		uruguay.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",1);
		uruguay.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",2);
		uruguay.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",3);
		uruguay.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",4);
		uruguay.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",5);
		uruguay.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",6);
		uruguay.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",7);
		uruguay.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",8);
		uruguay.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",9);
		uruguay.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",10);
		uruguay.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/uruguay/muslera.jpg",11);
		
		//Portugal
		Pagina portugal=new Pagina("./Archivos/imagenes/banderasRec/portugalRec.png","Portugal",5,"Grupo B");
		portugal.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/portugal/patricio.jpg",1);
		portugal.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/portugal/aSilva.jpg",2);
		portugal.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/portugal/carvalho.jpg",3);
		portugal.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/portugal/cristiano.jpg",4);
		portugal.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/portugal/eliseu.jpg",5);
		portugal.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/portugal/fonte.jpg",6);
		portugal.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/portugal/guerreiro.jpg",7);
		portugal.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/portugal/moutinho.jpg",8);
		portugal.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/portugal/nani.jpg",9);
		portugal.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/portugal/pepe.jpg",10);
		portugal.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/portugal/silva.jpg",11);
		
		//España
		Pagina españa=new Pagina("./Archivos/imagenes/banderasRec/españaRec.png","España",6,"Grupo B");
		españa.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/españa/DeGea.jpg",1);
		españa.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/españa/alba.jpg",2);
		españa.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/españa/asensio.jpg",3);
		españa.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/españa/busquet.jpg",4);
		españa.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/españa/carvajal.jpg",5);
		españa.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/españa/costa.jpg",6);
		españa.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/españa/iniesta.jpg",7);
		españa.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/españa/isco.jpg",8);
		españa.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/españa/morata.jpg",9);
		españa.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/españa/ramos.jpg",10);
		españa.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/españa/vitolo.jpg",11);
		
		//Marruecos
		Pagina marruecos=new Pagina("./Archivos/imagenes/banderasRec/marruecosRec.png","Marruecos",7,"Grupo B");
		marruecos.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/marruecos/mohamedi.jpg",1);
		marruecos.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/marruecos/alioui.jpg",2);
		marruecos.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/marruecos/amrabat.jpg",3);
		marruecos.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/marruecos/bouhaddouz.jpg",4);
		marruecos.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/marruecos/chafik.jpg",5);
		marruecos.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/marruecos/en-nesyri.jpg",6);
		marruecos.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/marruecos/fajr.jpg",7);
		marruecos.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/marruecos/hakimi.jpg",8);
		marruecos.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/marruecos/mendyl.jpg",9);
		marruecos.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/marruecos/saiss.jpg",10);
		marruecos.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/marruecos/ziyech.jpg",11);
		
		
		//Iran
		Pagina iran=new Pagina("./Archivos/imagenes/banderasRec/iranRec.png","Iran",8,"Grupo B");
		iran.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/iran/beiranvand.jpg",1);
		iran.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/iran/amiri.jpg",2);
		iran.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/iran/ansarifar.jpg",3);
		iran.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/iran/azmoun.jpg",4);
		iran.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/iran/ebrahimi.jpg",5);
		iran.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/iran/ghafouri.jpg",6);
		iran.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/iran/ghoddos.jpg",7);
		iran.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/iran/ghoochannejhad.jpg",8);
		iran.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/iran/hajsafi.jpg",9);
		iran.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/iran/jakanbakhsh.jpg",10);
		iran.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/iran/rezaeian.jpg",11);
		
		//Francia
		Pagina francia=new Pagina("./Archivos/imagenes/banderasRec/franciaRec.png","Francia",9,"Grupo C");
		francia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/francia/lloris.jpg",1);
		francia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/francia/dembele.jpg",2);
		francia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/francia/griezmann.jpg",3);
		francia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/francia/kurzawa.jpg",4);
		francia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/francia/lemar.jpg",5);
		francia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/francia/martial.jpg",6);
		francia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/francia/mbappe.jpg",7);
		francia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/francia/pogba.jpg",8);
		francia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/francia/rabiot.jpg",9);
		francia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/francia/umtiti.jpg",10);
		francia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/francia/varane.jpg",11);
		
		//Australia
		Pagina australia=new Pagina("./Archivos/imagenes/banderasRec/australiaRec.png","Australia",10,"Grupo C");
		australia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/australia/ryan.jpg",1);
		australia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/australia/behich.jpg",2);
		australia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/australia/cahill.jpg",3);
		australia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/australia/degenek.jpg",4);
		australia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/australia/jedinak.jpg",5);
		australia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/australia/juric.jpg",6);
		australia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/australia/kruse.jpg",7);
		australia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/australia/luongo.jpg",8);
		australia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/australia/mcgowan.jpg",9);
		australia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/australia/mooy.jpg",10);
		australia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/australia/wright.jpg",11);
		
		
		//Peru
		Pagina peru=new Pagina("./Archivos/imagenes/banderasRec/peruRec.png","Peru",11,"Grupo C");
		peru.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/peru/gallese.jpg",1);
		peru.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/peru/araujo.jpg",2);
		peru.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/peru/corzo.jpg",3);
		peru.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/peru/cueva.jpg",4);
		peru.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/peru/farfan.jpg",5);
		peru.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/peru/guerrero.jpg",6);
		peru.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/peru/polo.jpg",7);
		peru.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/peru/rodriguez.jpg",8);
		peru.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/peru/ruidiaz.jpg",9);
		peru.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/peru/trauco.jpg",10);
		peru.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/peru/yotun.jpg",11);
		
		//Dinamarca
		Pagina dinamarca=new Pagina("./Archivos/imagenes/banderasRec/dinamarcaRec.png","Dinamarca",12,"Grupo C");
		dinamarca.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/dinamarca/schmeichel.jpg",1);
		dinamarca.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/dinamarca/bjelland.jpg",2);
		dinamarca.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/dinamarca/christensen.jpg",3);
		dinamarca.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/dinamarca/cornelius.jpg",4);
		dinamarca.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/dinamarca/eriksen.jpg",5);
		dinamarca.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/dinamarca/jorgensen.jpg",6);
		dinamarca.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/dinamarca/kjaer.jpg",7);
		dinamarca.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/dinamarca/poulsen.jpg",8);
		dinamarca.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/dinamarca/schone.jpg",9);
		dinamarca.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/dinamarca/sisto.jpg",10);
		dinamarca.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/dinamarca/vestergaard.jpg",11);
		
		//Argentina
		Pagina argentina=new Pagina("./Archivos/imagenes/banderasRec/argentinaRec.png","Argentina",13,"Grupo D");
		argentina.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/argentina/romero.jpg",1);
		argentina.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/argentina/aguero.jpg",2);
		argentina.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/argentina/di maria.jpg",3);
		argentina.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/argentina/dybala.jpg",4);
		argentina.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/argentina/fazio.jpg",5);
		argentina.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/argentina/higuain.jpg",6);
		argentina.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/argentina/icardi.jpg",7);
		argentina.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/argentina/masherano.jpg",8);
		argentina.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/argentina/messi.jpg",9);
		argentina.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/argentina/otamendi.jpg",10);
		argentina.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/argentina/perez.jpg",11);
		
		//Islandia
		Pagina islandia=new Pagina("./Archivos/imagenes/banderasRec/islandiaRec.png","Islandia",14,"Grupo D");
		islandia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/islandia/halldorsson.jpg",1);
		islandia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/islandia/bjarnason.jpg",2);
		islandia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/islandia/bodvarsson.jpg",3);
		islandia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/islandia/finnbogason.jpg",4);
		islandia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/islandia/gislason.jpg",5);
		islandia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/islandia/gunnarsson.jpg",6);
		islandia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/islandia/hallfredsson.jpg",7);
		islandia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/islandia/ingason.jpg",8);
		islandia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/islandia/sigurdarson.jpg",9);
		islandia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/islandia/sigurdsson.jpg",10);
		islandia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/islandia/skulason.jpg",11);
		
		//Croacia
		Pagina croacia=new Pagina("./Archivos/imagenes/banderasRec/croaciaRec.png","Croacia",15,"Grupo D");
		croacia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/croacia/subasic.jpg",1);
		croacia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/croacia/kalinic.jpg",2);
		croacia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/croacia/kovacic.jpg",3);
		croacia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/croacia/kramaric.jpg",4);
		croacia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/croacia/mandzukic.jpg",5);
		croacia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/croacia/modric.jpg",6);
		croacia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/croacia/perisic.jpg",7);
		croacia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/croacia/pivaric.jpg",8);
		croacia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/croacia/rakitic.jpg",9);
		croacia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/croacia/strinic.jpg",10);
		croacia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/croacia/vida.jpg",11);
		
		//Nigeria
		Pagina nigeria=new Pagina("./Archivos/imagenes/banderasRec/nigeriaRec.png","Nigeria",16,"Grupo D");
		nigeria.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/nigeria/ezenwa.jpg",1);
		nigeria.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/nigeria/aina.jpg",2);
		nigeria.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/nigeria/balogun.jpg",3);
		nigeria.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/nigeria/echijile.jpg",4);
		nigeria.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/nigeria/ighalo.jpg",5);
		nigeria.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/nigeria/iheanacho.jpg",6);
		nigeria.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/nigeria/iwobi.jpg",7);
		nigeria.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/nigeria/mikel.jpg",8);
		nigeria.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/nigeria/musa.jpg",9);
		nigeria.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/nigeria/ndidi.jpg",10);
		nigeria.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/nigeria/omeruo.jpg",11);
		
		//Brasil
	}
}


