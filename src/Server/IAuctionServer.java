package Server;

import Server.Item.AuctionItem;
import Server.Item.IAuctionItem;

import java.util.ArrayList;

public interface IAuctionServer {
    public void placeItemForBid(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) throws Exception;
    public void bidOnItem(String bidderName, String itemName, double bid);
    public ArrayList<AuctionItem> getItems();
    public IAuctionItem getItem(String itemName);
//    public void regesterListener(IAuctionListener al, String itemName);
}
