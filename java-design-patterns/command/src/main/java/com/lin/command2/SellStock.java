package com.lin.command2;

/**
 * ConcreteCommand
 * */
public class SellStock implements Order {
    private Stock abdStock;

    public SellStock(Stock abdStock) {
        this.abdStock = abdStock;
    }

    @Override
    public void execute() {
        abdStock.sell();
    }
}
