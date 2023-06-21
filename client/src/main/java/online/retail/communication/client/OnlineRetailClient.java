package online.retail.communication.client;

public class OnlineRetailClient {
    public static void main(String[] args) throws InterruptedException {
        String host = args[0];
        int port = Integer.parseInt(args[1].trim());
        String operation = args[2];

        if (args.length != 3) {
            System.out.println("Usage CheckQuantityServiceClient <host> <port> <s(et)|c(heck)");
            System.exit(1);
        }

        if ("s".equals(operation)) {
            AddStockServiceClient client = new AddStockServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        } else if ("c".equals(operation)){
            CheckQuantityServiceClient client = new CheckQuantityServiceClient(host,
                    port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        } else {
            PlaceOrderServiceClient client = new PlaceOrderServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequests();
            client.closeConnection();
        }
    }
}
