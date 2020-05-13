package Client;


import Server.IAuctionServer;
import Server.Item.AuctionItem;

public interface IAuctionListener extends IAuctionServer {
    void update(AuctionItem auctionItem);
}
