package com.chat;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.chat.data.MetricDat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class pruebaQuantityMetric {


	@Test
	public void test() {
		MetricDat metricData = new MetricDat();
		int cantidad=0;
		cantidad = metricData.getQuantityRooms();
		assertTrue(cantidad>1);
	}

}
