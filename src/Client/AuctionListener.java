package Client;

import Server.Item.AuctionItem;

public class AuctionListener implements IAuctionListener {
    String name;

    public AuctionListener(String name) {
        this.name = name;
    }

    @Override
    public void update(AuctionItem auctionItem) {
        System.out.println("[" + name + "] Item :" + auctionItem.itemName + " is now " + auctionItem.currentBid + " bid.");
    }
}
