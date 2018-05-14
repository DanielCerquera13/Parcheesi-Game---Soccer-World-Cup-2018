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
}


