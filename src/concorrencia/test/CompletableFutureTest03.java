package concorrencia.test;

import concorrencia.service.StoreService;
import concorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecated storeServiceDeprecated = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFuture(storeServiceDeprecated);
    }
    private static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated storeService){ //Executando um método sincrono de forma assincrona. E usando um custom executor
        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(10, r -> {
            Thread thread = new Thread(r);
            thread.setDaemon(true);   //Vc pode criar nesse executor um threadFactory, onde vc pode definir como as threads devem ser criadas.
            return thread;
        });
        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        List<CompletableFuture<Double>> completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s), executor))
                .collect(Collectors.toList());

        List<Double> prices = completableFutures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println(prices);

        long end = System.currentTimeMillis();
        executor.shutdown();//Sempre tem que dar shutdown se for usar executor.
        System.out.printf("Time passed to searchPricesAsyncCompletableFuture: %d%n", (end - start));
    }
}
