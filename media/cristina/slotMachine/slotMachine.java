package media.cristina.slotMachine;


import java.util.Objects;
import java.util.Random;

public class slotMachine {

    //constants for the default slot machine
    private final String DIGIT_SEVEN = "\u0037";
    private final String DIAMOND = "\u2666";
    private final String HEART = "\u2666";
    private final String SPADE = "\u2660";
    private final String HORSE_SHOES = "\uD83E\uDDF2";
    private final String LIBERTY_BELL = "\uD83D\uDD14";
    private final String STAR = "\u2b50";

    Random rand = new Random(System.currentTimeMillis());

    byte reelNumber;
    short reelSize;
    byte symbolNumber;
    String[][] reel;
    short[] cursors;
    String[] symbols;
    short credits;

    public slotMachine() {

        reelNumber = 3;    // default configure a classic Liberty-bell three-reel slots
        reelSize = 200;
        symbolNumber = 8;
        credits = 100;
        reel = new String[reelNumber][reelSize];
        cursors = new short[reelNumber];
        symbols = new String[symbolNumber];

        System.out.println(DIGIT_SEVEN + DIGIT_SEVEN + DIGIT_SEVEN + " tripleSeven SlotMachine Init");

        symbols[0] = DIAMOND;
        symbols[1] = HEART;
        symbols[2] = SPADE;
        symbols[3] = HORSE_SHOES;
        symbols[4] = STAR;
        symbols[5] = LIBERTY_BELL;
        symbols[6] = HORSE_SHOES;
        symbols[7] = HORSE_SHOES;


        for (int i = 0; i < reelNumber; i++) {
            for (int j = 0; j < reelSize; j++) {
                //reel[i][j] = symbols[j % symbolNumber];
                reel[i][j] = symbols[rand.nextInt(symbolNumber)];
            }
        }
    }

    public String getReel() {
        StringBuilder reelStr = new StringBuilder();
        for (int i= 0; i < reelNumber; i++) {
            reelStr.append(reel[i][cursors[i]]);
        }
        return reelStr.toString();
    }
    public void printReels() {
        for (int i = 0; i < reelSize; i++) {
            for (int j = 0; j < reelNumber; j++) {
                System.out.print(reel[j][i]);
            }
            System.out.println();
        }
    }

    public int getPrize() {
        /*
            The payouts for the Liberty Bell were as follows:

            2 horseshoes = 5 cents
            2 horseshoe + 1 star = 10 cents
            3 spades = 20 cents
            3 diamonds = 30 cents
            3 hearts = 40 cents
            3 Liberty Bells = 50 cents
        */
        int prize = 0;
        String reelStr = this.getReel();
        if (Objects.equals(reelStr, LIBERTY_BELL + LIBERTY_BELL + LIBERTY_BELL)) {
            prize = 50;
        } else if (Objects.equals(reelStr, HEART + HEART + HEART)) {
            prize = 40;
        } else if (Objects.equals(reelStr, DIAMOND + DIAMOND + DIAMOND)) {
            prize = 30;
        } else if (Objects.equals(reelStr, SPADE + SPADE + SPADE)) {
            prize = 20;
        } else if (reelStr.startsWith(HORSE_SHOES + HORSE_SHOES)) {
            if (reelStr.endsWith(STAR)) {
                prize = 10;
            } else {
                prize = 5;
            }
        }
        this.credits += prize;
        return prize;
    }

    public short getCredits() {
        return credits;
    }
    public void spin() {
        for(int i = 0; i < reelNumber; i++) cursors[i] = (short) rand.nextInt(reelSize);
        this.credits -= 5;
    }
}
