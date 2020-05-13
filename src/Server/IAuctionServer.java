package Server;

import Client.AuctionListener;
import Client.IAuctionListener;
import Server.Item.AuctionItem;
import Server.Item.IAuctionItem;

import java.util.ArrayList;

public interface IAuctionServer {
    public void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime);
    public void bidOnItem(String bidderName, String itemName, double bid);
    public ArrayList<AuctionItem> getItems();
    public AuctionItem getItem(String itemName);
    public int countItems();
    public void registerListener(AuctionListener al, String itemName);
    public void notifyObservers(String itemName);
}
