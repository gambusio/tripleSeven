package media.cristina.slotMachine;

abstract public class State {
    public SlotMachine slotMachine;

    public State(SlotMachine slotMachine) {
        this.slotMachine = slotMachine;
    }

    abstract public void addCredits(int credits);
    abstract public void playGame();
    abstract public void withdrawBalance();
    abstract public int ejectCoins();

}
