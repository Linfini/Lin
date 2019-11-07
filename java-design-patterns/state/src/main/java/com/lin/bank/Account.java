package com.lin.bank;

/**
 *
 */
public class Account {
    private String state;
    private int balance;


    public void deposit() {
        stateCheck();
    }

    public void withdrwa() {
        if (state.equalsIgnoreCase("NormailState") || state.equalsIgnoreCase("OverdraftState")) {
            //取款操作
            stateCheck();
        } else {
            System.out.println("取款受限");
        }
    }

    public void computeInterest() {
        if (state.equalsIgnoreCase("OverdraftState") || state.equalsIgnoreCase("RestrictedState")) {
            //计算利息操作
        }
    }

    //状态检查和转换操作
    private void stateCheck() {
        if (balance >= 0) {
            state = "NormalState";
        } else if (balance > -2000 && balance < 0) {
            state = "OverdraftState";
        } else if (balance == -2000) {
            state = "RestrictedState";
        } else if (balance < -2000) {
            System.out.println("余额小于-2000,操作受限");
        }
    }
}
