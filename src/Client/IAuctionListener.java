package Client;


import Server.Item.AuctionItem;

public interface IAuctionListener {
    void update(AuctionItem auctionItem);
}
