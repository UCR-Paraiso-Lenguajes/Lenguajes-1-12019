package com.projectOne.interactiveMessaging.tda;

public class Util {
	
	public static boolean igualQ(Object a, Object b) {

		if (a instanceof Integer && b instanceof Integer) {
			Integer x = (Integer) a;
			Integer y = (Integer) b;
			return x == y;
		}
		if (a instanceof String && b instanceof String) {
			String x = (String) a;
			String y = (String) b;

			return x.equals(y);
		}
		if (a instanceof Character && b instanceof Character) {
			char x = (char) a;
			char y = (char) b;
			return x == y;
		}
		if (a instanceof QueueLinked && b instanceof QueueLinked) {
			QueueLinked x = (QueueLinked) a;
			QueueLinked y = (QueueLinked) b;
			return igualQ(x.toString(), y.toString());
		}

		if (a instanceof Character && b instanceof String) {
			char x = (char) a;
			String y = (String) b;
			String c = "" + x;
			return c.equals(y);
		}
		if (a instanceof Character && b instanceof Character) {
			char x = (char) a;
			char y = (char) b;

			return x == y;
		}
		if (a instanceof Nodo && b instanceof Nodo) {
			Nodo x = (Nodo) a;
			Nodo y = (Nodo) b;
			return igualQ(x, y);
		}
		if (a instanceof Queue && b instanceof Queue) {

			Queue x = (Queue) a;
			Queue y = (Queue) b;
			return igualQ(x, y);

		}
		return false;

	}

}
