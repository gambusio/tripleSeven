import media.cristina.slotMachine.SlotMachine;

public class termClient {

    public static void main(String[] args) {
        SlotMachine liberty = new SlotMachine();

        liberty.state.addCredits(4);
        liberty.state.playGame();
        liberty.state.withdrawBalance();
        liberty.state.ejectCoins();
        liberty.state.addCredits(20);
        liberty.state.playGame();
        liberty.state.playGame();
        liberty.state.ejectCoins();
        liberty.state.withdrawBalance();
        liberty.state.ejectCoins();
    }
}
