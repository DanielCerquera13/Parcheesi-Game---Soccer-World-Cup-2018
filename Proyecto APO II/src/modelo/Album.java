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
		Pagina espana=new Pagina("./Archivos/imagenes/banderasRec/españaRec.png","España",6,"Grupo B");
		espana.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/españa/DeGea.jpg",1);
		espana.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/españa/alba.jpg",2);
		espana.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/españa/asensio.jpg",3);
		espana.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/españa/busquet.jpg",4);
		espana.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/españa/carvajal.jpg",5);
		espana.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/españa/costa.jpg",6);
		espana.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/españa/iniesta.jpg",7);
		espana.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/españa/isco.jpg",8);
		espana.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/españa/morata.jpg",9);
		espana.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/españa/ramos.jpg",10);
		espana.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/españa/vitolo.jpg",11);
		
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
		Pagina brasil=new Pagina("./Archivos/imagenes/banderasRec/brasilRec.png","Brasil",17,"Grupo E");
		brasil.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/brasil/alisson.jpg",1);
		brasil.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/brasil/alves.jpg",2);
		brasil.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/brasil/casemiro.jpg",3);
		brasil.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/brasil/coutinho.jpg",4);
		brasil.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/brasil/firminho.jpg",5);
		brasil.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/brasil/jesus.jpg",6);
		brasil.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/brasil/marcelo.jpg",7);
		brasil.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/brasil/marquinhos.jpg",8);
		brasil.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/brasil/neymar.jpg",9);
		brasil.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/brasil/paulinho.jpg",10);
		brasil.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/brasil/silva.jpg",11);
		
		//Suiza
		Pagina suiza=new Pagina("./Archivos/imagenes/banderasRec/suizaRec.png","Suiza",18,"Grupo E");
		suiza.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/suiza/sommer.jpg",1);
		suiza.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/suiza/akanji.jpg",2);
		suiza.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/suiza/behrami.jpg",3);
		suiza.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/suiza/derdijok.jpg",4);
		suiza.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/suiza/djorou.jpg",5);
		suiza.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/suiza/embolo.jpg",6);
		suiza.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/suiza/lichtsteiner.jpg",7);
		suiza.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/suiza/mehmedi.jpg",8);
		suiza.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/suiza/rodriguez.jpg",9);
		suiza.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/suiza/shaqiri.jpg",10);
		suiza.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/suiza/xhaka.jpg",11);
		
		//Costa Rica
		Pagina costa=new Pagina("./Archivos/imagenes/banderasRec/costa ricaRec.png","Costa Rica",19,"Grupo E");
		costa.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/costa rica/navas.jpg",1);
		costa.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/costa rica/azofeifa.jpg",2);
		costa.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/costa rica/borges.jpg",3);
		costa.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/costa rica/calvo.jpg",4);
		costa.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/costa rica/guzman.jpg",5);
		costa.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/costa rica/matarrita.jpg",6);
		costa.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/costa rica/oviedo.jpg",7);
		costa.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/costa rica/ureña.jpg",8);
		costa.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/costa rica/venegas.jpg",9);
		costa.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/costa rica/wallace.jpg",10);
		costa.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/costa rica/waston.jpg",11);
		
		//Serbia
		Pagina serbia=new Pagina("./Archivos/imagenes/banderasRec/serbiaRec.png","Serbia",20,"Grupo E");
		serbia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/serbia/stojkovic.jpg",1);
		serbia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/serbia/gacinovic.jpg",2);
		serbia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/serbia/ivanovic.jpg",3);
		serbia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/serbia/kolarov.jpg",4);
		serbia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/serbia/kostic.jpg",5);
		serbia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/serbia/milivojevic.jpg",6);
		serbia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/serbia/mitrovic.jpg",7);
		serbia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/serbia/nastasic.jpg",8);
		serbia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/serbia/prijovic.jpg",9);
		serbia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/serbia/rukavina.jpg",10);
		serbia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/serbia/vukovic.jpg",11);
		
		//Alemania
		Pagina alemania=new Pagina("./Archivos/imagenes/banderasRec/alemaniaRec.png","Alemania",21,"Grupo F");
		alemania.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/alemania/neuer.jpg",1);
		alemania.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/alemania/boateng.jpg",2);
		alemania.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/alemania/draxler.jpg",3);
		alemania.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/alemania/gotze.jpg",4);
		alemania.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/alemania/hummels.jpg",5);
		alemania.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/alemania/khedira.jpg",6);
		alemania.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/alemania/kroos.jpg",7);
		alemania.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/alemania/muller.jpg",8);
		alemania.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/alemania/ozil.jpg",9);
		alemania.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/alemania/sane.jpg",10);
		alemania.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/alemania/werner.jpg",11);
		
		//Mexico
		Pagina mexico=new Pagina("./Archivos/imagenes/banderasRec/mexicoRec.png","Mexico",22,"Grupo F");
		mexico.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/mexico/ochoa.jpg",1);
		mexico.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/mexico/chicharito.jpg",2);
		mexico.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/mexico/dos-santos.jpg",3);
		mexico.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/mexico/gallardo.jpg",4);
		mexico.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/mexico/gDosSantos.jpg",5);
		mexico.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/mexico/herrera.jpg",6);
		mexico.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/mexico/jimenez.jpg",7);
		mexico.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/mexico/layun.jpg",8);
		mexico.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/mexico/moreno.jpg",9);
		mexico.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/mexico/reyes.jpg",10);
		mexico.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/mexico/vela.jpg",11);
		
		//Suecia
		Pagina suecia=new Pagina("./Archivos/imagenes/banderasRec/sueciaRec.png","Suecia",23,"Grupo F");
		suecia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/suecia/olsen.jpg",1);
		suecia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/suecia/berg.jpg",2);
		suecia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/suecia/durmaz.jpg",3);
		suecia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/suecia/forsberg.jpg",4);
		suecia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/suecia/granqist.jpg",5);
		suecia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/suecia/jansson.jpg",6);
		suecia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/suecia/larsson.jpg",7);
		suecia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/suecia/lindelof.jpg",8);
		suecia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/suecia/olsson.jpg",9);
		suecia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/suecia/svensson.jpg",10);
		suecia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/suecia/thelin.jpg",11);
		
		//Corea del Sur
		Pagina corea=new Pagina("./Archivos/imagenes/banderasRec/coreaRec.png","Corea del Sur",24,"Grupo F");
		corea.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/corea/seunggyu.jpg",1);
		corea.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/corea/dongwon.jpg",2);
		corea.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/corea/heechan.jpg",3);
		corea.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/corea/jeongho.jpg",4);
		corea.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/corea/jinsu.jpg",5);
		corea.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/corea/kookyoung.jpg",6);
		corea.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/corea/shinwook.jpg",7);
		corea.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/corea/sungyueng.jpg",8);
		corea.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/corea/taehee.jpg",9);
		corea.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/corea/taehwi.jpg",10);
		corea.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/corea/younggwon.jpg",11);
		
		//Belgica
		Pagina belgica=new Pagina("./Archivos/imagenes/banderasRec/belgicaRec.png","Belgica",25,"Grupo G");
		belgica.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/belgica/courtois.jpg",1);
		belgica.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/belgica/bruyne.jpg",2);
		belgica.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/belgica/carrasco.jpg",3);
		belgica.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/belgica/fellaini.jpg",4);
		belgica.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/belgica/hazard.jpg",5);
		belgica.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/belgica/kompany.jpg",6);
		belgica.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/belgica/lukaku.jpg",7);
		belgica.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/belgica/mertens.jpg",8);
		belgica.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/belgica/meunier.jpg",9);
		belgica.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/belgica/nainggolan.jpg",10);
		belgica.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/belgica/vertonghen.jpg",11);
		
		//Panama
		Pagina panama=new Pagina("./Archivos/imagenes/banderasRec/panamaRec.png","Panama",26,"Grupo G");
		panama.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/panama/calderon.jpg",1);
		panama.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/panama/arroyo.jpg",2);
		panama.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/panama/barcenas.jpg",3);
		panama.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/panama/davis.jpg",4);
		panama.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/panama/godoy.jpg",5);
		panama.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/panama/gTorres.jpg",6);
		panama.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/panama/machado.jpg",7);
		panama.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/panama/murillo.jpg",8);
		panama.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/panama/quintero.jpg",9);
		panama.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/panama/tejada.jpg",10);
		panama.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/panama/torres.jpg",11);
		
		//Tunez
		Pagina tunez=new Pagina("./Archivos/imagenes/banderasRec/tunezRec.png","Tunez",27,"Grupo G");
		tunez.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/tunez/mathlouthi.jpg",1);
		tunez.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/tunez/akaichi.jpg",2);
		tunez.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/tunez/badri.jpg",3);
		tunez.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/tunez/chaalali.jpg",4);
		tunez.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/tunez/khazri.jpg",5);
		tunez.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/tunez/maaloul.jpg",6);
		tunez.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/tunez/meriah.jpg",7);
		tunez.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/tunez/naguez.jpg",8);
		tunez.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/tunez/sliti.jpg",9);
		tunez.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/tunez/touzghar.jpg",10);
		tunez.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/tunez/youssef.jpg",11);
		
		//Inglaterra
		Pagina inglaterra=new Pagina("./Archivos/imagenes/banderasRec/inglaterraRec.png","Inglaterra",28,"Grupo G");
		inglaterra.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/inglaterra/hart.jpg",1);
		inglaterra.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/inglaterra/alli.jpg",2);
		inglaterra.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/inglaterra/bertrand.jpg",3);
		inglaterra.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/inglaterra/cahill.jpg",4);
		inglaterra.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/inglaterra/henderson.jpg",5);
		inglaterra.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/inglaterra/kane.jpg",6);
		inglaterra.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/inglaterra/lingard.jpg",7);
		inglaterra.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/inglaterra/rose.jpg",8);
		inglaterra.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/inglaterra/sterling.jpg",9);
		inglaterra.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/inglaterra/vardy.jpg",10);
		inglaterra.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/inglaterra/walker.jpg",11);
		
		//Polonia
		Pagina polonia=new Pagina("./Archivos/imagenes/banderasRec/poloniaRec.png","Polonia",29,"Grupo F");
		polonia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/polonia/szczesny.jpg",1);
		polonia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/polonia/artur.jpg",2);
		polonia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/polonia/bartosz.jpg",3);
		polonia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/polonia/cionek.jpg",4);
		polonia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/polonia/glik.jpg",5);
		polonia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/polonia/grosicki.jpg",6);
		polonia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/polonia/krychowiak.jpg",7);
		polonia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/polonia/linetty.jpg",8);
		polonia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/polonia/rybus.jpg",9);
		polonia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/polonia/piszczek.jpg",10);
		polonia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/polonia/teodorczyk.jpg",11);
		
		//Senegal
		Pagina senegal=new Pagina("./Archivos/imagenes/banderasRec/senegalRec.png","Senegal",30,"Grupo F");
		senegal.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/senegal/diaye.jpg",1);
		senegal.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/senegal/balde.jpg",2);
		senegal.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/senegal/gassama.jpg",3);
		senegal.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/senegal/konate.jpg",4);
		senegal.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/senegal/koulibaly.jpg",5);
		senegal.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/senegal/kouyate.jpg",6);
		senegal.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/senegal/mane.jpg",7);
		senegal.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/senegal/mbodj.jpg",8);
		senegal.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/senegal/ndoye.jpg",9);
		senegal.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/senegal/niang.jpg",10);
		senegal.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/senegal/sane.jpg",11);
		
		//Colombia
		Pagina colombia=new Pagina("./Archivos/imagenes/banderasRec/colombiaRec.png","Colombia",31,"Grupo F");
		colombia.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/colombia/ospina.jpg",1);
		colombia.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/colombia/arias.jpg",2);
		colombia.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/colombia/bacca.jpg",3);
		colombia.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/colombia/barrios.jpg",4);
		colombia.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/colombia/cSanchez.jpg",5);
		colombia.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/colombia/cZapata.jpg",6);
		colombia.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/colombia/dSanchez.jpg",7);
		colombia.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/colombia/dZapata.jpg",8);
		colombia.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/colombia/falcao.jpg",9);
		colombia.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/colombia/mina.jpg",10);
		colombia.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/colombia/rodriguez.jpg",11);
		
		//Japon
		Pagina japon=new Pagina("./Archivos/imagenes/banderasRec/japonRec.png","Japon",33,"Grupo F");
		japon.getLaminas()[0]=new Lamina("./Archivos/imagenes/laminas/japon/nishikawa.jpg",1);
		japon.getLaminas()[1]=new Lamina("./Archivos/imagenes/laminas/japon/h. sakai.jpg",2);
		japon.getLaminas()[2]=new Lamina("./Archivos/imagenes/laminas/japon/hasebe.jpg",3);
		japon.getLaminas()[3]=new Lamina("./Archivos/imagenes/laminas/japon/honda.jpg",4);
		japon.getLaminas()[4]=new Lamina("./Archivos/imagenes/laminas/japon/kagawa.jpg",5);
		japon.getLaminas()[5]=new Lamina("./Archivos/imagenes/laminas/japon/kubo.jpg",6);
		japon.getLaminas()[6]=new Lamina("./Archivos/imagenes/laminas/japon/morishige.jpg",7);
		japon.getLaminas()[7]=new Lamina("./Archivos/imagenes/laminas/japon/nagatomo.jpg",8);
		japon.getLaminas()[8]=new Lamina("./Archivos/imagenes/laminas/japon/okazaki.jpg",9);
		japon.getLaminas()[9]=new Lamina("./Archivos/imagenes/laminas/japon/osako.jpg",10);
		japon.getLaminas()[10]=new Lamina("./Archivos/imagenes/laminas/japon/sakai.jpg",11);
		
		
		
		
		

	}
}


