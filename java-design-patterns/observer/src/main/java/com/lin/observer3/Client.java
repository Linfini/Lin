package com.lin.observer3;

public class Client {
    public static void main(String[] args) {
        AllyControllerCenter acc = new ConcreteAllyController("金庸群侠");
        Observer player1 = new Player("杨过"),
                player2 = new Player("令狐冲"),
                player3 = new Player("张无忌"),
                player4 = new Player("段誉");

        acc.join(player1);
        acc.join(player2);
        acc.join(player3);
        acc.join(player4);

        player1.beAttacked(acc);
    }
}
