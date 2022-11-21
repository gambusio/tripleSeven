package media.cristina.slotMachine;

public class PlayableState extends State {
    public PlayableState(SlotMachine slotMachine) {
        super(slotMachine);
    }

    @Override
    public void addCredits(int credits) {
        System.out.println("[PlayableState] Add " + credits + " credits");
        slotMachine.credits += credits;
    }

    @Override
    public void playGame() {
        slotMachine.spin();
        System.out.print("[PlayableState] Activating game ");
        System.out.println(slotMachine.getReel() + " PRIZE: " + slotMachine.getPrize() + " CREDITS: " + slotMachine.getCredits());
        if (slotMachine.getCredits() < 5) {
            slotMachine.changeState(new InitialState(this.slotMachine));
        }
    }

    @Override
    public void withdrawBalance() {
        System.out.println("[PlayableState] Preparing withdrawal of funds");
        slotMachine.changeState(new withdrawState(slotMachine));
    }

    @Override
    public int ejectCoins() {
        System.out.println("[InitialSate] No coins to eject");
        return 0;
    }
}
