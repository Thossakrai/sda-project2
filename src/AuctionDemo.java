import Server.AuctionServer;
import Server.Item.AuctionItem;
import Server.ServerFactory;

public class AuctionDemo {
    public static void main(String[] args) throws Exception {
        ServerFactory serverFactory = new ServerFactory();
        serverFactory.create();
        AuctionServer server = serverFactory.getInstance();
        server.placeItemForBid("thosk", "books", "books", 500, 1000);
        AuctionItem item = (AuctionItem) server.getItem("books");
        System.out.println(item.itemName);
        server.bidOnItem("michael", "books", 100);


    }
}
