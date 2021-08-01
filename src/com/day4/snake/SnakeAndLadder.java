package com.day4.snake;

import java.util.Random;

public class SnakeAndLadder {
    public static Random random = new Random();
    public static int diceRoll, slnp, player1, turns1,turns2, player2,turns;

    public static void main(String[] args) {
        Loop();

    }

    public static void Dice() {
        turns = turns + 1;
        int temp = random.nextInt(6);
        diceRoll = temp + 1;
    }

    public static void SLNP() {
        int temp = random.nextInt(3);
        slnp = temp + 1;
        if (slnp == 1) {// No play
            SLNP1();
        }
        else if (slnp == 2) {// Snake
            turns1=turns1+1;
            Dice();
            player1 = player1 + diceRoll;
        }
        else 
        {
            turns1=turns1+1;
            Dice();
            player1 = player1 - diceRoll;
            if (player1 < 0) 
            {
                player1 = 0;
            }
            SLNP1();
        }
    }

    public static void SLNP1() {
        int temp = random.nextInt(3);
        slnp = temp + 1;
        if (slnp == 1) {// No play

        } else if (slnp == 2) {// Snake
            turns2=turns2+1;
            Dice();
            player2 = player2 + diceRoll;
        }
        else
        {
            turns2=turns2+1;
            Dice();
            player2 = player2 - diceRoll;
            if (player2 < 0)
            {
                player2 = 0;
            }
        }
    }

    public static void Loop() {
        while (player1 < 100 || player2 < 100) {
            SLNP();
        }
        if (player1 == 100) {
            System.out.println("Player 1 WINS");
            System.out.println("Total Dice rolls by player 1 : " + turns1);
            System.out.println("Total Dice rolls by player 2 : " + turns2);
            System.out.println("Total dice rolled : "+ turns);
        } else if (player2 == 100) {
            System.out.println("Player 2 WINS");
            System.out.println("Total Dice rolls by player 1 : " + turns1);
            System.out.println("Total Dice rolls by player 2 : " + turns2);
            System.out.println("Total dice rolled : "+ turns);
        } else if (player1 > 100) {
            player1 = player1 - diceRoll;
            Loop();
        } else if (player2 > 100) {
            player2 = player2 - diceRoll;
            Loop();
        }

    }
}
