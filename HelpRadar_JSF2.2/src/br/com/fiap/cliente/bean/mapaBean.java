package br.com.fiap.cliente.bean;

import javax.faces.bean.ManagedBean;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
@ManagedBean
public class mapaBean {
	private MapModel marcacoesMapaModel;
	
	public MapModel getMarcacoesMapaModel() {
	marcacoesMapaModel = new DefaultMapModel();
	//Coordenadas dos pontos
	
	LatLng coord1 = new LatLng(-23.571707167350665, -46.65844347000122);
	LatLng coord2 = new LatLng(-23.581530175457033, -46.64949417114258);
	LatLng coord3 = new LatLng(-23.576259640822254, -46.641083488464355);
	

	//Marcadores (google marker)
	
	Marker marker = new Marker(coord3);
	marker.setIcon("https://i.imgur.com/uDQ3UA9.png");
	marker.setLatlng(coord1);
	
	
	marcacoesMapaModel.addOverlay(marker);
	marcacoesMapaModel.addOverlay(new Marker(coord2, "Entrega do Pedido 20") );
	marcacoesMapaModel.addOverlay(new Marker(coord3, "Devolução"));
	
	
	
	
	
	return marcacoesMapaModel;
	}

}
