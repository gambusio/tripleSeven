import media.cristina.slotMachine.slotMachine;

public class termClient {

    public static void main(String[] args) {
        slotMachine liberty = new slotMachine();
        short numSpins = 0;

        boolean exit = false;
        while (!exit) {
                if (liberty.getCredits() == 0) {
                    System.out.println("No credits, game over");
                    System.out.println("SPINS: " + numSpins);
                    exit = true;
                } else {
                    liberty.spin();
                    numSpins++;
                    System.out.println(liberty.getReel() + " PRIZE: " + liberty.getPrize() + " CREDITS: " + liberty.getCredits());
                }
        }
    }
}
