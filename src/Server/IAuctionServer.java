package Server;

import Client.AuctionListener;
import Server.Item.AuctionItem;

import java.util.ArrayList;

public interface IAuctionServer {
    void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime);

    void bidOnItem(String bidderName, String itemName, double bid);

    ArrayList<AuctionItem> getItems();

    AuctionItem getItem(String itemName);

    int countItems();

    void registerListener(AuctionListener al, String itemName);

    void notifyObservers(String itemName);
}
