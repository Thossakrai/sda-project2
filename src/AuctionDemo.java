import Client.AuctionListener;
import Server.AuctionServer;
import Server.IServerFactory;
import Server.Item.AuctionItem;
import Server.ServerFactory;

import java.util.Scanner;

public abstract class AuctionDemo implements IServerFactory {
    public static void main(String[] args) {
        AuctionServer server = getServer();
        boolean activated = true;
        while (activated) {
            System.out.println("Menu: 1. Place item for bid, 2. bid on item, 3. register listener, 4. Exit");
            String itemName, itemDesc, startBid, auctionTime, ownerName, bidderName, bid, listenerName;
            Scanner scanner = new Scanner(System.in);
            String selectedMenu = scanner.nextLine();
            switch (selectedMenu) {
                case "1" :
                    System.out.println("PLACE ITEM FOR BID");
                    System.out.print("Item name = ");
                    itemName = scanner.nextLine();
                    System.out.print("Item description = ");
                    itemDesc = scanner.nextLine();
                    System.out.print("start bid = ");
                    startBid = scanner.nextLine();
                    System.out.print("auction time = ");
                    auctionTime = scanner.nextLine();
                    System.out.print("Owner name = ");
                    ownerName = scanner.nextLine();
                    server.placeItemForBid(ownerName, itemName, itemDesc, Double.parseDouble(startBid), Integer.parseInt(auctionTime));
                    break;
                case "2" :
                    System.out.println("BID ON ITEM");
                    if (server.countItems() > 0) {
                        server.getItems().forEach(item -> System.out.println("\t\titem :" + item.itemName + "\tcurrent bid :" + item.currentBid));
                        System.out.print("bidder name = ");
                        bidderName = scanner.nextLine();
                        System.out.print("item name = ");
                        itemName = scanner.nextLine();
                        System.out.print("bid = ");
                        bid = scanner.nextLine();
                        server.bidOnItem(bidderName, itemName, Double.parseDouble(bid));
                    }
                    else System.out.println("No items available");
                    break;
                case "3" :
                    System.out.print("listener name = ");
                    listenerName = scanner.nextLine();
                    System.out.print("item name = ");
                    itemName = scanner.nextLine();
                    server.registerListener(new AuctionListener(listenerName), itemName);
                    break;
                case "4" :
                    activated = false;
                    break;
            }
        }

    }

    public static AuctionServer getServer() {
        ServerFactory serverFactory = new ServerFactory();
        serverFactory.create();
        return serverFactory.getInstance();
    }
}
