package academy.concorrencia.test;

import academy.concorrencia.dominio.Quote;
import academy.concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest04 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);
    }

    private static void searchPricesWithDiscount (StoreServiceWithDiscount service){ //Esse esta sendo feito de forma síncrona
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        //stores.forEach(s -> System.out.println(service.getPriceSync(s)));
        stores.stream()
                .map(service::getPriceSync)
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesWithDiscount: %dms%n", (end - start));

    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){ //Esse esta sendo feito de forma assíncrona
        long start = System.currentTimeMillis();

        List<String> stores = List.of("Store 1", "Store 2", "Store 3", "Store 4");
        List<CompletableFuture<String>> completableFutures = stores.stream()
                //Getting the prices async storeName:price:discountCode
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                //Instanciando a new quote from the string generated by getPriceAsync
                .map(cf -> cf.thenApply(Quote::newQuote))
                //Composing the first completable future
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .collect(Collectors.toList());

        completableFutures.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesWithDiscount: %dms%n", (end - start));

    }
}
