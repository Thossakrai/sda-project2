package Server.Item;

import java.util.ArrayList;

public class AuctionItem implements IAuctionItem {
    public String ownerName;
    public String itemName;
    public String itemDesc;
    public double startBid;
    public int auctionTime;
    public double currentBid;
    public ArrayList<BidRecord> bidRecords = new ArrayList<>();


    public AuctionItem(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) {
        this.ownerName = ownerName;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.startBid = startBid;
        this.auctionTime = auctionTime;
        this.currentBid = startBid;
    }


    @Override
    public void bid(String bidderName, double bid) throws Exception {
        if (bid > currentBid) {
            currentBid = bid;
            BidRecord newRecord = new BidRecord(bidderName, bid);
            bidRecords.add(newRecord);
        } else {
            throw new Exception("Bid is lower that current bid");
        }
    }
}
