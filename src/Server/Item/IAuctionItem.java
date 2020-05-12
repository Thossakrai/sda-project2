package Server.Item;

public interface IAuctionItem {
    void bid(String bidderName, double bid) throws Exception;
}
