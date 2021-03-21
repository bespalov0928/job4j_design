package ru.job4j.chapter007.CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Demo1 {

    private static void iWork() throws InterruptedException {
        System.out.println("iwork");
        int count = 0;
        while (count < 10) {
            System.out.println("Вы: я работаю");
            TimeUnit.SECONDS.sleep(1);
            count++;
        }
    }

    /**
     * supplyAsync() и runAsync()
     * @return
     */
    public static CompletableFuture<Void> goToTrash() {
        System.out.println("goToTrash");
        return CompletableFuture.runAsync(
                () -> {
                    System.out.println("Сын: Мам/Пам, я пошел выносить мусор");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Сын: Мам/Пап, я вернулся!");
                }
        );
    }


    public static CompletableFuture<String> buyProduct(String product) {
        return CompletableFuture.supplyAsync(
                () -> {
                    System.out.println("Сын: Мам/Пам, я пошел в магазин");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Сын: Мам/Пап, я купил " + product);
                    return product;

                }
        );
    }

    public static void runAsyncExample() throws Exception {
        CompletableFuture<Void> gtt = goToTrash();
        CompletableFuture<String> bm = buyProduct("Молоко");
        iWork();
        System.out.println("Куплено: " + bm.get());
    }


    /**
     * thenApply(), thenAccept(), thenRun()
     * @throws Exception
     */
    public static void thenRunExample() throws Exception {
        CompletableFuture<Void> gtt = goToTrash();
        gtt.thenRun(
                () -> {
                    int count = 0;
                    while (count < 3) {
                        System.out.println("Сын: я мою руки");
                        try {
                            TimeUnit.MILLISECONDS.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        count++;
                    }
                    System.out.println("Сын: Я помыл руки");
                }
        );
        iWork();
    }


    public static void thenAcceptExample() throws Exception {
        CompletableFuture<String> bm = buyProduct("Молоко");
        bm.thenAccept(
                (product) -> System.out.println("Сын: Я убрал " + product + " в холодильник ")
        );
        iWork();
        System.out.println("Куплено: " + bm.get());
    }

    public static void thenApplyExample() throws Exception {
        CompletableFuture<String> bm = buyProduct("Молоко")
                .thenApply((product) -> "Сын: я налил тебе в кружку " + product + ". Держи.");
        iWork();
        System.out.println(bm.get());
    }

    /**
     * thenCompose(), thenCombine()
     * @param
     */

    public static void thenComposeExample() throws Exception {
        CompletableFuture<Void> result = buyProduct("Молоко").thenCompose(a -> goToTrash());
        iWork();
    }

    public static void thenCombineExample() throws Exception {
        CompletableFuture<String> result = buyProduct("Молоко")
                .thenCombine(buyProduct("Хлеб"), (r1, r2) -> "Куплены " + r1 + " и " + r2);
        iWork();
        System.out.println(result.get());
    }

    /**
     * allOf() и anyOf()
     * @param
     */
    public static CompletableFuture<Void> washHands(String name) {
        return CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + ", моет руки");
        });
    }

    public static void allOfExample() throws Exception {
        CompletableFuture<Void> all = CompletableFuture.allOf(
                washHands("Папа"), washHands("Мама"),
                washHands("Ваня"), washHands("Боря")
        );
        TimeUnit.SECONDS.sleep(3);
    }


    public static CompletableFuture<String> whoWashHands(String name) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return name + ", моет руки";
        });
    }

    public static void anyOfExample() throws Exception {
        CompletableFuture<Object> first = CompletableFuture.anyOf(
                whoWashHands("Папа"), whoWashHands("Мама"),
                whoWashHands("Ваня"), whoWashHands("Боря")
        );
        System.out.println("Кто сейчас моет руки?");
        TimeUnit.SECONDS.sleep(1);
        System.out.println(first.get());
    }

    public static void main(String[] args) {

//        try {
//            Demo1.runAsyncExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Demo1.thenRunExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Demo1.thenAcceptExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Demo1.thenApplyExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Demo1.thenComposeExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Demo1.thenCombineExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

//        try {
//            Demo1.allOfExample();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            Demo1.anyOfExample();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
