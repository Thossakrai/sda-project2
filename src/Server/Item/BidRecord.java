package Server.Item;

import Server.AuctionServer;

public class BidRecord extends AuctionServer {
    String bidderName;
    double bid;

    public BidRecord(String bidderName, double bid) {
        this.bidderName = bidderName;
        this.bid = bid;
    }
}
