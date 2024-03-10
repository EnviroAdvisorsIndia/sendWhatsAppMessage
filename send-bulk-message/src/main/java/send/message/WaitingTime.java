package send.message;

public class WaitingTime {

	public static void waitTime(int no) throws InterruptedException {
		System.out.println("*** WAIT FOR : " + no + " sec ***");
		for (int i = 1; i < (no + 1); i++) {
			Thread.sleep(1000);
			System.out.println("Waited for " + i + "seconds");
		}
	}

}
