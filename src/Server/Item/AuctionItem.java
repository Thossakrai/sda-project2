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
    public boolean bid(String bidderName, double bid) {
        if (bid > currentBid) {
            currentBid = bid;
            BidRecord newRecord = new BidRecord(bidderName, bid);
            bidRecords.add(newRecord);
            return true;
        } else {
            System.out.println("Your bid on " + itemName + " is lower that current bid (" + currentBid + " bid)");
            return false;
        }
    }
}
