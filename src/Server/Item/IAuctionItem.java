package Server.Item;

import Server.IAuctionServer;

public interface IAuctionItem extends IAuctionServer {
    boolean bid(String bidderName, double bid);
}
