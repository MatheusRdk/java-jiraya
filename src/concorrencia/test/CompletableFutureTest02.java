package concorrencia.test;

import concorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncCompletableFuture(storeService); //Dessa forma vc tem o mesmo problema de antes, o codigo é executando de forma síncrona. Para resolver vmos quebrar o stream
        //em duas partes diferentes.
    }
    private static void searchPricesAsyncCompletableFuture(StoreService storeService){
        long start = System.currentTimeMillis();
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
//        List<Double> prices = stores.stream().map(storeService::getPricesAsyncCompletableFuture).map(CompletableFuture::join).collect(Collectors.toList());
//        System.out.println(prices); Dessa forma ele ficou sincrono
        List<CompletableFuture<Double>> collect = stores.stream().map(storeService::getPricesAsyncCompletableFuture).collect(Collectors.toList());
        collect.stream().map(CompletableFuture::join); //Para dar certo o assincrono, vc separa a chamada do completablefuture do join.

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesAsyncCompletableFuture: %d%n", (end - start));
    }
}
