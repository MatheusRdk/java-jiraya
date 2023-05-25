package academy.concorrencia.test;

import academy.concorrencia.dominio.Quote;
import academy.concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){ //Esse esta sendo feito de forma assíncrona
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");

        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start)))) //Por causa desse thenAccept ele aparece um por um
                .toArray(CompletableFuture[]::new);

        //CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures); //O allof é para saber se todas as tarefas completablefuture foram finalizadas.
        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutures); //Anyof vai considera completo quando qualquer UMA delas for finalizada.
        //Com esse anyof, se terminar um a aplicaçao é finalizada, quando vc precisa somente de um valor, o quanto antes.
        voidCompletableFuture.join();
        System.out.printf("Finished? %b%n", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesWithDiscountAsync: %dms%n", (end - start));
    }
}
