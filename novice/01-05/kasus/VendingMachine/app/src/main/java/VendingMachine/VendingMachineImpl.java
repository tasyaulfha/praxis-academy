package VendingMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VendingMachineImpl implements VendingMachine{
    private Inventory<Coin> cashInventory = new Inventory<Coin>();
    private Inventory<Item> itemInventory = new Inventory<Item>();
    private long totalSales;
    private Item currentItem;
    private long currentBalance;


    public VendingMachineImpl(){
        initialize();
    }

    private void initialize(){
        for(Coin c : Coin.values()){
            cashInventory.put(c,5);
        }
        for(Item i : Item.values()){
            itemInventory.put(i,5);
        }
    }

    @Override
    public void insertCoin(Coin coin){
        currentBalance = currentBalance + coin.getDenomination();
        cashInventory.add(coin);
        System.out.println();
    }
    @Override
    public Bucket<Item, List<Coin>> collectItemAndChange() {
        Item item = collectItem();
        totalSales = totalSales + currentItem.getPrice();
       
        List<Coin> change = collectChange();
       
        return new Bucket<Item, List<Coin>>(item, change);
    }

    private Item collectItem() throws NotSufficientChangeException, NotFullPaidException{
        if(isFullPaid){
            if(hasSufficientChange()){
                itemInventory.deduct(currentItem);
                return currentItem;
            }
            throw new NotSufficientChangeException("Not sufficient change in inventory");
        }
        long remainingBalance = currentItem.getPrice() - currentBalance;
        throw new NotFullPaidException("Price not full paid, remaining :" +remainingBalance);
    }
    private List<Coin> collectChange(){
        long changeAmount = currentBalance - currentItem.getPrice();
        List<Coin> change = getChange(changeAmount);
        updateCashInventory(change);
        currentBalance=0;m
        currentItem = null;
        return change;
    }
    @Override
    public List<Coin> refund(){
        List<Coin> refund = getChange(currentBalance);
        updateCashInventory(refund);
        currentBalance = 0;
        currentItem = null;
        return refund;

    }
    private Boolean isFullPaid(){
        if(currentBalance>= currentItem.getPrice){
            return true;        
        }
        return false;
    }

    private List<Coin> getChange(long amount )throws NotSufficientChangeException{
        List<Coin> chages = Collections.EMPTY_LIST;

        if(amount>0){
            changes = new ArrayList<Coin>();
            long balance = amount;
            while(balance>0){
                if(balance >= Coin.QUARTER.getDenomination()&&cashInventory.hasItem(Coin.QUARTER)){changes.add(Coin.QUARTER);
                balance= balance-Coin.QUARTER.getDenomination();
                continue;
            } else if(balance>= Coin.DIME.getDenomination()&&cashInventory.hasItem(Coin.DIME)){
                changes.add(Coin.DIME);
                balance = balance - Coin.DIME.getDenomination();
                continue;
            } else if (balance>= Coin.NICKLE.getDenomination()&&cashInventory.hasItem(Coin.NICKLE)){
                changes.add(Coin.NICKLE);
                balance= balance - coin.NICKLE.getDenomination();
            }
            else if(balance>=Coin.PENNY.getDenomination()&&cashInventory.hasItem(Coin.PENNY)){
                changes.add(Coin.PENNY);
                balance = balance - coin.PENNY.getDenomination();
            }
            else{
                throw new NotSufficientChangeException("NotSufficientChange Please  try another product");
            }
            }
        }
        return changes;
    }
    @Override
    public void reset(){
        cashInventory.clear();
        itemInventory.clear();
        totalSales = 0;
        currentItem=null;
        currentBalance=0;
    }
    public void printStats(){
        System.out.println("Total sales :" + totalSales);
        System.out.println("Current Item inventory :" + itemInventory);
        System.out.println("Current Cash inventory : "+ cashInventory);
    }
    private boolean hasSufficientChange(){
        return hasSufficientChangeForAmount(currentBalance - currentItem.getPrice);
    }
    private boolean hasSufficientChangeForAmount(){
        boolean hasChange = true;
        try{
            getChange(amount);
        }
        catch(NotSufficientChangeException nsce){
            return hasChange = false;
        }

        return hasChange;
    }

    private void updateCashInventory(List change){
        for (Coin c : change){
            cashInventory.deduct(c);
        }
    }
    public long getTotalSales(){
        return totalSales;
    }
} 