package Server;

import Server.Item.AuctionItem;
import Server.Item.IAuctionItem;

import java.util.ArrayList;

public class AuctionServer implements IAuctionServer{
    private static IAuctionServer auctionServer = null;
    private ArrayList<AuctionItem> auctionItems = new ArrayList<>();

    @Override
    public void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) throws Exception {
//        for (Item item : auctionItems) {
//            if (item.itemName.equals(itemName)) {
//                throw new IllegalAccessException("Item is already in the system");
//            }
//        }
        AuctionItem existedItem = auctionItems.stream().filter(item -> itemName.equals(item.itemName)).findFirst().orElse(null);
        if (existedItem == null) {
            AuctionItem newItem = new AuctionItem(ownerName, itemName, itemDesc, startBid, auctionTime);
            auctionItems.add(newItem);
        } else {
            throw new Exception("Item is already in the system");
        }
    }

    @Override
    public void bidOnItem(String bidderName, String itemName, double bid) {
        auctionItems.stream().filter(item -> itemName.equals(item.itemName)).findFirst().ifPresent(biddenItem -> {
            try {
                biddenItem.bid(itemName, bid);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public ArrayList<AuctionItem> getItems() {
        return auctionItems;
    }

    @Override
    public IAuctionItem getItem(String itemName) {
        return auctionItems.stream().filter(item -> item.itemName.equals(itemName)).findFirst().orElse(null);
    }

    //Singleton Pattern
    public static IAuctionServer getAuctionServer() {
        if (auctionServer == null) {
            auctionServer = new AuctionServer();
        }
        return auctionServer;
    }

}
