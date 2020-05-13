package Server;

import Client.AuctionListener;
import Client.IAuctionListener;
import Server.Item.AuctionItem;
import Server.Item.IAuctionItem;

import java.util.ArrayList;

public class AuctionServer implements IAuctionServer {
    private static IAuctionServer auctionServer = null;
    private ArrayList<AuctionItem> auctionItems = new ArrayList<>();
    private ArrayList<AuctionSubscriber> auctionListeners = new ArrayList<>();

    static class AuctionSubscriber {
        String itemName;
        IAuctionListener listener;

        AuctionSubscriber(IAuctionListener listener, String itemName) {
            this.itemName = itemName;
            this.listener = listener;
        }
    }

    @Override
    public void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) {
        AuctionItem existedItem = auctionItems.stream().filter(item -> itemName.equals(item.itemName)).findFirst().orElse(null);
        if (existedItem == null) {
            AuctionItem newItem = new AuctionItem(ownerName, itemName, itemDesc, startBid, auctionTime);
            auctionItems.add(newItem);
            System.out.println(itemName + " has been added to the system");
        } else {
            System.out.println("Item is already in the system");
        }
    }

    @Override
    public void bidOnItem(String bidderName, String itemName, double bid) {
        auctionItems.stream().filter(item -> itemName.equals(item.itemName)).findFirst().ifPresent(biddenItem -> {
            boolean bidStatus = biddenItem.bid(bidderName, bid);
            if (bidStatus) this.notifyObservers(itemName);
        });
    }

    @Override
    public ArrayList<AuctionItem> getItems() {
        return auctionItems;
    }

    @Override
    public int countItems() {
        return auctionItems.size();
    }

    @Override
    public AuctionItem getItem(String itemName) {
        return auctionItems.stream().filter(item -> item.itemName.equals(itemName)).findFirst().orElse(null);
    }

    @Override
    public void registerListener(AuctionListener al, String itemName) {
        auctionListeners.add(new AuctionSubscriber(al, itemName));
    }

    @Override
    public void notifyObservers(String itemName) {
        auctionListeners.stream()
                .filter(auctionListeners -> auctionListeners.itemName.equals(itemName))
                .forEach(auctionListeners -> auctionListeners.listener.update(this.getItem(auctionListeners.itemName)));
    }

    //Singleton Pattern
    public static IAuctionServer getAuctionServer() {
        if (auctionServer == null) {
            auctionServer = new AuctionServer();
        }
        return auctionServer;
    }

}
