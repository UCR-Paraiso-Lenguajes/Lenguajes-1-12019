package com.chat.bussines;

import org.springframework.beans.factory.annotation.Autowired;

import com.chat.data.MetricData;

public class MetricBussines {
	@Autowired
	MetricData metricData;

	public int getQuantityUser() {
		return metricData.getQuantityUser();

	}

	public int getQuantityRooms() {
		return metricData.getQuantityRooms();

	}

	public int getAvgUserPerGroup() {
		return metricData.getAvgUserPerGroup();

	}

	public String getFechaPrimerLogueo() {
		return metricData.getFechaPrimerLogueo();

	}
	/*
	 * public String getFechaUltimoMensaje(chatRoom) { return
	 * metricData.getFechaUltimoMensaje(chatRoom)
	 * 
	 * }
	 */

	public String getUsuarioMasMensajes() {
		return metricData.getUsuarioMasMensajes();

	}
	

}
