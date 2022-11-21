package media.cristina.slotMachine;

public class withdrawState extends State {
    public withdrawState(SlotMachine slotMachine) {
        super(slotMachine);
    }

    @Override
    public void addCredits(int credits) {
        System.out.println("[withdrawState] Invalid action in withdrawal mode");
    }

    @Override
    public void playGame() {
        System.out.println("[withdrawState] Invalid action in withdrawal mode");
    }

    @Override
    public void withdrawBalance() {
        System.out.println("[withdrawState] Withdrawal mode already active");
    }

    @Override
    public int ejectCoins() {
        int numCoins = slotMachine.getCredits();
        slotMachine.credits = 0;
        System.out.println("[withdrawState] " + numCoins + " coins ejected");
        slotMachine.changeState(new InitialState(slotMachine));
        return numCoins;
    }
}
