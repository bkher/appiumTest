package reports;

import org.apache.log4j.Logger;

public class Log {


	private static Logger Log = Logger.getLogger(Log.class.getName());

	public static void startLog(String classname){
		Log.info("----------------------------------------------------------------");
		Log.info("           Testcase Execution Started For "+ classname           );
		Log.info("----------------------------------------------------------------");
	}

	public static void endLog(){
		Log.info("----------------------------------------------------------------");
		Log.info("                  TestCase Execution Completed                  ");
		Log.info("----------------------------------------------------------------");
	}

	public static void info (String message) {
		Log.info(message);
	}

	public static void warn (String message) {
		Log.warn(message);
	}

	public static void error (String message) {
		Log.error(message);
	}

	public static void fatal (String message) {
		Log.fatal(message);
	}

	public static void debug (String message) {
		Log.debug(message);
	}
}
