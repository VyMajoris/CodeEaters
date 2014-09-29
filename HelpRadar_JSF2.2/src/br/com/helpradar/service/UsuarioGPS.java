package br.com.helpradar.service;

public class UsuarioGPS<id, foto> {
	/** Sem foto
	 * @param id
	 */
	public UsuarioGPS(int id) {
		super();
		this.id = id;
	}
	/**Com foto
	 * @param id
	 * @param foto
	 */
	
	public UsuarioGPS(int id, byte[] foto) {
		super();
		this.id = id;
		this.foto = foto;
	}
	
	private int id;
	private byte[] foto;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
}
