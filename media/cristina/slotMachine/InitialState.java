package media.cristina.slotMachine;

public class InitialState extends State {

    public InitialState(SlotMachine slotMachine) {
        super(slotMachine);
    }

    @Override
    public void addCredits(int credits) {
        System.out.println("[InitialSate] Add " + credits + " credits");
        slotMachine.credits += credits;
        if (slotMachine.getCredits() >= 5) { //we have sufficient credits to play
            slotMachine.changeState(new PlayableState(slotMachine));
        }
    }

    @Override
    public void playGame() {
        System.out.println("[InitialState] Insufficient funds to play");
    }

    @Override
    public void withdrawBalance() {
        if (slotMachine.getCredits() > 0) { //has some credits?
            System.out.println("[InitialState] Preparing withdrawal of funds");
            slotMachine.changeState(new withdrawState(slotMachine));
        } else {
            System.out.println("[InitialState] You have no funds to withdraw");
        }
    }

    @Override
    public int ejectCoins() {
        System.out.println("[InitialState] No coins to eject");
        return 0;
    }
}
