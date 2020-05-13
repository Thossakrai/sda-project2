package Client;

import Server.Item.AuctionItem;

public class AuctionListener implements IAuctionListener {
    @Override
    public void update(AuctionItem auctionItem) {
        System.out.println("Item :" + auctionItem.itemName + " is now " + auctionItem.currentBid + " bid.");
    }
}
