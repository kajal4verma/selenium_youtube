package org.testing.reporthandling;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class loghandling {

	
		public static void log_capture(String className,String msg) {
			DOMConfigurator.configure("../youtube_selenium/layout.xml");
			Logger log= Logger.getLogger(className);
			log.info(msg);
		}

	}



