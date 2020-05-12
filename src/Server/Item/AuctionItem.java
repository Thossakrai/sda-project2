package Server.Item;

public class AuctionItem implements IAuctionItem {
    public String ownerName;
    public String itemName;
    public String itemDesc;
    public double startBid;
    public int auctionTime;
    public double currentBid;

    public AuctionItem(String ownerName, String itemName, String itemDesc, double startBid, int auctionTime) {
        this.ownerName = ownerName;
        this.itemName = itemName;
        this.itemDesc = itemDesc;
        this.startBid = startBid;
        this.auctionTime = auctionTime;
        this.currentBid = startBid;
    }


    @Override
    public void bid(String bidderName, double bid) {

    }
}
